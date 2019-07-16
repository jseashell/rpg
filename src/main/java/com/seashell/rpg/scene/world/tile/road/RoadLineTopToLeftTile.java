package com.seashell.rpg.scene.world.tile.road;

import com.seashell.rpg.asset.Assets;
import com.seashell.rpg.tile.Tile;

/**
 * A {@link Tile} for road with a line going from the top edge to the left edge
 */
public class RoadLineTopToLeftTile extends AbstractRoadTile
{
	/**
	 * Constructor
	 *
	 * @param id
	 *            Value for {@link #getId()}
	 */
	public RoadLineTopToLeftTile(int id)
	{
		super(id, Assets.getRoadLineTopToLeft());
	}
}
