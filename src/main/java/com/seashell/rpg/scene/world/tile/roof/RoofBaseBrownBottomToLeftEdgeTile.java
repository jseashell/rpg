package com.seashell.rpg.scene.world.tile.roof;

import com.seashell.rpg.asset.Assets;
import com.seashell.rpg.tile.Tile;

/**
 * A {@link Tile} for a brown roof with an edge going from bottom to right
 */
public class RoofBaseBrownBottomToLeftEdgeTile extends AbstractRoofTile
{
	/**
	 * Constructor
	 *
	 * @param id
	 *            Value for {@link #getId()}
	 */
	public RoofBaseBrownBottomToLeftEdgeTile(int id)
	{
		super(id, Assets.getRoofBrownBottomToLeftEdge());
	}
}
