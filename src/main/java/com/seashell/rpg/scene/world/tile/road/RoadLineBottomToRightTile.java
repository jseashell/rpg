package com.seashell.rpg.scene.world.tile.road;

import com.seashell.rpg.resource.R;
import com.seashell.rpg.tile.Tile;

/**
 * A {@link Tile} for road with a line going from the bottom edge to the right edge
 */
public class RoadLineBottomToRightTile extends AbstractRoadTile
{
	/**
	 * Constructor
	 *
	 * @param id
	 *            Value for {@link #getId()}
	 */
	public RoadLineBottomToRightTile(int id)
	{
		super(id, R.getRoadLineBottomToRight());
	}
}
