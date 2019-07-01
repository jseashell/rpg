package com.seashell.rpg.scene.menu;

import java.awt.Shape;
import java.awt.image.BufferedImage;
import java.util.Objects;

/**
 * Parent class for all menu buttons to extend
 */
public abstract class AbstractMenuButton implements MenuButton
{
	/**
	 * Value for {@link #getImage()}
	 */
	private final BufferedImage img_;

	/**
	 * Value for {@link #getShape()}
	 */
	private final Shape shape_;

	/**
	 * Constructor
	 *
	 * @param img
	 *            Value for {@link #getImage()}
	 * @param shape
	 *            Value for {@link #getShape()}
	 */
	public AbstractMenuButton(BufferedImage img, Shape shape)
	{
		img_ = Objects.requireNonNull(img);
		shape_ = Objects.requireNonNull(shape);
	}

	@Override
	public final BufferedImage getImage()
	{
		return img_;
	}

	@Override
	public final Shape getShape()
	{
		return shape_;
	}
}
