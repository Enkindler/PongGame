package com.mygdx.pong.commons.playable;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class PlayerPad extends Pad {

	public PlayerPad(ShapeRenderer shapeRenderer) {
		super(shapeRenderer);
	}

	public PlayerPad(ShapeRenderer shapeRenderer, int posX, int posY) {
		super(shapeRenderer, posX, posY);
	}
}
