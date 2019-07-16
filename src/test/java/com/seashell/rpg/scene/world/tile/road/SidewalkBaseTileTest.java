package com.seashell.rpg.scene.world.tile.road;

import static org.junit.Assert.assertEquals;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import org.junit.Test;
import org.mockito.Mockito;

import com.seashell.rpg.resource.R;
import com.seashell.rpg.scene.world.tile.sidewalk.SidewalkBaseTile;

/**
 * Test class {@link SidewalkBaseTile}
 */
public class SidewalkBaseTileTest extends AbstractRoadTileTest
{
	@Test
	@Override
	public void test_getId()
	{
		int id = 0;
		SidewalkBaseTile r = new SidewalkBaseTile(id);

		int actualId = r.getId();

		assertEquals(id, actualId);
	}

	@Test
	@Override
	public void test_getTexture()
	{
		BufferedImage expected = R.getSidewalkBase();

		SidewalkBaseTile r = new SidewalkBaseTile(0);
		BufferedImage actual = r.getTexture();

		runTextureTest(expected, actual);
	}

	@Test
	@Override
	public void test_isSolid()
	{
		SidewalkBaseTile r = new SidewalkBaseTile(0);

		boolean expected = false;
		boolean actual = r.isSolid();

		assertEquals("A SidewalkBaseTile should not be solid.", expected, actual);
	}

	@Test
	@Override
	public void test_tick()
	{
		SidewalkBaseTile r = new SidewalkBaseTile(0);
		r.tick();
	}

	@Test
	@Override
	public void test_render()
	{
		Graphics2D g2d = Mockito.mock(Graphics2D.class);

		SidewalkBaseTile r = new SidewalkBaseTile(0);
		r.render(g2d, 0, 0);
	}

	@Test(expected = NullPointerException.class)
	@Override
	public void test_render_nullGraphics2D()
	{
		SidewalkBaseTile r = new SidewalkBaseTile(0);
		r.render(null, 0, 0);
	}
}
