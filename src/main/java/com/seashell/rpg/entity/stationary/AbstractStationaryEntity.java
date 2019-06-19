package com.seashell.rpg.entity.stationary;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.seashell.rpg.entity.AbstractEntity;

/**
 * A {@link Entity} that all dynamic entities should extend. A dynamic entity is an entity that lacks any sort of movement component
 */
// TODO Implement a simple stationary entity
public abstract class AbstractStationaryEntity extends AbstractEntity
{
	/**
	 * Constructor
	 *
	 * @param texture
	 *            Value for {@link #getTexture()}
	 * @param x
	 *            Initial value for {@link #getX()}
	 * @param y
	 *            Initial value for {@link #getY()}
	 * @param width
	 *            Value for {@link #getWidth()}
	 * @param height
	 *            Value for {@link #getHeight()}
	 */
	protected AbstractStationaryEntity(BufferedImage texture, float x, float y, int width, int height)
	{
		super(texture, x, y, width, height);
	}

	@Override
	public void tick()
	{
	}

	@Override
	public void render(Graphics2D g2d)
	{
	}

}
