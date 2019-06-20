package com.seashell.rpg.asset;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.awt.image.BufferedImage;
import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Test class for {@link SpriteSheet}
 */
public class SpriteSheetTest
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
	public void test_crop()
	{
		BufferedImage b = new BufferedImage(10, 10, BufferedImage.TYPE_INT_RGB);

		SpriteSheet s = new SpriteSheet(b);

		BufferedImage cropped = s.crop(0, 0, 5, 5);

		assertEquals(b.getWidth() / 2, cropped.getWidth());
		assertEquals(b.getHeight() / 2, cropped.getHeight());
	}
}
