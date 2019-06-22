package com.seashell.rpg.scene.world;

import java.awt.Graphics2D;
import java.io.IOException;

import com.seashell.rpg.entity.dynamic.character.PlayerCharacter;
import com.seashell.rpg.entity.dynamic.vehicle.Car;
import com.seashell.rpg.gui.GuiCamera;
import com.seashell.rpg.process.GameProcess;
import com.seashell.rpg.scene.AbstractScene;
import com.seashell.rpg.scene.Scene;
import com.seashell.rpg.scene.world.config.WorldConfigurationBuilderException;

/**
 * A {@link Scene} representing the game play
 */
public class WorldScene extends AbstractScene
{
	/**
	 * Camera for the gui showing this scene
	 */
	private final GuiCamera camera_;

	/**
	 * The world for this game play
	 */
	private final World world_;

	/**
	 * The player character for this game play
	 */
	private final PlayerCharacter player_;

	/**
	 * A car entity
	 */
	private final Car car_;

	/**
	 * Constructor
	 *
	 * @param gameProcess
	 *            The {@link GameProcess} responsible for this state
	 * @throws WorldConfigurationBuilderException
	 *             Failure to load the world
	 * @throws IOException
	 *             Failure to load the character assets
	 */
	public WorldScene(GameProcess gameProcess) throws WorldConfigurationBuilderException, IOException
	{
		camera_ = gameProcess.getGui().getCamera();

		String worldFilename = gameProcess.getConfiguration().getWorldFilename();
		world_ = new World(gameProcess.getGui().getCamera(), worldFilename, gameProcess.getConfiguration());

		System.out.println("Spawning player at [" + world_.getSpawnX() + "," + world_.getSpawnY() + "].");

		// TODO Make the open world scene smart enough to only spawn entities onto tiles that make sense
		player_ = new PlayerCharacter(world_, camera_, gameProcess.getKeyManager(), world_.getSpawnX(), world_.getSpawnY(), 64, 64);
		car_ = new Car(camera_, world_.getHeight(), 1344, 1536, 128, 128);
	}

	@Override
	public void tick()
	{
		// TODO Implement a tick order field for objects implementing the Render API. Note: tick order might not be necessary though.
		world_.tick();
		player_.tick();
		car_.tick();

		camera_.centerOnEntity(player_);
	}

	@Override
	public void render(Graphics2D g2d)
	{
		// TODO Implement a render order field for objects implementing the Render API
		world_.render(g2d);
		player_.render(g2d);
		car_.render(g2d);
	}
}
