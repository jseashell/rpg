package com.seashell.rpg.config;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

/**
 * Read-only object representing runtime configuration
 */
public final class Configuration
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
	 * @throws ConfigurationKeyException
	 *             Invalid keys in the configuration file
	 * @throws ConfigurationValueException
	 *             Invalid data types in the configuration file
	 */
	public Configuration(Path path) throws NullPointerException, IOException, ConfigurationKeyException, ConfigurationValueException
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
	 * @throws ConfigurationKeyException
	 *             Invalid configuration
	 * @throws ConfigurationValueException
	 *             Invalid configuration
	 */
	private void validate() throws ConfigurationKeyException, ConfigurationValueException
	{
		// TODO Make keys know how to validate themselves
		final List<ConfigurationKey> keys = Arrays.asList(ConfigurationKey.values());

		Map<ConfigurationKey, Object> invalidValues = new HashMap<>();
		for(int i = 0; i < keys.size(); i++)
		{
			ConfigurationKey key = keys.get(i);

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
					if(key == ConfigurationKey.WORLD)
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
			throw new ConfigurationValueException(
					INVALID_VALUE_MESSAGE
							+ Arrays.toString(invalidValues.entrySet()
									.stream()
									.map(entry -> entry.getKey().getKey() + "=" + entry.getValue())
									.toArray(String[]::new)));
		}

		// TODO Implement a check for valid keys in the configuration file
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
	 * @return The filename for the world to load
	 */
	public String getWorldFilename()
	{
		return properties_.getProperty(ConfigurationKey.WORLD.getKey());
	}

	/**
	 * @return The configured FPS
	 */
	public int getFps()
	{
		String fps = properties_.getProperty(ConfigurationKey.FPS.getKey());
		return Integer.valueOf(fps);
	}

	/**
	 * @return The configured resolution width represented in number of pixels
	 */
	public int getResolutionWidth()
	{
		String resWidth = properties_.getProperty(ConfigurationKey.RESOLUTION_WIDTH.getKey());
		return Integer.valueOf(String.valueOf(resWidth));
	}

	/**
	 * @return The configured resolution height represented in number of pixels
	 */
	public int getResolutionHeight()
	{
		String resHeight = properties_.getProperty(ConfigurationKey.RESOLUTION_HEIGHT.getKey());
		return Integer.valueOf(String.valueOf(resHeight));
	}

	/**
	 * @return The configured key binding for up
	 */
	public String getKeyBindingUp()
	{
		return properties_.getProperty(ConfigurationKey.KEY_BINDING_UP.getKey());
	}

	/**
	 * @return The configured key binding for down
	 */
	public String getKeyBindingDown()
	{
		return properties_.getProperty(ConfigurationKey.KEY_BINDING_DOWN.getKey());
	}

	/**
	 * @return The configured key binding for left
	 */
	public String getKeyBindingLeft()
	{
		return properties_.getProperty(ConfigurationKey.KEY_BINDING_LEFT.getKey());
	}

	/**
	 * @return The configured key binding for right
	 */
	public String getKeyBindingRight()
	{
		return properties_.getProperty(ConfigurationKey.KEY_BINDING_RIGHT.getKey());
	}

	/**
	 * @return The configured key binding for sprint
	 */
	public String getKeyBindingSprint()
	{
		return properties_.getProperty(ConfigurationKey.KEY_BINDING_SPRINT.getKey());
	}

	@Override
	public String toString()
	{
		return properties_.toString();
	}
}
