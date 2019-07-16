package com.seashell.rpg.scene.world.tile.sidewalk;

import java.awt.image.BufferedImage;

import com.seashell.rpg.scene.world.tile.AbstractWorldTile;

/**
 * Abstract parent for all sidewalk tiles
 */
class AbstractSidewalkTile extends AbstractWorldTile
{
	/**
	 * Constructor
	 *
	 * @param id
	 *            Value for {@link #getId()}
	 * @param texture
	 *            Value for {@link #getTexture()}
	 */
	AbstractSidewalkTile(int id, BufferedImage texture)
	{
		super(id, texture);
	}

	@Override
	public final boolean isSolid()
	{
		return false;
	}

}
