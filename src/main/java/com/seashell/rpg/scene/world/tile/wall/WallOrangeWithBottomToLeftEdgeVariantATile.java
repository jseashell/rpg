package com.seashell.rpg.scene.world.tile.wall;

import com.seashell.rpg.resource.R;
import com.seashell.rpg.tile.Tile;

/**
 * A {@link Tile} for an orange wall with an edge going from bottom to left (variant a)
 */
public class WallOrangeWithBottomToLeftEdgeVariantATile extends AbstractWallTile
{
	/**
	 * Constructor
	 *
	 * @param id
	 *            Value for {@link #getId()}
	 */
	public WallOrangeWithBottomToLeftEdgeVariantATile(int id)
	{
		super(id, R.getWallOrangeWithBottomToLeftEdgeVariantA());
	}
}
