package com.seashell.rpg.gui;

import java.awt.Canvas;
import java.awt.Dimension;
import java.util.Objects;

import javax.swing.JFrame;

import com.seashell.rpg.GameProcess;

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
	 * @param gameProcess
	 *            The {@link GameProcess}. Non-null.
	 */
	public Gui(GameProcess gameProcess)
	{
		Objects.requireNonNull(gameProcess, "The given game process cannot be null.");

		camera_ = new GuiCamera(gameProcess.getConfiguration().getResolutionWidth(), gameProcess.getConfiguration().getResolutionHeight(), 0, 0);

		keyManager_ = new KeyManager();

		final Dimension size = new Dimension(gameProcess.getConfiguration().getResolutionWidth(), gameProcess.getConfiguration().getResolutionHeight());

		frame_ = new JFrame("RPG");
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
