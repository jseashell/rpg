package com.seashell.rpg.config;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.util.Properties;

import org.junit.Test;

import com.seashell.rpg.UnitTest;
import com.seashell.rpg.process.GameProcessConfiguration;
import com.seashell.rpg.process.GameProcessConfigurationKey;
import com.seashell.rpg.process.GameProcessConfigurationKeyException;
import com.seashell.rpg.process.GameProcessConfigurationValueException;

public class ConfigurationTest implements UnitTest
{
	/**
	 * Tests the that {@link GameProcessConfiguration#toString()} simply prints the underlying {@link Properties} it is wrapping
	 */
	@Test
	public void test_toString()
	{
		Properties p = new Properties();
		p.put("world", "world.txt");
		p.put("fps", "60");
		p.put("res_width", "1920");
		p.put("res_height", "1080");
		p.put("key_binding_up", "w");
		p.put("key_binding_down", "s");
		p.put("key_binding_left", "a");
		p.put("key_binding_right", "d");
		p.put("key_binding_sprint", "shift");
		p.put("spawn_x", "19");
		p.put("spawn_y", "17");

		String expected = p.toString();

		try
		{
			Path path = getTestResourcePath("config/test_config_valid.properties");
			GameProcessConfiguration c = new GameProcessConfiguration(path);

			String actual = c.toString();
			assertEquals(expected, actual);
		}
		catch(URISyntaxException | IOException | NullPointerException | GameProcessConfigurationKeyException | GameProcessConfigurationValueException e)
		{
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	/**
	 * Tests that loading a configuration with a valid path of a valid configuration file does not throw any exceptions
	 */
	@Test
	public void test_validConfig()
	{
		try
		{
			Path path = getTestResourcePath("config/test_config_valid.properties");
			new GameProcessConfiguration(path);
		}
		catch(URISyntaxException | IOException | NullPointerException | GameProcessConfigurationKeyException | GameProcessConfigurationValueException e)
		{
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	/**
	 * Tests that {@link GameProcessConfiguration#getWorldFilename()} returns the expected value from a valid configuration
	 */
	@Test
	public void test_getWorldFilename()
	{
		try
		{
			String expected = "world.txt";

			Path path = getTestResourcePath("config/test_config_valid.properties");
			GameProcessConfiguration c = new GameProcessConfiguration(path);

			String actual = c.getWorldFilename();
			assertEquals(expected, actual);
		}
		catch(URISyntaxException | IOException | NullPointerException | GameProcessConfigurationKeyException | GameProcessConfigurationValueException e)
		{
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	/**
	 * Tests that {@link GameProcessConfiguration#getFps()} returns the expected value from a valid configuration
	 */
	@Test
	public void test_getFps()
	{
		try
		{
			int expected = 60;

			Path path = getTestResourcePath("config/test_config_valid.properties");
			GameProcessConfiguration c = new GameProcessConfiguration(path);

			int actual = c.getFps();
			assertEquals(expected, actual);
		}
		catch(URISyntaxException | IOException | NullPointerException | GameProcessConfigurationKeyException | GameProcessConfigurationValueException e)
		{
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	/**
	 * Tests that {@link GameProcessConfiguration#getResolutionWidth()} returns the expected value from a valid configuration
	 */
	@Test
	public void test_getResolutionWidth()
	{
		try
		{
			int expected = 1920;

			Path path = getTestResourcePath("config/test_config_valid.properties");
			GameProcessConfiguration c = new GameProcessConfiguration(path);

			int actual = c.getResolutionWidth();
			assertEquals(expected, actual);
		}
		catch(URISyntaxException | IOException | NullPointerException | GameProcessConfigurationKeyException | GameProcessConfigurationValueException e)
		{
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	/**
	 * Tests that {@link GameProcessConfiguration#getResolutionHeight()} returns the expected value from a valid configuration
	 */
	@Test
	public void test_getResolutionHeight()
	{
		try
		{
			int expected = 1080;

			Path path = getTestResourcePath("config/test_config_valid.properties");
			GameProcessConfiguration c = new GameProcessConfiguration(path);

			int actual = c.getResolutionHeight();
			assertEquals(expected, actual);
		}
		catch(URISyntaxException | IOException | NullPointerException | GameProcessConfigurationKeyException | GameProcessConfigurationValueException e)
		{
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	/**
	 * Tests that {@link GameProcessConfiguration#getKeyBindingUp()} returns the expected value from a valid configuration
	 */
	@Test
	public void test_getKeyBindingUp()
	{
		try
		{
			int expected = 87;

			Path path = getTestResourcePath("config/test_config_valid.properties");
			GameProcessConfiguration c = new GameProcessConfiguration(path);

			int actual = c.getKeyBindingUp();
			assertEquals(expected, actual);
		}
		catch(URISyntaxException | IOException | NullPointerException | GameProcessConfigurationKeyException | GameProcessConfigurationValueException e)
		{
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	/**
	 * Tests that {@link GameProcessConfiguration#getKeyBindingDown()} returns the expected value from a valid configuration
	 */
	@Test
	public void test_getKeyBindingDown()
	{
		try
		{
			int expected = 83;

			Path path = getTestResourcePath("config/test_config_valid.properties");
			GameProcessConfiguration c = new GameProcessConfiguration(path);

			int actual = c.getKeyBindingDown();
			assertEquals(expected, actual);
		}
		catch(URISyntaxException | IOException | NullPointerException | GameProcessConfigurationKeyException | GameProcessConfigurationValueException e)
		{
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	/**
	 * Tests that {@link GameProcessConfiguration#getKeyBindingLeft()} returns the expected value from a valid configuration
	 */
	@Test
	public void test_getKeyBindingLeft()
	{
		try
		{
			int expected = 65;

			Path path = getTestResourcePath("config/test_config_valid.properties");
			GameProcessConfiguration c = new GameProcessConfiguration(path);

			int actual = c.getKeyBindingLeft();
			assertEquals(expected, actual);
		}
		catch(URISyntaxException | IOException | NullPointerException | GameProcessConfigurationKeyException | GameProcessConfigurationValueException e)
		{
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	/**
	 * Tests that {@link GameProcessConfiguration#getKeyBindingRight()} returns the expected value from a valid configuration
	 */
	@Test
	public void test_getKeyBindingRight()
	{
		try
		{
			int expected = 68;

			Path path = getTestResourcePath("config/test_config_valid.properties");
			GameProcessConfiguration c = new GameProcessConfiguration(path);

			int actual = c.getKeyBindingRight();
			assertEquals(expected, actual);
		}
		catch(URISyntaxException | IOException | NullPointerException | GameProcessConfigurationKeyException | GameProcessConfigurationValueException e)
		{
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	/**
	 * Tests that {@link GameProcessConfiguration#getKeyBindingSprint()} returns the expected value from a valid configuration
	 */
	@Test
	public void test_getKeyBindingSprint()
	{
		try
		{
			int expected = 16;

			Path path = getTestResourcePath("config/test_config_valid.properties");
			GameProcessConfiguration c = new GameProcessConfiguration(path);

			int actual = c.getKeyBindingSprint();
			assertEquals(expected, actual);
		}
		catch(URISyntaxException | IOException | NullPointerException | GameProcessConfigurationKeyException | GameProcessConfigurationValueException e)
		{
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	/**
	 * Tests that {@link GameProcessConfiguration#getSpawnX()} returns the expected value from a valid configuration
	 */
	@Test
	public void test_getSpawnX()
	{
		try
		{
			int expected = 19;

			Path path = getTestResourcePath("config/test_config_valid.properties");
			GameProcessConfiguration c = new GameProcessConfiguration(path);

			int actual = c.getSpawnX();
			assertEquals(expected, actual);
		}
		catch(URISyntaxException | IOException | NullPointerException | GameProcessConfigurationKeyException | GameProcessConfigurationValueException e)
		{
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	/**
	 * Tests that {@link GameProcessConfiguration#getSpawnY()} returns the expected value from a valid configuration
	 */
	@Test
	public void test_getSpawnY()
	{
		try
		{
			int expected = 17;

			Path path = getTestResourcePath("config/test_config_valid.properties");
			GameProcessConfiguration c = new GameProcessConfiguration(path);

			int actual = c.getSpawnY();
			assertEquals(expected, actual);
		}
		catch(URISyntaxException | IOException | NullPointerException | GameProcessConfigurationKeyException | GameProcessConfigurationValueException e)
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
			new GameProcessConfiguration(null);
		}
		catch(IOException | GameProcessConfigurationKeyException | GameProcessConfigurationValueException e)
		{
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	/**
	 * Tests that a {@link GameProcessConfigurationValueException} is thrown when {@link GameProcessConfigurationKey#WORLD} is configured with an invalid value
	 *
	 * @throws GameProcessConfigurationValueException
	 *             Expected
	 */
	@Test(expected = GameProcessConfigurationValueException.class)
	public void test_invalidWorld() throws GameProcessConfigurationValueException
	{
		GameProcessConfigurationKey key = GameProcessConfigurationKey.WORLD;
		String filename = "test_config_invalidWorld.properties";
		String expectedInvalidValue = "name_no_extension";

		runExpectedInvalidValueExceptionTest(key, filename, expectedInvalidValue);
	}

	/**
	 * Tests that a {@link GameProcessConfigurationValueException} is thrown when {@link GameProcessConfigurationKey#FPS} is configured with an invalid value
	 *
	 * @throws GameProcessConfigurationValueException
	 *             Expected
	 */
	@Test(expected = GameProcessConfigurationValueException.class)
	public void test_invalidFps() throws GameProcessConfigurationValueException
	{
		GameProcessConfigurationKey key = GameProcessConfigurationKey.FPS;
		String filename = "test_config_invalidFps.properties";
		String expectedInvalidValue = "j";

		runExpectedInvalidValueExceptionTest(key, filename, expectedInvalidValue);
	}

	/**
	 * Tests that a {@link GameProcessConfigurationValueException} is thrown when {@link GameProcessConfigurationKey#RESOLUTION_WIDTH} is configured with an invalid value
	 *
	 * @throws GameProcessConfigurationValueException
	 *             Expected
	 */
	@Test(expected = GameProcessConfigurationValueException.class)
	public void test_invalidResolutionWidth() throws GameProcessConfigurationValueException
	{
		GameProcessConfigurationKey key = GameProcessConfigurationKey.RESOLUTION_WIDTH;
		String filename = "test_config_invalidResolutionWidth.properties";
		String expectedInvalidValue = "j";

		runExpectedInvalidValueExceptionTest(key, filename, expectedInvalidValue);
	}

	/**
	 * Tests that a {@link GameProcessConfigurationValueException} is thrown when {@link GameProcessConfigurationKey#RESOLUTION_HEIGHT} is configured with an invalid value
	 *
	 * @throws GameProcessConfigurationValueException
	 *             Expected
	 */
	@Test(expected = GameProcessConfigurationValueException.class)
	public void test_invalidResolutionHeight() throws GameProcessConfigurationValueException
	{
		GameProcessConfigurationKey key = GameProcessConfigurationKey.RESOLUTION_HEIGHT;
		String filename = "test_config_invalidResolutionHeight.properties";
		String expectedInvalidValue = "j";

		runExpectedInvalidValueExceptionTest(key, filename, expectedInvalidValue);
	}

	/**
	 * Tests that a {@link GameProcessConfigurationValueException} is thrown when {@link GameProcessConfigurationKey#KEY_BINDING_UP} is configured with an invalid value
	 *
	 * @throws GameProcessConfigurationValueException
	 *             Expected
	 */
	@Test(expected = GameProcessConfigurationValueException.class)
	public void test_invalidKeyBindingUp() throws GameProcessConfigurationValueException
	{
		GameProcessConfigurationKey key = GameProcessConfigurationKey.KEY_BINDING_UP;
		String filename = "test_config_invalidKeyBindingUp.properties";
		String expectedInvalidValue = "1";

		runExpectedInvalidValueExceptionTest(key, filename, expectedInvalidValue);
	}

	/**
	 * Tests that a {@link GameProcessConfigurationValueException} is thrown when {@link GameProcessConfigurationKey#KEY_BINDING_DOWN} is configured with an invalid value
	 *
	 * @throws GameProcessConfigurationValueException
	 *             Expected
	 */
	@Test(expected = GameProcessConfigurationValueException.class)
	public void test_invalidKeyBindingDown() throws GameProcessConfigurationValueException
	{
		GameProcessConfigurationKey key = GameProcessConfigurationKey.KEY_BINDING_DOWN;
		String filename = "test_config_invalidKeyBindingDown.properties";
		String expectedInvalidValue = "1";

		runExpectedInvalidValueExceptionTest(key, filename, expectedInvalidValue);
	}

	/**
	 * Tests that a {@link GameProcessConfigurationValueException} is thrown when {@link GameProcessConfigurationKey#KEY_BINDING_LEFT} is configured with an invalid value
	 *
	 * @throws GameProcessConfigurationValueException
	 *             Expected
	 */
	@Test(expected = GameProcessConfigurationValueException.class)
	public void test_invalidKeyBindingLeft() throws GameProcessConfigurationValueException
	{
		GameProcessConfigurationKey key = GameProcessConfigurationKey.KEY_BINDING_LEFT;
		String filename = "test_config_invalidKeyBindingLeft.properties";
		String expectedInvalidValue = "1";

		runExpectedInvalidValueExceptionTest(key, filename, expectedInvalidValue);
	}

	/**
	 * Tests that a {@link GameProcessConfigurationValueException} is thrown when {@link GameProcessConfigurationKey#KEY_BINDING_RIGHT} is configured with an invalid value
	 *
	 * @throws GameProcessConfigurationValueException
	 *             Expected
	 */
	@Test(expected = GameProcessConfigurationValueException.class)
	public void test_invalidKeyBindingRight() throws GameProcessConfigurationValueException
	{
		GameProcessConfigurationKey key = GameProcessConfigurationKey.KEY_BINDING_RIGHT;
		String filename = "test_config_invalidKeyBindingRight.properties";
		String expectedInvalidValue = "1";

		runExpectedInvalidValueExceptionTest(key, filename, expectedInvalidValue);
	}

	/**
	 * Tests that a {@link GameProcessConfigurationValueException} is thrown when {@link GameProcessConfigurationKey#KEY_BINDING_SPRINT} is configured with an invalid value
	 *
	 * @throws GameProcessConfigurationValueException
	 *             Expected
	 */
	@Test(expected = GameProcessConfigurationValueException.class)
	public void test_invalidKeyBindingSprint() throws GameProcessConfigurationValueException
	{
		GameProcessConfigurationKey key = GameProcessConfigurationKey.KEY_BINDING_SPRINT;
		String filename = "test_config_invalidKeyBindingSprint.properties";
		String expectedInvalidValue = "1";

		runExpectedInvalidValueExceptionTest(key, filename, expectedInvalidValue);
	}

	/**
	 * Tests that a {@link GameProcessConfigurationValueException} is thrown when {@link GameProcessConfigurationKey#SPAWN_X} is configured with an invalid value
	 *
	 * @throws GameProcessConfigurationValueException
	 *             Expected
	 */
	@Test(expected = GameProcessConfigurationValueException.class)
	public void test_invalidSpawnX() throws GameProcessConfigurationValueException
	{
		GameProcessConfigurationKey key = GameProcessConfigurationKey.SPAWN_X;
		String filename = "test_config_invalidSpawnX.properties";
		String expectedInvalidValue = "j";

		runExpectedInvalidValueExceptionTest(key, filename, expectedInvalidValue);
	}

	/**
	 * Tests that a {@link GameProcessConfigurationValueException} is thrown when {@link GameProcessConfigurationKey#SPAWN_Y} is configured with an invalid value
	 *
	 * @throws GameProcessConfigurationValueException
	 *             Expected
	 */
	@Test(expected = GameProcessConfigurationValueException.class)
	public void test_invalidSpawnY() throws GameProcessConfigurationValueException
	{
		GameProcessConfigurationKey key = GameProcessConfigurationKey.SPAWN_Y;
		String filename = "test_config_invalidSpawnY.properties";
		String expectedInvalidValue = "j";

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
	 * @throws GameProcessConfigurationValueException
	 *             Expected
	 * @throws NullPointerException
	 *             Unexpected
	 * @throws GameProcessConfigurationKeyException
	 *             Unexpected
	 */
	private void runExpectedInvalidValueExceptionTest(GameProcessConfigurationKey expectedKey, String filename, String expectedInvalidValue) throws GameProcessConfigurationValueException
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
			new GameProcessConfiguration(path);
		}
		catch(GameProcessConfigurationValueException e)
		{
			String expectedExceptionMessage = GameProcessConfiguration.INVALID_VALUE_MESSAGE + "[" + expectedKey.getKey() + "=" + expectedInvalidValue + "]";
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
		catch(IOException | NullPointerException | GameProcessConfigurationKeyException e)
		{
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
}
