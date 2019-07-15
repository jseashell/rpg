package com.seashell.rpg.scene.world.tile.wall;

import com.seashell.rpg.asset.Assets;
import com.seashell.rpg.tile.Tile;

/**
 * A {@link Tile} for an orange wall with a right edge (variant a)
 */
public class WallOrangeWithRightEdgeVariantATile extends AbstractWallTile
{
	/**
	 * Constructor
	 *
	 * @param id
	 *            Value for {@link #getId()}
	 */
	public WallOrangeWithRightEdgeVariantATile(int id)
	{
		super(id, Assets.getWallOrangeWithRightEdgeVariantA());
	}
}
