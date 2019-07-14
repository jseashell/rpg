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
	 * Tests that {@link Assets#getPlayerCharacterStandingDown()} does not return null
	 */
	@Test
	public void test_getPlayerCharacterDown_nonNull()
	{
		assertNotNull(Assets.getPlayerCharacterStandingDown());
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
	 * Tests that {@link Assets#getRoofBase()} does not return null
	 */
	@Test
	public void test_getWallBase_nonNull()
	{
		assertNotNull(Assets.getRoofBase());
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
	 * Tests that {@link Assets#getRoadLineLeft()} does not return null
	 */
	@Test
	public void test_getRoadSidewalkLeft_nonNull()
	{
		assertNotNull(Assets.getRoadLineLeft());
	}

	/**
	 * Tests that {@link Assets#getRoadLineRight()} does not return null
	 */
	@Test
	public void test_getRoadSidewalkRight_nonNull()
	{
		assertNotNull(Assets.getRoadLineRight());
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
	 * Tests that {@link Assets#getCarUpRed()} does not return null
	 */
	@Test
	public void test_getCarUp_nonNull()
	{
		assertNotNull(Assets.getCarUpRed());
	}
}
