package com.seashell.rpg;

import java.awt.Graphics2D;

/**
 * API defining objects that should be rendered to the screen
 */
public interface Render
{
	/**
	 * Updates this implementor's variables that represent canvas location and any other pertinent metadata
	 */
	void tick();

	/**
	 * Renders this implementor to the given graphics
	 *
	 * @param g2d
	 *            A {@link Graphics2D} for rendering game objects to the canvas
	 */
	void render(Graphics2D g2d);
}
