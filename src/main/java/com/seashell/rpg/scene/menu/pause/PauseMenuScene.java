package com.seashell.rpg.scene.menu.pause;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.seashell.rpg.process.GameProcess;
import com.seashell.rpg.process.GameProcessState;
import com.seashell.rpg.resource.R;
import com.seashell.rpg.scene.Scene;
import com.seashell.rpg.scene.menu.AbstractMenuScene;
import com.seashell.rpg.scene.menu.MenuButton;
import com.seashell.rpg.scene.menu.MenuMouseHandler;

/**
 * A {@link Scene} for the pause menu screen
 */
public class PauseMenuScene extends AbstractMenuScene
{
	/**
	 * Width of buttons on this menu
	 */
	private static final int BTN_WIDTH_ = 190 * SCALE_;

	/**
	 * Height of buttons on this menu
	 */
	private static final int BTN_HEIGHT_ = 45 * SCALE_;

	/**
	 * Game process whose state has to change based on the buttons that get clicked in the main menu
	 */
	private final GameProcess gameProcess_;

	/**
	 * Resolution width
	 */
	private final int resWidth_;

	/**
	 * Resolution height
	 */
	private final int resHeight_;

	/**
	 * Background image for this menu
	 */
	private final BufferedImage backgroundImage_;

	/**
	 * Panel image for this menu
	 */
	private final BufferedImage panelImage_;

	/**
	 * Value for {@link #getMouseHandler()}
	 */
	private final MenuMouseHandler mouseHandler_;

	/**
	 * Invisible UI container for the menu buttons
	 */
	private final Shape buttonContainer_;

	/**
	 * Invisible UI container for the menu panel
	 */
	private final Shape panelContainer_;

	/**
	 * The buttons on the menu
	 */
	private final List<MenuButton> buttons_;

	/**
	 * Constructor
	 *
	 * @param gameProcess
	 *            Game process whose state has to change based on the buttons that get clicked in the main menu
	 * @param backgroundImage
	 *            Image to use for the background of this menu. Allows for null, indicating that there should be no background
	 */
	public PauseMenuScene(GameProcess gameProcess, BufferedImage backgroundImage)
	{
		gameProcess_ = Objects.requireNonNull(gameProcess);
		backgroundImage_ = backgroundImage;
		panelImage_ = R.getMenuPanelGrey();

		resWidth_ = gameProcess.getConfiguration().getResolutionWidth();
		resHeight_ = gameProcess.getConfiguration().getResolutionHeight();

		buttonContainer_ =
				new Rectangle2D.Double(
						(resWidth_ / 2) - (BTN_WIDTH_ / 2),
						(resHeight_ / 2) - BTN_HEIGHT_,
						BTN_WIDTH_,
						BTN_HEIGHT_ * 2 + 5);

		panelContainer_ =
				new Rectangle2D.Double(
						buttonContainer_.getBounds().x - (BTN_WIDTH_ / 4),
						buttonContainer_.getBounds().y - BTN_HEIGHT_,
						buttonContainer_.getBounds().width + (2 * (BTN_WIDTH_ / 4)),
						buttonContainer_.getBounds().height + (2 * BTN_HEIGHT_));

		final Shape shapeResume =
				new Rectangle2D.Double(
						buttonContainer_.getBounds().x,
						buttonContainer_.getBounds().y,
						BTN_WIDTH_,
						BTN_HEIGHT_);

		final Shape shapeExit = new Rectangle2D.Double(
				buttonContainer_.getBounds().x,
				buttonContainer_.getBounds().y + (1 * BTN_HEIGHT_) + 5,
				BTN_WIDTH_,
				BTN_HEIGHT_);

		final MenuButton btnResume = new MenuButton("Resume", GameProcessState.PLAY, shapeResume, R.getMenuBtnTwoToneYellowRaised(), R.getMenuBtnTwoToneYellowClicked());
		final MenuButton btnMainMenu = new MenuButton("Quit", GameProcessState.MAIN_MENU, shapeExit, R.getMenuBtnTwoToneYellowRaised(), R.getMenuBtnTwoToneYellowClicked());

		final List<MenuButton> buttons = new ArrayList<>();
		buttons.add(btnResume);
		buttons.add(btnMainMenu);
		buttons_ = buttons;

		final MenuMouseHandler mouseHandler = new MenuMouseHandler(buttons);
		gameProcess_.getGui().getCanvas().addMouseListener(mouseHandler);
		gameProcess_.getGui().getCanvas().addMouseMotionListener(mouseHandler);
		mouseHandler_ = mouseHandler;
	}

	/**
	 * @return Mouse handler for the main menu
	 */
	public MenuMouseHandler getMouseHandler()
	{
		return mouseHandler_;
	}

	@Override
	public void tick()
	{
		Optional<GameProcessState> state = mouseHandler_.getDestinationState();
		if(state.isPresent())
		{
			gameProcess_.setState(state.get());
		}
	}

	@Override
	public void render(Graphics2D g2d)
	{
		if(backgroundImage_ != null)
		{
			g2d.drawImage(backgroundImage_, 0, 0, resWidth_, resHeight_, null);
		}

		g2d.setColor(COLOR_MODAL_);
		g2d.fillRect(0, 0, resWidth_, resHeight_);

		g2d.drawImage(panelImage_,
				panelContainer_.getBounds().x,
				panelContainer_.getBounds().y,
				panelContainer_.getBounds().width,
				panelContainer_.getBounds().height,
				null);

		for(MenuButton button : buttons_)
		{
			final Rectangle bounds = button.getShape().getBounds();

			if(button.isClicked())
			{
				g2d.drawImage(button.getActiveImage(), bounds.x, bounds.y, bounds.width, bounds.height, null);
				drawHoveredText(g2d, bounds, button.getLabel());
			}
			else if(button.isHovered())
			{
				g2d.drawImage(button.getIdleImage(), bounds.x, bounds.y, bounds.width, bounds.height, null);
				drawHoveredText(g2d, bounds, button.getLabel());
			}
			else
			{
				g2d.drawImage(button.getIdleImage(), bounds.x, bounds.y, bounds.width, bounds.height, null);
				drawDefaultText(g2d, bounds, button.getLabel());
			}
		}

		// debug_drawContainers(g2d);
	}

	/**
	 * Debugging method to draw component containers for this menu in red coloring
	 *
	 * @param g2d
	 *            Graphics object used to draw
	 */
	@SuppressWarnings("unused")
	private void debug_drawContainers(Graphics2D g2d)
	{
		g2d.setColor(Color.RED);

		// Button Container
		g2d.drawRect(
				buttonContainer_.getBounds().x,
				buttonContainer_.getBounds().y,
				buttonContainer_.getBounds().width,
				buttonContainer_.getBounds().height);

		// Panel Container
		g2d.drawRect(
				panelContainer_.getBounds().x,
				panelContainer_.getBounds().y,
				panelContainer_.getBounds().width,
				panelContainer_.getBounds().height);
	}
}
