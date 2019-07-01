package com.seashell.rpg.scene.menu;

import java.awt.Shape;
import java.awt.image.BufferedImage;

/**
 * API defining buttons for menu-based scenes
 */
public interface MenuButton
{
	/**
	 * @return The image for this button
	 */
	BufferedImage getImage();

	/**
	 * @return The shape for this button
	 */
	Shape getShape();
}
