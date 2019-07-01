package com.seashell.rpg.scene.menu.main;

import java.awt.Shape;
import java.awt.image.BufferedImage;
import java.util.Objects;

import com.seashell.rpg.process.GameProcessState;
import com.seashell.rpg.scene.menu.AbstractMenuButton;

public class MainMenuButton extends AbstractMenuButton
{
	private final GameProcessState state_;

	public MainMenuButton(GameProcessState state, BufferedImage img, Shape shape)
	{
		super(img, shape);
		state_ = Objects.requireNonNull(state);
	}

	public GameProcessState getState()
	{
		return state_;
	}

}
