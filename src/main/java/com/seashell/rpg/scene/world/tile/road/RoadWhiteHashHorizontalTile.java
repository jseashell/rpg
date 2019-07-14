package com.seashell.rpg.scene.world.tile.road;

import com.seashell.rpg.asset.Assets;
import com.seashell.rpg.tile.Tile;

/**
 * A {@link Tile} for road with a horizontal white hash mark
 */
public class RoadWhiteHashHorizontalTile extends AbstractRoadTile
{
	/**
	 * Constructor
	 *
	 * @param id
	 *            Value for {@link #getId()}
	 */
	public RoadWhiteHashHorizontalTile(int id)
	{
		super(id, Assets.getRoadWhiteHashHorizontal());
	}
}
