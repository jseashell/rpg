package com.seashell.rpg.entity.dynamic;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.seashell.rpg.entity.AbstractEntity;
import com.seashell.rpg.gui.GuiCamera;

/**
 * A {@link Entity} that all dynamic entities should extend. A dynamic entity is an entity with a movement component.
 */
public abstract class AbstractDynamicEntity extends AbstractEntity
{
	/**
	 * A constant amount for entity speed
	 */
	protected float speed_;

	/**
	 * A variable amount to move the entity on the x-axis
	 */
	protected float xMove_;

	/**
	 * A variable amount to move the entity on the y-axis
	 */
	protected float yMove_;

	/**
	 * Constructor
	 *
	 * @param camera
	 *            The camera controlling the scene showing this entity
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
	protected AbstractDynamicEntity(GuiCamera camera, BufferedImage texture, float speed, float x, float y, int width, int height)
	{
		super(camera, texture, x, y, width, height);
		speed_ = speed;
		xMove_ = x;
		yMove_ = y;
	}

	@Override
	public void render(Graphics2D g2d)
	{
		g2d.drawImage(getTexture(),
				(int) (getX() - camera_.getXOffset()),
				(int) (getY() - camera_.getYOffset()),
				getWidth(),
				getHeight(),
				null);
	}
}
