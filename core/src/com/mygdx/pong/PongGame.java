package com.mygdx.pong;

import java.awt.Rectangle;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.pong.commons.PongGameRules;
import com.mygdx.pong.commons.input.PlayerController;
import com.mygdx.pong.commons.playable.Pad;
import com.mygdx.pong.commons.playable.PlayerPad;

public class PongGame extends ApplicationAdapter {
	SpriteBatch batch;
//	Texture img;
	ShapeRenderer shapeRenderer;
	PlayerPad playerPad;
	public static final int fieldWidthBounds = 100;

	@Override
	public void create () {
		batch = new SpriteBatch();
//		img = new Texture("badlogic.jpg");
		shapeRenderer = new ShapeRenderer();
		playerPad = new PlayerPad(shapeRenderer, PongGameRules.PLAYER_ONE_STARTING_HORIZONTAL, PongGameRules.PLAYER_ONE_STARTING_VERTICAL);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
//		batch.draw(img, 0, 0);
		batch.end();


		PlayerController.movePlayer(playerPad);

		shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
		playerPad.draw();
		shapeRenderer.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
//		img.dispose();
		shapeRenderer.dispose();
	}
}
