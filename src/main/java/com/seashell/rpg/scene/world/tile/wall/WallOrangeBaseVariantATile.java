package com.seashell.rpg.scene.world.tile.wall;

import com.seashell.rpg.asset.Assets;
import com.seashell.rpg.tile.Tile;

/**
 * A {@link Tile} for a plain orange wall (variant a)
 */
public class WallOrangeBaseVariantATile extends AbstractWallTile
{
	/**
	 * Constructor
	 *
	 * @param id
	 *            Value for {@link #getId()}
	 */
	public WallOrangeBaseVariantATile(int id)
	{
		super(id, Assets.getWallOrangeBaseVariantA());
	}
}
