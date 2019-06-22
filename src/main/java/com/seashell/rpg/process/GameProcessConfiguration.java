package com.seashell.rpg.process;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

/**
 * Read-only object representing runtime configuration
 */
public final class GameProcessConfiguration
{
	/**
	 * Can message used in invalid value scenarios. This should really only be used for unit testing
	 */
	public static final String INVALID_VALUE_MESSAGE = "Invalid value(s) in configuration: ";

	/**
	 * Underlying properties containing the configuration read from file
	 */
	private final Properties properties_;

	/**
	 * Constructor
	 *
	 * @param path
	 *            The file path of the *.properties file to load
	 * @throws NullPointerException
	 *             Null path argument
	 * @throws IOException
	 *             Failure to load a {@link Properties} object
	 * @throws GameProcessConfigurationKeyException
	 *             Invalid keys in the configuration file
	 * @throws GameProcessConfigurationValueException
	 *             Invalid data types in the configuration file
	 */
	public GameProcessConfiguration(Path path) throws NullPointerException, IOException, GameProcessConfigurationKeyException, GameProcessConfigurationValueException
	{
		Objects.requireNonNull(path, "Null path to configuration file.");

		byte[] config = Files.readAllBytes(path);
		InputStream is = new ByteArrayInputStream(config);

		properties_ = new Properties();
		properties_.load(is);

		validate();
	}

	/**
	 * Validates the loaded {@link #properties_}
	 *
	 * @throws GameProcessConfigurationKeyException
	 *             Invalid configuration
	 * @throws GameProcessConfigurationValueException
	 *             Invalid configuration
	 */
	private void validate() throws GameProcessConfigurationKeyException, GameProcessConfigurationValueException
	{
		// TODO #4 Make keys know how to validate themselves
		final List<GameProcessConfigurationKey> keys = Arrays.asList(GameProcessConfigurationKey.values());

		Map<GameProcessConfigurationKey, Object> invalidValues = new HashMap<>();
		for(int i = 0; i < keys.size(); i++)
		{
			GameProcessConfigurationKey key = keys.get(i);

			String property = properties_.getProperty(key.getKey());

			try
			{
				if(key.getType() == Integer.class)
				{
					@SuppressWarnings("unused")
					Integer casted = Integer.valueOf(property);
				}

				if(key.getType() == String.class)
				{
					if(key == GameProcessConfigurationKey.WORLD)
					{
						if(!property.endsWith(".txt"))
						{
							invalidValues.put(key, property);

						}
					}
					else
					{
						try
						{
							Integer.parseInt(property);

							// Unexpected
							invalidValues.put(key, property);
							continue;
						}
						catch(Exception e)
						{
							// Expected
						}

						// TODO Add support for floats and booleans to the game configuration
						// try
						// {
						// Float.parseFloat(property);
						//
						// // Unexpected
						// invalidValues.put(key, property);
						// continue;
						// }
						// catch(Exception e)
						// {
						// // Expected
						// }
					}
				}

				// TODO Add support for floats and booleans to the game configuration
				// if(key.getType() == Float.class)
				// {
				// @SuppressWarnings("unused")
				// Float casted = Float.valueOf(property);
				// }
				//
				// if(key.getType() == Boolean.class)
				// {
				// @SuppressWarnings("unused")
				// Boolean casted = Boolean.valueOf(property);
				// }
			}
			catch(Exception e)
			{
				invalidValues.put(key, property);
			}
		}

		if(invalidValues.size() > 0)

		{
			throw new GameProcessConfigurationValueException(
					INVALID_VALUE_MESSAGE
							+ Arrays.toString(invalidValues.entrySet()
									.stream()
									.map(entry -> entry.getKey().getKey() + "=" + entry.getValue())
									.toArray(String[]::new)));
		}

		// TODO #3 Implement a check for valid keys in the configuration file
		// if(keys.size() > 0)
		// {
		// List<String> invalidKeys = new ArrayList<>();
		// for(ConfigurationKey key : keys)
		// {
		// invalidKeys.add(key.getKey());
		// }
		//
		// throw new ConfigurationKeyException("Invalid keys in configuration file: " + Arrays.toString(invalidKeys.stream().toArray(String[]::new)));
		// }
	}

	/**
	 * Loads a new instance of a game process configuration using the given filename
	 *
	 * @param configFilename
	 *            The filename of the configuration file. Extension must be .properties
	 * @return The {@link GameProcessConfiguration}
	 * @throws GameProcessConfigurationException
	 *             Invalid file extension, path, or properties
	 */
	public static GameProcessConfiguration newInstance(String configFilename) throws GameProcessConfigurationException
	{
		if(!configFilename.endsWith(".properties"))
		{
			throw new GameProcessConfigurationException("Invalid configuration file extension. Configuration files must be .properties files.");
		}

		try
		{
			Path configPath = Paths.get(GameProcess.class.getClassLoader().getResource(configFilename).toURI());
			return new GameProcessConfiguration(configPath);
		}
		catch(URISyntaxException | NullPointerException | IOException e)
		{
			throw new GameProcessConfigurationException("Invalid configuration file path.", e);
		}
		catch(GameProcessConfigurationKeyException | GameProcessConfigurationValueException e)
		{
			throw new GameProcessConfigurationException("Invalid key/value pair in configuration file.", e);
		}
	}

	/**
	 * @return The filename for the world to load
	 */
	public String getWorldFilename()
	{
		return properties_.getProperty(GameProcessConfigurationKey.WORLD.getKey());
	}

	/**
	 * @return The configured FPS
	 */
	public int getFps()
	{
		String fps = properties_.getProperty(GameProcessConfigurationKey.FPS.getKey());
		return Integer.valueOf(fps);
	}

	/**
	 * @return The configured resolution width represented in number of pixels
	 */
	public int getResolutionWidth()
	{
		String resWidth = properties_.getProperty(GameProcessConfigurationKey.RESOLUTION_WIDTH.getKey());
		return Integer.valueOf(String.valueOf(resWidth));
	}

	/**
	 * @return The configured resolution height represented in number of pixels
	 */
	public int getResolutionHeight()
	{
		String resHeight = properties_.getProperty(GameProcessConfigurationKey.RESOLUTION_HEIGHT.getKey());
		return Integer.valueOf(String.valueOf(resHeight));
	}

	/**
	 * @return The configured key binding for up
	 */
	public String getKeyBindingUp()
	{
		return properties_.getProperty(GameProcessConfigurationKey.KEY_BINDING_UP.getKey());
	}

	/**
	 * @return The configured key binding for down
	 */
	public String getKeyBindingDown()
	{
		return properties_.getProperty(GameProcessConfigurationKey.KEY_BINDING_DOWN.getKey());
	}

	/**
	 * @return The configured key binding for left
	 */
	public String getKeyBindingLeft()
	{
		return properties_.getProperty(GameProcessConfigurationKey.KEY_BINDING_LEFT.getKey());
	}

	/**
	 * @return The configured key binding for right
	 */
	public String getKeyBindingRight()
	{
		return properties_.getProperty(GameProcessConfigurationKey.KEY_BINDING_RIGHT.getKey());
	}

	/**
	 * @return The configured key binding for sprint
	 */
	public String getKeyBindingSprint()
	{
		return properties_.getProperty(GameProcessConfigurationKey.KEY_BINDING_SPRINT.getKey());
	}

	/**
	 * @return The configured x-coordinate of the spawn location
	 */
	public int getSpawnX()
	{
		String spawnX = properties_.getProperty(GameProcessConfigurationKey.SPAWN_X.getKey());
		return Integer.valueOf(String.valueOf(spawnX));
	}

	/**
	 * @return The configured y-coordinate of the spawn location
	 */
	public int getSpawnY()
	{
		String spawnY = properties_.getProperty(GameProcessConfigurationKey.SPAWN_Y.getKey());
		return Integer.valueOf(String.valueOf(spawnY));
	}

	@Override
	public String toString()
	{
		return properties_.toString();
	}
}
