package com.seashell.rpg.process;

import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

import com.seashell.rpg.gui.Gui;
import com.seashell.rpg.gui.KeyManager;
import com.seashell.rpg.resource.R;
import com.seashell.rpg.scene.Scene;
import com.seashell.rpg.scene.menu.main.MainMenuScene;
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
	private BufferedImage mainMenuBackground_;

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
		// TODO do this better
		WorldScene worldScene = null;
		try
		{
			worldScene = new WorldScene(this);
		}
		catch(WorldConfigurationBuilderException | IOException e)
		{
			System.err.println("Failed to initialize world scene.");
			e.printStackTrace();
			System.exit(0);
		}

		double timePerTick = NANO_ / desiredFps_;
		double delta = 0;

		long now;
		long lastTime = System.nanoTime();
		int ticks = 0;
		long fpsDisplayTimer = 0;

		GameProcessState previousState = null; // Used to control logging

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
					scene_ = new MainMenuScene(this, mainMenuBackground_);
					break;

				case PLAY:
					worldScene.resume();
					scene_ = worldScene;
					break;

				case SETTINGS_MENU:
					scene_ = new SettingsMenuScene();
					break;

				case QUIT:
					isRunning_ = false;
				}

				// Cache the state
				previousState = state_;
			}

			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;

			fpsDisplayTimer += now - lastTime;
			lastTime = now;

			if(delta >= 1)
			{
				tick();
				ticks++;

				render();

				// Reset the difference
				delta = 0;

				if(fpsDisplayTimer >= NANO_)
				{
					String fps = ticks + " fps";

					// TODO #15 Add fps display on screen
					// g2d.setFont(new Font("Serif", Font.PLAIN, 96));
					// g2d.drawString(fps, Gui.WIDTH, Gui.HEIGHT + g2d.getFontMetrics().getHeight());
					System.out.println(fps);

					ticks = 0;
					fpsDisplayTimer = 0;
				}
			}
		}

		// TODO Thread better
		System.out.println("Quitting game");
		System.exit(0);
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
				state_ = GameProcessState.MAIN_MENU;
				break;

			case MAIN_MENU:
				// do nothing
				break;

			case SETTINGS_MENU:
				state_ = GameProcessState.MAIN_MENU;
				break;

			case QUIT:
				// do nothing
				break;
			}

		}
	}

	/**
	 * Renders in-memory variables to the {@link Gui}
	 */
	private void render()
	{
		BufferStrategy bufferStrategy = gui_.getCanvas().getBufferStrategy();
		if(bufferStrategy == null)
		{
			// On first launch, the buffer strategy will be null. So create a new one. 3 buffers should be enough for this game but if
			// rendering begins lagging, maybe experiment with more.
			gui_.getCanvas().createBufferStrategy(3);
			return;
		}

		Graphics2D g2d = (Graphics2D) bufferStrategy.getDrawGraphics();

		// Clear any previous graphics on the display
		g2d.clearRect(0, 0, configuration_.getResolutionWidth(), configuration_.getResolutionHeight());

		if(scene_ != null)
		{
			// Render the current state
			scene_.render(g2d);
		}

		bufferStrategy.show();

		if(shouldScreenshot_)
		{
			screenshot();
		}

		g2d.dispose();
	}

	/**
	 * Takes a screenshot of the current canvas
	 */
	private void screenshot()
	{
		BufferedImage image = new BufferedImage(gui_.getCanvas().getWidth(), gui_.getCanvas().getHeight(), BufferedImage.TYPE_INT_ARGB);

		Graphics2D screenshotGraphics = (Graphics2D) image.getGraphics();

		scene_.render(screenshotGraphics);

		screenshotGraphics.dispose();

		mainMenuBackground_ = image;

		// try
		// {
		// ImageIO.write(image, "png",
		// Paths.get(System.getProperty("user.dir"))
		// .resolve("src")
		// .resolve("main")
		// .resolve("resources")
		// .resolve("asset")
		// .resolve("menu")
		// .resolve("background")
		// .resolve("screenshot.png").toFile());
		// }
		// catch(IOException e)
		// {
		// System.err.println("Failed to save screenshot");
		// e.printStackTrace();
		// }

		shouldScreenshot_ = false;
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
