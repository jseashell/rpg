package com.seashell.rpg.config;

import org.junit.Test;
import org.mockito.Mockito;

import com.seashell.rpg.process.GameProcessConfigurationException;

/**
 * Test class for {@link GameProcessConfigurationException}
 */
public class ConfigurationExceptionTest
{
	/**
	 * Tests that a {@link ConfigurationException(String)} can be constructed and thrown
	 *
	 * @throws GameProcessConfigurationException
	 *             Expected
	 */
	@Test(expected = GameProcessConfigurationException.class)
	public void test_exceptionWithMessageOnly() throws GameProcessConfigurationException
	{
		throw new GameProcessConfigurationException("message");
	}

	/**
	 * Tests that a {@link ConfigurationException(Throwable)} can be constructed and thrown
	 *
	 * @throws GameProcessConfigurationException
	 *             Expected
	 */
	@Test(expected = GameProcessConfigurationException.class)
	public void test_exceptionWithCauseOnly() throws GameProcessConfigurationException
	{
		throw new GameProcessConfigurationException(Mockito.mock(Throwable.class));
	}

	/**
	 * Tests that a {@link ConfigurationException(String, Throwable)} can be constructed and thrown
	 *
	 * @throws GameProcessConfigurationException
	 *             Expected
	 */
	@Test(expected = GameProcessConfigurationException.class)
	public void test_exceptionWithMessageAndCause() throws GameProcessConfigurationException
	{
		throw new GameProcessConfigurationException("message", Mockito.mock(Throwable.class));
	}
}
