package com.seashell.rpg.scene.menu;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.seashell.rpg.process.GameProcessState;
import com.seashell.rpg.scene.InputHandler;
import com.seashell.rpg.scene.menu.MenuButton;

/**
 * Handles mouse events for the main menu
 */
public class MenuMouseHandler extends MouseAdapter implements InputHandler, MouseMotionListener
{
	/**
	 * The buttons to be observed by this handler
	 */
	private final List<MenuButton> buttons_;

	/**
	 * Selected button for the handler
	 */
	private Optional<MenuButton> selectedButton_;

	/**
	 * Constructor
	 *
	 * @param buttons
	 *            The buttons to be observed by this handler
	 */
	public MenuMouseHandler(List<MenuButton> buttons)
	{
		buttons_ = Objects.requireNonNull(buttons);
		selectedButton_ = Optional.empty();
	}

	/**
	 * Handles a click event for the main menu buttons
	 */
	@Override
	public void mouseClicked(MouseEvent me)
	{
		super.mouseReleased(me);

		for(MenuButton b : buttons_)
		{
			if(b.getShape().contains(me.getPoint()))
			{
				selectedButton_ = Optional.of(b);
				b.setIsHovered(true);
				b.setIsClick(true);
				break;
			}
			else
			{
				b.setIsHovered(false);
				b.setIsClick(false);
			}
		}
	}

	/**
	 * Handles a hover event for the main menu buttons
	 */
	@Override
	public void mouseMoved(MouseEvent me)
	{
		super.mouseMoved(me);

		for(MenuButton b : buttons_)
		{
			if(b.getShape().contains(me.getPoint()))
			{
				b.setIsHovered(true);
				b.setIsClick(false);
			}
			else
			{
				b.setIsHovered(false);
				b.setIsClick(false);
			}
		}
	}

	/**
	 * @return The state to go to based on the most recently selected button
	 */
	public Optional<GameProcessState> getDestinationState()
	{
		if(selectedButton_.isPresent())
		{
			return Optional.ofNullable(selectedButton_.get().getDestinationState());
		}

		return Optional.empty();
	}
}
