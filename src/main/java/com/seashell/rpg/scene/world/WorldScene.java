package com.seashell.rpg.scene.world;

import java.awt.Graphics2D;
import java.io.IOException;

import com.seashell.rpg.asset.Assets;
import com.seashell.rpg.entity.dynamic.character.PlayerCharacter;
import com.seashell.rpg.entity.dynamic.vehicle.CarRed;
import com.seashell.rpg.entity.dynamic.vehicle.CarTaxi;
import com.seashell.rpg.entity.stationary.Door;
import com.seashell.rpg.entity.stationary.StoplightDown;
import com.seashell.rpg.entity.stationary.Window;
import com.seashell.rpg.gui.GuiCamera;
import com.seashell.rpg.process.GameProcess;
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
	 * The player character for this game play
	 */
	private final PlayerCharacter player_;

	/**
	 * A car entity
	 */
	private final CarRed carA_;

	/**
	 * A car entity
	 */
	private final CarTaxi carB_;

	/**
	 * A car entity
	 */
	private final CarRed carC_;

	/**
	 * A car entity
	 */
	private final CarTaxi carD_;

	/**
	 * A door entity
	 */
	private final Door doorA_;

	/**
	 * A door entity
	 */
	private final Door doorB_;

	/**
	 * A door entity
	 */
	private final Door doorC_;

	/**
	 * A window entity
	 */
	private final Window windowA_;

	/**
	 * A window entity
	 */
	private final Window windowB_;

	/**
	 * A window entity
	 */
	private final Window windowC_;

	/**
	 * A window entity
	 */
	private final Window windowD_;

	/**
	 * A window entity
	 */
	private final Window windowE_;

	/**
	 * A window entity
	 */
	private final Window windowF_;

	/**
	 * A window entity
	 */
	private final Window windowG_;

	/**
	 * A window entity
	 */
	private final Window windowH_;

	/**
	 * A stoplight entity facing down
	 */
	private final StoplightDown stoplightDown_;

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

		// TODO #11 Make the open world scene smart enough to only spawn entities onto tiles that make sense

		doorA_ = new Door(camera_, (23 * Tile.SIZE) + (Assets.SIZE * 2), (7 * Tile.SIZE) + (Assets.SIZE * 4));
		windowA_ = new Window(camera_, (22 * Tile.SIZE) + (Assets.SIZE * 3), (5 * Tile.SIZE) + (Assets.SIZE * 3));
		windowB_ = new Window(camera_, (22 * Tile.SIZE) + (Assets.SIZE * 3), (7 * Tile.SIZE) + (Assets.SIZE * 1));
		windowC_ = new Window(camera_, (24 * Tile.SIZE) + (Assets.SIZE * 1), (6 * Tile.SIZE) + (Assets.SIZE * 3));

		doorB_ = new Door(camera_, (26 * Tile.SIZE) + (Assets.SIZE * 2), (7 * Tile.SIZE) + (Assets.SIZE * 4));
		windowD_ = new Window(camera_, (25 * Tile.SIZE) + (Assets.SIZE * 3), (6 * Tile.SIZE) + (Assets.SIZE * 3));
		windowE_ = new Window(camera_, (27 * Tile.SIZE) + (Assets.SIZE * 1), (6 * Tile.SIZE) + (Assets.SIZE * 3));

		doorC_ = new Door(camera_, (30 * Tile.SIZE) + (Assets.SIZE * 2), (7 * Tile.SIZE) + (Assets.SIZE * 4));
		windowF_ = new Window(camera_, (29 * Tile.SIZE) + (Assets.SIZE * 3), (7 * Tile.SIZE) + (Assets.SIZE * 1));
		windowG_ = new Window(camera_, (29 * Tile.SIZE) + (Assets.SIZE * 3), (6 * Tile.SIZE) + (Assets.SIZE * 3));
		windowH_ = new Window(camera_, (31 * Tile.SIZE) + (Assets.SIZE * 1), (7 * Tile.SIZE) + (Assets.SIZE * 1));

		stoplightDown_ = new StoplightDown(camera_, (20 * Tile.SIZE) - (Assets.SIZE * 2), (9 * Tile.SIZE) + (Assets.SIZE * 3));

		player_ = new PlayerCharacter(world_, camera_, gameProcess.getKeyManager(), world_.getSpawnX(), world_.getSpawnY());

		carA_ = new CarRed(0, camera_, world_.getWidth(), world_.getHeight(), 19 * Assets.SIZE * 8, 15 * Assets.SIZE * 8);
		carB_ = new CarTaxi(0, camera_, world_.getWidth(), world_.getHeight(), 19 * Assets.SIZE * 8, 9 * Assets.SIZE * 8);
		carC_ = new CarRed(1, camera_, world_.getWidth(), world_.getHeight(), 15 * Assets.SIZE * 8, 10 * Assets.SIZE * 8);
		carD_ = new CarTaxi(1, camera_, world_.getWidth(), world_.getHeight(), 20 * Assets.SIZE * 8, 10 * Assets.SIZE * 8);
	}

	@Override
	public void tick()
	{
		// TODO Implement a tick order field for objects implementing the Render API. Note: tick order might not be necessary though.
		world_.tick();

		doorA_.tick();
		windowA_.tick();
		windowB_.tick();
		windowC_.tick();

		doorB_.tick();
		windowD_.tick();
		windowE_.tick();

		doorC_.tick();
		windowF_.tick();
		windowG_.tick();
		windowH_.tick();

		carA_.tick();
		carB_.tick();
		carC_.tick();
		carD_.tick();

		stoplightDown_.tick();

		player_.tick();
		camera_.centerOnEntity(player_);
	}

	@Override
	public void render(Graphics2D g2d)
	{
		// TODO #13 Implement a render order field for objects implementing the Render API
		world_.render(g2d);

		doorA_.render(g2d);
		windowA_.render(g2d);
		windowB_.render(g2d);
		windowC_.render(g2d);

		doorB_.render(g2d);
		windowD_.render(g2d);
		windowE_.render(g2d);

		doorC_.render(g2d);
		windowF_.render(g2d);
		windowG_.render(g2d);
		windowH_.render(g2d);

		player_.render(g2d);

		carA_.render(g2d);
		carB_.render(g2d);
		carC_.render(g2d);
		carD_.render(g2d);

		stoplightDown_.render(g2d);
	}
}
