package com.seashell.rpg.scene.world.tile.sidewalk;

import com.seashell.rpg.resource.R;
import com.seashell.rpg.tile.Tile;

/**
 * A {@link Tile} for sidewalk with a curb going from the bottom edge to the left edge
 */
public class SidewalkCurbBottomToLeftTile extends AbstractSidewalkTile
{
	/**
	 * Constructor
	 *
	 * @param id
	 *            Value for {@link #getId()}
	 */
	public SidewalkCurbBottomToLeftTile(int id)
	{
		super(id, R.getSidewalkCurbBottomToLeft());
	}
}
