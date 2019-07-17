package com.seashell.rpg.scene.world.tile.roof;

import com.seashell.rpg.resource.R;
import com.seashell.rpg.tile.Tile;

/**
 * A {@link Tile} for a brown roof with an edge going from bottom to right
 */
public class RoofBaseBrownTopToLeftEdgeTile extends AbstractRoofTile
{
	/**
	 * Constructor
	 *
	 * @param id
	 *            Value for {@link #getId()}
	 */
	public RoofBaseBrownTopToLeftEdgeTile(int id)
	{
		super(id, R.getRoofBrownTopToLeftEdge());
	}
}
