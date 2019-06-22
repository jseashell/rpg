package com.seashell.rpg.config;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.seashell.rpg.process.GameProcessConfigurationKey;

/**
 * Test class for {@link GameProcessConfigurationKey}
 */
public class ConfigurationKeyTest
{
	/**
	 * Tests the {@link GameProcessConfigurationKey#WORLD}
	 */
	@Test
	public void test_keyWorld()
	{
		GameProcessConfigurationKey key = GameProcessConfigurationKey.WORLD;
		String expectedKey = "world";
		Class<?> expectedType = String.class;

		runTest(key, expectedKey, expectedType);
	}

	/**
	 * Tests the {@link GameProcessConfigurationKey#FPS}
	 */
	@Test
	public void test_keyFps()
	{
		GameProcessConfigurationKey key = GameProcessConfigurationKey.FPS;
		String expectedKey = "fps";
		Class<?> expectedType = Integer.class;

		runTest(key, expectedKey, expectedType);
	}

	/**
	 * Tests the {@link GameProcessConfigurationKey#RESOLUTION_WIDTH}
	 */
	@Test
	public void test_keyResolutionWidth()
	{
		GameProcessConfigurationKey key = GameProcessConfigurationKey.RESOLUTION_WIDTH;
		String expectedKey = "res_width";
		Class<?> expectedType = Integer.class;

		runTest(key, expectedKey, expectedType);
	}

	/**
	 * Tests the {@link GameProcessConfigurationKey#RESOLUTION_HEIGHT}
	 */
	@Test
	public void test_keyResolutionHeight()
	{
		GameProcessConfigurationKey key = GameProcessConfigurationKey.RESOLUTION_HEIGHT;
		String expectedKey = "res_height";
		Class<?> expectedType = Integer.class;

		runTest(key, expectedKey, expectedType);
	}

	/**
	 * Tests the {@link GameProcessConfigurationKey#KEY_BINDING_UP}
	 */
	@Test
	public void test_keyBindingUp()
	{
		GameProcessConfigurationKey key = GameProcessConfigurationKey.KEY_BINDING_UP;
		String expectedKey = "key_binding_up";
		Class<?> expectedType = String.class;

		runTest(key, expectedKey, expectedType);
	}

	/**
	 * Tests the {@link GameProcessConfigurationKey#KEY_BINDING_DOWN}
	 */
	@Test
	public void test_keyBindingDown()
	{
		GameProcessConfigurationKey key = GameProcessConfigurationKey.KEY_BINDING_DOWN;
		String expectedKey = "key_binding_down";
		Class<?> expectedType = String.class;

		runTest(key, expectedKey, expectedType);
	}

	/**
	 * Tests the {@link GameProcessConfigurationKey#KEY_BINDING_LEFT}
	 */
	@Test
	public void test_keyBindingLeft()
	{
		GameProcessConfigurationKey key = GameProcessConfigurationKey.KEY_BINDING_LEFT;
		String expectedKey = "key_binding_left";
		Class<?> expectedType = String.class;

		runTest(key, expectedKey, expectedType);
	}

	/**
	 * Tests the {@link GameProcessConfigurationKey#KEY_BINDING_RIGHT}
	 */
	@Test
	public void test_keyBindingRight()
	{
		GameProcessConfigurationKey key = GameProcessConfigurationKey.KEY_BINDING_RIGHT;
		String expectedKey = "key_binding_right";
		Class<?> expectedType = String.class;

		runTest(key, expectedKey, expectedType);
	}

	/**
	 * Tests the {@link GameProcessConfigurationKey#KEY_BINDING_SPRINT}
	 */
	@Test
	public void test_keyBindingSprint()
	{
		GameProcessConfigurationKey key = GameProcessConfigurationKey.KEY_BINDING_SPRINT;
		String expectedKey = "key_binding_sprint";
		Class<?> expectedType = String.class;

		runTest(key, expectedKey, expectedType);
	}

	/**
	 * Tests the {@link GameProcessConfigurationKey#SPAWN_X}
	 */
	@Test
	public void test_spawnX()
	{
		GameProcessConfigurationKey key = GameProcessConfigurationKey.SPAWN_X;
		String expectedKey = "spawn_x";
		Class<?> expectedType = Integer.class;

		runTest(key, expectedKey, expectedType);
	}

	/**
	 * Tests the {@link GameProcessConfigurationKey#SPAWN_Y}
	 */
	@Test
	public void test_spawnY()
	{
		GameProcessConfigurationKey key = GameProcessConfigurationKey.SPAWN_Y;
		String expectedKey = "spawn_y";
		Class<?> expectedType = Integer.class;

		runTest(key, expectedKey, expectedType);
	}

	/**
	 * Tests that the given key contains the expected key and type
	 *
	 * @param key
	 *            The configuration key to test
	 * @param expectedKey
	 *            The expected key for the configuration key
	 * @param expectedType
	 *            The expected type for the configuration key
	 */
	private void runTest(GameProcessConfigurationKey key, String expectedKey, Class<?> expectedType)
	{
		String actualKey = key.getKey();
		assertEquals(expectedKey, actualKey);

		Class<?> actualType = key.getType();
		assertEquals(expectedType, actualType);
	}
}
