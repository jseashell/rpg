package com.seashell.rpg.asset;

import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Utility class for accessing game assets
 */
public class Assets
{
	/**
	 * Size of all assets
	 */
	public static final int SIZE = 16;

	/**
	 * Sprite sheet for the RPG Urban Pack by kenney
	 * <p>
	 * https://www.kenney.nl/assets/rpg-urban-pack
	 */
	private static SpriteSheet kenneyRpgUrban_;

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
		kenneyRpgUrban_ = new SpriteSheet(TextureLoader.load("kenney_urban_rpg_tilemap_packed.png"));
	}

	/**
	 * @return A {@link BufferedImage} of the default player character facing upward while standing
	 */
	public static BufferedImage getPlayerCharacterStandingDown()
	{
		int x = SIZE * 24;
		int y = SIZE * 0;

		return kenneyRpgUrban_.crop(x, y, SIZE, SIZE);
	}

	/**
	 * @return A {@link BufferedImage} of the default player character facing up while standing
	 */
	public static BufferedImage getPlayerCharacterStandingUp()
	{
		int x = SIZE * 25;
		int y = SIZE * 0;

		return kenneyRpgUrban_.crop(x, y, SIZE, SIZE);
	}

	/**
	 * @return A {@link BufferedImage} of the default player character facing left while standing
	 */
	public static BufferedImage getPlayerCharacterStandingLeft()
	{
		int x = SIZE * 23;
		int y = SIZE * 0;

		return kenneyRpgUrban_.crop(x, y, SIZE, SIZE);
	}

	/**
	 * @return A {@link BufferedImage} of the default player character facing down while standing
	 */
	public static BufferedImage getPlayerCharacterStandingRight()
	{
		int x = SIZE * 26;
		int y = SIZE * 0;

		return kenneyRpgUrban_.crop(x, y, SIZE, SIZE);
	}

	/**
	 * @return A {@link BufferedImage} of the default player character facing left while walking (variant a)
	 */
	public static BufferedImage getPlayerCharacterWalkingLeftVariantA()
	{
		int x = SIZE * 23;
		int y = SIZE * 1;

		return kenneyRpgUrban_.crop(x, y, SIZE, SIZE);
	}

	/**
	 * @return A {@link BufferedImage} of the default player character facing left while walking (variant b)
	 */
	public static BufferedImage getPlayerCharacterWalkingLeftVariantB()
	{
		int x = SIZE * 23;
		int y = SIZE * 2;

		return kenneyRpgUrban_.crop(x, y, SIZE, SIZE);
	}

	/**
	 * @return A {@link BufferedImage} of the default player character facing right while walking (variant a)
	 */
	public static BufferedImage getPlayerCharacterWalkingRightVariantA()
	{
		int x = SIZE * 26;
		int y = SIZE * 1;

		return kenneyRpgUrban_.crop(x, y, SIZE, SIZE);
	}

	/**
	 * @return A {@link BufferedImage} of the default player character facing right while walking (variant b)
	 */
	public static BufferedImage getPlayerCharacterWalkingRightVariantB()
	{
		int x = SIZE * 26;
		int y = SIZE * 2;

		return kenneyRpgUrban_.crop(x, y, SIZE, SIZE);
	}

	/**
	 * @return A {@link BufferedImage} of the default player character facing up while walking (variant a)
	 */
	public static BufferedImage getPlayerCharacterWalkingUpVariantA()
	{
		int x = SIZE * 25;
		int y = SIZE * 1;

		return kenneyRpgUrban_.crop(x, y, SIZE, SIZE);
	}

	/**
	 * @return A {@link BufferedImage} of the default player character facing up while walking (variant b)
	 */
	public static BufferedImage getPlayerCharacterWalkingUpVariantB()
	{
		int x = SIZE * 25;
		int y = SIZE * 2;

		return kenneyRpgUrban_.crop(x, y, SIZE, SIZE);
	}

	/**
	 * @return A {@link BufferedImage} of the default player character facing down while walking (variant a)
	 */
	public static BufferedImage getPlayerCharacterWalkingDownVariantA()
	{
		int x = SIZE * 24;
		int y = SIZE * 1;

		return kenneyRpgUrban_.crop(x, y, SIZE, SIZE);
	}

	/**
	 * @return A {@link BufferedImage} of the default player character facing down while walking (variant b)
	 */
	public static BufferedImage getPlayerCharacterWalkingDownVariantB()
	{
		int x = SIZE * 24;
		int y = SIZE * 2;

		return kenneyRpgUrban_.crop(x, y, SIZE, SIZE);
	}

	/**
	 * @return A {@link BufferedImage} of a plain grass
	 */
	public static BufferedImage getGrassBase()
	{
		int x = SIZE * 1;
		int y = SIZE * 1;

		return kenneyRpgUrban_.crop(x, y, SIZE, SIZE);
	}

	/**
	 * @return A {@link BufferedImage} of a plain roof
	 */
	public static BufferedImage getRoofBase()
	{
		int x = SIZE * 9;
		int y = SIZE * 4;

		return kenneyRpgUrban_.crop(x, y, SIZE, SIZE);
	}

	/**
	 * @return A {@link BufferedImage} of a plain road
	 */
	public static BufferedImage getRoadBase()
	{
		int x = SIZE * 9;
		int y = SIZE * 16;

		return kenneyRpgUrban_.crop(x, y, SIZE, SIZE);
	}

	/**
	 * @return A {@link BufferedImage} of a road with a white vertical hash mark
	 */
	public static BufferedImage getRoadWhiteHashVertical()
	{
		int x = SIZE * 3;
		int y = SIZE * 17;

		return kenneyRpgUrban_.crop(x, y, SIZE, SIZE);
	}

	/**
	 * @return A {@link BufferedImage} of a road with a white horizontal hash mark
	 */
	public static BufferedImage getRoadWhiteHashHorizontal()
	{
		int x = SIZE * 1;
		int y = SIZE * 16;

		return kenneyRpgUrban_.crop(x, y, SIZE, SIZE);
	}

	/**
	 * @return A {@link BufferedImage} of a road with a line on the left edge
	 */
	public static BufferedImage getRoadLineLeft()
	{
		int x = SIZE * 2;
		int y = SIZE * 17;

		return kenneyRpgUrban_.crop(x, y, SIZE, SIZE);
	}

	/**
	 * @return A {@link BufferedImage} of a road with a line on the right edge
	 */
	public static BufferedImage getRoadLineRight()
	{
		int x = SIZE * 4;
		int y = SIZE * 17;

		return kenneyRpgUrban_.crop(x, y, SIZE, SIZE);
	}

	/**
	 * @return A {@link BufferedImage} of a road with a line on the top edge
	 */
	public static BufferedImage getRoadLineTop()
	{
		int x = SIZE * 1;
		int y = SIZE * 15;

		return kenneyRpgUrban_.crop(x, y, SIZE, SIZE);
	}

	/**
	 * @return A {@link BufferedImage} of a road with a line on the bottom edge
	 */
	public static BufferedImage getRoadLineBottom()
	{
		int x = SIZE * 1;
		int y = SIZE * 17;

		return kenneyRpgUrban_.crop(x, y, SIZE, SIZE);
	}

	/**
	 * @return A {@link BufferedImage} of a road with a line going from the top edge to the left edge
	 */
	public static BufferedImage getRoadLineTopToLeft()
	{
		int x = SIZE * 8;
		int y = SIZE * 17;

		return kenneyRpgUrban_.crop(x, y, SIZE, SIZE);
	}

	/**
	 * @return A {@link BufferedImage} of a road with a line going from the top edge to the right edge
	 */
	public static BufferedImage getRoadLineTopToRight()
	{
		int x = SIZE * 7;
		int y = SIZE * 17;

		return kenneyRpgUrban_.crop(x, y, SIZE, SIZE);
	}

	/**
	 * @return A {@link BufferedImage} of a road with a line going from the bottom edge to the left edge
	 */
	public static BufferedImage getRoadLineBottomToLeft()
	{
		int x = SIZE * 8;
		int y = SIZE * 16;

		return kenneyRpgUrban_.crop(x, y, SIZE, SIZE);
	}

	/**
	 * @return A {@link BufferedImage} of a road with a line going from the bottom edge to the right edge
	 */
	public static BufferedImage getRoadLineBottomToRight()
	{
		int x = SIZE * 7;
		int y = SIZE * 16;

		return kenneyRpgUrban_.crop(x, y, SIZE, SIZE);
	}

	/**
	 * @return A {@link BufferedImage} of a plain sidewalk
	 */
	public static BufferedImage getSidewalkBase()
	{
		int x = SIZE * 9;
		int y = SIZE * 1;

		return kenneyRpgUrban_.crop(x, y, SIZE, SIZE);
	}

	/**
	 * @return A {@link BufferedImage} of a sidewalk with a curb on the right edge
	 */
	public static BufferedImage getSidewalkCurbRight()
	{
		int x = SIZE * 10;
		int y = SIZE * 1;

		return kenneyRpgUrban_.crop(x, y, SIZE, SIZE);
	}

	/**
	 * @return A {@link BufferedImage} of a sidewalk with a curb on the left edge
	 */
	public static BufferedImage getSidewalkCurbLeft()
	{
		int x = SIZE * 8;
		int y = SIZE * 1;

		return kenneyRpgUrban_.crop(x, y, SIZE, SIZE);
	}

	/**
	 * @return A {@link BufferedImage} of a sidewalk with a curb on the top edge
	 */
	public static BufferedImage getSidewalkCurbTop()
	{
		int x = SIZE * 9;
		int y = SIZE * 0;

		return kenneyRpgUrban_.crop(x, y, SIZE, SIZE);
	}

	/**
	 * @return A {@link BufferedImage} of a sidewalk with a curb on the bottom edge
	 */
	public static BufferedImage getSidewalkCurbBottom()
	{
		int x = SIZE * 9;
		int y = SIZE * 2;

		return kenneyRpgUrban_.crop(x, y, SIZE, SIZE);
	}

	/**
	 * @return A {@link BufferedImage} of a sidewalk with a curb going from the top edge to the right edge
	 */
	public static BufferedImage getSidewalkCurbTopToRight()
	{
		int x = SIZE * 8;
		int y = SIZE * 2;

		return kenneyRpgUrban_.crop(x, y, SIZE, SIZE);
	}

	/**
	 * @return A {@link BufferedImage} of a sidewalk with a curb going from the top edge to the left edge
	 */
	public static BufferedImage getSidewalkCurbTopToLeft()
	{
		int x = SIZE * 10;
		int y = SIZE * 2;

		return kenneyRpgUrban_.crop(x, y, SIZE, SIZE);
	}

	/**
	 * @return A {@link BufferedImage} of a sidewalk with a curb going from the bottom edge to the right edge
	 */
	public static BufferedImage getSidewalkCurbBottomToRight()
	{
		int x = SIZE * 8;
		int y = SIZE * 0;

		return kenneyRpgUrban_.crop(x, y, SIZE, SIZE);
	}

	/**
	 * @return A {@link BufferedImage} of a sidewalk with a curb going from the bottom edge to the left edge
	 */
	public static BufferedImage getSidewalkCurbBottomToLeft()
	{
		int x = SIZE * 10;
		int y = SIZE * 0;

		return kenneyRpgUrban_.crop(x, y, SIZE, SIZE);
	}

	/**
	 * @return A {@link BufferedImage} of a car facing upward
	 */
	public static BufferedImage getCarUpRed()
	{
		int x = SIZE * 20;
		int y = SIZE * 16;

		return kenneyRpgUrban_.crop(x, y, SIZE, SIZE * 2);
	}

	/**
	 * @return A {@link BufferedImage} of a car facing left
	 */
	public static BufferedImage getCarLeftRed()
	{
		int x = SIZE * 15;
		int y = SIZE * 16;

		return kenneyRpgUrban_.crop(x, y, SIZE * 2, SIZE * 2);
	}
}
