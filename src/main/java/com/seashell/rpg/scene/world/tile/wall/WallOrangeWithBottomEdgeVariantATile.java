package com.seashell.rpg.scene.world.tile.wall;

import com.seashell.rpg.resource.R;
import com.seashell.rpg.tile.Tile;

/**
 * A {@link Tile} for an orange wall with a bottom edge (variant a)
 */
public class WallOrangeWithBottomEdgeVariantATile extends AbstractWallTile
{
	/**
	 * Constructor
	 *
	 * @param id
	 *            Value for {@link #getId()}
	 */
	public WallOrangeWithBottomEdgeVariantATile(int id)
	{
		super(id, R.getWallOrangeWithBottomEdgeVariantA());
	}
}
