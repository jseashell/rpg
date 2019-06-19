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
	 * Flags indicating wether or not the key is pressed
	 */
	private boolean isUp_, isDown_, isLeft_, isRight_, isSprint_;

	/**
	 * Constructor
	 */
	KeyManager()
	{
		keyIndex = new boolean[256];
	}

	public void tick()
	{
		// TODO Load key bindings from config.properties. Mapping text representations to KeyEvent seems like it is not an option after a short amount of research
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
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		keyIndex[e.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent e)
	{
	}

}
