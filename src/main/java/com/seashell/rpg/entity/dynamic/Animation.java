package com.seashell.rpg.entity.dynamic;

import java.awt.image.BufferedImage;

/**
 * Utility class to animated an array of {@link BufferedImages} representing frames for a dynamic entity
 */
public class Animation
{
	/**
	 * Speed of the animation
	 */
	private int speed_;

	/**
	 * Frame index
	 */
	private int index_;

	/**
	 * Last time this animation ticked, in milliseconds
	 */
	private long lastTime_;

	/**
	 * Timer keeps track of how long it has been since {@link #lastTime_}
	 */
	private long timer_;

	/**
	 * Frames for this animation
	 */
	private final BufferedImage[] frames_;

	/**
	 * Constructor
	 *
	 * @param speed
	 * @param frames
	 */
	public Animation(int speed, BufferedImage[] frames)
	{
		speed_ = speed;
		frames_ = frames;

		index_ = 0;
		lastTime_ = System.currentTimeMillis();
		timer_ = 0;
	}

	/**
	 * Updates the animations internal fields
	 */
	public void tick()
	{
		timer_ += System.currentTimeMillis() - lastTime_;
		lastTime_ = System.currentTimeMillis();

		if(timer_ > speed_)
		{
			index_++;
			timer_ = 0;

			if(index_ >= frames_.length)
			{
				index_ = 0;
			}
		}
	}

	/**
	 * @return The current frame for the animation
	 */
	public BufferedImage getCurrentFrame()
	{
		return frames_[index_];
	}

	/**
	 * @param speed
	 *            The speed to set
	 */
	public void setSpeed(int speed)
	{
		speed_ = speed;
	}
}
