package com.seashell.rpg.scene.world.tile.road;

import com.seashell.rpg.resource.R;
import com.seashell.rpg.tile.Tile;

/**
 * A {@link Tile} for road with a line on the bottom edge
 */
public class RoadLineRightWithCrossWalkTile extends AbstractRoadTile
{
	/**
	 * Constructor
	 *
	 * @param id
	 *            Value for {@link #getId()}
	 */
	public RoadLineRightWithCrossWalkTile(int id)
	{
		super(id, R.getRoadLineRightWithCrossWalk());
	}
}
