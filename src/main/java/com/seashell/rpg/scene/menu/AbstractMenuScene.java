package com.seashell.rpg.scene.menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import com.seashell.rpg.scene.AbstractScene;

/**
 * Parent class for all menu-based scenes to extend
 */
public abstract class AbstractMenuScene extends AbstractScene
{
	/**
	 * Scale for the buttons on this menu
	 */
	protected static final int SCALE_ = 2;

	/**
	 * Background color. Black, 50% transparent
	 */
	protected static final Color COLOR_MODAL_ = new Color(0, 0, 0, 127);

	/**
	 * Font size for buttons on this menu
	 */
	protected static final int FONT_SIZE_ = 18 * SCALE_;

	/**
	 * Font for the menu
	 */
	protected static final Font FONT_ = new Font(Font.MONOSPACED, Font.BOLD, FONT_SIZE_);

	/**
	 * Draws text for the given button in the hovered state -- the text is drawn white
	 *
	 * @param g2d
	 *            The graphics to draw the text with
	 * @param rect
	 *            The bounds of the hoverable area
	 * @param text
	 *            The text to draw
	 */
	protected final void drawHoveredText(Graphics2D g2d, Rectangle rect, String text)
	{
		Color color = Color.WHITE;
		drawText(g2d, rect, text, color, FONT_);

	}

	/**
	 * Draws text for the given button in the default state -- the text is drawn dark gray
	 *
	 * @param g2d
	 *            The graphics to draw the text with
	 * @param rect
	 *            The bounds of the text area
	 * @param text
	 *            The text to draw
	 */
	protected final void drawDefaultText(Graphics2D g2d, Rectangle rect, String text)
	{
		Color color = Color.DARK_GRAY;
		drawText(g2d, rect, text, color, FONT_);
	}
}
