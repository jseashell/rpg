package com.seashell.rpg.entity.dynamic.character;

import java.awt.image.BufferedImage;

import com.seashell.rpg.entity.dynamic.AbstractDynamicEntity;
import com.seashell.rpg.gui.GuiCamera;

/**
 * An {@link Entity} representing a character
 */
public abstract class AbstractCharacter extends AbstractDynamicEntity
{
	/**
	 * Constructor
	 *
	 * @param camera
	 *            The {@link GuiCamera}
	 * @param x
	 *            Initial value for {@link #getX()}
	 * @param y
	 *            Initial value for {@link #getY()}
	 * @param width
	 *            Value for {@link #getWidth()}
	 * @param height
	 *            Value for {@link #getHeight()}
	 */
	public AbstractCharacter(GuiCamera camera, BufferedImage texture, float x, float y, int width, int height)
	{
		super(camera, texture, 2.0f, x, y, width, height);
	}
}
