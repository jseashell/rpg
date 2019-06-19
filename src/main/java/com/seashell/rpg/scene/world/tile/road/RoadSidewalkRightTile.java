package com.seashell.rpg.scene.world.tile.road;

import com.seashell.rpg.asset.Assets;
import com.seashell.rpg.tile.Tile;

/**
 * A {@link Tile} for road with a sidewalk on the right edge
 */
public class RoadSidewalkRightTile extends AbstractRoadTile
{
	/**
	 * Constructor
	 *
	 * @param id
	 *            Value for {@link #getId()}
	 */
	public RoadSidewalkRightTile(int id)
	{
		super(id, Assets.getRoadSidewalkRight());
	}

	@Override
	public boolean isSolid()
	{
		return false;
	}
}
