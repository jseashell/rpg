package com.seashell.rpg.scene.world.tile.structure;

import static org.junit.Assert.assertEquals;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import org.junit.Test;
import org.mockito.Mockito;

import com.seashell.rpg.asset.Assets;
import com.seashell.rpg.scene.world.tile.AbstractTileTest;
import com.seashell.rpg.scene.world.tile.structure.WallTile;

/**
 * Test class for {@link WallTile}
 */
public class WallTileTest extends AbstractTileTest
{
	@Test
	@Override
	public void test_getId()
	{
		int id = 0;
		WallTile w = new WallTile(id);

		int actualId = w.getId();

		assertEquals(id, actualId);
	}

	@Test
	@Override
	public void test_getTexture()
	{
		BufferedImage expected = Assets.getWallBase();

		WallTile w = new WallTile(0);
		BufferedImage actual = w.getTexture();

		runTextureTest(expected, actual);
	}

	@Test
	@Override
	public void test_isSolid()
	{
		WallTile w = new WallTile(0);

		boolean expected = true;
		boolean actual = w.isSolid();

		assertEquals("A WallTile should be solid.", expected, actual);
	}

	@Test
	@Override
	public void test_tick()
	{
		WallTile w = new WallTile(0);
		w.tick();
	}

	@Test
	@Override
	public void test_render()
	{
		Graphics2D g2d = Mockito.mock(Graphics2D.class);

		WallTile w = new WallTile(0);
		w.render(g2d, 0, 0);
	}

	@Test(expected = NullPointerException.class)
	@Override
	public void test_render_nullGraphics2D()
	{
		WallTile w = new WallTile(0);
		w.render(null, 0, 0);
	}
}
