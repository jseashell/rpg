package com.seashell.rpg.scene.world.tile.nature;

import com.seashell.rpg.resource.R;
import com.seashell.rpg.scene.world.tile.AbstractWorldTile;
import com.seashell.rpg.tile.Tile;

/**
 * A {@link Tile} for plain grass
 */
public class GrassBaseTile extends AbstractWorldTile
{
	/**
	 * Constructor
	 *
	 * @param id
	 *            Value for {@link #getId()}
	 */
	public GrassBaseTile(int id)
	{
		super(id, R.getGrassBase());
	}

	@Override
	public boolean isSolid()
	{
		return false;
	}
}
