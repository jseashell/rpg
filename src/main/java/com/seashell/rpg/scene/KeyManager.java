package com.seashell.rpg.scene;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.seashell.rpg.process.GameProcessConfiguration;

/**
 * An implementation of {@link KeyListener} for user input. Handles PC movement.
 */
public class KeyManager implements KeyListener
{
	/**
	 * Identifiers for key bindings set via the game process configuration provided at construction
	 */
	private final int upId_, downId_, leftId_, rightId_, sprintId_;
	/**
	 * Index of keys
	 */
	private boolean[] keyIndex;

	/**
	 * Flags indicating whether or not the key is pressed
	 */
	private boolean isEsc_, isUp_, isDown_, isLeft_, isRight_, isSprint_;

	/**
	 * Integer representing the last direction that was faced. See {@link KeyEvent} constants
	 */
	private int lastDirectionFaced_;

	/**
	 * Constructor
	 */
	public KeyManager(GameProcessConfiguration config)
	{
		keyIndex = new boolean[256];
		lastDirectionFaced_ = KeyEvent.VK_S; // Initialize last direction to Down

		upId_ = config.getKeyBindingUp();
		downId_ = config.getKeyBindingDown();
		leftId_ = config.getKeyBindingLeft();
		rightId_ = config.getKeyBindingRight();
		sprintId_ = config.getKeyBindingSprint();
	}

	/**
	 * Updates this managers internal values
	 */
	public void tick()
	{
		isEsc_ = keyIndex[KeyEvent.VK_ESCAPE];
		isUp_ = keyIndex[upId_];
		isDown_ = keyIndex[downId_];
		isLeft_ = keyIndex[leftId_];
		isRight_ = keyIndex[rightId_];
		isSprint_ = keyIndex[sprintId_];
	}

	/**
	 * @return Flag indicating if escape is currently active ({@code true})
	 */
	public boolean isEsc()
	{
		return isEsc_;
	}

	/**
	 * @return Flag indicating if up is currently active ({@code true})
	 */
	public boolean isUp()
	{
		return isUp_;
	}

	/**
	 * @return Flag indicating if down is currently active ({@code true})
	 */
	public boolean isDown()
	{
		return isDown_;
	}

	/**
	 * @return Flag indicating if left is currently active ({@code true})
	 */
	public boolean isLeft()
	{
		return isLeft_;
	}

	/**
	 * @return Flag indicating if right is currently active ({@code true})
	 */
	public boolean isRight()
	{
		return isRight_;
	}

	/**
	 * @return Flag indicating if sprint is currently active ({@code true})
	 */
	public boolean isSprint()
	{
		return isSprint_;
	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		boolean isPressed = keyIndex[e.getKeyCode()];
		if(isPressed == false)
		{
			// Only log the change on the first press of the key
			System.out.println("Key pressed: " + e.getKeyChar());
		}

		keyIndex[e.getKeyCode()] = true;

		if(e.getKeyCode() == KeyEvent.VK_A
				|| e.getKeyCode() == KeyEvent.VK_D
				|| e.getKeyCode() == KeyEvent.VK_S
				|| e.getKeyCode() == KeyEvent.VK_W)
		{
			lastDirectionFaced_ = e.getKeyCode();
		}
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		keyIndex[e.getKeyCode()] = false;

		// Update the lastKeyPressed
		if(e.getKeyCode() == leftId_ || e.getKeyCode() == rightId_)
		{
			if(isUp())
			{
				lastDirectionFaced_ = upId_;
			}
			else if(isDown())
			{
				lastDirectionFaced_ = downId_;
			}
		}
		else if(e.getKeyCode() == downId_ || e.getKeyCode() == upId_)
		{
			if(isRight())
			{
				lastDirectionFaced_ = rightId_;
			}
			else if(isLeft())
			{
				lastDirectionFaced_ = leftId_;
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent e)
	{
	}

	/**
	 * @return The last registered direction that the player character was facing
	 */
	public int getLastDirectionFaced()
	{
		return lastDirectionFaced_;
	}
}
