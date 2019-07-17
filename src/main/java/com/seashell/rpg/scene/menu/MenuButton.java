package com.seashell.rpg.scene.menu;

import java.awt.Shape;
import java.awt.image.BufferedImage;

/**
 * API defining buttons for menu-based scenes
 */
public interface MenuButton
{

	/**
	 * @return The bounds for this button
	 */
	Shape getShape();

	/**
	 * @return The image to use when this button is in the idle (non-clicked) state
	 */
	BufferedImage getIdleImage();

	/**
	 * @return The image to use when this button is in the active (clicked) state
	 */
	BufferedImage getActiveImage();

	/**
	 * @return {@code true} if this button is being hovered over
	 */
	boolean isHovered();

	/**
	 * @return {@code true} if this button is clicked
	 */
	boolean isClicked();
}
