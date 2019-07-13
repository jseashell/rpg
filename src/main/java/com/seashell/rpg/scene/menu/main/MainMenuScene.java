package com.seashell.rpg.scene.menu.main;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.MouseEvent;
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
	 * Bounds of the new game button
	 */
	private final Shape boundsNewGame_;

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

			boundsNewGame_ = new Rectangle2D.Double((resWidth / 2) - 150, (resHeight / 2) - 175, 300, 150);
			final Shape boundsOptions = new Rectangle2D.Double((resWidth / 2) - 150, (resHeight / 2), 300, 150);
			final Shape boundsExit = new Rectangle2D.Double((resWidth / 2) - 150, (resHeight / 2) + 175, 300, 150);

			final MainMenuButton btnNewGame = new MainMenuButton(GameProcessState.NEW_GAME, imgNewGame, boundsNewGame_);
			final MainMenuButton btnOptions = new MainMenuButton(GameProcessState.SETTINGS_MENU, imgOptions, boundsOptions);
			final MainMenuButton btnExit = new MainMenuButton(GameProcessState.EXIT, imgExit, boundsExit);

			final List<MainMenuButton> buttons = new ArrayList<>();
			// buttons.add(btnNewGame);
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
			Rectangle rect = button.getBounds().getBounds();
			g2d.drawImage(button.getImage(), rect.x, rect.y, rect.width, rect.height, null);
		}
	}

	/**
	 * Programmatically starts a new game from this main menu scene by clicking the new game button
	 * <p>
	 * The idea is that this method can be used for testing purposes. There should not be a reason to perform this action in production, with the exception of maybe being able to leverage this ability
	 * in a tutorial.
	 */
	public void startNewGameWithMouseEvent()
	{
		final MouseEvent me =
				new MouseEvent(gameProcess_.getGui().getFrame(), // Swing component where the click occurred
						MouseEvent.BUTTON1, // Mouse button 1
						System.currentTimeMillis(), // Time of event (now)
						0, // Modifier mask (ctrl, shift, etc.). Zero indicating no modifiers
						boundsNewGame_.getBounds().x,
						boundsNewGame_.getBounds().y,
						1, // Click count
						false); // false indicates that this event is not for a popup

		mouseHandler_.mouseClicked(me);
	}
}
