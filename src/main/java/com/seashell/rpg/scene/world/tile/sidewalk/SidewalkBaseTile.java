package com.seashell.rpg.scene.world.tile.sidewalk;

import com.seashell.rpg.asset.Assets;
import com.seashell.rpg.tile.Tile;

/**
 * A {@link Tile} for plain sidewalk
 */
public class SidewalkBaseTile extends AbstractSidewalkTile
{
	/**
	 * Constructor
	 *
	 * @param id
	 *            Value for {@link #getId()}
	 */
	public SidewalkBaseTile(int id)
	{
		super(id, Assets.getSidewalkBase());
	}
}
