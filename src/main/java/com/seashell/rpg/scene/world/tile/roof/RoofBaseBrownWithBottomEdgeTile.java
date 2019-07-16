package com.seashell.rpg.scene.world.tile.roof;

import com.seashell.rpg.resource.R;
import com.seashell.rpg.tile.Tile;

/**
 * A {@link Tile} for a brown roof with a bottom edge
 */
public class RoofBaseBrownWithBottomEdgeTile extends AbstractRoofTile
{
	/**
	 * Constructor
	 *
	 * @param id
	 *            Value for {@link #getId()}
	 */
	public RoofBaseBrownWithBottomEdgeTile(int id)
	{
		super(id, R.getRoofBrownWithBottomEdge());
	}
}
