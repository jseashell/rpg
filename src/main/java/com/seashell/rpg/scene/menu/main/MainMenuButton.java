package com.seashell.rpg.scene.menu.main;

import java.awt.Shape;
import java.awt.image.BufferedImage;
import java.util.Objects;

import com.seashell.rpg.process.GameProcessState;
import com.seashell.rpg.scene.menu.AbstractMenuButton;

/**
 * A button for the main menu
 */
public class MainMenuButton extends AbstractMenuButton
{
	/**
	 * Value for {@link #getDestinationState()}
	 */
	private final GameProcessState destinationState_;

	/**
	 * The text to use for the given button. Programmatically determined by the {@link #destinationState_} provided at construction
	 */
	private final String buttonText_;

	/**
	 * Constructor
	 *
	 * @param destinationState
	 *            Value for {@link #getDestinationState()}
	 * @param img
	 *            The image for the button
	 * @param shape
	 *            The bounds for the button
	 */
	public MainMenuButton(GameProcessState destinationState, Shape shape, BufferedImage idleImage, BufferedImage activeImage)
	{
		super(shape, idleImage, activeImage);
		destinationState_ = Objects.requireNonNull(destinationState);

		switch(destinationState_)
		{
		case MAIN_MENU:
			buttonText_ = "Main Menu";
			break;

		case PLAY:
			buttonText_ = "Play";
			break;

		case SETTINGS_MENU:
			buttonText_ = "Setting";
			break;

		case QUIT:
			buttonText_ = "Exit";
			break;

		default:
			throw new AssertionError("Unhandled destination state");
		}
	}

	/**
	 * @return The game process state to go to when this button is clicked
	 */
	public GameProcessState getDestinationState()
	{
		return destinationState_;
	}

	/**
	 * @return The text to display on this button
	 */
	public String getText()
	{
		return buttonText_;
	}
}
