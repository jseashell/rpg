package com.seashell.rpg.scene.world.tile.wall;

import com.seashell.rpg.asset.Assets;
import com.seashell.rpg.tile.Tile;

/**
 * A {@link Tile} for an orange wall with a top edge (variant a)
 */
public class WallOrangeWithTopEdgeVariantATile extends AbstractWallTile
{
	/**
	 * Constructor
	 *
	 * @param id
	 *            Value for {@link #getId()}
	 */
	public WallOrangeWithTopEdgeVariantATile(int id)
	{
		super(id, Assets.getWallOrangeWithTopEdgeVariantA());
	}
}
