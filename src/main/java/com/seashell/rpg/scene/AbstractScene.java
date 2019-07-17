package com.seashell.rpg.scene;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 * Abstract parent for all scene implementations
 */
public abstract class AbstractScene implements Scene
{
	/**
	 * Draws text to this scene
	 *
	 * @param g2d
	 *            The graphics for this scene
	 * @param bounds
	 *            The bounds for the text component
	 * @param text
	 *            The text to draw
	 * @param color
	 *            The color of the text
	 */
	protected final void drawText(Graphics2D g2d, Rectangle bounds, String text, Color color, Font font)
	{
		FontMetrics metrics = g2d.getFontMetrics(font);

		int x = bounds.x + (bounds.width - metrics.stringWidth(text)) / 2 + 5;
		int y = bounds.y + ((bounds.height - metrics.getHeight()) / 2) + metrics.getAscent() - 5;

		g2d.setFont(font);
		g2d.setColor(color);

		g2d.drawString(text, x, y);
	}
}
