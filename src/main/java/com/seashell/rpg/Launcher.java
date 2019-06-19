package com.seashell.rpg;

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
			GameProcess gameProcess = new GameProcess();
			gameProcess.start();
		}
		catch(Exception e)
		{
			// TODO Add logging mechanism
			System.err.println("Failed to start game process.");
			e.printStackTrace();
			System.exit(0);
		}
	}
}
