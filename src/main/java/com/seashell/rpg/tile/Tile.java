package com.seashell.rpg.tile;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.seashell.rpg.asset.Assets;

/**
 * API defining tiles for the game world. Tiles should have textures with a 1:1 aspect ratio for {@link #getSize()} to work appropriately
 */
public interface Tile
{
	/**
	 * Constant representing Tile size (always 1:1 aspect ratio, so height and width are the same)
	 */
	// TODO This has to be manually synced up with assets, and also forces tile assets to be 1:1 aspect ratio. Feels dirty as is. Not sure how to fix properly at this time though.
	static final int SIZE = Assets.SIZE * 8;

	/**
	 * @return The numeric identifier for this tile
	 */
	int getId();

	/**
	 * @return The texture for this tile
	 */
	BufferedImage getTexture();

	/**
	 * Updates this implementor's variables that represent canvas location and any other pertinent metadata
	 */
	// TODO Do tiles actually need to tick?
	void tick();

	/**
	 * Renders this implementor to the given graphics
	 *
	 * @param g2d
	 *            A graphics object for rendering the tile to the canvas. Non-null
	 * @param x
	 *            The x-coordinate for the tile
	 * @param y
	 *            The y-coordinate for the tile
	 * @throws NullPointerException
	 *             If the given graphics object is null
	 */
	void render(Graphics2D g2d, int x, int y) throws NullPointerException;
}
