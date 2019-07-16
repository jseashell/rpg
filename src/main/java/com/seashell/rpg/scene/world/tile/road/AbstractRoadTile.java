package com.seashell.rpg.scene.world.tile.road;

import java.awt.image.BufferedImage;

import com.seashell.rpg.scene.world.tile.AbstractWorldTile;

/**
 * Abstract parent for all road tiles
 */
abstract class AbstractRoadTile extends AbstractWorldTile
{
	/**
	 * Constructor
	 *
	 * @param id
	 *            Value for {@link #getId()}
	 * @param texture
	 *            Value for {@link #getTexture()}
	 */
	public AbstractRoadTile(int id, BufferedImage texture)
	{
		super(id, texture);
	}

	@Override
	public final boolean isSolid()
	{
		return false;
	}
}
