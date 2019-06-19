package com.seashell.rpg.scene.world;

/**
 * Checked exception for any {@link World} related classes
 */
@SuppressWarnings("serial")
public class WorldConfigurationLoaderException extends Exception
{
	/**
	 * Constructor
	 *
	 * @param message
	 *            A message about the exception
	 */
	public WorldConfigurationLoaderException(String message)
	{
		super(message);
	}

	/**
	 * Constructor
	 *
	 * @param cause
	 *            The cause of the exception
	 */
	public WorldConfigurationLoaderException(Throwable cause)
	{
		super(cause);
	}

	/**
	 * Constructor
	 *
	 * @param message
	 *            A message about the exception
	 * @param cause
	 *            The cause of the exception
	 */
	public WorldConfigurationLoaderException(String message, Throwable cause)
	{
		super(message, cause);
	}
}
