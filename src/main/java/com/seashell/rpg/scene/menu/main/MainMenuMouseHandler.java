package com.seashell.rpg.scene.menu.main;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.seashell.rpg.process.GameProcessState;
import com.seashell.rpg.scene.InputHandler;

/**
 * Handles mouse events for the main menu
 */
public class MainMenuMouseHandler extends MouseAdapter implements InputHandler, MouseMotionListener
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
		super.mouseReleased(me);

		for(MainMenuButton b : buttons_)
		{
			if(b.getBounds().contains(me.getPoint()))
			{
				selectedButton_ = Optional.of(b);
				b.setIsHover(true);
				b.setIsClick(true);
				break;
			}
			else
			{
				b.setIsHover(false);
				b.setIsClick(false);
			}
		}
	}

	@Override
	public void mouseMoved(MouseEvent me)
	{
		super.mouseMoved(me);

		for(MainMenuButton b : buttons_)
		{
			if(b.getBounds().contains(me.getPoint()))
			{
				b.setIsHover(true);
				b.setIsClick(false);
			}
			else
			{
				b.setIsHover(false);
				b.setIsClick(false);
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
			return Optional.ofNullable(selectedButton_.get().getDestinationState());
		}

		return Optional.empty();
	}
}
