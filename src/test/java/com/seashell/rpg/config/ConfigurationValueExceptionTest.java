package com.seashell.rpg.config;

import org.junit.Test;
import org.mockito.Mockito;

import com.seashell.rpg.UnitTest;

/**
 * Test class for {@link ConfigurationValueException}
 */
public class ConfigurationValueExceptionTest implements UnitTest
{
	/**
	 * Tests that a {@link ConfigurationValueException(String)} can be constructed and thrown
	 *
	 * @throws ConfigurationValueException
	 *             Expected
	 */
	@Test(expected = ConfigurationValueException.class)
	public void test_exceptionWithMessageOnly() throws ConfigurationValueException
	{
		throw new ConfigurationValueException("message");
	}

	/**
	 * Tests that a {@link ConfigurationValueException(Throwable)} can be constructed and thrown
	 *
	 * @throws ConfigurationValueException
	 *             Expected
	 */
	@Test(expected = ConfigurationValueException.class)
	public void test_exceptionWithCauseOnly() throws ConfigurationValueException
	{
		throw new ConfigurationValueException(Mockito.mock(Throwable.class));
	}

	/**
	 * Tests that a {@link ConfigurationValueException(String, Throwable)} can be constructed and thrown
	 *
	 * @throws ConfigurationValueException
	 *             Expected
	 */
	@Test(expected = ConfigurationValueException.class)
	public void test_exceptionWithMessageAndCause() throws ConfigurationValueException
	{
		throw new ConfigurationValueException("message", Mockito.mock(Throwable.class));
	}
}
