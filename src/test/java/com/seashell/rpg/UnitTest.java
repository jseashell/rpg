package com.seashell.rpg;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.seashell.rpg.config.ConfigurationTest;

public interface UnitTest
{
	/**
	 * Gets a path for the given test resource
	 *
	 * @param filename
	 *            The name of the test resource file
	 * @return A {@link Path}
	 * @throws URISyntaxException
	 *             Invalid URI
	 */
	default Path getTestResourcePath(String filename) throws URISyntaxException
	{
		return Paths.get(ConfigurationTest.class.getClassLoader().getResource("dev/test/" + filename).toURI());
	}
}
