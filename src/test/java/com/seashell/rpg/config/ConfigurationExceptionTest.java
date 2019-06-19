package com.seashell.rpg.config;

import org.junit.Test;
import org.mockito.Mockito;

import com.seashell.rpg.UnitTest;

/**
 * Test class for {@link ConfigurationException}
 */
public class ConfigurationExceptionTest implements UnitTest
{
	/**
	 * Tests that a {@link ConfigurationException(String)} can be constructed and thrown
	 *
	 * @throws ConfigurationException
	 *             Expected
	 */
	@Test(expected = ConfigurationException.class)
	public void test_exceptionWithMessageOnly() throws ConfigurationException
	{
		throw new ConfigurationException("message");
	}

	/**
	 * Tests that a {@link ConfigurationException(Throwable)} can be constructed and thrown
	 *
	 * @throws ConfigurationException
	 *             Expected
	 */
	@Test(expected = ConfigurationException.class)
	public void test_exceptionWithCauseOnly() throws ConfigurationException
	{
		throw new ConfigurationException(Mockito.mock(Throwable.class));
	}

	/**
	 * Tests that a {@link ConfigurationException(String, Throwable)} can be constructed and thrown
	 *
	 * @throws ConfigurationException
	 *             Expected
	 */
	@Test(expected = ConfigurationException.class)
	public void test_exceptionWithMessageAndCause() throws ConfigurationException
	{
		throw new ConfigurationException("message", Mockito.mock(Throwable.class));
	}
}
