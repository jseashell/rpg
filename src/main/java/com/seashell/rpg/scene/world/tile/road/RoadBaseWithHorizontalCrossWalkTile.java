package com.seashell.rpg.scene.world.tile.road;

import com.seashell.rpg.resource.R;
import com.seashell.rpg.tile.Tile;

/**
 * A {@link Tile} for plain road
 */
public class RoadBaseWithHorizontalCrossWalkTile extends AbstractRoadTile
{
	/**
	 * Constructor
	 *
	 * @param id
	 *            Value for {@link #getId()}
	 */
	public RoadBaseWithHorizontalCrossWalkTile(int id)
	{
		super(id, R.getRoadBaseWithHorizontalCrossWalk());
	}
}
