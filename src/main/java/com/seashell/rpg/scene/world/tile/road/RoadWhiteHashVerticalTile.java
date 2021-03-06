package com.seashell.rpg.scene.world.tile.road;

import com.seashell.rpg.resource.R;
import com.seashell.rpg.tile.Tile;

/**
 * A {@link Tile} for road with a vertical white hash mark
 */
public class RoadWhiteHashVerticalTile extends AbstractRoadTile
{
	/**
	 * Constructor
	 *
	 * @param id
	 *            Value for {@link #getId()}
	 */
	public RoadWhiteHashVerticalTile(int id)
	{
		super(id, R.getRoadWhiteHashVertical());
	}
}
