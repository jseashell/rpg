package com.seashell.rpg.scene.world.tile.wall;

import com.seashell.rpg.resource.R;
import com.seashell.rpg.tile.Tile;

/**
 * A {@link Tile} for an orange wall with a left edge (variant a)
 */
public class WallOrangeWithLeftEdgeVariantATile extends AbstractWallTile
{
	/**
	 * Constructor
	 *
	 * @param id
	 *            Value for {@link #getId()}
	 */
	public WallOrangeWithLeftEdgeVariantATile(int id)
	{
		super(id, R.getWallOrangeWithLeftEdgeVariantA());
	}
}
