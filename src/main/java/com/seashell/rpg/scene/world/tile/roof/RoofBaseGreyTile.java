package com.seashell.rpg.scene.world.tile.roof;

import com.seashell.rpg.resource.R;
import com.seashell.rpg.tile.Tile;

/**
 * A {@link Tile} for a plain grey roof
 */
public class RoofBaseGreyTile extends AbstractRoofTile
{
	/**
	 * Constructor
	 *
	 * @param id
	 *            Value for {@link #getId()}
	 */
	public RoofBaseGreyTile(int id)
	{
		super(id, R.getRoofGreyBase());
	}
}
