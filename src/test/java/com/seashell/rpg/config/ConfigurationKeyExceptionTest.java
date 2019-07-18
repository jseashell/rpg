package com.seashell.rpg.config;

import org.junit.Test;
import org.mockito.Mockito;

import com.seashell.rpg.process.GameProcessConfigurationKeyException;

/**
 * Test class for {@link GameProcessConfigurationKeyException}
 */
public class ConfigurationKeyExceptionTest
{
	/**
	 * Tests that a {@link ConfigurationKeyException(String)} can be constructed and thrown
	 *
	 * @throws GameProcessConfigurationKeyException
	 *             Expected
	 */
	@Test(expected = GameProcessConfigurationKeyException.class)
	public void test_exceptionWithMessageOnly() throws GameProcessConfigurationKeyException
	{
		throw new GameProcessConfigurationKeyException("message");
	}

	/**
	 * Tests that a {@link ConfigurationKeyException(Throwable)} can be constructed and thrown
	 *
	 * @throws GameProcessConfigurationKeyException
	 *             Expected
	 */
	@Test(expected = GameProcessConfigurationKeyException.class)
	public void test_exceptionWithCauseOnly() throws GameProcessConfigurationKeyException
	{
		throw new GameProcessConfigurationKeyException(Mockito.mock(Throwable.class));
	}

	/**
	 * Tests that a {@link ConfigurationKeyException(String, Throwable)} can be constructed and thrown
	 *
	 * @throws GameProcessConfigurationKeyException
	 *             Expected
	 */
	@Test(expected = GameProcessConfigurationKeyException.class)
	public void test_exceptionWithMessageAndCause() throws GameProcessConfigurationKeyException
	{
		throw new GameProcessConfigurationKeyException("message", Mockito.mock(Throwable.class));
	}
}
