package com.seashell.rpg;

import static org.junit.Assert.fail;

import java.awt.GraphicsEnvironment;
import java.io.IOException;

import org.junit.Ignore;
import org.junit.Test;

import com.seashell.rpg.process.GameProcess;
import com.seashell.rpg.process.GameProcessConfiguration;
import com.seashell.rpg.process.GameProcessConfigurationException;

/**
 * Test class for the {@link GameProcess}
 */
public class GameProcessTest implements UnitTest
{
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
}
