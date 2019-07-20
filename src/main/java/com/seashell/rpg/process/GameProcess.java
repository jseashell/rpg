package com.seashell.rpg.process;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

import com.seashell.rpg.gui.Gui;
import com.seashell.rpg.resource.R;
import com.seashell.rpg.scene.KeyManager;
import com.seashell.rpg.scene.Scene;
import com.seashell.rpg.scene.menu.main.MainMenuScene;
import com.seashell.rpg.scene.menu.pause.PauseMenuScene;
import com.seashell.rpg.scene.menu.settings.SettingsMenuScene;
import com.seashell.rpg.scene.world.WorldScene;
import com.seashell.rpg.scene.world.config.WorldConfigurationBuilderException;

/**
 * Main process for the game. Handles the changing and {@link Gui displaying} of different {@link Scene Scenes}
 *
 * @see {@link Runnable}
 */
public final class GameProcess implements Runnable
{
	/**
	 * Thread responsible for running this process
	 */
	private Thread thread_;

	/**
	 * Flag indicating the running state of this process
	 */
	private boolean isRunning_;

	/**
	 * Value for {@link #getGui()}
	 */
	private final Gui gui_;

	/**
	 * Constant representing 1 second in nanoseconds
	 */
	private static final int NANO_ = 1_000_000_000;

	/**
	 * Value for {@link #getConfiguration()}
	 */
	private final GameProcessConfiguration configuration_;

	/**
	 * Configured FPS setting
	 */
	private final int desiredFps_;

	/**
	 * Actual FPS achieved
	 */
	private int actualFps_;

	/**
	 * The current scene being displayed in the {@link #gui_}
	 */
	private Scene scene_;

	/**
	 * The state of this process
	 */
	private GameProcessState state_;

	/**
	 * Flag indicating whether or not the canvas should be screenshot
	 */
	private boolean shouldScreenshot_;

	/**
	 * Image to use for the background of the main menu
	 */
	private BufferedImage playScreenshot_;

	/**
	 * Constructor
	 *
	 * @param configuration
	 *            The configuration for the game process. Non-null.
	 * @throws NullPointerException
	 *             Null configuration argument
	 * @throws GameProcessConfigurationException
	 *             Invalid configuration file
	 * @throws IOException
	 *             Failure to initialize game assets
	 */
	public GameProcess(GameProcessConfiguration configuration) throws NullPointerException, GameProcessConfigurationException, IOException
	{
		configuration_ = Objects.requireNonNull(configuration, "Game process configuration cannot be null.");
		desiredFps_ = configuration_.getFps();
		actualFps_ = 0;
		isRunning_ = false;

		try
		{
			// Initialize resources
			R.init();
		}
		catch(IOException e)
		{
			System.err.println("Failed to initialize assets.");
			throw e;
		}

		// Initialize the gui
		gui_ = new Gui(configuration_);

		// Set the states to main menu
		state_ = GameProcessState.MAIN_MENU;
	}

	@Override
	public void run()
	{
		WorldScene worldScene = null;
		try
		{
			worldScene = new WorldScene(this);
		}
		catch(WorldConfigurationBuilderException | IOException e)
		{
			System.err.println("Failed to initialize world.");
			e.printStackTrace();
			System.exit(0);
		}

		double timePerTick = NANO_ / desiredFps_;
		double delta = 0;

		long now;
		long lastTime = System.nanoTime();
		int ticks = 0;
		long timer = 0;

		GameProcessState previousState = null; // Used to control logging

		final BufferStrategy bufferStrategy = initializeBufferStrategy(gui_);

		// This loop should run for the lifecycle of execution. Once this loop exits, the application should terminate
		while(isRunning_)
		{
			if(state_ != previousState)
			{
				System.out.println("Entering new state: " + state_);

				// Change the scene based on the state
				switch(state_)
				{
				case MAIN_MENU:
					// TODO worldScene.saveAndQuit();
					scene_ = new MainMenuScene(this);
					break;

				case PLAY:
					if(previousState == GameProcessState.PAUSE)
					{
						worldScene.resume();
					}
					else
					{
						// TODO worldScene.start();
						worldScene.resume();
					}
					scene_ = worldScene;
					break;

				case PAUSE:
					scene_ = new PauseMenuScene(this, playScreenshot_);
					break;

				case SETTINGS:
					scene_ = new SettingsMenuScene();
					break;

				case EXIT:
					isRunning_ = false;
					break;

				default:
					throw new AssertionError("Unhandled game process state \"" + state_ + "\".");
				}

				// Cache the state
				previousState = state_;
			}

			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;

			timer += now - lastTime;
			lastTime = now;

			if(delta >= 1)
			{
				tick();
				ticks++;

				Graphics2D g2d = (Graphics2D) bufferStrategy.getDrawGraphics();

				render(g2d);

				String fps = actualFps_ + " fps";

				Font font = new Font(Font.MONOSPACED, Font.BOLD, 32);
				g2d.setColor(Color.YELLOW);
				g2d.setFont(font);
				g2d.drawString(fps, 25, 25);

				bufferStrategy.show();
				g2d.dispose();

				// Reset the difference
				delta = 0;

				if(timer >= NANO_)
				{
					actualFps_ = ticks;
					ticks = 0;
					timer = 0;
				}
			}
		}

		// TODO Thread better
		System.out.println("Quitting game");
		System.exit(0);
	}

	/**
	 * Initializes a buffer strategy for the give GUI
	 *
	 * @param gui
	 *            The gui to create the buffer strategy for
	 * @return The buffer strategy
	 */
	private BufferStrategy initializeBufferStrategy(Gui gui)
	{
		// Initialize the buffer strategy
		while(gui.getCanvas().getBufferStrategy() == null)
		{
			// On first launch, the buffer strategy will be null. So create a new one. 3 buffers should be enough for this game but if
			// rendering begins lagging, maybe experiment with more.
			gui.getCanvas().createBufferStrategy(3);
		}

		return gui.getCanvas().getBufferStrategy();
	}

	/**
	 * Updates in-memory variables to be {@link render() rendered}
	 */
	private void tick()
	{
		getKeyManager().tick();

		if(scene_ != null)
		{
			scene_.tick();
		}

		if(getKeyManager().isEsc())
		{
			switch(state_)
			{
			case PLAY:
				((WorldScene) scene_).pause();
				shouldScreenshot_ = true;
				state_ = GameProcessState.PAUSE;
				break;

			// // TODO The key manager responds to quickly to be able to do leave the pause menu using ESC
			// case PAUSE:
			// state_ = GameProcessState.PLAY;
			// break;

			case SETTINGS:
				state_ = GameProcessState.MAIN_MENU;

			default:
				// do nothing
			}

		}
	}

	/**
	 * Renders in-memory variables to the {@link #gui}
	 */
	private void render(Graphics2D g2d)
	{
		// Clear any previous graphics on the display
		g2d.clearRect(0, 0, configuration_.getResolutionWidth(), configuration_.getResolutionHeight());

		if(scene_ != null)
		{
			// Render the current state
			scene_.render(g2d);
		}

		if(shouldScreenshot_)
		{
			screenshotCurrentScene();
		}
	}

	/**
	 * Takes a screenshot of the current scene
	 */
	private void screenshotCurrentScene()
	{
		BufferedImage image = new BufferedImage(gui_.getCanvas().getWidth(), gui_.getCanvas().getHeight(), BufferedImage.TYPE_INT_ARGB);

		Graphics2D screenshotGraphics = (Graphics2D) image.getGraphics();
		scene_.render(screenshotGraphics);
		screenshotGraphics.dispose();

		playScreenshot_ = image;

		shouldScreenshot_ = false; // Reset the flag
	}

	/**
	 * Starts the game process (only if it is stopped)
	 */
	public synchronized void start()
	{
		if(isRunning_)
		{
			return;
		}

		thread_ = new Thread(this);
		isRunning_ = true;
		thread_.start();
	}

	/**
	 * Stops the game process (only if it is running)
	 */
	public synchronized void stop()
	{
		if(!isRunning_)
		{
			return;
		}

		try
		{
			isRunning_ = false;
			thread_.join();
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
			System.exit(0);
		}
	}

	/**
	 * @return The key manager for the entire game
	 */
	public KeyManager getKeyManager()
	{
		return gui_.getKeyManager();
	}

	/**
	 * @return The gui
	 */
	public Gui getGui()
	{
		return gui_;
	}

	/**
	 * @return The configuration
	 */
	public GameProcessConfiguration getConfiguration()
	{
		return configuration_;
	}

	/**
	 * @return The current state of this process
	 */
	public GameProcessState getState()
	{
		return state_;
	}

	/**
	 * @param state
	 *            The state of this process to set
	 */
	public void setState(GameProcessState state)
	{
		state_ = state;
	}

	/**
	 * @return The current scene being shown
	 */
	public Scene getScene()
	{
		return scene_;
	}
}
