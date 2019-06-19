package com.seashell.rpg.config;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;

import org.junit.Test;

import com.seashell.rpg.UnitTest;

public class ConfigurationTest implements UnitTest
{
	/**
	 * Tests that loading a configuration with a valid path of a valid configuration file does not throw any exceptions
	 */
	@Test
	public void test_validConfig()
	{
		try
		{
			Path path = getTestResourcePath("config/test_config_valid.properties");
			new Configuration(path);
		}
		catch(URISyntaxException | IOException | NullPointerException | ConfigurationKeyException | ConfigurationValueException e)
		{
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	/**
	 * Tests that {@link Configuration#getWorldFilename()} returns the expected value from a valid configuration
	 */
	@Test
	public void test_getWorldFilename()
	{
		try
		{
			String expected = "world.txt";

			Path path = getTestResourcePath("config/test_config_valid.properties");
			Configuration c = new Configuration(path);

			String actual = c.getWorldFilename();
			assertEquals(expected, actual);
		}
		catch(URISyntaxException | IOException | NullPointerException | ConfigurationKeyException | ConfigurationValueException e)
		{
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	/**
	 * Tests that {@link Configuration#getFps()} returns the expected value from a valid configuration
	 */
	@Test
	public void test_getFps()
	{
		try
		{
			int expected = 60;

			Path path = getTestResourcePath("config/test_config_valid.properties");
			Configuration c = new Configuration(path);

			int actual = c.getFps();
			assertEquals(expected, actual);
		}
		catch(URISyntaxException | IOException | NullPointerException | ConfigurationKeyException | ConfigurationValueException e)
		{
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	/**
	 * Tests that {@link Configuration#getResolutionWidth()} returns the expected value from a valid configuration
	 */
	@Test
	public void test_getResolutionWidth()
	{
		try
		{
			int expected = 1920;

			Path path = getTestResourcePath("config/test_config_valid.properties");
			Configuration c = new Configuration(path);

			int actual = c.getResolutionWidth();
			assertEquals(expected, actual);
		}
		catch(URISyntaxException | IOException | NullPointerException | ConfigurationKeyException | ConfigurationValueException e)
		{
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	/**
	 * Tests that {@link Configuration#getResolutionHeight()} returns the expected value from a valid configuration
	 */
	@Test
	public void test_getResolutionHeight()
	{
		try
		{
			int expected = 1080;

			Path path = getTestResourcePath("config/test_config_valid.properties");
			Configuration c = new Configuration(path);

			int actual = c.getResolutionHeight();
			assertEquals(expected, actual);
		}
		catch(URISyntaxException | IOException | NullPointerException | ConfigurationKeyException | ConfigurationValueException e)
		{
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	/**
	 * Tests that {@link Configuration#getKeyBindingUp()} returns the expected value from a valid configuration
	 */
	@Test
	public void test_getKeyBindingUp()
	{
		try
		{
			String expected = "w";

			Path path = getTestResourcePath("config/test_config_valid.properties");
			Configuration c = new Configuration(path);

			String actual = c.getKeyBindingUp();
			assertEquals(expected, actual);
		}
		catch(URISyntaxException | IOException | NullPointerException | ConfigurationKeyException | ConfigurationValueException e)
		{
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	/**
	 * Tests that {@link Configuration#getKeyBindingDown()} returns the expected value from a valid configuration
	 */
	@Test
	public void test_getKeyBindingDown()
	{
		try
		{
			String expected = "s";

			Path path = getTestResourcePath("config/test_config_valid.properties");
			Configuration c = new Configuration(path);

			String actual = c.getKeyBindingDown();
			assertEquals(expected, actual);
		}
		catch(URISyntaxException | IOException | NullPointerException | ConfigurationKeyException | ConfigurationValueException e)
		{
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	/**
	 * Tests that {@link Configuration#getKeyBindingLeft()} returns the expected value from a valid configuration
	 */
	@Test
	public void test_getKeyBindingLeft()
	{
		try
		{
			String expected = "a";

			Path path = getTestResourcePath("config/test_config_valid.properties");
			Configuration c = new Configuration(path);

			String actual = c.getKeyBindingLeft();
			assertEquals(expected, actual);
		}
		catch(URISyntaxException | IOException | NullPointerException | ConfigurationKeyException | ConfigurationValueException e)
		{
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	/**
	 * Tests that {@link Configuration#getKeyBindingRight()} returns the expected value from a valid configuration
	 */
	@Test
	public void test_getKeyBindingRight()
	{
		try
		{
			String expected = "d";

			Path path = getTestResourcePath("config/test_config_valid.properties");
			Configuration c = new Configuration(path);

			String actual = c.getKeyBindingRight();
			assertEquals(expected, actual);
		}
		catch(URISyntaxException | IOException | NullPointerException | ConfigurationKeyException | ConfigurationValueException e)
		{
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	/**
	 * Tests that {@link Configuration#getKeyBindingSprint()} returns the expected value from a valid configuration
	 */
	@Test
	public void test_getKeyBindingSprint()
	{
		try
		{
			String expected = "shift";

			Path path = getTestResourcePath("config/test_config_valid.properties");
			Configuration c = new Configuration(path);

			String actual = c.getKeyBindingSprint();
			assertEquals(expected, actual);
		}
		catch(URISyntaxException | IOException | NullPointerException | ConfigurationKeyException | ConfigurationValueException e)
		{
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	/**
	 * Tests that a null pointer exception is thrown when the {@link Configuration(Path) constructor argument for path} is {@code null}
	 *
	 * @throws NullPointerException
	 *             Expected
	 */
	@Test(expected = NullPointerException.class)
	public void test_nullPath() throws NullPointerException
	{
		try
		{
			new Configuration(null);
		}
		catch(IOException | ConfigurationKeyException | ConfigurationValueException e)
		{
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	/**
	 * Tests that a {@link ConfigurationValueException} is thrown when {@link ConfigurationKey#WORLD} is configured with an invalid value
	 *
	 * @throws ConfigurationValueException
	 *             Expected
	 */
	@Test(expected = ConfigurationValueException.class)
	public void test_invalidWorld() throws ConfigurationValueException
	{
		ConfigurationKey key = ConfigurationKey.WORLD;
		String filename = "test_config_invalidWorld.properties";
		String expectedInvalidValue = "name_no_extension";

		runExpectedInvalidValueExceptionTest(key, filename, expectedInvalidValue);
	}

	/**
	 * Tests that a {@link ConfigurationValueException} is thrown when {@link ConfigurationKey#FPS} is configured with an invalid value
	 *
	 * @throws ConfigurationValueException
	 *             Expected
	 */
	@Test(expected = ConfigurationValueException.class)
	public void test_invalidFps() throws ConfigurationValueException
	{
		ConfigurationKey key = ConfigurationKey.FPS;
		String filename = "test_config_invalidFps.properties";
		String expectedInvalidValue = "j";

		runExpectedInvalidValueExceptionTest(key, filename, expectedInvalidValue);
	}

	/**
	 * Tests that a {@link ConfigurationValueException} is thrown when {@link ConfigurationKey#RESOLUTION_WIDTH} is configured with an invalid value
	 *
	 * @throws ConfigurationValueException
	 *             Expected
	 */
	@Test(expected = ConfigurationValueException.class)
	public void test_invalidResolutionWidth() throws ConfigurationValueException
	{
		ConfigurationKey key = ConfigurationKey.RESOLUTION_WIDTH;
		String filename = "test_config_invalidResolutionWidth.properties";
		String expectedInvalidValue = "j";

		runExpectedInvalidValueExceptionTest(key, filename, expectedInvalidValue);
	}

	/**
	 * Tests that a {@link ConfigurationValueException} is thrown when {@link ConfigurationKey#RESOLUTION_HEIGHT} is configured with an invalid value
	 *
	 * @throws ConfigurationValueException
	 *             Expected
	 */
	@Test(expected = ConfigurationValueException.class)
	public void test_invalidResolutionHeight() throws ConfigurationValueException
	{
		ConfigurationKey key = ConfigurationKey.RESOLUTION_HEIGHT;
		String filename = "test_config_invalidResolutionHeight.properties";
		String expectedInvalidValue = "j";

		runExpectedInvalidValueExceptionTest(key, filename, expectedInvalidValue);
	}

	/**
	 * Tests that a {@link ConfigurationValueException} is thrown when {@link ConfigurationKey#KEY_BINDING_UP} is configured with an invalid value
	 *
	 * @throws ConfigurationValueException
	 *             Expected
	 */
	@Test(expected = ConfigurationValueException.class)
	public void test_invalidKeyBindingUp() throws ConfigurationValueException
	{
		ConfigurationKey key = ConfigurationKey.KEY_BINDING_UP;
		String filename = "test_config_invalidKeyBindingUp.properties";
		String expectedInvalidValue = "1";

		runExpectedInvalidValueExceptionTest(key, filename, expectedInvalidValue);
	}

	/**
	 * Tests that a {@link ConfigurationValueException} is thrown when {@link ConfigurationKey#KEY_BINDING_DOWN} is configured with an invalid value
	 *
	 * @throws ConfigurationValueException
	 *             Expected
	 */
	@Test(expected = ConfigurationValueException.class)
	public void test_invalidKeyBindingDown() throws ConfigurationValueException
	{
		ConfigurationKey key = ConfigurationKey.KEY_BINDING_DOWN;
		String filename = "test_config_invalidKeyBindingDown.properties";
		String expectedInvalidValue = "1";

		runExpectedInvalidValueExceptionTest(key, filename, expectedInvalidValue);
	}

	/**
	 * Tests that a {@link ConfigurationValueException} is thrown when {@link ConfigurationKey#KEY_BINDING_LEFT} is configured with an invalid value
	 *
	 * @throws ConfigurationValueException
	 *             Expected
	 */
	@Test(expected = ConfigurationValueException.class)
	public void test_invalidKeyBindingLeft() throws ConfigurationValueException
	{
		ConfigurationKey key = ConfigurationKey.KEY_BINDING_LEFT;
		String filename = "test_config_invalidKeyBindingLeft.properties";
		String expectedInvalidValue = "1";

		runExpectedInvalidValueExceptionTest(key, filename, expectedInvalidValue);
	}

	/**
	 * Tests that a {@link ConfigurationValueException} is thrown when {@link ConfigurationKey#KEY_BINDING_RIGHT} is configured with an invalid value
	 *
	 * @throws ConfigurationValueException
	 *             Expected
	 */
	@Test(expected = ConfigurationValueException.class)
	public void test_invalidKeyBindingRight() throws ConfigurationValueException
	{
		ConfigurationKey key = ConfigurationKey.KEY_BINDING_RIGHT;
		String filename = "test_config_invalidKeyBindingRight.properties";
		String expectedInvalidValue = "1";

		runExpectedInvalidValueExceptionTest(key, filename, expectedInvalidValue);
	}

	/**
	 * Tests that a {@link ConfigurationValueException} is thrown when {@link ConfigurationKey#KEY_BINDING_SPRINT} is configured with an invalid value
	 *
	 * @throws ConfigurationValueException
	 *             Expected
	 */
	@Test(expected = ConfigurationValueException.class)
	public void test_invalidKeyBindingSprint() throws ConfigurationValueException
	{
		ConfigurationKey key = ConfigurationKey.KEY_BINDING_SPRINT;
		String filename = "test_config_invalidKeyBindingSprint.properties";
		String expectedInvalidValue = "1";

		runExpectedInvalidValueExceptionTest(key, filename, expectedInvalidValue);
	}

	/**
	 * Convenience method to run the expected exception test
	 *
	 * @param key
	 *            The configuration key being tested for an invalid value
	 * @param filename
	 *            The name of the *.properties file to use for this test
	 * @param expectedInvalidValue
	 *            The invalid value used in the *.properties file
	 * @throws ConfigurationValueException
	 *             Expected
	 * @throws NullPointerException
	 *             Unexpected
	 * @throws ConfigurationKeyException
	 *             Unexpected
	 */
	private void runExpectedInvalidValueExceptionTest(ConfigurationKey expectedKey, String filename, String expectedInvalidValue) throws ConfigurationValueException
	{
		Path path;

		try
		{
			path = getTestResourcePath("config/" + filename);
		}
		catch(URISyntaxException e)
		{
			e.printStackTrace();
			fail(e.getMessage());
			return;
		}

		try
		{
			new Configuration(path);
		}
		catch(ConfigurationValueException e)
		{
			String expectedExceptionMessage = Configuration.INVALID_VALUE_MESSAGE + "[" + expectedKey.getKey() + "=" + expectedInvalidValue + "]";
			String actualExceptionMessage = e.getMessage();
			if(expectedExceptionMessage.equals(actualExceptionMessage))
			{
				// The expected exception was achieved
				throw e;
			}
			else
			{
				fail("This test was expected to fail due to an invalid value for the \"" + expectedKey
						+ "\" configuration property. But other values were unexpectedly invalid -- " + e.getMessage());
			}
		}
		catch(IOException | NullPointerException | ConfigurationKeyException e)
		{
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
}
