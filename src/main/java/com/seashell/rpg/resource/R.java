package com.seashell.rpg.resource;

import java.awt.image.BufferedImage;
import java.io.IOException;

import com.seashell.rpg.SpriteSheet;

/**
 * Utility class for accessing game resources
 */
public class R
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
	 * Value for {@link #getMenuBtnTwoToneYellowRaised()}
	 */
	private static BufferedImage menuBtnTwoToneYellowRaised_;

	/**
	 * Value for {@link #getMenuBtnTwoToneYellowClicked()}
	 */
	private static BufferedImage menuBtnTwoToneYellowClicked_;

	/**
	 * Value for {@link #getMenuBtnSolidYellowRaised()}
	 */
	private static BufferedImage menuBtnSolidYellowRaised_;

	/**
	 * Value for {@link #getMenuBtnSolidYellowClicked()}
	 */
	private static BufferedImage menuBtnSolidYellowClicked_;

	/**
	 * Value for {@link #getMenuPanelYellow()}
	 */
	private static BufferedImage menuPanelYellow_;

	/**
	 * Value for {@link #getMenuPanelGrey()}
	 */
	private static BufferedImage menuPanelGrey_;

	/**
	 * Constructor prevents instantiation
	 */
	private R()
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
		kenneyRpgUrban_ = new SpriteSheet(ResourceLoader.loadTexture("kenney_urban_rpg_tilemap_packed.png"));

		menuBtnTwoToneYellowRaised_ = ResourceLoader.loadMenu("yellow/yellow_button00.png");
		menuBtnTwoToneYellowClicked_ = ResourceLoader.loadMenu("yellow/yellow_button01.png");
		menuBtnSolidYellowRaised_ = ResourceLoader.loadMenu("yellow/yellow_button02.png");
		menuBtnSolidYellowClicked_ = ResourceLoader.loadMenu("yellow/yellow_button03.png");
		menuPanelYellow_ = ResourceLoader.loadMenu("yellow/yellow_panel.png");

		menuPanelGrey_ = ResourceLoader.loadMenu("grey/grey_panel.png");
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
	 * @return A {@link BufferedImage} of a plain grey roof
	 */
	public static BufferedImage getRoofGreyBase()
	{
		int x = SIZE * 9;
		int y = SIZE * 4;

		return kenneyRpgUrban_.crop(x, y, SIZE, SIZE);
	}

	/**
	 * @return A {@link BufferedImage} of a plain brown roof
	 */
	public static BufferedImage getRoofBrownBase()
	{
		int x = SIZE * 1;
		int y = SIZE * 4;

		return kenneyRpgUrban_.crop(x, y, SIZE, SIZE);
	}

	/**
	 * @return A {@link BufferedImage} of a brown roof with an edge going from bottom to right
	 */
	public static BufferedImage getRoofBrownBottomToRightEdge()
	{
		int x = SIZE * 0;
		int y = SIZE * 3;

		return kenneyRpgUrban_.crop(x, y, SIZE, SIZE);
	}

	/**
	 * @return A {@link BufferedImage} of a brown roof with an edge going from bottom to right
	 */
	public static BufferedImage getRoofBrownBottomToLeftEdge()
	{
		int x = SIZE * 2;
		int y = SIZE * 3;

		return kenneyRpgUrban_.crop(x, y, SIZE, SIZE);
	}

	/**
	 * @return A {@link BufferedImage} of a brown roof with an edge going from bottom to right
	 */
	public static BufferedImage getRoofBrownTopToLeftEdge()
	{
		int x = SIZE * 2;
		int y = SIZE * 5;

		return kenneyRpgUrban_.crop(x, y, SIZE, SIZE);
	}

	/**
	 * @return A {@link BufferedImage} of a brown roof with an edge going from bottom to right
	 */
	public static BufferedImage getRoofBrownTopToRightEdge()
	{
		int x = SIZE * 0;
		int y = SIZE * 5;

		return kenneyRpgUrban_.crop(x, y, SIZE, SIZE);
	}

	/**
	 * @return A {@link BufferedImage} of a brown roof with an edge going from bottom to right
	 */
	public static BufferedImage getRoofBrownWithTopEdge()
	{
		int x = SIZE * 1;
		int y = SIZE * 3;

		return kenneyRpgUrban_.crop(x, y, SIZE, SIZE);
	}

	/**
	 * @return A {@link BufferedImage} of a brown roof with an edge going from bottom to right
	 */
	public static BufferedImage getRoofBrownWithBottomEdge()
	{
		int x = SIZE * 1;
		int y = SIZE * 5;

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
	 * @return A {@link BufferedImage} of a plain road
	 */
	public static BufferedImage getRoadBaseWithVerticalCrossWalk()
	{
		int x = SIZE * 0;
		int y = SIZE * 16;

		return kenneyRpgUrban_.crop(x, y, SIZE, SIZE);
	}

	/**
	 * @return A {@link BufferedImage} of a plain road
	 */
	public static BufferedImage getRoadBaseWithHorizontalCrossWalk()
	{
		int x = SIZE * 3;
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
	 * @return A {@link BufferedImage} of a road with a line on the top edge
	 */
	public static BufferedImage getRoadLineTopWithCrossWalk()
	{
		int x = SIZE * 0;
		int y = SIZE * 15;

		return kenneyRpgUrban_.crop(x, y, SIZE, SIZE);
	}

	/**
	 * @return A {@link BufferedImage} of a road with a line on the top edge
	 */
	public static BufferedImage getRoadLineBottomWithCrossWalk()
	{
		int x = SIZE * 0;
		int y = SIZE * 17;

		return kenneyRpgUrban_.crop(x, y, SIZE, SIZE);
	}

	/**
	 * @return A {@link BufferedImage} of a road with a line on the top edge
	 */
	public static BufferedImage getRoadLineLeftWithCrossWalk()
	{
		int x = SIZE * 2;
		int y = SIZE * 16;

		return kenneyRpgUrban_.crop(x, y, SIZE, SIZE);
	}

	/**
	 * @return A {@link BufferedImage} of a road with a line on the top edge
	 */
	public static BufferedImage getRoadLineRightWithCrossWalk()
	{
		int x = SIZE * 4;
		int y = SIZE * 16;

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
	 * @return A {@link BufferedImage} of a red car facing upward
	 */
	public static BufferedImage getCarUpRed()
	{
		int x = SIZE * 20;
		int y = SIZE * 16;

		return kenneyRpgUrban_.crop(x, y, SIZE, SIZE * 2);
	}

	/**
	 * @return A {@link BufferedImage} of a red car facing left
	 */
	public static BufferedImage getCarLeftRed()
	{
		int x = SIZE * 15;
		int y = SIZE * 16;

		return kenneyRpgUrban_.crop(x, y, SIZE * 2, SIZE * 2);
	}

	/**
	 * @return A {@link BufferedImage} of a red car facing upward
	 */
	public static BufferedImage getCarUpTaxi()
	{
		int x = SIZE * 20;
		int y = SIZE * 14;

		return kenneyRpgUrban_.crop(x, y, SIZE, SIZE * 2);
	}

	/**
	 * @return A {@link BufferedImage} of a red car facing left
	 */
	public static BufferedImage getCarLeftTaxi()
	{
		int x = SIZE * 15;
		int y = SIZE * 14;

		return kenneyRpgUrban_.crop(x, y, SIZE * 2, SIZE * 2);
	}

	/**
	 * @return A {@link BufferedImage} of a plain orange wall (variant a)
	 */
	public static BufferedImage getWallOrangeBaseVariantA()
	{
		int x = SIZE * 18;
		int y = SIZE * 6;

		return kenneyRpgUrban_.crop(x, y, SIZE, SIZE);
	}

	/**
	 * @return A {@link BufferedImage} of a orange wall with a left edge (variant a)
	 */
	public static BufferedImage getWallOrangeWithLeftEdgeVariantA()
	{
		int x = SIZE * 17;
		int y = SIZE * 6;

		return kenneyRpgUrban_.crop(x, y, SIZE, SIZE);
	}

	/**
	 * @return A {@link BufferedImage} of a orange wall with a right edge (variant a)
	 */
	public static BufferedImage getWallOrangeWithRightEdgeVariantA()
	{
		int x = SIZE * 19;
		int y = SIZE * 6;

		return kenneyRpgUrban_.crop(x, y, SIZE, SIZE);
	}

	/**
	 * @return A {@link BufferedImage} of a orange wall with a bottom edge (variant a)
	 */
	public static BufferedImage getWallOrangeWithBottomEdgeVariantA()
	{
		int x = SIZE * 18;
		int y = SIZE * 7;

		return kenneyRpgUrban_.crop(x, y, SIZE, SIZE);
	}

	/**
	 * @return A {@link BufferedImage} of a orange wall with an edge going from bottom to left (variant a)
	 */
	public static BufferedImage getWallOrangeWithBottomToLeftEdgeVariantA()
	{
		int x = SIZE * 17;
		int y = SIZE * 7;

		return kenneyRpgUrban_.crop(x, y, SIZE, SIZE);
	}

	/**
	 * @return A {@link BufferedImage} of a orange wall with an edge going from bottom to right (variant a)
	 */
	public static BufferedImage getWallOrangeWithBottomToRightEdgeVariantA()
	{
		int x = SIZE * 19;
		int y = SIZE * 7;

		return kenneyRpgUrban_.crop(x, y, SIZE, SIZE);
	}

	/**
	 * @return A {@link BufferedImage} of a orange wall with a bottom edge (variant a)
	 */
	public static BufferedImage getWallOrangeWithTopEdgeVariantA()
	{
		int x = SIZE * 18;
		int y = SIZE * 4;

		return kenneyRpgUrban_.crop(x, y, SIZE, SIZE);
	}

	/**
	 * @return A {@link BufferedImage} of a orange wall with a top edge (variant a)
	 */
	public static BufferedImage getWallOrangeWithTopToLeftEdgeVariantA()
	{
		int x = SIZE * 17;
		int y = SIZE * 4;

		return kenneyRpgUrban_.crop(x, y, SIZE, SIZE);
	}

	/**
	 * @return A {@link BufferedImage} of a orange wall with an edge going from top to right (variant a)
	 */
	public static BufferedImage getWallOrangeWithTopToRightEdgeVariantA()
	{
		int x = SIZE * 19;
		int y = SIZE * 4;

		return kenneyRpgUrban_.crop(x, y, SIZE, SIZE);
	}

	/**
	 * @return A {@link BufferedImage} of a door
	 */
	public static BufferedImage getDoor()
	{
		int x = SIZE * 7;
		int y = SIZE * 15;

		return kenneyRpgUrban_.crop(x, y, SIZE, SIZE);
	}

	/**
	 * @return A {@link BufferedImage} of a window
	 */
	public static BufferedImage getWindow()
	{
		int x = SIZE * 12;
		int y = SIZE * 16;

		return kenneyRpgUrban_.crop(x, y, SIZE, SIZE);
	}

	/**
	 * @return A {@link BufferedImage} of a stoplight facing downward
	 */
	public static BufferedImage getStoplightDown()
	{
		int x = SIZE * 4;
		int y = SIZE * 15;

		return kenneyRpgUrban_.crop(x, y, SIZE, SIZE);
	}

	/**
	 * @return Image for a two-tone yellow menu button that is clicked
	 */
	public static BufferedImage getMenuBtnTwoToneYellowClicked()
	{
		return menuBtnTwoToneYellowClicked_;
	}

	/**
	 * @return Image for a two-tone yellow menu button that is raised
	 */
	public static BufferedImage getMenuBtnTwoToneYellowRaised()
	{
		return menuBtnTwoToneYellowRaised_;
	}

	/**
	 * @return Image for a solid yellow menu button that is clicked
	 */
	public static BufferedImage getMenuBtnSolidYellowClicked()
	{
		return menuBtnSolidYellowClicked_;
	}

	/**
	 * @return Image for a solid yellow menu button that is raised
	 */
	public static BufferedImage getMenuBtnSolidYellowRaised()
	{
		return menuBtnSolidYellowRaised_;
	}

	/**
	 * @return Image for a yellow menu panel
	 */
	public static BufferedImage getMenuPanelYellow()
	{
		return menuPanelYellow_;
	}

	/**
	 * @return Image for a gray menu panel
	 */
	public static BufferedImage getMenuPanelGrey()
	{
		return menuPanelGrey_;
	}
}
