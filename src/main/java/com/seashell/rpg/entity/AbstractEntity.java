package com.seashell.rpg.entity;

import java.awt.image.BufferedImage;

import com.seashell.rpg.gui.GuiCamera;

/**
 * Abstract parent for all {@link Entity} implementations
 */
public abstract class AbstractEntity implements Entity
{
	/**
	 * The camera controlling the scene showing this entity
	 */
	protected final GuiCamera camera_;

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
	 * @param camera
	 *            The camera controlling the scene showing this entity
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
	protected AbstractEntity(GuiCamera camera, BufferedImage texture, float x, float y, int width, int height)
	{
		camera_ = camera;
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
