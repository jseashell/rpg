package com.seashell.rpg.resource;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Utility class to load resources
 */
final class ResourceLoader
{
	/**
	 * Constructor prevents instantiation
	 */
	private ResourceLoader()
	{
	}

	/**
	 * Loads a image file from {@code src/main/resources/asset/texture/<filename>}
	 *
	 * @param filename
	 *            The name of the texture file to load (with extension)
	 * @return A {@link BufferedImage} of the texture
	 * @throws IOException
	 *             Invalid filename
	 */
	static BufferedImage loadTexture(String filename) throws IOException
	{
		return ImageIO.read(ResourceLoader.class.getClassLoader().getResource("asset/texture/" + filename));
	}

	/**
	 * Loads an image file from {@code src/main/resources/asset/menu/<filename>}
	 *
	 * @param filename
	 *            The name of the menu background file to load (with extension)
	 * @return A {@link BufferedImage} of the background
	 * @throws IOException
	 *             Invalid filename
	 */
	static BufferedImage loadMenu(String filename) throws IOException
	{
		return ImageIO.read(ResourceLoader.class.getClassLoader().getResource("asset/menu/" + filename));
	}
}
