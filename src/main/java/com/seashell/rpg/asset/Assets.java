package com.seashell.rpg.asset;

import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Utility class for accessing game assets
 */
public class Assets
{
	/**
	 * Sprite sheet for grass assets
	 */
	private static SpriteSheet grass_;

	/**
	 * Sprite sheet for player assets
	 */
	private static SpriteSheet player_;

	/**
	 * Sprite sheet for wall assets
	 */
	private static SpriteSheet wall_;

	/**
	 * Sprite sheet for road assets
	 */
	private static SpriteSheet road_;

	/**
	 * Sprite sheet for car assets
	 */
	private static SpriteSheet car_;

	/**
	 * Initializes all game assets. This should only be done at start-up.
	 *
	 * @throws IOException
	 *             Failure to load any single asset
	 */
	public static void init() throws IOException
	{
		player_ = new SpriteSheet(TextureLoader.load("texture_player.png"));
		grass_ = new SpriteSheet(TextureLoader.load("texture_grass.png"));
		wall_ = new SpriteSheet(TextureLoader.load("texture_wall.png"));
		road_ = new SpriteSheet(TextureLoader.load("texture_road.png"));
		car_ = new SpriteSheet(TextureLoader.load("texture_car.png"));
	}

	/**
	 * @return A {@link BufferedImage} of the default player character facing upward texture
	 */
	public static BufferedImage getPlayerCharacterDown()
	{
		return player_.crop(0, 0, 128, 128); // partial
	}

	/**
	 * @return A {@link BufferedImage} of a plain grass texture
	 */
	public static BufferedImage getGrassBase()
	{
		return grass_.crop(0, 0, 128, 128); // whole
	}

	/**
	 * @return A {@link BufferedImage} of a plain wall texture
	 */
	public static BufferedImage getWallBase()
	{
		return wall_.crop(0, 0, 128, 128); // whole
	}

	/**
	 * @return A {@link BufferedImage} of a plain road texture
	 */
	public static BufferedImage getRoadBase()
	{
		return road_.crop(0, 0, 256, 256); // partial
	}

	/**
	 * @return A {@link BufferedImage} of a road with a white vertical hash mark texture
	 */
	public static BufferedImage getRoadWhiteHashVertical()
	{
		return road_.crop(256, 0, 256, 256); // partial
	}

	/**
	 * @return A {@link BufferedImage} of a road with a sidewalk on the left edge texture
	 */
	public static BufferedImage getRoadSidewalkLeft()
	{
		return road_.crop(768, 256, 256, 256); // partial
	}

	/**
	 * @return A {@link BufferedImage} of a road with a sidewalk on the right edge texture
	 */
	public static BufferedImage getRoadSidewalkRight()
	{
		return road_.crop(256, 256, 256, 256); // partial
	}

	/**
	 * @return A {@link BufferedImage} of a plain sidewalk texture
	 */
	public static BufferedImage getSidewalkBase()
	{
		return road_.crop(1024, 256, 256, 256); // partial
	}

	/**
	 * @return A {@link BufferedImage} of a road with a yellow vertical hash mark texture
	 */
	public static BufferedImage getRoadYellowSolidVertical()
	{
		return road_.crop(768, 0, 256, 256); // partial
	}

	/**
	 * @return A {@link BufferedImage} of a car facing upward texture
	 */
	public static BufferedImage getCarUp()
	{
		return car_.crop(0, 0, 256, 256); // partial
	}
}
