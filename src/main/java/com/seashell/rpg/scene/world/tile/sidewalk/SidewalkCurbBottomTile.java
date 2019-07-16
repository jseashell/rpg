package com.seashell.rpg.scene.world.tile.sidewalk;

import com.seashell.rpg.resource.R;
import com.seashell.rpg.tile.Tile;

/**
 * A {@link Tile} for sidewalk with a curb on the bottom edge
 */
public class SidewalkCurbBottomTile extends AbstractSidewalkTile
{
	/**
	 * Constructor
	 *
	 * @param id
	 *            Value for {@link #getId()}
	 */
	public SidewalkCurbBottomTile(int id)
	{
		super(id, R.getSidewalkCurbBottom());
	}
}
