package com.seashell.rpg.scene.world.tile.sidewalk;

import com.seashell.rpg.resource.R;
import com.seashell.rpg.tile.Tile;

/**
 * A {@link Tile} for sidewalk with a curb on the left edge
 */
public class SidewalkCurbLeftTile extends AbstractSidewalkTile
{
	/**
	 * Constructor
	 *
	 * @param id
	 *            Value for {@link #getId()}
	 */
	public SidewalkCurbLeftTile(int id)
	{
		super(id, R.getSidewalkCurbLeft());
	}
}
