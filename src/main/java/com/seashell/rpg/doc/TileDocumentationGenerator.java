package com.seashell.rpg.doc;

import java.io.IOException;

import com.seashell.rpg.resource.R;

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
			R.init();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}
