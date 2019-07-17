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
	 * Value for {@link #getIdleImage()}
	 */
	private BufferedImage idleImage_;
	/**
	 * Value for {@link #getActiveImage()}
	 */
	private BufferedImage activeImage_;

	/**
	 * Value for {@link #getShape()}
	 */
	private final Shape shape_;

	/**
	 * Value for {@link #isHovered()}
	 */
	private boolean isHovered_;

	/**
	 * Value for {@link #isClicked()}
	 */
	private boolean isClicked_;

	/**
	 * Constructor
	 *
	 * @param shape
	 *            Value for {@link #getShape()}
	 * @param idleImage
	 *            Value for {@link #getIdleImage()}
	 * @param activeImage
	 *            Value for {@link #getIdleImage()}
	 */
	public AbstractMenuButton(Shape shape, BufferedImage idleImage, BufferedImage activeImage)
	{
		shape_ = Objects.requireNonNull(shape);
		idleImage_ = Objects.requireNonNull(idleImage);
		activeImage_ = Objects.requireNonNull(activeImage);
		isHovered_ = false;
		isClicked_ = false;
	}

	@Override
	public final Shape getShape()
	{
		return shape_;
	}

	@Override
	public final BufferedImage getIdleImage()
	{
		return idleImage_;
	}

	@Override
	public final BufferedImage getActiveImage()
	{
		return activeImage_;
	}

	@Override
	public boolean isHovered()
	{
		return isHovered_;
	}

	/**
	 * @param isHovered
	 *            {@code true} if this button is being hovered over
	 */
	public void setIsHovered(boolean isHovered)
	{
		isHovered_ = isHovered;
	}

	@Override
	public boolean isClicked()
	{
		return isClicked_;

	}

	/**
	 * @param isClicked
	 *            {@code true} if this button is clicked
	 */
	public void setIsClick(boolean isClicked)
	{
		isClicked_ = isClicked;
	}
}
