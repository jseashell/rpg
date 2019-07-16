package com.seashell.rpg.scene.world.tile.nature;

import static org.junit.Assert.assertEquals;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import org.junit.Test;
import org.mockito.Mockito;

import com.seashell.rpg.asset.Assets;
import com.seashell.rpg.scene.world.tile.AbstractTileTest;

/**
 * Test class for {@link GrassBaseTile}
 */
public class GrassBaseTileTest extends AbstractTileTest
{
	@Test
	@Override
	public void test_getId()
	{
		int id = 0;
		GrassBaseTile g = new GrassBaseTile(id);

		int actualId = g.getId();

		assertEquals(id, actualId);
	}

	@Test
	@Override
	public void test_getTexture()
	{
		BufferedImage expected = Assets.getGrassBase();

		GrassBaseTile g = new GrassBaseTile(0);
		BufferedImage actual = g.getTexture();

		runTextureTest(expected, actual);
	}

	@Test
	@Override
	public void test_isSolid()
	{
		GrassBaseTile g = new GrassBaseTile(0);

		boolean expected = false;
		boolean actual = g.isSolid();

		assertEquals("A GrassBaseTile should not be solid.", expected, actual);
	}

	@Test
	@Override
	public void test_tick()
	{
		GrassBaseTile g = new GrassBaseTile(0);
		g.tick();
	}

	@Test
	@Override
	public void test_render()
	{
		Graphics2D g2d = Mockito.mock(Graphics2D.class);

		GrassBaseTile g = new GrassBaseTile(0);
		g.render(g2d, 0, 0);
	}

	@Test(expected = NullPointerException.class)
	@Override
	public void test_render_nullGraphics2D()
	{
		GrassBaseTile g = new GrassBaseTile(0);
		g.render(null, 0, 0);
	}
}
