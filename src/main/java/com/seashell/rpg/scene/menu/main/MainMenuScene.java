package com.seashell.rpg.scene.menu.main;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
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
 * A {@link Scene} for the main menu screen
 */
public class MainMenuScene extends AbstractMenuScene
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
	 * Value for {@link #getMouseHandler()}
	 */
	private final MenuMouseHandler mouseHandler_;

	/**
	 * The buttons on the menu
	 */
	private final List<MenuButton> buttons_;

	/**
	 * Constructor
	 *
	 * @param gameProcess
	 *            Game process whose state has to change based on the buttons that get clicked in the main menu
	 * @param playScreenshot
	 *            Image to use for the background of this menu. Allows for null, indicating that there should be no background
	 */
	public MainMenuScene(GameProcess gameProcess)
	{
		gameProcess_ = Objects.requireNonNull(gameProcess);

		resWidth_ = gameProcess.getConfiguration().getResolutionWidth();
		resHeight_ = gameProcess.getConfiguration().getResolutionHeight();

		// TODO Implement containers similar to PauseMenuScene
		final Shape shapePlay = new Rectangle2D.Double((resWidth_ / 2) - (BTN_WIDTH_ / 2), (resHeight_ / 2) - (BTN_HEIGHT_ / 2) - BTN_HEIGHT_ - 10, BTN_WIDTH_, BTN_HEIGHT_);
		final Shape shapeSettings = new Rectangle2D.Double((resWidth_ / 2) - (BTN_WIDTH_ / 2), (resHeight_ / 2) - (BTN_HEIGHT_ / 2), BTN_WIDTH_, BTN_HEIGHT_);
		final Shape shapeQuit = new Rectangle2D.Double((resWidth_ / 2) - (BTN_WIDTH_ / 2), (resHeight_ / 2) + (BTN_HEIGHT_ / 2) + 10, BTN_WIDTH_, BTN_HEIGHT_);

		final MenuButton btnPlay = new MenuButton("Play", GameProcessState.PLAY, shapePlay, R.getMenuBtnTwoToneYellowRaised(), R.getMenuBtnTwoToneYellowClicked());
		final MenuButton btnSettings = new MenuButton("Settings", GameProcessState.SETTINGS, shapeSettings, R.getMenuBtnTwoToneYellowRaised(), R.getMenuBtnTwoToneYellowClicked());
		final MenuButton btnQuit = new MenuButton("Exit", GameProcessState.EXIT, shapeQuit, R.getMenuBtnTwoToneYellowRaised(), R.getMenuBtnTwoToneYellowClicked());

		final List<MenuButton> buttons = new ArrayList<>();
		buttons.add(btnPlay);
		buttons.add(btnSettings);
		buttons.add(btnQuit);
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
		g2d.setColor(Color.LIGHT_GRAY);
		g2d.fillRect(0, 0, gameProcess_.getGui().getCanvas().getWidth(), gameProcess_.getGui().getCanvas().getHeight());

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
	}
}
