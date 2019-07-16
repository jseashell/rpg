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
	 * Value for {@link #getRaisedImage()}
	 */
	private BufferedImage raisedImg_;
	/**
	 * Value for {@link #getClickedImage()}
	 */
	private BufferedImage clickedImg_;

	/**
	 * Value for {@link #getBounds()}
	 */
	private final Shape shape_;

	private boolean isHover_;

	private boolean isClick_;

	/**
	 * Constructor
	 *
	 * @param raisedImg
	 *            Value for {@link #getRaisedImage()}
	 * @param shape
	 *            Value for {@link #getBounds()}
	 */
	public AbstractMenuButton(BufferedImage raisedImg, BufferedImage clickedImg, Shape shape)
	{
		raisedImg_ = Objects.requireNonNull(raisedImg);
		clickedImg_ = Objects.requireNonNull(clickedImg);
		shape_ = Objects.requireNonNull(shape);
		isHover_ = false;
		isClick_ = false;
	}

	@Override
	public final BufferedImage getRaisedImage()
	{
		return raisedImg_;
	}

	@Override
	public final BufferedImage getClickedImage()
	{
		return clickedImg_;
	}

	public boolean isHover()
	{
		return isHover_;
	}

	public void setIsHover(boolean isHover)
	{
		isHover_ = isHover;
	}

	public boolean isClick()
	{
		return isClick_;

	}

	public void setIsClick(boolean b)
	{
		isClick_ = b;

	}

	@Override
	public final Shape getBounds()
	{
		return shape_;
	}
}
