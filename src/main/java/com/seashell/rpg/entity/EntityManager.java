package com.seashell.rpg.entity;

import java.awt.Graphics2D;
import java.util.LinkedHashSet;
import java.util.Objects;

import com.seashell.rpg.Render;

/**
 * Utility for managing a collection of entities
 */
public final class EntityManager implements Render
{
	/**
	 * Managed entities. Sorted by {@link #add(Entity)} order
	 */
	private final LinkedHashSet<Entity> entities_;

	/**
	 * Constructor
	 */
	public EntityManager()
	{
		entities_ = new LinkedHashSet<>();
	}

	/**
	 * Adds an entity to this end of this manager's interal collection of entities
	 *
	 * @param entity
	 *            The entity to add
	 */
	public void add(Entity entity)
	{
		entities_.add(Objects.requireNonNull(entity));
	}

	@Override
	public void tick()
	{
		for(Entity e : entities_)
		{
			e.tick();
		}
	}

	@Override
	public void render(Graphics2D g2d)
	{
		for(Entity e : entities_)
		{
			e.render(g2d);
		}
	}
}
