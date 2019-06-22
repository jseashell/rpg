package com.seashell.rpg.entity.dynamic.vehicle;

import com.seashell.rpg.asset.Assets;
import com.seashell.rpg.gui.GuiCamera;
import com.seashell.rpg.tile.Tile;

/**
 * A car entity
 */
public class Car extends AbstractVehicle
{
	/**
	 * The height of the world represented as number of Tiles
	 */
	private final int worldHeight_;

	/**
	 * Constructor
	 *
	 * @param camera
	 *            The {@link GuiCamera}
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
	public Car(GuiCamera camera, int worldHeight, float x, float y, int width, int height)
	{
		super(camera, Assets.getCarUp(), 6.0f, x, y, width, height);
		worldHeight_ = worldHeight;
	}

	@Override
	public void tick()
	{
		if(y_ <= 0)
		{
			y_ = (worldHeight_ * height_) - Tile.SIZE;
		}

		y_ += -speed_;
	}
}
