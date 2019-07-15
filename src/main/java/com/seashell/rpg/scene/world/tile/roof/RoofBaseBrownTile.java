package com.seashell.rpg.scene.world.tile.roof;

import com.seashell.rpg.asset.Assets;
import com.seashell.rpg.tile.Tile;

/**
 * A {@link Tile} for a plain brown roof
 */
public class RoofBaseBrownTile extends AbstractRoofTile
{
	/**
	 * Constructor
	 *
	 * @param id
	 *            Value for {@link #getId()}
	 */
	public RoofBaseBrownTile(int id)
	{
		super(id, Assets.getRoofBrownBase());
	}
}
