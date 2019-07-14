package com.seashell.rpg.scene.world.config;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.google.common.io.Files;
import com.seashell.rpg.scene.world.World;

/**
 * Builder a {@link World}
 */
public class WorldConfigurationBuilder
{
	/**
	 * Value mutated by {@link #setFilename(String)}
	 */
	private String filename_;

	/**
	 * Width read from the world file
	 */
	private int width_;

	/**
	 * Height read from the world file
	 */
	private int height_;

	/**
	 * Value mutated by {@link #setSpawnX(int)}
	 */
	private int spawnX_;

	/**
	 * Value mutated by {@link #setSpawnY(int)}
	 */
	private int spawnY_;

	/**
	 * Tokens read from the world file
	 */
	private String[] tokens_;

	/**
	 * Constructor prevents instantiation
	 */
	public WorldConfigurationBuilder()
	{
		filename_ = null;
		width_ = 0;
		height_ = 0;
		spawnX_ = 0;
		spawnY_ = 0;
		tokens_ = new String[0];
	}

	/**
	 * @param filename
	 *            The filename to set
	 * @return this, for chaining
	 */
	public WorldConfigurationBuilder setFilename(String filename)
	{
		filename_ = filename;
		return this;
	}

	/**
	 * @param spawnX
	 *            The x-coordinate for the spawn location
	 * @return this, for chaining
	 */
	public WorldConfigurationBuilder setSpawnX(int spawnX)
	{
		spawnX_ = spawnX;
		return this;
	}

	/**
	 * @param spawnY
	 *            The y-coordinate for the spawn location
	 * @return this, for chaining
	 */
	public WorldConfigurationBuilder setSpawnY(int spawnY)
	{
		spawnY_ = spawnY;
		return this;
	}

	/**
	 * Builds a world configuration using this builder's configured fields
	 *
	 * @return The {@link WorldConfiguration}
	 * @throws WorldConfigurationBuilderException
	 *             Failure to read the world file; Failure to validate the configured fields
	 */
	public WorldConfiguration build() throws WorldConfigurationBuilderException
	{
		readFile();
		validate();

		return new WorldConfiguration(width_,
				height_,
				spawnX_,
				spawnY_,
				tokens_);
	}

	/**
	 * Reads a world file using the {@link filename_}. The world file must live in {@code ../resources/worlds/}
	 *
	 * @param filename
	 *            The name of the world file to load (with extension)
	 * @return A world configuration
	 * @throws WorldConfigurationBuilderException
	 *             The given file does not exist, or is empty of tile ID tokens
	 */
	private void readFile() throws WorldConfigurationBuilderException
	{
		final List<String> lines;

		try
		{
			Path path = Paths.get(WorldConfigurationBuilder.class.getClassLoader().getResource("worlds/" + filename_).toURI());
			lines = Files.readLines(path.toFile(), StandardCharsets.UTF_8);
		}
		catch(IOException | URISyntaxException e)
		{
			throw new WorldConfigurationBuilderException("Failed to load world file \"" + filename_ + "\"", e);
		}

		if(lines.size() > 0)
		{
			// Count the number of commas in the first line, then add 1. The resulting value is the width (in number of tiles) of the world
			width_ = StringUtils.countMatches(lines.get(0), ",") + 1;

			// Count the number of entries in the read #lines list. The resulting value is the height (in number of tiles) of the world
			height_ = lines.size();

			final StringBuilder sb = new StringBuilder();
			for(String line : lines)
			{
				sb.append(line);
				sb.append(",");
			}

			tokens_ = StringUtils.split(sb.toString(), ",");
		}
		else
		{
			throw new WorldConfigurationBuilderException("Failed to load world file \"" + filename_ + "\". No tokens.");
		}
	}

	/**
	 * Validates the configuration of this builder
	 *
	 * @throws WorldConfigurationBuilderException
	 *             Validation failure
	 */
	private void validate() throws WorldConfigurationBuilderException
	{
		if(filename_ == null)
		{
			throw new WorldConfigurationBuilderException("Failed to build world configuration. Filename was never set.");
		}

		if(width_ == 0)
		{
			throw new WorldConfigurationBuilderException("Failed to build world configuration. Width is set to zero.");
		}

		if(height_ == 0)
		{
			throw new WorldConfigurationBuilderException("Failed to build world configuration. Height is set to zero.");
		}

		if(tokens_.length == 0)
		{
			throw new WorldConfigurationBuilderException("Failed to build world configuration. Unable to parse tokens.");
		}
	}
}
