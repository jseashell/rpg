package com.seashell.rpg.entity.dynamic.character;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import com.seashell.rpg.gui.GuiCamera;

/**
 * A {@link AbstractCharacter} that cannot be controlled by a player
 */
// TODO #8 Implement a simple NPC
public class NonPlayerCharacter extends AbstractCharacter
{
	/**
	 * Constructor
	 *
	 * @param camera
	 *            The {@link GuiCamera}
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
	public NonPlayerCharacter(GuiCamera camera, BufferedImage texture, float x, float y, int width, int height) throws IOException
	{
		super(camera, texture, x * width, y * height, width, height);
	}

	@Override
	public void tick()
	{
	}

	@Override
	public void render(Graphics2D g2d)
	{
	}
}
