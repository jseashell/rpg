package com.seashell.rpg.scene.world.tile;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Objects;

import com.seashell.rpg.tile.AbstractTile;
import com.seashell.rpg.tile.Tile;

/**
 * Parent for all tiles in the world scene to extend
 */
public abstract class AbstractWorldTile extends AbstractTile implements WorldTile
{

	/**
	 * Hitbox for this character
	 */
	private final Rectangle hitbox_;

	/**
	 * Constructor
	 *
	 * @param id
	 *            Value for {@link #getId()}
	 * @param texture
	 *            Value for {@link #getTexture()}
	 */
	protected AbstractWorldTile(int id, BufferedImage texture)
	{
		super(id, texture);
		hitbox_ = new Rectangle(0, 0, Tile.SIZE, Tile.SIZE); // TODO #12 Implement a strategy for defining a hitbox
	}

	@Override
	public void tick()
	{
		// Nothing for now. Tiles don't need location to be updated
	}

	@Override
	public void render(Graphics2D g2d, int x, int y)
	{
		Objects.requireNonNull(g2d);

		g2d.drawImage(getTexture(), x, y, Tile.SIZE, Tile.SIZE, null);

		// // DEBUG
		// // Draw an outline around the tile
		// g2d.setColor(Color.RED);
		// g2d.drawRect(x + hitbox_.x,
		// y + hitbox_.y,
		// hitbox_.width,
		// hitbox_.height);
	}
}
