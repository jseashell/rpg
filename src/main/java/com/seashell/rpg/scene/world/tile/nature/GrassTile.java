package com.seashell.rpg.scene.world.tile.nature;

import com.seashell.rpg.asset.Assets;
import com.seashell.rpg.scene.world.tile.AbstractWorldTile;
import com.seashell.rpg.tile.Tile;

/**
 * A {@link Tile} for plain grass
 */
public class GrassTile extends AbstractWorldTile
{
	/**
	 * Constructor
	 *
	 * @param id
	 *            Value for {@link #getId()}
	 */
	public GrassTile(int id)
	{
		super(id, Assets.getGrassBase());
	}

	@Override
	public boolean isSolid()
	{
		return false;
	}
}
