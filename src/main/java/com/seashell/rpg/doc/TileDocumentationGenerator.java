package com.seashell.rpg.doc;

import java.io.IOException;

import com.seashell.rpg.asset.Assets;

/**
 * Utility to generate documentation for tiles
 */
public final class TileDocumentationGenerator
{
	/**
	 * Main method
	 *
	 * @param args
	 *            Command line args
	 */
	public static void main(String[] args)
	{
		try
		{
			Assets.init();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}
