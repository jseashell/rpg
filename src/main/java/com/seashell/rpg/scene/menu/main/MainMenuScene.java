package com.seashell.rpg.scene.menu.main;

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
	 * Background image for this menu
	 */
	private final BufferedImage backgroundImage_;

	/**
	 * Value for {@link #getMouseHandler()}
	 */
	private final MainMenuMouseHandler mouseHandler_;

	/**
	 * The buttons on the menu
	 */
	private final List<MainMenuButton> buttons_;

	/**
	 * Constructor
	 *
	 * @param gameProcess
	 *            Game process whose state has to change based on the buttons that get clicked in the main menu
	 * @param backgroundImage
	 *            Image to use for the background of this menu. Allows for null, indicating that there should be no background
	 */
	public MainMenuScene(GameProcess gameProcess, BufferedImage backgroundImage)
	{
		gameProcess_ = Objects.requireNonNull(gameProcess);
		backgroundImage_ = backgroundImage;

		resWidth_ = gameProcess.getConfiguration().getResolutionWidth();
		resHeight_ = gameProcess.getConfiguration().getResolutionHeight();

		final Shape shapePlay = new Rectangle2D.Double((resWidth_ / 2) - (BTN_WIDTH_ / 2), (resHeight_ / 2) - BTN_HEIGHT_ - 10, BTN_WIDTH_, BTN_HEIGHT_);
		final Shape shapeOptions = new Rectangle2D.Double((resWidth_ / 2) - (BTN_WIDTH_ / 2), (resHeight_ / 2), BTN_WIDTH_, BTN_HEIGHT_);
		final Shape shapeExit = new Rectangle2D.Double((resWidth_ / 2) - (BTN_WIDTH_ / 2), (resHeight_ / 2) + BTN_HEIGHT_ + 10, BTN_WIDTH_, BTN_HEIGHT_);

		final MainMenuButton btnPlay = new MainMenuButton(GameProcessState.PLAY, shapePlay, R.getMenuBtnSolidYellowRaised(), R.getMenuBtnSolidYellowClicked());
		final MainMenuButton btnOptions = new MainMenuButton(GameProcessState.SETTINGS_MENU, shapeOptions, R.getMenuBtnSolidYellowRaised(), R.getMenuBtnSolidYellowClicked());
		final MainMenuButton btnExit = new MainMenuButton(GameProcessState.QUIT, shapeExit, R.getMenuBtnSolidYellowRaised(), R.getMenuBtnSolidYellowClicked());

		final List<MainMenuButton> buttons = new ArrayList<>();
		buttons.add(btnPlay);
		buttons.add(btnOptions);
		buttons.add(btnExit);
		buttons_ = buttons;

		final MainMenuMouseHandler mouseHandler = new MainMenuMouseHandler(buttons);
		gameProcess_.getGui().getCanvas().addMouseListener(mouseHandler);
		gameProcess_.getGui().getCanvas().addMouseMotionListener(mouseHandler);
		mouseHandler_ = mouseHandler;
	}

	/**
	 * @return Mouse handler for the main menu
	 */
	public MainMenuMouseHandler getMouseHandler()
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

		g2d.setColor(BG_COLOR_);
		g2d.fillRect(0, 0, gameProcess_.getGui().getCanvas().getWidth(), gameProcess_.getGui().getCanvas().getHeight());

		for(MainMenuButton button : buttons_)
		{
			final Rectangle bounds = button.getShape().getBounds();

			if(button.isClicked())
			{
				g2d.drawImage(button.getActiveImage(), bounds.x, bounds.y, bounds.width, bounds.height, null);
				drawHoveredText(g2d, bounds, button.getText());
			}
			else if(button.isHovered())
			{
				g2d.drawImage(button.getIdleImage(), bounds.x, bounds.y, bounds.width, bounds.height, null);
				drawHoveredText(g2d, bounds, button.getText());
			}
			else
			{
				g2d.drawImage(button.getIdleImage(), bounds.x, bounds.y, bounds.width, bounds.height, null);
				drawDefaultText(g2d, bounds, button.getText());
			}
		}
	}
}
