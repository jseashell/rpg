package com.seashell.rpg.scene.world;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import com.google.common.io.Files;

/**
 * Utility class that loads a {@link World} from a file
 */
public class WorldConfigurationLoader
{
	/**
	 * Constructor prevents instantiation
	 */
	private WorldConfigurationLoader()
	{

	}

	/**
	 * Loads a world file using the given filename. The world file must live in {@code ../resources/worlds/}
	 *
	 * @param filename
	 *            The name of the world file to load (with extension)
	 * @return A world configuration
	 * @throws WorldConfigurationLoaderException
	 *             The given file does not exist, or is empty of tile ID tokens
	 */
	public static WorldConfiguration load(String filename) throws WorldConfigurationLoaderException
	{
		final List<String> lines;

		try
		{
			Path path = Paths.get(WorldConfigurationLoader.class.getClassLoader().getResource("worlds/" + filename).toURI());
			lines = Files.readLines(path.toFile(), StandardCharsets.UTF_8);
		}
		catch(IOException | URISyntaxException e)
		{
			throw new WorldConfigurationLoaderException("Failed to load world file \"" + filename + "\"", e);
		}

		if(lines.size() > 0)
		{
			int width = lines.get(0).replace(" ", "").length();
			int height = lines.size();

			int spawnX = 15;
			int spawnY = 11;

			final StringBuilder sb = new StringBuilder();
			for(String line : lines)
			{
				sb.append(line);
				sb.append("\n");
			}

			String[] tokens = sb.toString().split("\\s+");

			return new WorldConfiguration(width, height, spawnX, spawnY, tokens);
		}
		else
		{
			throw new WorldConfigurationLoaderException("Failed to load world file \"" + filename + "\". No tokens.");
		}
	}
}
