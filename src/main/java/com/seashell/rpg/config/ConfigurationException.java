/**
 *
 */
package com.seashell.rpg.config;

/**
 * Checked exception to use for generic failures in {@link Configuration}
 */
@SuppressWarnings("serial")
public class ConfigurationException extends Exception
{
	/**
	 * Constructor
	 *
	 * @param message
	 *            A message about the exception
	 */
	public ConfigurationException(String message)
	{
		super(message);
	}

	/**
	 * Constructor
	 *
	 * @param cause
	 *            The cause of the exception
	 */
	public ConfigurationException(Throwable cause)
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
	public ConfigurationException(String message, Throwable cause)
	{
		super(message, cause);
	}
}
