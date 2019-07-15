package com.seashell.rpg.world.tile.roof;

import static org.junit.Assert.assertEquals;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import org.junit.Test;
import org.mockito.Mockito;

import com.seashell.rpg.asset.Assets;
import com.seashell.rpg.scene.world.tile.roof.RoofBaseGreyTile;
import com.seashell.rpg.world.tile.AbstractTileTest;

/**
 * Test class for {@link RoofBaseGreyTile}
 */
public class RoofBaseTileTest extends AbstractTileTest
{
	@Test
	@Override
	public void test_getId()
	{
		int id = 0;
		RoofBaseGreyTile r = new RoofBaseGreyTile(id);

		int actualId = r.getId();

		assertEquals(id, actualId);
	}

	@Test
	@Override
	public void test_getTexture()
	{
		BufferedImage expected = Assets.getRoofGreyBase();

		RoofBaseGreyTile r = new RoofBaseGreyTile(0);
		BufferedImage actual = r.getTexture();

		runTextureTest(expected, actual);
	}

	@Test
	@Override
	public void test_isSolid()
	{
		RoofBaseGreyTile r = new RoofBaseGreyTile(0);

		boolean expected = true;
		boolean actual = r.isSolid();

		assertEquals("A WallTile should be solid.", expected, actual);
	}

	@Test
	@Override
	public void test_tick()
	{
		RoofBaseGreyTile r = new RoofBaseGreyTile(0);
		r.tick();
	}

	@Test
	@Override
	public void test_render()
	{
		Graphics2D g2d = Mockito.mock(Graphics2D.class);

		RoofBaseGreyTile r = new RoofBaseGreyTile(0);
		r.render(g2d, 0, 0);
	}

	@Test(expected = NullPointerException.class)
	@Override
	public void test_render_nullGraphics2D()
	{
		RoofBaseGreyTile r = new RoofBaseGreyTile(0);
		r.render(null, 0, 0);
	}
}
