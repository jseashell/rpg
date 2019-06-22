/**
 *
 */
package com.seashell.rpg.process;

/**
 * Checked exception to use for generic failures in {@link GameProcessConfiguration}
 */
@SuppressWarnings("serial")
public class GameProcessConfigurationException extends Exception
{
	/**
	 * Constructor
	 *
	 * @param message
	 *            A message about the exception
	 */
	public GameProcessConfigurationException(String message)
	{
		super(message);
	}

	/**
	 * Constructor
	 *
	 * @param cause
	 *            The cause of the exception
	 */
	public GameProcessConfigurationException(Throwable cause)
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
	public GameProcessConfigurationException(String message, Throwable cause)
	{
		super(message, cause);
	}
}
