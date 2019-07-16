package com.seashell.rpg.scene.world.tile.wall;

import com.seashell.rpg.asset.Assets;
import com.seashell.rpg.tile.Tile;

/**
 * A {@link Tile} for an orange wall with an edge going from bottom to right (variant a)
 */
public class WallOrangeWithBottomToRightEdgeVariantATile extends AbstractWallTile
{
	/**
	 * Constructor
	 *
	 * @param id
	 *            Value for {@link #getId()}
	 */
	public WallOrangeWithBottomToRightEdgeVariantATile(int id)
	{
		super(id, Assets.getWallOrangeWithBottomToRightEdgeVariantA());
	}
}
