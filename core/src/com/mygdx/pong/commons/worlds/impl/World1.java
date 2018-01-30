package com.mygdx.pong.commons.worlds.impl;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.pong.commons.worlds.IWorld;

public class World1 implements IWorld {

	private Texture worldBackground;

	public World1() {
		worldBackground = new Texture(new FileHandle("World1Background.jpg"), true);
	}

	@Override
	public Texture getWorldBackground() {
		return this.worldBackground;
	}

	@Override
	public float getWorldGravity() {
		return 1;
	}

	@Override
	public void dispose() {
		worldBackground.dispose();
	}
}
