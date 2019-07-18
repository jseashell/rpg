package com.seashell.rpg.config;

import org.junit.Test;
import org.mockito.Mockito;

import com.seashell.rpg.process.GameProcessConfigurationValueException;

/**
 * Test class for {@link GameProcessConfigurationValueException}
 */
public class ConfigurationValueExceptionTest
{
	/**
	 * Tests that a {@link ConfigurationValueException(String)} can be constructed and thrown
	 *
	 * @throws GameProcessConfigurationValueException
	 *             Expected
	 */
	@Test(expected = GameProcessConfigurationValueException.class)
	public void test_exceptionWithMessageOnly() throws GameProcessConfigurationValueException
	{
		throw new GameProcessConfigurationValueException("message");
	}

	/**
	 * Tests that a {@link ConfigurationValueException(Throwable)} can be constructed and thrown
	 *
	 * @throws GameProcessConfigurationValueException
	 *             Expected
	 */
	@Test(expected = GameProcessConfigurationValueException.class)
	public void test_exceptionWithCauseOnly() throws GameProcessConfigurationValueException
	{
		throw new GameProcessConfigurationValueException(Mockito.mock(Throwable.class));
	}

	/**
	 * Tests that a {@link ConfigurationValueException(String, Throwable)} can be constructed and thrown
	 *
	 * @throws GameProcessConfigurationValueException
	 *             Expected
	 */
	@Test(expected = GameProcessConfigurationValueException.class)
	public void test_exceptionWithMessageAndCause() throws GameProcessConfigurationValueException
	{
		throw new GameProcessConfigurationValueException("message", Mockito.mock(Throwable.class));
	}
}
