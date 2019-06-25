package com.seashell.rpg.process;

/**
 * Checked exception for
 */
@SuppressWarnings("serial")
final class GameProcessStateException extends Exception
{
	/**
	 * Constructor
	 *
	 * @param message
	 *            A message about the exception
	 */
	public GameProcessStateException(String message)
	{
		super(message);
	}

	/**
	 * Constructor
	 *
	 * @param cause
	 *            The cause of the exception
	 */
	public GameProcessStateException(Throwable cause)
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
	public GameProcessStateException(String message, Throwable cause)
	{
		super(message, cause);
	}
}
