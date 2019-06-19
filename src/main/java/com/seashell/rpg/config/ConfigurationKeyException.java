/**
 *
 */
package com.seashell.rpg.config;

/**
 * Checked exception to use for invalid keys in the configuration file
 */
@SuppressWarnings("serial")
public class ConfigurationKeyException extends Exception
{
	/**
	 * Constructor
	 *
	 * @param message
	 *            A message about the exception
	 */
	public ConfigurationKeyException(String message)
	{
		super(message);
	}

	/**
	 * Constructor
	 *
	 * @param cause
	 *            The cause of the exception
	 */
	public ConfigurationKeyException(Throwable cause)
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
	public ConfigurationKeyException(String message, Throwable cause)
	{
		super(message, cause);
	}
}
