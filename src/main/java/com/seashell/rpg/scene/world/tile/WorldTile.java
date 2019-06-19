package com.seashell.rpg.scene.world.tile;

import com.seashell.rpg.tile.Tile;

/**
 * API defining tiles for a world
 */
public interface WorldTile extends Tile
{
	/**
	 * @return {@code true} if the tile is solid (entities should not walk through the tile)
	 */
	boolean isSolid();
}
