package com.seashell.rpg.config;

/**
 * Checked exception to use for invalid data types in the configuration file
 */
@SuppressWarnings("serial")
public class ConfigurationValueException extends Exception
{
	/**
	 * Constructor
	 *
	 * @param message
	 *            A message about this exception
	 */
	public ConfigurationValueException(String message)
	{
		super(message);
	}

	/**
	 * Constructor
	 *
	 * @param cause
	 *            The cause of this exception
	 */
	public ConfigurationValueException(Throwable cause)
	{
		super(cause);
	}

	/**
	 * Constructor
	 *
	 * @param message
	 *            A message about this exception
	 * @param cause
	 *            The cause of this exception
	 */
	public ConfigurationValueException(String message, Throwable cause)
	{
		super(message, cause);
	}
}
