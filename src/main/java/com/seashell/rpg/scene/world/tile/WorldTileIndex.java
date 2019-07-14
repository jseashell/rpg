package com.seashell.rpg.scene.world.tile;

import java.util.HashMap;
import java.util.Map;

import com.seashell.rpg.scene.world.tile.nature.GrassBaseTile;
import com.seashell.rpg.scene.world.tile.road.RoadBaseTile;
import com.seashell.rpg.scene.world.tile.road.RoadLineBottomTile;
import com.seashell.rpg.scene.world.tile.road.RoadLineBottomToLeftTile;
import com.seashell.rpg.scene.world.tile.road.RoadLineBottomToRightTile;
import com.seashell.rpg.scene.world.tile.road.RoadLineLeftTile;
import com.seashell.rpg.scene.world.tile.road.RoadLineRightTile;
import com.seashell.rpg.scene.world.tile.road.RoadLineTopTile;
import com.seashell.rpg.scene.world.tile.road.RoadLineTopToLeftTile;
import com.seashell.rpg.scene.world.tile.road.RoadLineTopToRightTile;
import com.seashell.rpg.scene.world.tile.road.RoadWhiteHashHorizontalTile;
import com.seashell.rpg.scene.world.tile.road.RoadWhiteHashVerticalTile;
import com.seashell.rpg.scene.world.tile.sidewalk.SidewalkBaseTile;
import com.seashell.rpg.scene.world.tile.sidewalk.SidewalkCurbBottomTile;
import com.seashell.rpg.scene.world.tile.sidewalk.SidewalkCurbBottomToLeftTile;
import com.seashell.rpg.scene.world.tile.sidewalk.SidewalkCurbBottomToRightTile;
import com.seashell.rpg.scene.world.tile.sidewalk.SidewalkCurbLeftTile;
import com.seashell.rpg.scene.world.tile.sidewalk.SidewalkCurbRightTile;
import com.seashell.rpg.scene.world.tile.sidewalk.SidewalkCurbTopTile;
import com.seashell.rpg.scene.world.tile.sidewalk.SidewalkCurbTopToLeftTile;
import com.seashell.rpg.scene.world.tile.sidewalk.SidewalkCurbTopToRightTile;
import com.seashell.rpg.tile.Tile;

/**
 * An index containing tiles for the world. Each tile can be found by position via {@link #getTile}
 */
public class WorldTileIndex
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
	 */
	public WorldTileIndex(int width, int height, String[] tokens)
	{
		// TODO #14 This is not maintainable as new tiles get added in. Build the index using annotations/reflection
		tileIndex_ = new HashMap<>();

		tileIndex_.put(0, new RoadBaseTile(0));
		tileIndex_.put(1, new RoadLineBottomTile(1));
		tileIndex_.put(2, new RoadLineBottomToLeftTile(2));
		tileIndex_.put(3, new RoadLineBottomToRightTile(3));
		tileIndex_.put(4, new RoadLineLeftTile(4));
		tileIndex_.put(5, new RoadLineRightTile(5));
		tileIndex_.put(6, new RoadLineTopTile(6));
		tileIndex_.put(7, new RoadLineTopToLeftTile(7));
		tileIndex_.put(8, new RoadLineTopToRightTile(8));
		tileIndex_.put(9, new RoadWhiteHashHorizontalTile(9));
		tileIndex_.put(10, new RoadWhiteHashVerticalTile(10));

		tileIndex_.put(20, new GrassBaseTile(20));

		tileIndex_.put(40, new SidewalkBaseTile(40));
		tileIndex_.put(41, new SidewalkCurbBottomTile(41));
		tileIndex_.put(42, new SidewalkCurbBottomToLeftTile(42));
		tileIndex_.put(43, new SidewalkCurbBottomToRightTile(43));
		tileIndex_.put(44, new SidewalkCurbLeftTile(44));
		tileIndex_.put(45, new SidewalkCurbRightTile(45));
		tileIndex_.put(46, new SidewalkCurbTopTile(46));
		tileIndex_.put(47, new SidewalkCurbTopToLeftTile(47));
		tileIndex_.put(48, new SidewalkCurbTopToRightTile(48));

		idMap_ = new int[width][height];
		for(int y = 0; y < height; y++)
		{
			for(int x = 0; x < width; x++)
			{
				int index = x + y * width;

				try
				{
					idMap_[x][y] = Integer.parseInt(tokens[index]);
				}
				catch(NumberFormatException e)
				{
					// TODO Log this
					e.printStackTrace();
					System.out.println("Uh oh");
				}
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
