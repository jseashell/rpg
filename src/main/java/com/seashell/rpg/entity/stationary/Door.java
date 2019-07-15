package com.seashell.rpg.entity.stationary;

import com.seashell.rpg.asset.Assets;
import com.seashell.rpg.gui.GuiCamera;

/**
 * A stationary door entity
 */
public class Door extends AbstractStationaryEntity
{
	/**
	 * Scaling factor for the character's width and height
	 */
	private static final int SCALE_ = 4;

	/**
	 * Constructor
	 *
	 * @param camera
	 *            The camera controlling the scene showing this entity
	 * @param x
	 *            Initial value for {@link #getX()}
	 * @param y
	 *            Initial value for {@link #getY()}
	 */
	public Door(GuiCamera camera, float x, float y)
	{
		super(camera, Assets.getDoor(), x, y,
				Assets.SIZE * SCALE_,
				Assets.SIZE * SCALE_);
	}
}
