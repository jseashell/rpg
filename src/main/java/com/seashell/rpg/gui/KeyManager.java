package com.seashell.rpg.gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * An implementation of {@link KeyListener} for user input. Handles PC movement.
 */
public class KeyManager implements KeyListener
{
	/**
	 * Index of keys
	 */
	private boolean[] keyIndex;

	/**
	 * Flags indicating whether or not the key is pressed
	 */
	private boolean isUp_, isDown_, isLeft_, isRight_, isSprint_;

	/**
	 * Integer representing the last direction that was faced. See {@link KeyEvent} constants
	 */
	private int lastDirectionFaced_;

	/**
	 * Constructor
	 */
	KeyManager()
	{
		keyIndex = new boolean[256];
		lastDirectionFaced_ = KeyEvent.VK_S; // Initialize last direction to Down
	}

	/**
	 * Updates this managers internal values
	 */
	public void tick()
	{
		// TODO #5 Load key bindings from config.properties. Mapping text representations to KeyEvent seems like it is not an option after a short amount of research
		isUp_ = keyIndex[KeyEvent.VK_W];
		isDown_ = keyIndex[KeyEvent.VK_S];
		isLeft_ = keyIndex[KeyEvent.VK_A];
		isRight_ = keyIndex[KeyEvent.VK_D];
		isSprint_ = keyIndex[KeyEvent.VK_SHIFT];
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
		lastDirectionFaced_ = e.getKeyCode();
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		keyIndex[e.getKeyCode()] = false;

		// Update the lastKeyPressed
		if(e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_D)
		{
			if(isUp())
			{
				lastDirectionFaced_ = KeyEvent.VK_W;
			}
			else if(isDown())
			{
				lastDirectionFaced_ = KeyEvent.VK_S;
			}
		}
		else if(e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_W)
		{
			if(isRight())
			{
				lastDirectionFaced_ = KeyEvent.VK_D;
			}
			else if(isLeft())
			{
				lastDirectionFaced_ = KeyEvent.VK_A;
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
