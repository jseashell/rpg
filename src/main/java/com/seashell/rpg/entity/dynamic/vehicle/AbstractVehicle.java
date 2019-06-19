package com.seashell.rpg.entity.dynamic.vehicle;

import java.awt.image.BufferedImage;

import com.seashell.rpg.entity.dynamic.AbstractDynamicEntity;
import com.seashell.rpg.gui.GuiCamera;

/**
 * A {@link Entity} that all vehicle entities should extend. A vehicle would be any entity that can transport any kind of character
 */
abstract class AbstractVehicle extends AbstractDynamicEntity
{
	/**
	 * Constructor
	 *
	 * @param camera
	 *            The {@link GuiCamera}
	 * @param texture
	 *            Value for {@link #getTexture()}
	 * @param speed
	 *            Value for {@link #speed_}
	 * @param x
	 *            Initial value for {@link #getX()}
	 * @param y
	 *            Initial value for {@link #getY()}
	 * @param width
	 *            Value for {@link #getWidth()}
	 * @param height
	 *            Value for {@link #getHeight()}
	 */
	AbstractVehicle(GuiCamera camera, BufferedImage texture, float speed, float x, float y, int width, int height)
	{
		super(camera, texture, speed, x, y, width, height);
	}
}
