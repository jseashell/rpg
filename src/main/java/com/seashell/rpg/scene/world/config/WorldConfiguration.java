package com.seashell.rpg.scene.world.config;

import com.seashell.rpg.scene.world.World;
import com.seashell.rpg.scene.world.tile.WorldTile;
import com.seashell.rpg.scene.world.tile.WorldTileIndex;

/**
 * Configuration for a {@link World}. Must be created using a {@link WorldConfigurationBuilder}
 */
public final class WorldConfiguration
{
	/**
	 * Value for {@link #getWidth()}
	 */
	private final int width_;

	/**
	 * Value for {@link #getHeight()}
	 */
	private final int height_;

	/**
	 * Value for {@link #getSpawnX()}
	 */
	private final int spawnX_;

	/**
	 * Value for {@link #getSpawnY()}
	 */
	private final int spawnY_;

	/**
	 * Tile index for this world
	 */
	private final WorldTileIndex tileIndex_;

	/**
	 * Constructor.
	 *
	 * @param width
	 *            Value for {@link #getWidth()}
	 * @param height
	 *            Value for {@link #getHeight()}
	 * @param tokens
	 *            See {@link WorldTileIndex}
	 */
	WorldConfiguration(int width, int height, int spawnX, int spawnY, String[] tokens)
	{
		this.width_ = width;
		this.height_ = height;
		this.spawnX_ = spawnX;
		this.spawnY_ = spawnY;

		tileIndex_ = new WorldTileIndex(width, height, tokens);
	}

	/**
	 * @return the width
	 */
	public int getWidth()
	{
		return width_;
	}

	/**
	 * @return the height
	 */
	public int getHeight()
	{
		return height_;
	}

	/**
	 * @return the spawnX
	 */
	public int getSpawnX()
	{
		return spawnX_;
	}

	/**
	 * @return the spawnY
	 */
	public int getSpawnY()
	{
		return spawnY_;
	}

	/**
	 * Gets a world tile from the index at the given x- and y-coordinates
	 *
	 * @param x
	 *            The x-coordinate
	 * @param y
	 *            The y-coordinate
	 * @return A {@link WorldTile}
	 */
	public WorldTile getTile(int x, int y)
	{
		return tileIndex_.getTile(x, y);
	}
}
