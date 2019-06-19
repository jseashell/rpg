package com.seashell.rpg.scene.world;

import java.util.HashMap;
import java.util.Map;

import com.seashell.rpg.scene.world.tile.WorldTile;
import com.seashell.rpg.scene.world.tile.nature.GrassTile;
import com.seashell.rpg.scene.world.tile.road.RoadBaseTile;
import com.seashell.rpg.scene.world.tile.road.RoadSidewalkLeftTile;
import com.seashell.rpg.scene.world.tile.road.RoadSidewalkRightTile;
import com.seashell.rpg.scene.world.tile.road.RoadWhiteHashVerticalTile;
import com.seashell.rpg.scene.world.tile.road.RoadYellowSolidTile;
import com.seashell.rpg.scene.world.tile.road.SidewalkBaseTile;
import com.seashell.rpg.scene.world.tile.structure.WallTile;
import com.seashell.rpg.tile.Tile;

/**
 * Configuration for a {@link World}
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
	 * Value for {@link #getTokens()}
	 */
	private final String[] tokens_;

	/**
	 * Tile index for this world
	 */
	private final WorldTileIndex tileIndex_;

	/**
	 * Constructor
	 *
	 * @param width
	 *            Value for {@link #getWidth()}
	 * @param height
	 *            Value for {@link #getHeight()}
	 * @param spawnX
	 *            Value for {@link #getSpawnX()}
	 * @param spawnY
	 *            Value for {@link #getSpawnY()}
	 * @param tokens
	 *            Value for {@link #getTokens()}
	 */
	public WorldConfiguration(int width, int height, int spawnX, int spawnY, String[] tokens)
	{
		this.width_ = width;
		this.height_ = height;
		this.spawnX_ = spawnX;
		this.spawnY_ = spawnY;
		this.tokens_ = tokens;

		tileIndex_ = new WorldTileIndex(this);
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
	 * @return the tokens
	 */
	public String[] getTokens()
	{
		return tokens_;
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

	/**
	 * An index containing tiles for the world. Each tile can be found by position via {@link #getTile}
	 */
	private class WorldTileIndex
	{
		/**
		 * Mapping of tiles by {@link Tile#getId()}
		 */
		private final Map<Integer, WorldTile> tileIndex_;

		/**
		 * Mapping of tile IDs represented on an x-y plane
		 */
		private final int[][] idMap_;

		/**
		 * Constructor
		 *
		 * @param tileIds
		 *            An array of IDs that represent tiles in the order in which they should be placed
		 * @param width_
		 *            The width of the world
		 * @param height_
		 *            The height of the world
		 */
		public WorldTileIndex(WorldConfiguration worldConfig)
		{
			// TODO This is not maintainable as new tiles get added in. Build the index using annotations/reflection
			tileIndex_ = new HashMap<>();
			tileIndex_.put(0, new GrassTile(0));
			tileIndex_.put(1, new WallTile(1));
			tileIndex_.put(2, new RoadBaseTile(2));
			tileIndex_.put(3, new RoadWhiteHashVerticalTile(3));
			tileIndex_.put(4, new RoadSidewalkLeftTile(4));
			tileIndex_.put(5, new RoadSidewalkRightTile(5));
			tileIndex_.put(6, new SidewalkBaseTile(6));
			tileIndex_.put(7, new RoadYellowSolidTile(7));

			idMap_ = new int[width_][height_];
			for(int y = 0; y < height_; y++)
			{
				for(int x = 0; x < width_; x++)
				{
					idMap_[x][y] = Integer.parseInt(tokens_[(x + y * width_)]);
				}
			}
		}

		/**
		 * Gets a tile from the index at the given x- and y-coordinates
		 *
		 * @param x
		 *            The x-coordinate
		 * @param y
		 *            The y-coordinate
		 * @return A {@link WorldTile}
		 */
		public WorldTile getTile(int x, int y)
		{
			int tileId = idMap_[x][y];
			return tileIndex_.get(tileId);
		}
	}
}
