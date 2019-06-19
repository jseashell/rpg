package com.seashell.rpg;

/**
 * Checked exception for the {@link Render} API
 */
@SuppressWarnings("serial")
public class RenderException extends Exception
{
	/**
	 * Constructor
	 *
	 * @param message
	 *            A message about the exception
	 */
	public RenderException(String message)
	{
		super(message);
	}

	/**
	 * Constructor
	 *
	 * @param cause
	 *            The cause of the exception
	 */
	public RenderException(Throwable cause)
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
	public RenderException(String message, Throwable cause)
	{
		super(message, cause);
	}
}
