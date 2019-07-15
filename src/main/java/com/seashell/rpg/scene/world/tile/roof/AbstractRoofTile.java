package com.seashell.rpg.scene.world.tile.roof;

import java.awt.image.BufferedImage;

import com.seashell.rpg.scene.world.tile.AbstractWorldTile;

abstract class AbstractRoofTile extends AbstractWorldTile
{

	AbstractRoofTile(int id, BufferedImage texture)
	{
		super(id, texture);
	}

	@Override
	public final boolean isSolid()
	{
		return true;
	}
}
