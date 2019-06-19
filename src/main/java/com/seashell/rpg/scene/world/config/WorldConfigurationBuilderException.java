package com.seashell.rpg.scene.world.config;

import com.seashell.rpg.scene.world.World;

/**
 * Checked exception for any {@link World} related classes
 */
@SuppressWarnings("serial")
public class WorldConfigurationBuilderException extends Exception
{
	/**
	 * Constructor
	 *
	 * @param message
	 *            A message about the exception
	 */
	public WorldConfigurationBuilderException(String message)
	{
		super(message);
	}

	/**
	 * Constructor
	 *
	 * @param cause
	 *            The cause of the exception
	 */
	public WorldConfigurationBuilderException(Throwable cause)
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
	public WorldConfigurationBuilderException(String message, Throwable cause)
	{
		super(message, cause);
	}
}
