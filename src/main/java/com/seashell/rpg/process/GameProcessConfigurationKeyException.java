/**
 *
 */
package com.seashell.rpg.process;

/**
 * Checked exception to use for invalid keys in the configuration file
 */
@SuppressWarnings("serial")
public class GameProcessConfigurationKeyException extends Exception
{
	/**
	 * Constructor
	 *
	 * @param message
	 *            A message about the exception
	 */
	public GameProcessConfigurationKeyException(String message)
	{
		super(message);
	}

	/**
	 * Constructor
	 *
	 * @param cause
	 *            The cause of the exception
	 */
	public GameProcessConfigurationKeyException(Throwable cause)
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
	public GameProcessConfigurationKeyException(String message, Throwable cause)
	{
		super(message, cause);
	}
}
