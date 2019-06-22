package com.seashell.rpg.scene.world;

import java.awt.Graphics2D;

import com.seashell.rpg.Render;
import com.seashell.rpg.gui.GuiCamera;
import com.seashell.rpg.process.GameProcessConfiguration;
import com.seashell.rpg.scene.world.config.WorldConfiguration;
import com.seashell.rpg.scene.world.config.WorldConfigurationBuilder;
import com.seashell.rpg.scene.world.config.WorldConfigurationBuilderException;
import com.seashell.rpg.scene.world.tile.WorldTile;
import com.seashell.rpg.tile.Tile;

/**
 * A world that can be rendered to the canvas
 */
public final class World implements Render
{
	/**
	 * The camera
	 */
	private final GuiCamera camera_;

	/**
	 * Configuration for this world
	 */
	private final WorldConfiguration config_;

	/**
	 * Width of the gui
	 */
	private final int guiResolutionWidth_;

	/**
	 * Height of the gui
	 */
	private final int guiResolutionHeight_;

	/**
	 * Constructor
	 *
	 * @param camera
	 *            The {@link GuiCamera}
	 * @param filename
	 *            The filename used to {@link WorldConfigurationBuilder#newInstance(String) load} the world
	 * @throws WorldConfigurationBuilderException
	 *             Failure to load a world using the given filename
	 */
	public World(GuiCamera camera, String filename, GameProcessConfiguration config) throws WorldConfigurationBuilderException
	{
		camera_ = camera;

		WorldConfigurationBuilder wcb = new WorldConfigurationBuilder();
		config_ =
				wcb.setFilename(filename)
						.setSpawnX(config.getSpawnX())
						.setSpawnY(config.getSpawnY())
						.build();

		guiResolutionWidth_ = config.getResolutionWidth();
		guiResolutionHeight_ = config.getResolutionHeight();
	}

	@Override
	public void tick()
	{
		// Nothing for now
	}

	@Override
	public void render(Graphics2D g2d)
	{
		// Only render the tiles that are in display
		int xStart = (int) Math.max(0, camera_.getXOffset()) / Tile.SIZE;
		int xEnd = (int) Math.min(config_.getWidth(), (camera_.getXOffset() + guiResolutionWidth_) / Tile.SIZE + 1); //
		int yStart = (int) Math.max(0, camera_.getYOffset()) / Tile.SIZE;
		int yEnd = (int) Math.min(config_.getHeight(), (camera_.getYOffset() + guiResolutionHeight_) / Tile.SIZE + 1);

		for(int y = yStart; y < yEnd; y++)
		{
			for(int x = xStart; x < xEnd; x++)
			{
				Tile tile = getTile(x, y);
				tile.render(g2d,
						(int) (x * Tile.SIZE - camera_.getXOffset()),
						(int) (y * Tile.SIZE - camera_.getYOffset()));
			}
		}
	}

	/**
	 * @return The width of this world
	 */
	public int getWidth()
	{
		return config_.getWidth();
	}

	/**
	 * @return The height of this world
	 */
	public int getHeight()
	{
		return config_.getHeight();
	}

	/**
	 * @return The x-coordinate for the spawn location of this world
	 */
	public int getSpawnX()
	{
		return config_.getSpawnX();
	}

	/**
	 * @return The y-coordinate for the spawn location for this world
	 */
	public int getSpawnY()
	{
		return config_.getSpawnY();
	}

	/**
	 * Gets a tile from this world at the given x- and y-coordinates
	 *
	 * @param x
	 *            The x-coordinate
	 * @param y
	 *            The y-coordinate
	 * @return A {@link WorldTile}
	 */
	public WorldTile getTile(int x, int y)
	{
		return config_.getTile(x, y);
	}
}
