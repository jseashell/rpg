package com.seashell.rpg.scene.menu.main;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.seashell.rpg.process.GameProcessState;
import com.seashell.rpg.scene.InputHandler;

/**
 * Handles mouse events for the main menu
 */
public class MainMenuMouseHandler extends MouseAdapter implements InputHandler
{
	/**
	 * The buttons to be observed by this handler
	 */
	private final List<MainMenuButton> buttons_;

	/**
	 * Selected button for the handler
	 */
	private Optional<MainMenuButton> selectedButton_;

	/**
	 * Constructor
	 *
	 * @param buttons
	 *            The buttons to be observed by this handler
	 */
	public MainMenuMouseHandler(List<MainMenuButton> buttons)
	{
		buttons_ = Objects.requireNonNull(buttons);
		selectedButton_ = Optional.empty();
	}

	@Override
	public void mouseClicked(MouseEvent me)
	{
		super.mouseClicked(me);

		for(MainMenuButton b : buttons_)
		{
			if(b.getShape().contains(me.getPoint()))
			{
				selectedButton_ = Optional.of(b);
			}
		}
	}

	/**
	 * Gets the selected button and resets the cached selected button
	 *
	 * @return The selected button
	 */
	public Optional<GameProcessState> getSelectedButtonAndReset()
	{
		if(selectedButton_.isPresent())
		{
			// Reset the selected button
			selectedButton_ = Optional.empty();

			return Optional.ofNullable(selectedButton_.get().getDestinationState());
		}

		return Optional.empty();
	}
}
