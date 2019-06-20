package com.seashell.rpg.asset;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Test class for {@link Assets}
 */
public class AssetsTest
{
	/**
	 * Initializes the assets
	 */
	@BeforeClass
	public static void setup()
	{
		try
		{
			Assets.init();
		}
		catch(IOException e)
		{
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	/**
	 * Tests that {@link Assets#getPlayerCharacterDown()} does not return null
	 */
	@Test
	public void test_getPlayerCharacterDown_nonNull()
	{
		assertNotNull(Assets.getPlayerCharacterDown());
	}

	/**
	 * Tests that {@link Assets#getGrassBase()} does not return null
	 */
	@Test
	public void test_getGrassBase_nonNull()
	{
		assertNotNull(Assets.getGrassBase());
	}

	/**
	 * Tests that {@link Assets#getWallBase()} does not return null
	 */
	@Test
	public void test_getWallBase_nonNull()
	{
		assertNotNull(Assets.getWallBase());
	}

	/**
	 * Tests that {@link Assets#getRoadBase()} does not return null
	 */
	@Test
	public void test_getRoadBase_nonNull()
	{
		assertNotNull(Assets.getRoadBase());
	}

	/**
	 * Tests that {@link Assets#getRoadWhiteHashVertical()} does not return null
	 */
	@Test
	public void test_getRoadWhiteHashVertical_nonNull()
	{
		assertNotNull(Assets.getRoadWhiteHashVertical());
	}

	/**
	 * Tests that {@link Assets#getRoadSidewalkLeft()} does not return null
	 */
	@Test
	public void test_getRoadSidewalkLeft_nonNull()
	{
		assertNotNull(Assets.getRoadSidewalkLeft());
	}

	/**
	 * Tests that {@link Assets#getRoadSidewalkRight()} does not return null
	 */
	@Test
	public void test_getRoadSidewalkRight_nonNull()
	{
		assertNotNull(Assets.getRoadSidewalkRight());
	}

	/**
	 * Tests that {@link Assets#getSidewalkBase()} does not return null
	 */
	@Test
	public void test_getSidewalkBase_nonNull()
	{
		assertNotNull(Assets.getSidewalkBase());
	}

	/**
	 * Tests that {@link Assets#getRoadYellowSolidVertical()} does not return null
	 */
	@Test
	public void test_getRoadYellowSolidVertical_nonNull()
	{
		assertNotNull(Assets.getRoadYellowSolidVertical());
	}

	/**
	 * Tests that {@link Assets#getCarUp()} does not return null
	 */
	@Test
	public void test_getCarUp_nonNull()
	{
		assertNotNull(Assets.getCarUp());
	}
}
