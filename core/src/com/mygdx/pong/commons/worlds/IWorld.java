package com.mygdx.pong.commons.worlds;

import com.badlogic.gdx.graphics.Texture;

public interface IWorld {

	Texture getWorldBackground();

	//TODO: Some sort of speed modifiers for the game balls?
	float getWorldGravity();

	void dispose();

}
