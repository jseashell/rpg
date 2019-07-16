package com.seashell.rpg.entity.dynamic.vehicle;

import java.awt.image.BufferedImage;

import com.seashell.rpg.asset.Assets;
import com.seashell.rpg.gui.GuiCamera;
import com.seashell.rpg.tile.Tile;

/**
 * A car entity
 */
public class CarTaxi extends AbstractVehicle
{
	/**
	 * Scaling factor for the car's height
	 */
	private static final int SCALE_HEIGHT_ = 8;

	/**
	 * Integer representing the direction of the car. {@code 0} for bottom to top. {@code 1} for right to left.
	 */
	private final int direction_;

	/**
	 * The width of the world represented as number of Tiles
	 */
	private final int worldWidth_;

	/**
	 * The height of the world represented as number of Tiles
	 */
	private final int worldHeight_;

	/**
	 * Constructor
	 *
	 * @param camera
	 *            The camera controlling the scene showing this entity
	 * @param worldHeight
	 *            The height of the world represented as number of Tiles
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
	public CarTaxi(int direction, GuiCamera camera, int worldWidth, int worldHeight, float x, float y)
	{
		super(camera, getTexture(direction), 7.0f, x, y, Assets.SIZE * getScaleWidth(direction), Assets.SIZE * SCALE_HEIGHT_);
		direction_ = direction;
		worldWidth_ = worldWidth;
		worldHeight_ = worldHeight;
	}

	/**
	 * Gets the texture for this car based on its given direction of travel
	 *
	 * @param direction
	 *            {@code 0} for up
	 *            {@code 1} for left
	 * @return The texture
	 */
	private static BufferedImage getTexture(int direction)
	{
		switch(direction)
		{
		case 0:
			return Assets.getCarUpTaxi();
		case 1:
			return Assets.getCarLeftTaxi();
		case 2:
		}

		return null;
	}

	/**
	 * Gets the scaling factor for this car's width based on its given direction of travel
	 *
	 * @param direction
	 *            {@code 0} for up
	 *            {@code 1} for left
	 * @return Scaling factor for the car's width
	 */
	private static int getScaleWidth(int direction)
	{
		return direction == 0 ? 4 : 8;
	}

	@Override
	public void tick()
	{
		if(direction_ == 0)
		{
			if(y_ <= 0)
			{
				y_ = (worldHeight_ * height_) - Tile.SIZE;
			}

			y_ += -speed_;
		}
		else
		{
			if(x_ <= 0)
			{
				x_ = (worldWidth_ * width_) - Tile.SIZE;
			}

			x_ += -speed_;
		}
	}
}
