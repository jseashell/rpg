package com.seashell.rpg.config;

import org.junit.Test;
import org.mockito.Mockito;

import com.seashell.rpg.UnitTest;

/**
 * Test class for {@link ConfigurationKeyException}
 */
public class ConfigurationKeyExceptionTest implements UnitTest
{
	/**
	 * Tests that a {@link ConfigurationKeyException(String)} can be constructed and thrown
	 *
	 * @throws ConfigurationKeyException
	 *             Expected
	 */
	@Test(expected = ConfigurationKeyException.class)
	public void test_exceptionWithMessageOnly() throws ConfigurationKeyException
	{
		throw new ConfigurationKeyException("message");
	}

	/**
	 * Tests that a {@link ConfigurationKeyException(Throwable)} can be constructed and thrown
	 *
	 * @throws ConfigurationKeyException
	 *             Expected
	 */
	@Test(expected = ConfigurationKeyException.class)
	public void test_exceptionWithCauseOnly() throws ConfigurationKeyException
	{
		throw new ConfigurationKeyException(Mockito.mock(Throwable.class));
	}

	/**
	 * Tests that a {@link ConfigurationKeyException(String, Throwable)} can be constructed and thrown
	 *
	 * @throws ConfigurationKeyException
	 *             Expected
	 */
	@Test(expected = ConfigurationKeyException.class)
	public void test_exceptionWithMessageAndCause() throws ConfigurationKeyException
	{
		throw new ConfigurationKeyException("message", Mockito.mock(Throwable.class));
	}
}
