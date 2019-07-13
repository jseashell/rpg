package com.seashell.rpg.scene.world.tile.road;

import com.seashell.rpg.asset.Assets;

public class SidewalkCurbLeftTile extends AbstractRoadTile
{

	public SidewalkCurbLeftTile(int id)
	{
		super(id, Assets.getSidewalkCurbLeft());
	}

	@Override
	public boolean isSolid()
	{
		return false;
	}

}
