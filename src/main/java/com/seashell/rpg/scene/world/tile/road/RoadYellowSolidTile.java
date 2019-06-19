package com.seashell.rpg.scene.world.tile.road;

import com.seashell.rpg.asset.Assets;
import com.seashell.rpg.tile.Tile;

/**
 * A {@link Tile} for road with a vertical yellow divider line
 */
public class RoadYellowSolidTile extends AbstractRoadTile
{
	/**
	 * Constructor
	 *
	 * @param id
	 *            Value for {@link #getId()}
	 */
	public RoadYellowSolidTile(int id)
	{
		super(id, Assets.getRoadYellowSolidVertical());
	}

	@Override
	public boolean isSolid()
	{
		return false;
	}
}
