package com.seashell.rpg.entity.dynamic.character;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import com.seashell.rpg.asset.Assets;
import com.seashell.rpg.entity.dynamic.Animation;
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
	 * Speed for the walking animation
	 */
	private static final int WALK_SPEED_ = 150;

	/**
	 * Speed for the sprinting animation
	 */
	private static final int SPRINT_SPEED_ = 75;

	/**
	 * Scaling factor for the character's width and height
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
	 * Animation to use for moving down
	 */
	private Animation animDown_;

	/**
	 * Animation to use for moving left
	 */
	private Animation animLeft_;

	/**
	 * Animation to use for moving right
	 */
	private Animation animRight_;

	/**
	 * Animation to use for moving up
	 */
	private Animation animUp_;

	/**
	 * Animation speed
	 */
	private int animSpeed_;

	/**
	 * Flag indicating that the player has collided upward
	 */
	private boolean collidedUp_;

	/**
	 * Flag indicating that the player has collided downward
	 */
	private boolean collidedDown_;

	/**
	 * Flag indicating that the player has collided leftward
	 */
	private boolean collidedLeft_;

	/**
	 * Flag indicating that the player has collided rightward
	 */
	private boolean collidedRight_;

	/**
	 * Constructor
	 *
	 * @param camera
	 *            The camera controlling the scene showing this entity
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
		super(camera, Assets.getPlayerCharacterStandingDown(),
				x * 2 * Assets.SIZE * SCALE_ + (Assets.SIZE / 2 * SCALE_),
				y * 2 * Assets.SIZE * SCALE_ + (Assets.SIZE / 2),
				Assets.SIZE * SCALE_,
				Assets.SIZE * SCALE_);

		collidedUp_ = false;
		collidedDown_ = false;
		collidedLeft_ = false;
		collidedRight_ = false;

		animSpeed_ = WALK_SPEED_; // Initialize character with walking speed

		BufferedImage[] playerDown = new BufferedImage[3];
		playerDown[0] = Assets.getPlayerCharacterWalkingDownVariantA();
		playerDown[1] = Assets.getPlayerCharacterWalkingDownVariantB();
		playerDown[2] = Assets.getPlayerCharacterStandingDown();
		animDown_ = new Animation(animSpeed_, playerDown);

		BufferedImage[] playerLeft = new BufferedImage[3];
		playerLeft[0] = Assets.getPlayerCharacterWalkingLeftVariantA();
		playerLeft[1] = Assets.getPlayerCharacterWalkingLeftVariantB();
		playerLeft[2] = Assets.getPlayerCharacterStandingLeft();
		animLeft_ = new Animation(animSpeed_, playerLeft);

		BufferedImage[] playerRight = new BufferedImage[3];
		playerRight[0] = Assets.getPlayerCharacterWalkingRightVariantA();
		playerRight[1] = Assets.getPlayerCharacterWalkingRightVariantB();
		playerRight[2] = Assets.getPlayerCharacterStandingRight();
		animRight_ = new Animation(animSpeed_, playerRight);

		BufferedImage[] playerUp = new BufferedImage[3];
		playerUp[0] = Assets.getPlayerCharacterWalkingUpVariantA();
		playerUp[1] = Assets.getPlayerCharacterWalkingUpVariantB();
		playerUp[2] = Assets.getPlayerCharacterStandingUp();
		animUp_ = new Animation(animSpeed_, playerUp);

		world_ = world;
		keyManager_ = keyManager;
		hitbox_ = new Rectangle(3 * SCALE_, 2 * SCALE_, 10 * SCALE_, 14 * SCALE_); // TODO #12 Implement a strategy for defining a hitbox
	}

	@Override
	public void tick()
	{
		if(keyManager_.isSprint())
		{
			setAnimationSpeed(SPRINT_SPEED_);
		}
		else
		{
			setAnimationSpeed(WALK_SPEED_);
		}

		animDown_.tick();
		animLeft_.tick();
		animUp_.tick();
		animRight_.tick();

		readMovementFromKeyManager();

		move();
	}

	/**
	 * @param animSpeed
	 *            The speed to set for all animations for this character
	 */
	private void setAnimationSpeed(int animSpeed)
	{
		animDown_.setSpeed(animSpeed);
		animLeft_.setSpeed(animSpeed);
		animUp_.setSpeed(animSpeed);
		animRight_.setSpeed(animSpeed);
	}

	/**
	 * Moves the character on the x/y plane
	 */
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
			// No collision
			collidedRight_ = false;
			collidedLeft_ = false;

			x_ += xMove_;
		}
		else
		{
			// Collision
			if(xMove_ > 0)
			{
				collidedRight_ = true;
			}
			else if(xMove_ < 0)
			{
				collidedLeft_ = true;
			}
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
			// No collision
			collidedDown_ = false;
			collidedUp_ = false;

			y_ += yMove_;
		}
		else
		{
			if(yMove_ > 0)
			{
				collidedDown_ = true;
			}
			else if(yMove_ < 0)
			{
				collidedUp_ = true;
			}
		}
	}

	@Override
	public void render(Graphics2D g2d)
	{
		g2d.drawImage(getCurrentAnimationFrame(),
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
	 * @return The image to use for the current frame of this characters animation
	 */
	private BufferedImage getCurrentAnimationFrame()
	{
		if(xMove_ == 0 || collidedLeft_ || collidedRight_) // Check if the PC is stuck moving left/right
		{
			if(keyManager_.getLastDirectionFaced() == KeyEvent.VK_A)
			{
				return Assets.getPlayerCharacterStandingLeft();
			}
			else if(keyManager_.getLastDirectionFaced() == KeyEvent.VK_D)
			{
				return Assets.getPlayerCharacterStandingRight();
			}
		}

		if(yMove_ == 0 || collidedUp_ || collidedDown_) // Check if the PC is stuck moving up/down
		{
			if(keyManager_.getLastDirectionFaced() == KeyEvent.VK_S)
			{
				return Assets.getPlayerCharacterStandingDown();
			}
			else if(keyManager_.getLastDirectionFaced() == KeyEvent.VK_W)
			{
				return Assets.getPlayerCharacterStandingUp();
			}
		}

		if(xMove_ < 0)
		{
			return animLeft_.getCurrentFrame();
		}
		else if(xMove_ > 0)
		{
			return animRight_.getCurrentFrame();
		}
		else if(yMove_ < 0)
		{
			return animUp_.getCurrentFrame();
		}
		else if(yMove_ > 0)
		{
			return animDown_.getCurrentFrame();
		}

		// Default
		return Assets.getPlayerCharacterStandingDown();
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