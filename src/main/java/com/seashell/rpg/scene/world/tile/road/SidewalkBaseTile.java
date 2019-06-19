package com.seashell.rpg.scene.world.tile.road;

import com.seashell.rpg.asset.Assets;

public class SidewalkBaseTile extends AbstractRoadTile
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

	@Override
	public boolean isSolid()
	{
		return false;
	}
}
