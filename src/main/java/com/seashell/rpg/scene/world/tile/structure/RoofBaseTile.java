package com.seashell.rpg.scene.world.tile.structure;

import com.seashell.rpg.asset.Assets;
import com.seashell.rpg.scene.world.tile.AbstractWorldTile;
import com.seashell.rpg.tile.Tile;

/**
 * A {@link Tile} for a plain roof
 */
public class RoofBaseTile extends AbstractWorldTile
{
	/**
	 * Constructor
	 *
	 * @param id
	 *            Value for {@link #getId()}
	 */
	public RoofBaseTile(int id)
	{
		super(id, Assets.getRoofBase());
	}

	@Override
	public boolean isSolid()
	{
		return true;
	}
}
