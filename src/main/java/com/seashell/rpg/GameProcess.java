package com.seashell.rpg;

import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.seashell.rpg.asset.Assets;
import com.seashell.rpg.config.Configuration;
import com.seashell.rpg.config.ConfigurationException;
import com.seashell.rpg.config.ConfigurationKeyException;
import com.seashell.rpg.config.ConfigurationValueException;
import com.seashell.rpg.gui.Gui;
import com.seashell.rpg.gui.KeyManager;
import com.seashell.rpg.scene.Scene;
import com.seashell.rpg.scene.world.WorldConfigurationLoaderException;
import com.seashell.rpg.scene.world.WorldScene;

/**
 * Main process for the game. Handles the changing and {@link Gui displaying} of different {@link Scene Scenes}
 *
 * @see {@link Runnable}
 */
public class GameProcess implements Runnable
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
	 * Display object
	 */
	private final Gui gui_;

	/**
	 * Constant representing 1 second in nanoseconds
	 */
	private static final int NANO_ = 1_000_000_000;

	/**
	 * Configuration for the game
	 */
	private final Configuration configuration_;

	/**
	 * Configured FPS setting
	 */
	private final int desiredFps_;

	/**
	 * The current scene being displayed in the {@link #gui_}
	 */
	private Scene scene_;

	/**
	 * Constructor
	 *
	 * @throws ConfigurationException
	 *             Invalid configuration file
	 * @throws IOException
	 *             Failure to initialize game assets
	 */
	public GameProcess() throws ConfigurationException, IOException
	{
		try
		{
			Path configPath = Paths.get(GameProcess.class.getClassLoader().getResource("config.properties").toURI());
			configuration_ = new Configuration(configPath);
		}
		catch(URISyntaxException | NullPointerException e)
		{
			throw new ConfigurationException("Invalid configuration file path.", e);
		}
		catch(ConfigurationKeyException | ConfigurationValueException e)
		{
			throw new ConfigurationException("Invalid key/value pair in configuration file.", e);
		}

		desiredFps_ = configuration_.getFps();

		isRunning_ = false;

		try
		{
			Assets.init();
		}
		catch(IOException e)
		{
			System.err.println("Failed to initialize assets.");
			throw e;
		}

		gui_ = new Gui(this);
	}

	@Override
	public void run()
	{
		try
		{
			scene_ = new WorldScene(this);
		}
		catch(WorldConfigurationLoaderException | IOException e)
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

		// This loop should run for the lifecycle of execution. Once this loop exits, the application should terminate
		while(isRunning_)
		{
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

					// TODO Add fps display on screen
					// g2d.setFont(new Font("Serif", Font.PLAIN, 96));
					// g2d.drawString(fps, Gui.WIDTH, Gui.HEIGHT + g2d.getFontMetrics().getHeight());
					System.out.println(fps);

					ticks = 0;
					fpsDisplayTimer = 0;
				}
			}
		}

		stop();
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
		g2d.dispose();
	}

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
		}
	}

	/**
	 * @return The {@link KeyManager} for the entire game
	 */
	public KeyManager getKeyManager()
	{
		return gui_.getKeyManager();
	}

	public Gui getGui()
	{
		return gui_;
	}

	public Configuration getConfiguration()
	{
		return configuration_;
	}
}
