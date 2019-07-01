package com.seashell.rpg;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Utility class to load resources
 */
public final class Resources
{
	/**
	 * Constructor prevents instantiation
	 */
	private Resources()
	{
	}

	/**
	 * Loads a image file from {@code src/main/resources/textures/<filename>}
	 *
	 * @param filename
	 *            The name of the texture file to load (with extension)
	 * @return A {@link BufferedImage} of the texture
	 * @throws IOException
	 *             Invalid filename
	 */
	public static BufferedImage loadTexture(String filename) throws IOException
	{
		return ImageIO.read(Resources.class.getClassLoader().getResource("textures/" + filename));
	}

	/**
	 * Loads an image file from {@code src/main/resources/menus/<filename>}
	 *
	 * @param filename
	 *            The name of the menu background file to load (with extension)
	 * @return A {@link BufferedImage} of the background
	 * @throws IOException
	 *             Invalid filename
	 */
	public static BufferedImage loadMenu(String filename) throws IOException
	{
		return ImageIO.read(Resources.class.getClassLoader().getResource("menus/" + filename));
	}
}
