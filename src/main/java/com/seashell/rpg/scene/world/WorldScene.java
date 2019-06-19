package com.seashell.rpg.scene.world;

import java.awt.Graphics2D;
import java.io.IOException;

import com.seashell.rpg.GameProcess;
import com.seashell.rpg.entity.dynamic.character.PlayerCharacter;
import com.seashell.rpg.entity.dynamic.vehicle.Car;
import com.seashell.rpg.scene.AbstractScene;
import com.seashell.rpg.scene.Scene;

/**
 * A {@link Scene} representing the game play
 */
public class WorldScene extends AbstractScene
{
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
	 * @throws WorldConfigurationLoaderException
	 *             Failure to load the world
	 * @throws IOException
	 *             Failure to load the character assets
	 */
	public WorldScene(GameProcess gameProcess) throws WorldConfigurationLoaderException, IOException
	{
		String worldFilename = gameProcess.getConfiguration().getWorldFilename();
		world_ = new World(gameProcess.getGui().getCamera(), worldFilename, gameProcess.getConfiguration().getResolutionWidth(), gameProcess.getConfiguration().getResolutionHeight());

		System.out.println("Spawning player at [" + world_.getSpawnX() + "," + world_.getSpawnY() + "].");

		// TODO Make the open world scene smart enough to only spawn entities onto tiles that make sense
		player_ = new PlayerCharacter(world_, gameProcess.getGui().getCamera(), gameProcess.getKeyManager(), world_.getSpawnX(), world_.getSpawnY(), 64, 64);
		car_ = new Car(gameProcess.getGui().getCamera(), world_.getHeight(), 1344, 1536, 128, 128);
	}

	@Override
	public void tick()
	{
		// TODO Implement a tick order field for objects implementing the Render API. Note: tick order might not be necessary though.
		world_.tick();
		player_.tick();
		car_.tick();
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
