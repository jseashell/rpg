package com.seashell.rpg.scene.world.tile.road;

import com.seashell.rpg.resource.R;
import com.seashell.rpg.tile.Tile;

/**
 * A {@link Tile} for plain road
 */
public class RoadBaseTile extends AbstractRoadTile
{
	/**
	 * Constructor
	 *
	 * @param id
	 *            Value for {@link #getId()}
	 */
	public RoadBaseTile(int id)
	{
		super(id, R.getRoadBase());
	}
}
