package com.seashell.rpg.scene.world.tile;

import static org.junit.Assert.fail;

import java.awt.image.BufferedImage;
import java.io.IOException;

import org.junit.BeforeClass;

import com.seashell.rpg.resource.R;

/**
 * Parent for all tile tests to extend
 */
public abstract class AbstractTileTest implements TileTest
{

	/**
	 * Setup for all tile tests
	 *
	 * @throws IOException
	 *             Failure to load {@link R}
	 */
	@BeforeClass
	public static void setup() throws IOException
	{
		R.init();
	}

	/**
	 * Utility method to test the equality of two buffered images. Equality is considered to be achieved when (A) the images are the same size, and (B) all pixels of the given images are the same
	 * color (integer representation is considered).
	 *
	 * @param expected
	 *            The expected image
	 * @param actual
	 *            The actual image
	 */
	protected void runTextureTest(BufferedImage expected, BufferedImage actual)
	{
		// The images must be the same size.
		if(expected.getWidth() != actual.getWidth() || expected.getHeight() != actual.getHeight())
		{
			fail();
		}

		int width = expected.getWidth();
		int height = expected.getHeight();

		// Loop over every pixel.
		for(int y = 0; y < height; y++)
		{
			for(int x = 0; x < width; x++)
			{
				// Compare the pixels for equality.
				if(expected.getRGB(x, y) != actual.getRGB(x, y))
				{
					fail();
				}
			}
		}

		// success
	}
}
