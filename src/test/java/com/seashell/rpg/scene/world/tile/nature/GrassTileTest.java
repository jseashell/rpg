package com.seashell.rpg.scene.world.tile.nature;

import static org.junit.Assert.assertEquals;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import org.junit.Test;
import org.mockito.Mockito;

import com.seashell.rpg.asset.Assets;
import com.seashell.rpg.scene.world.tile.AbstractTileTest;
import com.seashell.rpg.scene.world.tile.nature.GrassTile;

/**
 * Test class for {@link GrassTile}
 */
public class GrassTileTest extends AbstractTileTest
{
	@Test
	@Override
	public void test_getId()
	{
		int id = 0;
		GrassTile g = new GrassTile(id);

		int actualId = g.getId();

		assertEquals(id, actualId);
	}

	@Test
	@Override
	public void test_getTexture()
	{
		BufferedImage expected = Assets.getGrassBase();

		GrassTile g = new GrassTile(0);
		BufferedImage actual = g.getTexture();

		runTextureTest(expected, actual);
	}

	@Test
	@Override
	public void test_isSolid()
	{
		GrassTile g = new GrassTile(0);

		boolean expected = false;
		boolean actual = g.isSolid();

		assertEquals("A GrassTile should not be solid.", expected, actual);
	}

	@Test
	@Override
	public void test_tick()
	{
		GrassTile g = new GrassTile(0);
		g.tick();
	}

	@Test
	@Override
	public void test_render()
	{
		Graphics2D g2d = Mockito.mock(Graphics2D.class);

		GrassTile g = new GrassTile(0);
		g.render(g2d, 0, 0);
	}

	@Test(expected = NullPointerException.class)
	@Override
	public void test_render_nullGraphics2D()
	{
		GrassTile g = new GrassTile(0);
		g.render(null, 0, 0);
	}
}
