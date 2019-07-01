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
	 * Constructor
	 *
	 * @param destinationState
	 *            Value for {@link #getDestinationState()}
	 * @param img
	 *            The image for the button
	 * @param bounds
	 *            The bounds for the button
	 */
	public MainMenuButton(GameProcessState destinationState, BufferedImage img, Shape bounds)
	{
		super(img, bounds);
		destinationState_ = Objects.requireNonNull(destinationState);
	}

	/**
	 * @return The game process state to go to when this button is clicked
	 */
	public GameProcessState getDestinationState()
	{
		return destinationState_;
	}

}
