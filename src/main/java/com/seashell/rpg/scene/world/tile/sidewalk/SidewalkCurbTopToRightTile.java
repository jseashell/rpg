package com.seashell.rpg.scene.world.tile.sidewalk;

import com.seashell.rpg.asset.Assets;
import com.seashell.rpg.tile.Tile;

/**
 * A {@link Tile} for sidewalk with a curb going from the top edge to the right edge
 */
public class SidewalkCurbTopToRightTile extends AbstractSidewalkTile
{
	/**
	 * Constructor
	 *
	 * @param id
	 *            Value for {@link #getId()}
	 */
	public SidewalkCurbTopToRightTile(int id)
	{
		super(id, Assets.getSidewalkCurbTopToRight());
	}
}
