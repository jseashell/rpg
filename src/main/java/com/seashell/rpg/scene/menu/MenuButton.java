package com.seashell.rpg.scene.menu;

import java.awt.Shape;
import java.awt.image.BufferedImage;
import java.util.Objects;

import com.seashell.rpg.process.GameProcessState;

/**
 * Parent class for all menu buttons to extend
 */
public class MenuButton
{
	/**
	 * Value for {@link #getLabel()}
	 */
	private final String label_;
	/**
	 * Value for {@link #getDestinationState()}
	 */
	private final GameProcessState destinationState_;

	/**
	 * Value for {@link #getShape()}
	 */
	private final Shape shape_;

	/**
	 * Value for {@link #getIdleImage()}
	 */
	private BufferedImage idleImage_;
	/**
	 * Value for {@link #getActiveImage()}
	 */
	private BufferedImage activeImage_;

	/**
	 * Value for {@link #isHovered()}
	 */
	private boolean isHovered_;

	/**
	 * Value for {@link #isClicked()}
	 */
	private boolean isClicked_;

	/**
	 * Constructor
	 *
	 * @param label
	 *            Value for {@link #getLabel()}
	 * @param destinationState
	 *            Value for {@link #getDestinationState()}.
	 * @param shape
	 *            Value for {@link #getShape()}
	 * @param idleImage
	 *            Value for {@link #getIdleImage()}
	 * @param activeImage
	 *            Value for {@link #getIdleImage()}
	 */
	public MenuButton(String label, GameProcessState destinationState, Shape shape, BufferedImage idleImage, BufferedImage activeImage)
	{
		destinationState_ = Objects.requireNonNull(destinationState);
		label_ = Objects.requireNonNull(label);
		shape_ = Objects.requireNonNull(shape);
		idleImage_ = Objects.requireNonNull(idleImage);
		activeImage_ = Objects.requireNonNull(activeImage);
		isHovered_ = false;
		isClicked_ = false;
	}

	/**
	 * @return The game process state to go to when this button is clicked
	 */
	public GameProcessState getDestinationState()
	{
		return destinationState_;
	}

	/**
	 * @return The label text for this button
	 */
	public String getLabel()
	{
		return label_;
	}

	/**
	 * @return The shape of this button
	 */
	public final Shape getShape()
	{
		return shape_;
	}

	/**
	 * @return The idle (unclicked) image for this button
	 */
	public final BufferedImage getIdleImage()
	{
		return idleImage_;
	}

	/**
	 * @return The active (clicked) image for this button
	 */
	public final BufferedImage getActiveImage()
	{
		return activeImage_;
	}

	/**
	 * @return {@code true} if this button is being hovered over
	 */
	public boolean isHovered()
	{
		return isHovered_;
	}

	/**
	 * @param isHovered
	 *            {@code true} if this button is being hovered over
	 */
	public void setIsHovered(boolean isHovered)
	{
		isHovered_ = isHovered;
	}

	public boolean isClicked()
	{
		return isClicked_;

	}

	/**
	 * @param isClicked
	 *            {@code true} if this button is clicked
	 */
	public void setIsClick(boolean isClicked)
	{
		isClicked_ = isClicked;
	}
}
