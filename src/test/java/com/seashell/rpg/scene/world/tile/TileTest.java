package com.seashell.rpg.scene.world.tile;

import java.awt.Graphics2D;

import org.mockito.Mockito;

import com.seashell.rpg.UnitTest;
import com.seashell.rpg.tile.Tile;

/**
 * API defining tests for {@link Tile} implementations
 */
public interface TileTest extends UnitTest
{
	/**
	 * Tests the golden path usage of {@link Tile#getId()}
	 */
	void test_getId();

	/**
	 * Tests that the proper texture is being associated from this tile
	 */
	void test_getTexture();

	/**
	 * Tests that the tile has a {@link Tile#isSolid()} implementation
	 */
	void test_isSolid();

	/**
	 * Tests that the tile has a {@link Tile#tick()} implementation
	 */
	void test_tick();

	/**
	 * Tests that the tile is rendered when given a {@link Mockito#mock(Class)} of a {@link Graphics2D} object
	 */
	void test_render();

	/**
	 * Tests that a {@link NullPointerException} occurs when {@link Tile#render(java.awt.Graphics2D, int, int)} is given a null {@link java.awt.Graphics2D} argument
	 */
	void test_render_nullGraphics2D();
}
