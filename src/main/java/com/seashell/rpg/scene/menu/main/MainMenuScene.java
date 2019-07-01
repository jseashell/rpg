package com.seashell.rpg.scene.menu.main;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.seashell.rpg.Resources;
import com.seashell.rpg.process.GameProcess;
import com.seashell.rpg.process.GameProcessState;
import com.seashell.rpg.scene.Scene;
import com.seashell.rpg.scene.menu.AbstractMenuScene;

/**
 * A {@link Scene} for the main menu screen
 */
public class MainMenuScene extends AbstractMenuScene
{
	/**
	 * Game process whose state has to change based on the buttons that get clicked in the main menu
	 */
	private final GameProcess gameProcess_;

	/**
	 * Value for {@link #getMouseHandler()}
	 */
	private final MainMenuMouseHandler mouseHandler_;

	/**
	 * The background image for the menu
	 */
	private final BufferedImage backgroundImage_;

	/**
	 * The buttons on the menu
	 */
	private final List<MainMenuButton> buttons_;

	/**
	 * Constructor
	 *
	 * @param gameProcess
	 *            Game process whose state has to change based on the buttons that get clicked in the main menu
	 */
	public MainMenuScene(GameProcess gameProcess)
	{
		gameProcess_ = Objects.requireNonNull(gameProcess);

		final int resWidth = gameProcess.getConfiguration().getResolutionWidth();
		final int resHeight = gameProcess.getConfiguration().getResolutionHeight();

		try
		{
			backgroundImage_ = Resources.loadMenu("main_menu_background.png");

			final BufferedImage imgNewGame = Resources.loadMenu("main_menu_btn_new_game.png");
			final BufferedImage imgOptions = Resources.loadMenu("main_menu_btn_options.png");
			final BufferedImage imgExit = Resources.loadMenu("main_menu_btn_exit.png");

			final Shape shapeNewGame = new Rectangle2D.Double((resWidth / 2) - 150, (resHeight / 2) - 175, 300, 150);
			final Shape shapeOptions = new Rectangle2D.Double((resWidth / 2) - 150, (resHeight / 2), 300, 150);
			final Shape shapeExit = new Rectangle2D.Double((resWidth / 2) - 150, (resHeight / 2) + 175, 300, 150);

			final MainMenuButton btnNewGame = new MainMenuButton(GameProcessState.WORLD, imgNewGame, shapeNewGame);
			final MainMenuButton btnOptions = new MainMenuButton(GameProcessState.SETTINGS_MENU, imgOptions, shapeOptions);
			final MainMenuButton btnExit = new MainMenuButton(GameProcessState.EXIT, imgExit, shapeExit);

			final List<MainMenuButton> buttons = new ArrayList<>();
			buttons.add(btnNewGame);
			buttons.add(btnOptions);
			buttons.add(btnExit);
			buttons_ = buttons;

			final MainMenuMouseHandler mouseHandler = new MainMenuMouseHandler(buttons);
			gameProcess_.getGui().getCanvas().addMouseListener(mouseHandler);
			mouseHandler_ = mouseHandler;
		}
		catch(IOException e)
		{
			throw new RuntimeException("Failed to load main menu resources.", e);
		}
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
		Optional<GameProcessState> state = mouseHandler_.getSelectedButtonAndReset();
		if(state.isPresent())
		{
			gameProcess_.setState(state.get());
		}
	}

	@Override
	public void render(Graphics2D g2d)
	{
		g2d.drawImage(backgroundImage_, 0, 0, null);

		for(MainMenuButton button : buttons_)
		{
			Rectangle rect = button.getShape().getBounds();
			g2d.drawImage(button.getImage(), rect.x, rect.y, rect.width, rect.height, null);
		}
	}

}
