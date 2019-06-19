package com.seashell.rpg.entity;

import java.awt.image.BufferedImage;

import com.seashell.rpg.Render;

/**
 * API defining an entity for the game
 */
public interface Entity extends Render
{
	/**
	 * @return The texture for this entity
	 */
	BufferedImage getTexture();

	/**
	 * @return The x-coordinate for this entity
	 */
	float getX();

	/**
	 * @return The x-coordinate for this entity
	 */
	float getY();

	/**
	 * @return The width of this entity
	 */
	int getWidth();

	/**
	 * @return The height of this entity
	 */
	int getHeight();
}
