package com.seashell.rpg.asset;

import java.awt.image.BufferedImage;
import java.io.IOException;

import com.seashell.rpg.tile.Tile;

/**
 * Utility class for accessing game assets
 */
public class Assets
{
	/**
	 * Sprite sheet for the RPG Urban Pack by kenney
	 * <p>
	 * https://www.kenney.nl/assets/rpg-urban-pack
	 */
	private static SpriteSheet kenneyRpgUrban_;

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
	 * Constructor prevents instantiation
	 */
	private Assets()
	{
	}

	/**
	 * Initializes all game assets. This should only be done at start-up.
	 *
	 * @throws IOException
	 *             Failure to load any single asset
	 */
	public static void init() throws IOException
	{
		kenneyRpgUrban_ = new SpriteSheet(TextureLoader.load("tilemap_packed.png"));
		player_ = new SpriteSheet(TextureLoader.load("texture_player.png"));
		grass_ = new SpriteSheet(TextureLoader.load("texture_grass.png"));
		wall_ = new SpriteSheet(TextureLoader.load("texture_wall.png"));
		road_ = new SpriteSheet(TextureLoader.load("texture_road.png"));
		car_ = new SpriteSheet(TextureLoader.load("texture_car.png"));
	}

	private static BufferedImage crop(SpriteSheet s, int x, int y)
	{
		return s.crop(x, y, Tile.SIZE, Tile.SIZE);
	}

	/**
	 * @return A {@link BufferedImage} of the default player character facing upward texture
	 */
	public static BufferedImage getPlayerCharacterDown()
	{
		int tileSize = 16; // in pixels
		int x = tileSize * 24;
		int y = tileSize * 0;

		// TODO return crop(kenneyRpgUrban_, x, y);

		return kenneyRpgUrban_.crop(x, y, tileSize, tileSize);
	}

	/**
	 * @return A {@link BufferedImage} of a plain grass texture
	 */
	public static BufferedImage getGrassBase()
	{
		int tileSize = 16; // in pixels
		int x = tileSize * 1;
		int y = tileSize * 1;

		// TODO return crop(kenneyRpgUrban_, x, y);

		return kenneyRpgUrban_.crop(x, y, tileSize, tileSize);
	}

	/**
	 * @return A {@link BufferedImage} of a plain wall texture
	 */
	public static BufferedImage getWallBaseGrey()
	{
		int tileSize = 16; // in pixels
		int x = tileSize * 9;
		int y = tileSize * 4;

		// TODO return crop(kenneyRpgUrban_, x, y);

		return kenneyRpgUrban_.crop(x, y, tileSize, tileSize);
	}

	/**
	 * @return A {@link BufferedImage} of a plain road texture
	 */
	public static BufferedImage getRoadBase()
	{
		int tileSize = 16; // in pixels
		int x = tileSize * 9;
		int y = tileSize * 16;

		// TODO return crop(kenneyRpgUrban_, x, y);

		return kenneyRpgUrban_.crop(x, y, tileSize, tileSize);
	}

	/**
	 * @return A {@link BufferedImage} of a road with a white vertical hash mark texture
	 */
	public static BufferedImage getRoadWhiteHashVertical()
	{
		int tileSize = 16; // in pixels
		int x = tileSize * 3;
		int y = tileSize * 17;

		// TODO return crop(kenneyRpgUrban_, x, y);

		return kenneyRpgUrban_.crop(x, y, tileSize, tileSize);
	}

	/**
	 * @return A {@link BufferedImage} of a road with a sidewalk on the left edge texture
	 */
	public static BufferedImage getRoadLineLeft()
	{
		int tileSize = 16; // in pixels
		int x = tileSize * 2;
		int y = tileSize * 17;

		// TODO return crop(kenneyRpgUrban_, x, y);

		return kenneyRpgUrban_.crop(x, y, tileSize, tileSize);
	}

	/**
	 * @return A {@link BufferedImage} of a road with a sidewalk on the right edge texture
	 */
	public static BufferedImage getRoadLineRight()
	{
		int tileSize = 16; // in pixels
		int x = tileSize * 4;
		int y = tileSize * 17;

		// TODO return crop(kenneyRpgUrban_, x, y);

		return kenneyRpgUrban_.crop(x, y, tileSize, tileSize);
	}

	/**
	 * @return A {@link BufferedImage} of a plain sidewalk texture
	 */
	public static BufferedImage getSidewalkBase()
	{
		int tileSize = 16; // in pixels
		int x = tileSize * 9;
		int y = tileSize * 1;

		// TODO return crop(kenneyRpgUrban_, x, y);

		return kenneyRpgUrban_.crop(x, y, tileSize, tileSize);
	}

	public static BufferedImage getSidewalkCurbRight()
	{
		int tileSize = 16; // in pixels
		int x = tileSize * 10;
		int y = tileSize * 1;

		// TODO return crop(kenneyRpgUrban_, x, y);

		return kenneyRpgUrban_.crop(x, y, tileSize, tileSize);
	}

	public static BufferedImage getSidewalkCurbLeft()
	{
		int tileSize = 16; // in pixels
		int x = tileSize * 8;
		int y = tileSize * 1;

		// TODO return crop(kenneyRpgUrban_, x, y);

		return kenneyRpgUrban_.crop(x, y, tileSize, tileSize);
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
		int tileSize = 16; // in pixels
		int x = tileSize * 20;
		int y = tileSize * 16;

		// TODO return crop(kenneyRpgUrban_, x, y);

		return kenneyRpgUrban_.crop(x, y, tileSize, tileSize * 2);
	}
}
