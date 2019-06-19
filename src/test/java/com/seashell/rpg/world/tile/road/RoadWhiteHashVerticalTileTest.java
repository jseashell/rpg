package com.seashell.rpg.world.tile.road;

import static org.junit.Assert.assertEquals;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import org.junit.Test;
import org.mockito.Mockito;

import com.seashell.rpg.asset.Assets;
import com.seashell.rpg.scene.world.tile.road.RoadWhiteHashVerticalTile;

/**
 * Test class {@link RoadWhiteHashVerticalTile}
 */
public class RoadWhiteHashVerticalTileTest extends AbstractRoadTileTest
{
	@Test
	@Override
	public void test_getId()
	{
		int id = 0;
		RoadWhiteHashVerticalTile r = new RoadWhiteHashVerticalTile(id);

		int actualId = r.getId();

		assertEquals(id, actualId);
	}

	@Test
	@Override
	public void test_getTexture()
	{
		BufferedImage expected = Assets.getRoadWhiteHashVertical();

		RoadWhiteHashVerticalTile r = new RoadWhiteHashVerticalTile(0);
		BufferedImage actual = r.getTexture();

		runTextureTest(expected, actual);
	}

	@Test
	@Override
	public void test_isSolid()
	{
		RoadWhiteHashVerticalTile r = new RoadWhiteHashVerticalTile(0);

		boolean expected = false;
		boolean actual = r.isSolid();

		assertEquals("A RoadWhiteHashVerticalTile should not be solid.", expected, actual);
	}

	@Test
	@Override
	public void test_tick()
	{
		RoadWhiteHashVerticalTile r = new RoadWhiteHashVerticalTile(0);
		r.tick();
	}

	@Test
	@Override
	public void test_render()
	{
		Graphics2D g2d = Mockito.mock(Graphics2D.class);

		RoadWhiteHashVerticalTile r = new RoadWhiteHashVerticalTile(0);
		r.render(g2d, 0, 0);
	}

	@Test(expected = NullPointerException.class)
	@Override
	public void test_render_nullGraphics2D()
	{
		RoadWhiteHashVerticalTile r = new RoadWhiteHashVerticalTile(0);
		r.render(null, 0, 0);
	}
}
