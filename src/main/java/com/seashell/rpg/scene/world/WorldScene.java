package com.seashell.rpg.scene.world;

import java.awt.Graphics2D;
import java.io.IOException;

import com.seashell.rpg.asset.Assets;
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
	private final Car carA_;

	/**
	 * A car entity
	 */
	private final Car carB_;

	/**
	 * A car entity
	 */
	private final Car carC_;

	/**
	 * A car entity
	 */
	private final Car carD_;

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

		// TODO #11 Make the open world scene smart enough to only spawn entities onto tiles that make sense
		player_ = new PlayerCharacter(world_, camera_, gameProcess.getKeyManager(), world_.getSpawnX(), world_.getSpawnY());

		carA_ = new Car(0, camera_, world_.getWidth(), world_.getHeight(), 7 * Assets.SIZE * 8, 15 * Assets.SIZE * 8);
		carB_ = new Car(0, camera_, world_.getWidth(), world_.getHeight(), 7 * Assets.SIZE * 8, 9 * Assets.SIZE * 8);

		carC_ = new Car(1, camera_, world_.getWidth(), world_.getHeight(), 3 * Assets.SIZE * 8, 10 * Assets.SIZE * 8);
		carD_ = new Car(1, camera_, world_.getWidth(), world_.getHeight(), 8 * Assets.SIZE * 8, 10 * Assets.SIZE * 8);
	}

	@Override
	public void tick()
	{
		// TODO Implement a tick order field for objects implementing the Render API. Note: tick order might not be necessary though.
		world_.tick();

		carA_.tick();
		carB_.tick();
		carC_.tick();
		carD_.tick();

		player_.tick();
		camera_.centerOnEntity(player_);
	}

	@Override
	public void render(Graphics2D g2d)
	{
		// TODO #13 Implement a render order field for objects implementing the Render API
		world_.render(g2d);
		player_.render(g2d);

		carA_.render(g2d);
		carB_.render(g2d);
		carC_.render(g2d);
		carD_.render(g2d);
	}
}
