package com.seashell.rpg.asset;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;

import com.seashell.rpg.resource.R;

/**
 * Test class for {@link R}
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
			R.init();
		}
		catch(IOException e)
		{
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	/**
	 * Tests that {@link R#getPlayerCharacterStandingDown()} does not return null
	 */
	@Test
	public void test_getPlayerCharacterDown_nonNull()
	{
		assertNotNull(R.getPlayerCharacterStandingDown());
	}

	/**
	 * Tests that {@link R#getGrassBase()} does not return null
	 */
	@Test
	public void test_getGrassBase_nonNull()
	{
		assertNotNull(R.getGrassBase());
	}

	/**
	 * Tests that {@link R#getRoofGreyBase()} does not return null
	 */
	@Test
	public void test_getWallBase_nonNull()
	{
		assertNotNull(R.getRoofGreyBase());
	}

	/**
	 * Tests that {@link R#getRoadBase()} does not return null
	 */
	@Test
	public void test_getRoadBase_nonNull()
	{
		assertNotNull(R.getRoadBase());
	}

	/**
	 * Tests that {@link R#getRoadWhiteHashVertical()} does not return null
	 */
	@Test
	public void test_getRoadWhiteHashVertical_nonNull()
	{
		assertNotNull(R.getRoadWhiteHashVertical());
	}

	/**
	 * Tests that {@link R#getRoadLineLeft()} does not return null
	 */
	@Test
	public void test_getRoadSidewalkLeft_nonNull()
	{
		assertNotNull(R.getRoadLineLeft());
	}

	/**
	 * Tests that {@link R#getRoadLineRight()} does not return null
	 */
	@Test
	public void test_getRoadSidewalkRight_nonNull()
	{
		assertNotNull(R.getRoadLineRight());
	}

	/**
	 * Tests that {@link R#getSidewalkBase()} does not return null
	 */
	@Test
	public void test_getSidewalkBase_nonNull()
	{
		assertNotNull(R.getSidewalkBase());
	}

	/**
	 * Tests that {@link R#getCarUpRed()} does not return null
	 */
	@Test
	public void test_getCarUp_nonNull()
	{
		assertNotNull(R.getCarUpRed());
	}
}
