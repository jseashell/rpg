package com.seashell.rpg.tile;

import java.awt.image.BufferedImage;

/**
 * Abstract parent for all {@link Tile} implementations
 */
public abstract class AbstractTile implements Tile
{
	/**
	 * Value for {@link #getId()}
	 */
	private final int id_;

	/**
	 * Value for {@link #getTexture()}
	 */
	private final BufferedImage texture_;

	/**
	 * Constructor
	 *
	 * @param id
	 *            Value for {@link #getId()}
	 * @param texture
	 *            Value for {@link #getTexture()}
	 */
	protected AbstractTile(int id, BufferedImage texture)
	{
		id_ = id;
		texture_ = texture;
	}

	@Override
	public int getId()
	{
		return id_;
	}

	@Override
	public BufferedImage getTexture()
	{
		return texture_;
	}
}
