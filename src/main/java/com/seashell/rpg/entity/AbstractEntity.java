package com.seashell.rpg.entity;

import java.awt.image.BufferedImage;

/**
 * Abstract parent for all {@link Entity} implementations
 */
public abstract class AbstractEntity implements Entity
{
	/**
	 * Value for {@link #getTexture()}
	 */
	private BufferedImage texture_;

	/**
	 * Value for {@link #getX()}
	 */
	protected float x_;

	/**
	 * Value for {@link #getY()}
	 */
	protected float y_;

	/**
	 * Value for {@link #getWidth()}
	 */
	protected final int width_;

	/**
	 * Value for {@link #getHeight()}
	 */
	protected final int height_;

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
	protected AbstractEntity(BufferedImage texture, float x, float y, int width, int height)
	{
		texture_ = texture;
		x_ = x;
		y_ = y;
		width_ = width;
		height_ = height;
	}

	@Override
	public final BufferedImage getTexture()
	{
		return texture_;
	}

	@Override
	public final float getX()
	{
		return x_;
	}

	/**
	 * Set the return for {@link #getX()}. Only available to extensions of this class
	 *
	 * @param x
	 *            The x to set
	 */
	protected final void setX(float x)
	{
		x_ = x;
	}

	@Override
	public final float getY()
	{
		return y_;
	}

	/**
	 * Set the return for {@link #getY()}. Only available to extensions of this class
	 *
	 * @param y
	 *            The y to set
	 */
	protected final void setY(float y)
	{
		y_ = y;
	}

	@Override
	public final int getWidth()
	{
		return width_;

	}

	@Override
	public final int getHeight()
	{
		return height_;
	}
}
