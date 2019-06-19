package com.seashell.rpg.asset;

import java.awt.image.BufferedImage;

/**
 * A {@link BufferedImage} that can be {@link #crop(int, int, int, int) cropped} to retrieve a specific sprite.
 */
public class SpriteSheet
{
	/**
	 * The underlying image representing the whole sprite sheet
	 */
	private final BufferedImage image_;

	/**
	 * Constructor
	 *
	 * @param image
	 *            The image representing the whole sprite sheet
	 */
	public SpriteSheet(BufferedImage image)
	{
		image_ = image;
	}

	/**
	 * Crops this sprite sheet using the given coordinates
	 *
	 * @param x
	 *            The initial x-coordinate to begin cropping at
	 * @param y
	 *            The initial y-coordinate to begin cropping at
	 * @param width
	 *            The desired width of the sprite to crop
	 * @param height
	 *            The desired height of the sprite to crop
	 *
	 * @return A {@link BufferedImage} representing the cropped sprite
	 */
	public BufferedImage crop(int x, int y, int width, int height)
	{
		return image_.getSubimage(x, y, width, height);
	}
}
