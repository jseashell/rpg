package com.seashell.rpg.scene.menu.main;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
	private GameProcess gameProcess_;

	private BufferedImage img_;

	private BufferedImage imgNewGame_;

	private BufferedImage imgOptions_;

	private BufferedImage imgExit_;

	private Shape newGame_;

	private Shape options_;

	private Shape exit_;

	public MainMenuScene(GameProcess gameProcess)
	{
		gameProcess_ = gameProcess; // TODO check for null

		try
		{
			img_ = Resources.loadMenuBackground("main_menu_background.png");
			imgNewGame_ = Resources.loadMenuBackground("main_menu_btn_new_game.png");
			imgOptions_ = Resources.loadMenuBackground("main_menu_btn_options.png");
			imgExit_ = Resources.loadMenuBackground("main_menu_btn_exit.png");
		}
		catch(IOException e)
		{
			e.printStackTrace();
			System.exit(0);
		}

		int resWidth = gameProcess.getConfiguration().getResolutionWidth();
		int resHeight = gameProcess.getConfiguration().getResolutionHeight();

		newGame_ = new Rectangle2D.Double((resWidth / 2) - 150, (resHeight / 2) - 175, 300, 150);
		options_ = new Rectangle2D.Double((resWidth / 2) - 150, (resHeight / 2), 300, 150);
		exit_ = new Rectangle2D.Double((resWidth / 2) - 150, (resHeight / 2) + 175, 300, 150);

		final List<Shape> shapes = new ArrayList<>();
		shapes.add(newGame_);
		shapes.add(options_);
		shapes.add(exit_);

		MouseAdapter ml =
				new MouseAdapter()
				{
					@Override
					public void mouseClicked(MouseEvent me)
					{
						super.mouseClicked(me);
						for(Shape s : shapes)
						{
							if(s.contains(me.getPoint()))
							{
								if(s == newGame_)
								{
									gameProcess_.setState(GameProcessState.WORLD);
								}
								else if(s == options_)
								{
									gameProcess_.setState(GameProcessState.SETTINGS_MENU);
								}
								else if(s == exit_)
								{
									gameProcess_.setState(GameProcessState.EXIT);
								}
							}
						}
					}
				};

		gameProcess_.getGui().getCanvas().addMouseListener(ml);

	}

	@Override
	public void tick()
	{
	}

	@Override
	public void render(Graphics2D g2d)
	{
		g2d.drawImage(img_, 0, 0, null);

		Rectangle rect = newGame_.getBounds();
		g2d.drawImage(imgNewGame_, rect.x, rect.y, rect.width, rect.height, null);

		rect = options_.getBounds();
		g2d.drawImage(imgOptions_, rect.x, rect.y, rect.width, rect.height, null);

		rect = exit_.getBounds();
		g2d.drawImage(imgExit_, rect.x, rect.y, rect.width, rect.height, null);
	}
}
