package com.seashell.rpg.scene.world.tile.road;

import com.seashell.rpg.resource.R;
import com.seashell.rpg.tile.Tile;

/**
 * A {@link Tile} for road with a line on the top edge
 */
public class RoadLineTopWithCrossWalkTile extends AbstractRoadTile
{
	/**
	 * Constructor
	 *
	 * @param id
	 *            Value for {@link #getId()}
	 */
	public RoadLineTopWithCrossWalkTile(int id)
	{
		super(id, R.getRoadLineTopWithCrossWalk());
	}
}
