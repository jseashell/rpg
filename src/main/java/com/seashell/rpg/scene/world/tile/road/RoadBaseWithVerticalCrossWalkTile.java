package com.seashell.rpg.scene.world.tile.road;

import com.seashell.rpg.resource.R;
import com.seashell.rpg.tile.Tile;

/**
 * A {@link Tile} for plain road
 */
public class RoadBaseWithVerticalCrossWalkTile extends AbstractRoadTile
{
	/**
	 * Constructor
	 *
	 * @param id
	 *            Value for {@link #getId()}
	 */
	public RoadBaseWithVerticalCrossWalkTile(int id)
	{
		super(id, R.getRoadBaseWithVerticalCrossWalk());
	}
}
