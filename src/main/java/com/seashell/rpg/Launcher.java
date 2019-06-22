package com.seashell.rpg;

import com.seashell.rpg.process.GameProcessConfiguration;
import com.seashell.rpg.process.GameProcess;

/**
 * Main entry point for the game
 */
public class Launcher
{
	/**
	 * Main method for the game
	 *
	 * @param args
	 *            Command line args
	 */
	public static void main(String[] args)
	{
		try
		{
			GameProcessConfiguration configuration = GameProcessConfiguration.newInstance("config.properties");

			GameProcess gameProcess = new GameProcess(configuration);
			gameProcess.start();
		}
		catch(Exception e)
		{
			// TODO Add logging mechanism
			System.err.println("Failed to start game process.");
			e.printStackTrace();
		}
	}
}
