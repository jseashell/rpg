package com.seashell.rpg.scene.world;

import java.awt.Graphics2D;
import java.io.IOException;

import com.seashell.rpg.entity.EntityManager;
import com.seashell.rpg.entity.dynamic.character.PlayerCharacter;
import com.seashell.rpg.entity.dynamic.vehicle.CarRed;
import com.seashell.rpg.entity.dynamic.vehicle.CarTaxi;
import com.seashell.rpg.entity.stationary.Door;
import com.seashell.rpg.entity.stationary.StoplightDown;
import com.seashell.rpg.entity.stationary.Window;
import com.seashell.rpg.gui.GuiCamera;
import com.seashell.rpg.process.GameProcess;
import com.seashell.rpg.resource.R;
import com.seashell.rpg.scene.AbstractScene;
import com.seashell.rpg.scene.Scene;
import com.seashell.rpg.scene.world.config.WorldConfigurationBuilderException;
import com.seashell.rpg.tile.Tile;

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
	 * Manages entities for the world
	 */
	private final EntityManager entityManager_;

	/**
	 * The player character for this game play
	 */
	private final PlayerCharacter player_;

	/**
	 * Value manipulated by {@link #pause()} and {@link #resume()}
	 */
	private boolean isPaused_;

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
		isPaused_ = false;
		camera_ = gameProcess.getGui().getCamera();

		String worldFilename = gameProcess.getConfiguration().getWorldFilename();
		world_ = new World(gameProcess.getGui().getCamera(), worldFilename, gameProcess.getConfiguration());

		entityManager_ = new EntityManager();

		// TODO #11 Make the open world scene smart enough to only spawn entities onto tiles that make sense

		entityManager_.add(new Door(camera_, (23 * Tile.SIZE) + (R.SIZE * 2), (7 * Tile.SIZE) + (R.SIZE * 4)));

		entityManager_.add(new Window(camera_, (22 * Tile.SIZE) + (R.SIZE * 3), (5 * Tile.SIZE) + (R.SIZE * 3)));
		entityManager_.add(new Window(camera_, (22 * Tile.SIZE) + (R.SIZE * 3), (7 * Tile.SIZE) + (R.SIZE * 1)));
		entityManager_.add(new Window(camera_, (24 * Tile.SIZE) + (R.SIZE * 1), (6 * Tile.SIZE) + (R.SIZE * 3)));
		entityManager_.add(new Door(camera_, (26 * Tile.SIZE) + (R.SIZE * 2), (7 * Tile.SIZE) + (R.SIZE * 4)));
		entityManager_.add(new Window(camera_, (25 * Tile.SIZE) + (R.SIZE * 3), (6 * Tile.SIZE) + (R.SIZE * 3)));
		entityManager_.add(new Window(camera_, (27 * Tile.SIZE) + (R.SIZE * 1), (6 * Tile.SIZE) + (R.SIZE * 3)));
		entityManager_.add(new Door(camera_, (30 * Tile.SIZE) + (R.SIZE * 2), (7 * Tile.SIZE) + (R.SIZE * 4)));
		entityManager_.add(new Window(camera_, (29 * Tile.SIZE) + (R.SIZE * 3), (7 * Tile.SIZE) + (R.SIZE * 1)));
		entityManager_.add(new Window(camera_, (29 * Tile.SIZE) + (R.SIZE * 3), (6 * Tile.SIZE) + (R.SIZE * 3)));
		entityManager_.add(new Window(camera_, (31 * Tile.SIZE) + (R.SIZE * 1), (7 * Tile.SIZE) + (R.SIZE * 1)));
		entityManager_.add(new StoplightDown(camera_, (20 * Tile.SIZE) - (R.SIZE * 2), (9 * Tile.SIZE) + (R.SIZE * 3)));

		player_ = new PlayerCharacter(world_, camera_, gameProcess.getKeyManager(), world_.getSpawnX(), world_.getSpawnY());
		entityManager_.add(player_);

		entityManager_.add(new CarRed(0, camera_, world_.getWidth(), world_.getHeight(), 19 * R.SIZE * 8, 15 * R.SIZE * 8));
		entityManager_.add(new CarTaxi(0, camera_, world_.getWidth(), world_.getHeight(), 19 * R.SIZE * 8, 9 * R.SIZE * 8));
		entityManager_.add(new CarRed(1, camera_, world_.getWidth(), world_.getHeight(), 15 * R.SIZE * 8, 10 * R.SIZE * 8));
		entityManager_.add(new CarTaxi(1, camera_, world_.getWidth(), world_.getHeight(), 20 * R.SIZE * 8, 10 * R.SIZE * 8));

	}

	@Override
	public void tick()
	{
		if(!isPaused_)
		{
			world_.tick();
			entityManager_.tick();

			camera_.centerOnEntity(player_);
		}
	}

	@Override
	public void render(Graphics2D g2d)
	{
		world_.render(g2d);
		entityManager_.render(g2d);
	}

	/**
	 * Pauses the world scene
	 */
	public void pause()
	{
		isPaused_ = true;
	}

	/**
	 * Resumes the world scene
	 */
	public void resume()
	{
		isPaused_ = false;
	}
}
