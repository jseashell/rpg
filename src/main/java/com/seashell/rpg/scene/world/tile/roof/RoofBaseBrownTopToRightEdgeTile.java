package com.seashell.rpg.scene.world.tile.roof;

import com.seashell.rpg.resource.R;
import com.seashell.rpg.tile.Tile;

/**
 * A {@link Tile} for a brown roof with an edge going from bottom to right
 */
public class RoofBaseBrownTopToRightEdgeTile extends AbstractRoofTile
{
	/**
	 * Constructor
	 *
	 * @param id
	 *            Value for {@link #getId()}
	 */
	public RoofBaseBrownTopToRightEdgeTile(int id)
	{
		super(id, R.getRoofBrownTopToRightEdge());
	}
}
