package com.seashell.rpg.scene.world.tile.road;

import com.seashell.rpg.asset.Assets;
import com.seashell.rpg.tile.Tile;

/**
 * A {@link Tile} for road with a sidewalk on the left edge
 */
public class RoadLineLeftTile extends AbstractRoadTile
{
	/**
	 * Constructor
	 *
	 * @param id
	 *            Value for {@link #getId()}
	 */
	public RoadLineLeftTile(int id)
	{
		super(id, Assets.getRoadLineLeft());
	}

	@Override
	public boolean isSolid()
	{
		return false;
	}
}
