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

	private final String buttonText_;

	/**
	 * Constructor
	 *
	 * @param destinationState
	 *            Value for {@link #getDestinationState()}
	 * @param img
	 *            The image for the button
	 * @param bounds
	 *            The bounds for the button
	 */
	public MainMenuButton(GameProcessState destinationState, BufferedImage raisedImg, BufferedImage clickedImg, Shape bounds)
	{
		super(raisedImg, clickedImg, bounds);
		destinationState_ = Objects.requireNonNull(destinationState);

		switch(destinationState_)
		{
		case MAIN_MENU:
			buttonText_ = "Main Menu";
			break;

		case NEW_GAME:
			buttonText_ = "New Game";
			break;

		case SETTINGS_MENU:
			buttonText_ = "Setting";
			break;

		case EXIT:
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

	public String getButtonText()
	{
		return buttonText_;
	}
}
