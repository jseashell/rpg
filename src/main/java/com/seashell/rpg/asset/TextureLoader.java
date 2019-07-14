package com.seashell.rpg.asset;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Utility class to load textures
 */
public class TextureLoader
{
	/**
	 * Constructor prevents instantiation
	 */
	private TextureLoader()
	{
	}

	/**
	 * Loads the given texture into an image. The texture file must live in {@code ../resources/asset/texture/}
	 *
	 * @param filename
	 *            The name of the texture file to load (with extension)
	 * @return A {@link BufferedImage} of the texture
	 * @throws IOException
	 *             Invalid filename
	 */
	public static BufferedImage load(String filename) throws IOException
	{
		return ImageIO.read(TextureLoader.class.getClassLoader().getResource("asset/texture/" + filename));
	}
}
