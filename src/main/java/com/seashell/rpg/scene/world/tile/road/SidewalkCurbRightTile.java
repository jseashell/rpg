package com.seashell.rpg.scene.world.tile.road;

import com.seashell.rpg.asset.Assets;

public class SidewalkCurbRightTile extends AbstractRoadTile
{

	public SidewalkCurbRightTile(int id)
	{
		super(id, Assets.getSidewalkCurbRight());
	}

	@Override
	public boolean isSolid()
	{
		return false;
	}

}
