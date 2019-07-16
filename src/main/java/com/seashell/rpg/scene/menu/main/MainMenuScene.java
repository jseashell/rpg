package com.seashell.rpg.scene.menu.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.MouseEvent;
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
	 * The buttons on the menu
	 */
	private final List<MainMenuButton> buttons_;

	/**
	 * Bounds of the new game button
	 */
	private final Shape boundsNewGame_;

	private static final int SCALE_ = 2;

	private static final int BTN_WIDTH_ = 190 * SCALE_;

	private static final int BTN_HEIGHT_ = 45 * SCALE_;

	private static final int FONT_SIZE_ = 18 * SCALE_;

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

		boundsNewGame_ = new Rectangle2D.Double((resWidth / 2) - (BTN_WIDTH_ / 2), (resHeight / 2) - BTN_HEIGHT_ - 10, BTN_WIDTH_, BTN_HEIGHT_);
		final Shape boundsOptions = new Rectangle2D.Double((resWidth / 2) - (BTN_WIDTH_ / 2), (resHeight / 2), BTN_WIDTH_, BTN_HEIGHT_);
		final Shape boundsExit = new Rectangle2D.Double((resWidth / 2) - (BTN_WIDTH_ / 2), (resHeight / 2) + BTN_HEIGHT_ + 10, BTN_WIDTH_, BTN_HEIGHT_);

		final MainMenuButton btnNewGame = new MainMenuButton(GameProcessState.NEW_GAME, R.getMenuBtnSolidYellowRaised(), R.getMenuBtnSolidYellowClicked(), boundsNewGame_);
		final MainMenuButton btnOptions = new MainMenuButton(GameProcessState.SETTINGS_MENU, R.getMenuBtnSolidYellowRaised(), R.getMenuBtnSolidYellowClicked(), boundsOptions);
		final MainMenuButton btnExit = new MainMenuButton(GameProcessState.EXIT, R.getMenuBtnSolidYellowRaised(), R.getMenuBtnSolidYellowClicked(), boundsExit);

		final List<MainMenuButton> buttons = new ArrayList<>();
		buttons.add(btnNewGame);
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
		Optional<GameProcessState> state = mouseHandler_.getSelectedButtonAndReset();
		if(state.isPresent())
		{
			gameProcess_.setState(state.get());
		}
	}

	@Override
	public void render(Graphics2D g2d)
	{
		// TODO Screenshot of save point goes here

		int alpha = 127; // 50% transparent
		Color backgroundColor = new Color(0, 0, 0, alpha);

		g2d.setColor(backgroundColor);
		g2d.fillRect(0, 0, gameProcess_.getGui().getCanvas().getWidth(), gameProcess_.getGui().getCanvas().getHeight());

		for(MainMenuButton button : buttons_)
		{
			Rectangle rect = button.getBounds().getBounds();

			if(button.isClick())
			{
				g2d.drawImage(button.getClickedImage(), rect.x, rect.y, rect.width, rect.height, null);
				drawHoverText(g2d, rect, button);
			}
			else if(button.isHover())
			{
				g2d.drawImage(button.getRaisedImage(), rect.x, rect.y, rect.width, rect.height, null);
				drawHoverText(g2d, rect, button);
			}
			else
			{
				g2d.drawImage(button.getRaisedImage(), rect.x, rect.y, rect.width, rect.height, null);
				drawDefaultText(g2d, rect, button);
			}

		}
	}

	private void drawHoverText(Graphics2D g2d, Rectangle rect, MainMenuButton button)
	{
		Font font = new Font(Font.MONOSPACED, Font.BOLD, FONT_SIZE_);
		String text = button.getButtonText();

		// Get the FontMetrics
		FontMetrics metrics = g2d.getFontMetrics(font);
		// Determine the X coordinate for the text
		int x = rect.x + (rect.width - metrics.stringWidth(text)) / 2 + 5;
		// Determine the Y coordinate for the text (note we add the ascent, as in java 2d 0 is top of the screen)
		int y = rect.y + ((rect.height - metrics.getHeight()) / 2) + metrics.getAscent() - 5;
		// Set the font
		g2d.setFont(font);
		g2d.setColor(Color.WHITE);
		// Draw the String
		g2d.drawString(text, x, y);

	}

	private void drawDefaultText(Graphics2D g2d, Rectangle rect, MainMenuButton button)
	{
		Font font = new Font(Font.MONOSPACED, Font.BOLD, FONT_SIZE_);
		String text = button.getButtonText();

		// Get the FontMetrics
		FontMetrics metrics = g2d.getFontMetrics(font);
		// Determine the X coordinate for the text
		int x = rect.x + (rect.width - metrics.stringWidth(text)) / 2 + 5;
		// Determine the Y coordinate for the text (note we add the ascent, as in java 2d 0 is top of the screen)
		int y = rect.y + ((rect.height - metrics.getHeight()) / 2) + metrics.getAscent() - 5;
		// Set the font
		g2d.setFont(font);
		g2d.setColor(Color.DARK_GRAY);
		// Draw the String
		g2d.drawString(text, x, y);

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
