package com.seashell.rpg.entity;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.seashell.rpg.Render;
import com.seashell.rpg.entity.dynamic.character.PlayerCharacter;

/**
 * Utility for managing a collection of entities
 */
public final class EntityManager implements Render
{
	/**
	 * Managed entities. Sorted by {@link #add(Entity)} order
	 */
	private final List<Entity> entities_;

	/**
	 * Value for {@link #getPlayerCharacter()}
	 */
	private final PlayerCharacter player_;

	/**
	 * Constructor
	 *
	 * @param player
	 *            Value for {@link #getPlayerCharacter()}
	 */
	public EntityManager(PlayerCharacter player)
	{
		entities_ = new ArrayList<>();
		player_ = player;
	}

	/**
	 * @return The player character entity
	 */
	public PlayerCharacter getPlayerCharacter()
	{
		return player_;
	}

	/**
	 * Adds an entity to this end of this manager's internal collection of entities
	 *
	 * @param entity
	 *            The entity to add
	 */
	public void add(Entity entity)
	{
		if(!entities_.add(Objects.requireNonNull(entity)))
		{
			System.err.println("Failed to add entity " + entity);
		}
	}

	@Override
	public void tick()
	{
		for(int i = 0; i < entities_.size(); i++)
		{
			Entity e = entities_.get(i);
			e.tick();
		}

		player_.tick();
	}

	@Override
	public void render(Graphics2D g2d)
	{
		for(Entity e : entities_)
		{
			e.render(g2d);
		}

		player_.render(g2d);
	}
}
