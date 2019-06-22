package com.seashell.rpg.process;

/**
 * Keys for the config.properties resource
 */
public enum GameProcessConfigurationKey
{
	WORLD("world", String.class),

	FPS("fps", Integer.class),

	RESOLUTION_WIDTH("res_width", Integer.class),
	RESOLUTION_HEIGHT("res_height", Integer.class),

	KEY_BINDING_UP("key_binding_up", String.class),
	KEY_BINDING_DOWN("key_binding_down", String.class),
	KEY_BINDING_LEFT("key_binding_left", String.class),
	KEY_BINDING_RIGHT("key_binding_right", String.class),
	KEY_BINDING_SPRINT("key_binding_sprint", String.class),

	SPAWN_X("spawn_x", Integer.class),
	SPAWN_Y("spawn_y", Integer.class),

	;

	/**
	 * Value for {@link #getKey()}
	 */
	private final String key_;

	/**
	 * Value for {@link #getType()}
	 */
	private final Class<?> type_;

	/**
	 * Constructor
	 *
	 * @param key
	 *            Value for {@link #getKey()}
	 * @param type
	 *            Value for {@link #getType()}
	 */
	private GameProcessConfigurationKey(String key, Class<?> type)
	{
		key_ = key;
		type_ = type;
	}

	/**
	 * @return The key to retrieve this property by
	 */
	public String getKey()
	{
		return key_;
	}

	/**
	 * @return The Java type for this property
	 */
	public Class<?> getType()
	{
		return type_;
	}
}
