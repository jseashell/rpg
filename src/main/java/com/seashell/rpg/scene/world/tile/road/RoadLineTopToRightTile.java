package com.seashell.rpg.scene.world.tile.road;

import com.seashell.rpg.resource.R;
import com.seashell.rpg.tile.Tile;

/**
 * A {@link Tile} for road with a line going from the top edge to the right edge
 */
public class RoadLineTopToRightTile extends AbstractRoadTile
{
	/**
	 * Constructor
	 *
	 * @param id
	 *            Value for {@link #getId()}
	 */
	public RoadLineTopToRightTile(int id)
	{
		super(id, R.getRoadLineTopToRight());
	}
}
