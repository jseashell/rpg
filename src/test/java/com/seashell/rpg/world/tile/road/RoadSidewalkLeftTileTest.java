package com.seashell.rpg.world.tile.road;

import static org.junit.Assert.assertEquals;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import org.junit.Test;
import org.mockito.Mockito;

import com.seashell.rpg.asset.Assets;
import com.seashell.rpg.scene.world.tile.road.RoadLineLeftTile;

/**
 * Test class {@link RoadLineLeftTile}
 */
public class RoadSidewalkLeftTileTest extends AbstractRoadTileTest
{
	@Test
	@Override
	public void test_getId()
	{
		int id = 0;
		RoadLineLeftTile r = new RoadLineLeftTile(id);

		int actualId = r.getId();

		assertEquals(id, actualId);
	}

	@Test
	@Override
	public void test_getTexture()
	{
		BufferedImage expected = Assets.getRoadLineLeft();

		RoadLineLeftTile r = new RoadLineLeftTile(0);
		BufferedImage actual = r.getTexture();

		runTextureTest(expected, actual);
	}

	@Test
	@Override
	public void test_isSolid()
	{
		RoadLineLeftTile r = new RoadLineLeftTile(0);

		boolean expected = false;
		boolean actual = r.isSolid();

		assertEquals("A RoadSidewalkLeftTile should not be solid.", expected, actual);
	}

	@Test
	@Override
	public void test_tick()
	{
		RoadLineLeftTile r = new RoadLineLeftTile(0);
		r.tick();
	}

	@Test
	@Override
	public void test_render()
	{
		Graphics2D g2d = Mockito.mock(Graphics2D.class);

		RoadLineLeftTile r = new RoadLineLeftTile(0);
		r.render(g2d, 0, 0);
	}

	@Test(expected = NullPointerException.class)
	@Override
	public void test_render_nullGraphics2D()
	{
		RoadLineLeftTile r = new RoadLineLeftTile(0);
		r.render(null, 0, 0);
	}
}
