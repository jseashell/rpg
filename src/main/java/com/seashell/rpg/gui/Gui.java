package com.seashell.rpg.gui;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

/**
 * The graphical user interface for the game
 */
public class Gui
{
	/**
	 * Value for {@link #getCamera()}
	 */
	private final GuiCamera camera_;

	/**
	 * Value for {@link #getKeyManager()}
	 */
	private final KeyManager keyManager_;

	/**
	 * Value for {@link #getFrame()}
	 */
	private final JFrame frame_;

	/**
	 * Value for {@link #getCanvas()}
	 */
	private final Canvas canvas_;

	/**
	 * Constructor
	 *
	 * @param resolutionWidth
	 *            The width to use for the resolution
	 * @param resolutionHeight
	 *            The height to use for the resolution
	 */
	public Gui(int resolutionWidth, int resolutionHeight)
	{
		camera_ = new GuiCamera(resolutionWidth, resolutionHeight);

		keyManager_ = new KeyManager();

		final Dimension size = new Dimension(resolutionWidth, resolutionHeight);

		frame_ = new JFrame("RPG"); // TODO Replace this with the name of the game
		frame_.setSize(size); // must be called before location relative to null
		frame_.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame_.setResizable(false);
		frame_.setLocationRelativeTo(null);
		frame_.setVisible(true);
		frame_.addKeyListener(keyManager_);

		canvas_ = new Canvas();
		canvas_.setPreferredSize(size);
		canvas_.setMinimumSize(size);
		canvas_.setMaximumSize(size);
		canvas_.setFocusable(false); // #frame_ is the only thing that can have focus, not the drawing canvas

		frame_.add(canvas_);

		frame_.pack();
	}

	private void init()
	{

	}

	/**
	 * @return The {@link GuiCamera} for the gui
	 */
	public GuiCamera getCamera()
	{
		return camera_;
	}

	/**
	 * @return The {@link KeyManager} for the gui
	 */
	public KeyManager getKeyManager()
	{
		return keyManager_;
	}

	/**
	 * @return The {@link JFrame top-level container} for the gui's components
	 */
	public JFrame getFrame()
	{
		return frame_;
	}

	/**
	 * @return The {@link Canvas} to draw components to
	 */
	public Canvas getCanvas()
	{
		return canvas_;
	}
}
