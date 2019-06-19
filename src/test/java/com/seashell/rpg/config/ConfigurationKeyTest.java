package com.seashell.rpg.config;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Test class for {@link ConfigurationKey}
 */
public class ConfigurationKeyTest
{
	/**
	 * Tests the {@link ConfigurationKey#WORLD}
	 */
	@Test
	public void test_keyWorld()
	{
		ConfigurationKey key = ConfigurationKey.WORLD;
		String expectedKey = "world";
		Class<?> expectedType = String.class;

		runTest(key, expectedKey, expectedType);
	}

	/**
	 * Tests the {@link ConfigurationKey#FPS}
	 */
	@Test
	public void test_keyFps()
	{
		ConfigurationKey key = ConfigurationKey.FPS;
		String expectedKey = "fps";
		Class<?> expectedType = Integer.class;

		runTest(key, expectedKey, expectedType);
	}

	/**
	 * Tests the {@link ConfigurationKey#RESOLUTION_WIDTH}
	 */
	@Test
	public void test_keyResolutionWidth()
	{
		ConfigurationKey key = ConfigurationKey.RESOLUTION_WIDTH;
		String expectedKey = "res_width";
		Class<?> expectedType = Integer.class;

		runTest(key, expectedKey, expectedType);
	}

	/**
	 * Tests the {@link ConfigurationKey#RESOLUTION_HEIGHT}
	 */
	@Test
	public void test_keyResolutionHeight()
	{
		ConfigurationKey key = ConfigurationKey.RESOLUTION_HEIGHT;
		String expectedKey = "res_height";
		Class<?> expectedType = Integer.class;

		runTest(key, expectedKey, expectedType);
	}

	/**
	 * Tests the {@link ConfigurationKey#KEY_BINDING_UP}
	 */
	@Test
	public void test_keyBindingUp()
	{
		ConfigurationKey key = ConfigurationKey.KEY_BINDING_UP;
		String expectedKey = "key_binding_up";
		Class<?> expectedType = String.class;

		runTest(key, expectedKey, expectedType);
	}

	/**
	 * Tests the {@link ConfigurationKey#KEY_BINDING_DOWN}
	 */
	@Test
	public void test_keyBindingDown()
	{
		ConfigurationKey key = ConfigurationKey.KEY_BINDING_DOWN;
		String expectedKey = "key_binding_down";
		Class<?> expectedType = String.class;

		runTest(key, expectedKey, expectedType);
	}

	/**
	 * Tests the {@link ConfigurationKey#KEY_BINDING_LEFT}
	 */
	@Test
	public void test_keyBindingLeft()
	{
		ConfigurationKey key = ConfigurationKey.KEY_BINDING_LEFT;
		String expectedKey = "key_binding_left";
		Class<?> expectedType = String.class;

		runTest(key, expectedKey, expectedType);
	}

	/**
	 * Tests the {@link ConfigurationKey#KEY_BINDING_RIGHT}
	 */
	@Test
	public void test_keyBindingRight()
	{
		ConfigurationKey key = ConfigurationKey.KEY_BINDING_RIGHT;
		String expectedKey = "key_binding_right";
		Class<?> expectedType = String.class;

		runTest(key, expectedKey, expectedType);
	}

	/**
	 * Tests the {@link ConfigurationKey#KEY_BINDING_SPRINT}
	 */
	@Test
	public void test_keyBindingSprint()
	{
		ConfigurationKey key = ConfigurationKey.KEY_BINDING_SPRINT;
		String expectedKey = "key_binding_sprint";
		Class<?> expectedType = String.class;

		runTest(key, expectedKey, expectedType);
	}

	/**
	 * Tests the {@link ConfigurationKey#SPAWN_X}
	 */
	@Test
	public void test_spawnX()
	{
		ConfigurationKey key = ConfigurationKey.SPAWN_X;
		String expectedKey = "spawn_x";
		Class<?> expectedType = Integer.class;

		runTest(key, expectedKey, expectedType);
	}

	/**
	 * Tests the {@link ConfigurationKey#SPAWN_Y}
	 */
	@Test
	public void test_spawnY()
	{
		ConfigurationKey key = ConfigurationKey.SPAWN_Y;
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
	private void runTest(ConfigurationKey key, String expectedKey, Class<?> expectedType)
	{
		String actualKey = key.getKey();
		assertEquals(expectedKey, actualKey);

		Class<?> actualType = key.getType();
		assertEquals(expectedType, actualType);
	}
}
