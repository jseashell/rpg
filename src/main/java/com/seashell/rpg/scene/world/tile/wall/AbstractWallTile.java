package com.seashell.rpg.scene.world.tile.wall;

import java.awt.image.BufferedImage;

import com.seashell.rpg.scene.world.tile.AbstractWorldTile;

/**
 * Abstract parent for all wall tiles to extend
 */
class AbstractWallTile extends AbstractWorldTile
{
	/**
	 * Constructor
	 *
	 * @param id
	 *            Value for {@link #getId()}
	 * @param texture
	 *            Value for {@link #getTexture()}
	 */
	AbstractWallTile(int id, BufferedImage texture)
	{
		super(id, texture);
	}

	/**
	 * @return {@code true}
	 */
	@Override
	public final boolean isSolid()
	{
		return true;
	}
}
