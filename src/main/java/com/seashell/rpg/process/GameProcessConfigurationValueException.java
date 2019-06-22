package com.seashell.rpg.process;

/**
 * Checked exception to use for invalid data types in the configuration file
 */
@SuppressWarnings("serial")
public class GameProcessConfigurationValueException extends Exception
{
	/**
	 * Constructor
	 *
	 * @param message
	 *            A message about this exception
	 */
	public GameProcessConfigurationValueException(String message)
	{
		super(message);
	}

	/**
	 * Constructor
	 *
	 * @param cause
	 *            The cause of this exception
	 */
	public GameProcessConfigurationValueException(Throwable cause)
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
	public GameProcessConfigurationValueException(String message, Throwable cause)
	{
		super(message, cause);
	}
}
