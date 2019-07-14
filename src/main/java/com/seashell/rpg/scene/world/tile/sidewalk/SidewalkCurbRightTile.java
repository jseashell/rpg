package com.seashell.rpg.scene.world.tile.sidewalk;

import com.seashell.rpg.asset.Assets;
import com.seashell.rpg.tile.Tile;

/**
 * A {@link Tile} for sidewalk with a curb on the top edge
 */
public class SidewalkCurbRightTile extends AbstractSidewalkTile
{
	/**
	 * Constructor
	 *
	 * @param id
	 *            Value for {@link #getId()}
	 */
	public SidewalkCurbRightTile(int id)
	{
		super(id, Assets.getSidewalkCurbRight());
	}
}
