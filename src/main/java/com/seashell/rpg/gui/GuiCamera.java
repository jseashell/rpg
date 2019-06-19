package com.seashell.rpg.gui;

import com.seashell.rpg.entity.Entity;

/**
 * The camera for the {@link Gui}
 */
public class GuiCamera
{
	private int guiResolutionWidth_;

	private int guiResolutionHeight_;

	/**
	 * Value for {@link #getXOffset()}
	 */
	private float xOffset_;

	/**
	 * Value for {@link #getYOffset()}
	 */
	private float yOffset_;

	/**
	 * Constructor
	 *
	 * @param xOffset
	 *            Initial value for {@link #getXOffset()}
	 * @param yOffset
	 *            Initial value for {@link #getYOffset()}
	 */
	public GuiCamera(int guiResolutionWidth, int guiResolutionHeight, float xOffset, float yOffset)
	{
		guiResolutionWidth_ = guiResolutionWidth;
		guiResolutionHeight_ = guiResolutionHeight;
		xOffset_ = xOffset;
		yOffset_ = yOffset;
	}

	/**
	 * Centers the camera on the given entity
	 *
	 * @param e
	 *            The {@link Entity}
	 */
	public void centerOnEntity(Entity e)
	{
		xOffset_ = e.getX() - guiResolutionWidth_ / 2 + e.getWidth() / 2;
		yOffset_ = e.getY() - guiResolutionHeight_ / 2 + e.getHeight() / 2;
	}

	/**
	 * Moves the camera based on the given amounts
	 *
	 * @param x
	 *            The amount to move the camera on the x-axis
	 * @param y
	 *            The amount to move the camera on the y-axis
	 */
	public void move(float x, float y)
	{
		xOffset_ += x;
		yOffset_ += y;
	}

	/**
	 * @return The offset of the camera on the x-axis
	 */
	public float getXOffset()
	{
		return xOffset_;
	}

	/**
	 * @param xOffset
	 *            The offset of the camera on the x-axis
	 */
	public void setxOffset(float xOffset)
	{
		xOffset_ = xOffset;
	}

	/**
	 * @return The offset of the camera on the y-axis
	 */
	public float getYOffset()
	{
		return yOffset_;
	}

	/**
	 * @param yOffset
	 *            The offset of the camera on the y-axis
	 */
	public void setyOffset(float yOffset)
	{
		yOffset_ = yOffset;
	}
}
