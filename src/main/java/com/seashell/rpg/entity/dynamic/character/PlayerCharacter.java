package com.seashell.rpg.entity.dynamic.character;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.io.IOException;

import com.seashell.rpg.asset.Assets;
import com.seashell.rpg.gui.GuiCamera;
import com.seashell.rpg.gui.KeyManager;
import com.seashell.rpg.scene.world.World;
import com.seashell.rpg.tile.Tile;

/**
 * A {@link AbstractCharacter} that can be controlled by a player
 */
public final class PlayerCharacter extends AbstractCharacter
{
	/**
	 * Scaling factor for the character's size
	 */
	private static final int SCALE_ = 4;

	/**
	 * Value for {@link #getKeyManager()}
	 */
	private final KeyManager keyManager_;

	/**
	 * Hitbox for this character
	 */
	private final Rectangle hitbox_;

	/**
	 * The world this character resides in
	 */
	private final World world_;

	/**
	 * Constructor
	 *
	 * @param camera
	 *            The camera for the game
	 * @param keyManager
	 *            Value for {@link #getKeyManager()}
	 * @param x
	 *            Initial value for {@link #getX()}
	 * @param y
	 *            Initial value for {@link #getY()}
	 * @param width
	 *            Value for {@link #getWidth()}
	 * @param height
	 *            Value for {@link #getHeight()}
	 */
	public PlayerCharacter(World world, GuiCamera camera, KeyManager keyManager, float x, float y) throws IOException
	{
		super(camera, Assets.getPlayerCharacterDown(),
				x * 2 * Assets.SIZE * SCALE_ + (Assets.SIZE / 2 * SCALE_),
				y * 2 * Assets.SIZE * SCALE_ + (Assets.SIZE / 2),
				Assets.SIZE * SCALE_,
				Assets.SIZE * SCALE_);

		world_ = world;
		keyManager_ = keyManager;
		hitbox_ = new Rectangle(3 * SCALE_, 2 * SCALE_, 10 * SCALE_, 14 * SCALE_); // TODO #12 Implement a strategy for defining a hitbox
	}

	@Override
	public void tick()
	{
		readMovementFromKeyManager();
		move();
	}

	private void move()
	{
		// TODO #10 Keep player character from escaping the edges of the map. When this happens, the player gets stuck and cannot move back inside the map, forcing a game restart.

		moveX();
		moveY();
	}

	/**
	 * Moves this player character in the x-axis plane
	 */
	private void moveX()
	{
		Integer tx = null;
		if(xMove_ > 0)
		{
			// Moving right
			tx = new Integer((int) (x_ + xMove_ + hitbox_.x + hitbox_.width) / Tile.SIZE);

		}
		else
		{
			// Moving left
			tx = new Integer((int) (x_ + xMove_ + hitbox_.x) / Tile.SIZE);
		}

		int hitboxUpperEdge = (int) (y_ + hitbox_.y) / Tile.SIZE;
		int hitboxLowerEdge = (int) (y_ + hitbox_.height) / Tile.SIZE;

		// Check for collisions
		if(tx != null
				&& !isCollision(tx.intValue(), hitboxUpperEdge)
				&& !isCollision(tx.intValue(), hitboxLowerEdge))
		{
			x_ += xMove_;
		}
	}

	/**
	 * Moves this player character in the y-axis plane
	 */
	private void moveY()
	{
		Integer ty = null;
		if(yMove_ > 0)
		{
			// Moving down
			ty = new Integer((int) (y_ + yMove_ + hitbox_.y + hitbox_.height) / Tile.SIZE);

		}
		else
		{
			// Moving up
			ty = new Integer((int) (y_ + yMove_ + hitbox_.y) / Tile.SIZE);
		}

		int hitboxLeftEdge = (int) (x_ + hitbox_.x) / Tile.SIZE;
		int hitboxRightEdge = (int) (x_ + hitbox_.width) / Tile.SIZE;

		// Check for collisions
		if(ty != null
				&& !isCollision(hitboxLeftEdge, ty.intValue())
				&& !isCollision(hitboxRightEdge, ty.intValue()))
		{
			y_ += yMove_;
		}
	}

	@Override
	public void render(Graphics2D g2d)
	{
		g2d.drawImage(getTexture(),
				(int) (x_ - camera_.getXOffset()),
				(int) (y_ - camera_.getYOffset()),
				width_,
				height_,
				null);

		// // DEBUG
		// // Draw the hitbox on top of the player
		// g2d.setColor(Color.RED);
		// g2d.drawRect((int) (x_ + hitbox_.x - camera_.getXOffset()),
		// (int) (y_ + hitbox_.y - camera_.getYOffset()),
		// hitbox_.width,
		// hitbox_.height);
	}

	/**
	 * Indicates whether or not this player character has collided with any world tiles
	 *
	 * @param x
	 *            The x-coordinate of the world tile
	 * @param y
	 *            The y-coordinate of the world tile
	 * @return {@code true} if this player character has collided with a world tile
	 */
	private boolean isCollision(int x, int y)
	{
		return world_.getTile(x, y).isSolid();
	}

	/**
	 * Updates the {@link #xMove_} and {@link #yMove_} variables using the {@link #getKeyManager()}
	 */
	// TODO #9 Improve character movement
	private void readMovementFromKeyManager()
	{

		xMove_ = 0;
		yMove_ = 0;

		if(keyManager_.isSprint())
		{
			speed_ = 6.0f;
		}
		else
		{
			speed_ = 3.0f;
		}
		if(keyManager_.isUp())
		{
			yMove_ = -speed_;
		}

		if(keyManager_.isLeft())
		{
			xMove_ = -speed_;
		}

		if(keyManager_.isDown())
		{
			yMove_ = speed_;
		}

		if(keyManager_.isRight())
		{
			xMove_ = speed_;
		}
	}
}