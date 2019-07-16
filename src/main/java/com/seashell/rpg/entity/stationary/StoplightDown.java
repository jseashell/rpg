package com.seashell.rpg.entity.stationary;

import com.seashell.rpg.gui.GuiCamera;
import com.seashell.rpg.resource.R;

/**
 * A stationary stoplight entity facing downard
 */
public class StoplightDown extends AbstractStationaryEntity
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
	public StoplightDown(GuiCamera camera, float x, float y)
	{
		super(camera, R.getStoplightDown(), x, y,
				R.SIZE * SCALE_,
				R.SIZE * SCALE_);
	}
}
