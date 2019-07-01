package com.seashell.rpg;

import static org.junit.Assert.fail;

import java.awt.GraphicsEnvironment;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.google.common.base.Stopwatch;
import com.seashell.rpg.asset.Assets;
import com.seashell.rpg.process.GameProcess;
import com.seashell.rpg.process.GameProcessConfiguration;
import com.seashell.rpg.process.GameProcessConfigurationException;
import com.seashell.rpg.process.GameProcessState;
import com.seashell.rpg.scene.Scene;
import com.seashell.rpg.scene.menu.main.MainMenuScene;

/**
 * Test class for the {@link GameProcess}
 */
public class GameProcessTest implements UnitTest
{
	/**
	 * Initializes the assets
	 */
	@BeforeClass
	public static void setup()
	{
		try
		{
			Assets.init();
		}
		catch(IOException e)
		{
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	/**
	 * Tests that a {@link NullPointerException} occurs when a {@link GameProcess#GameProcess(String) new GameProcess(String)} is given {@code null}
	 */
	@Test(expected = NullPointerException.class)
	public void test_configFilename_null() throws GameProcessConfigurationException
	{
		try
		{
			new GameProcess(null);
		}
		catch(IOException e)
		{
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	/**
	 * Tests valid construction
	 */
	// TODO #1 Fix unit tests to run Swing in a headless state
	@Ignore // @Test
	public void test_configFilename_valid()
	{
		try
		{
			if(GraphicsEnvironment.isHeadless())
			{
				fail("Headless graphics environment causes an exception.");
			}

			GameProcessConfiguration configuration = GameProcessConfiguration.newInstance("config.properties");
			new GameProcess(configuration);
		}
		catch(GameProcessConfigurationException | IOException e)
		{
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	/**
	 * Load tests the loading of a new game by clicking the new game button 10 times
	 *
	 * @throws GameProcessConfigurationException
	 * @throws NullPointerException
	 * @throws IOException
	 */
	// TODO #1 Fix unit tests to run Swing in a headless state
	@Ignore // @Test
	public void loadTest_newGame() throws GameProcessConfigurationException, NullPointerException, IOException
	{
		List<Duration> durations = new ArrayList<>();

		for(int i = 0; i < 10; i++)
		{
			Duration duration = run_newGame();
			durations.add(duration);
		}

		for(int i = 0; i < durations.size(); i++)
		{
			System.out.println("Run #" + i + ": " + durations.get(i));
		}
	}

	/**
	 * Programmatically starts the game and clicks the new game button. Returns if the game doesn't transition to the new game scene within 1 second.
	 *
	 * @return Duration that it took to change game scene
	 * @throws GameProcessConfigurationException
	 * @throws NullPointerException
	 * @throws IOException
	 */
	private Duration run_newGame() throws GameProcessConfigurationException, NullPointerException, IOException
	{
		GameProcessConfiguration configuration = GameProcessConfiguration.newInstance("config.properties");
		GameProcess gameProcess = new GameProcess(configuration);

		gameProcess.start();
		Stopwatch stopwatch = Stopwatch.createStarted();

		GameProcessState expectedStartState = GameProcessState.MAIN_MENU;
		if(expectedStartState != gameProcess.getState())
		{
			fail("Game process started in unexpected state for this test.");
		}

		int x = (1920 / 2) - 150;
		int y = (1080 / 2) - 175;

		MouseEvent me = new MouseEvent(gameProcess.getGui().getFrame(), MouseEvent.BUTTON1, System.currentTimeMillis(), 0, x, y, 1, false);

		boolean exit = false;
		while(!exit)
		{
			Scene s = gameProcess.getScene();
			if(s instanceof MainMenuScene)
			{
				MainMenuScene mms = (MainMenuScene) s;
				mms.getMouseHandler().mouseClicked(me);
			}

			GameProcessState expectedEndState = GameProcessState.WORLD;
			if(expectedEndState == gameProcess.getState())
			{
				exit = true;
			}

			if(stopwatch.elapsed().compareTo(Duration.ofSeconds(1)) == 1)
			{
				break;
			}
		}

		return stopwatch.elapsed();
	}
}
