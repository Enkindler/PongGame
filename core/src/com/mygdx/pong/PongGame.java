package com.mygdx.pong;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.pong.commons.PongGameRules;
import com.mygdx.pong.commons.balls.Ball;
import com.mygdx.pong.commons.input.PlayerOneController;
import com.mygdx.pong.commons.input.interfaces.PlayerTwoController;
import com.mygdx.pong.commons.playable.player.Player;

//TODO: In the future, remove global rules, instead use some sort of map class to have different levels with different rules.

public class PongGame extends ApplicationAdapter {
	SpriteBatch batch;
	ShapeRenderer shapeRenderer;
	Player player;
	Player player2;
	Ball gameBall;

	Texture gameBackground;

	@Override
	public void create () {
		this.resize(PongGameRules.SCREEN_WIDTH, PongGameRules.SCREEN_HEIGHT);
		batch = new SpriteBatch();
		gameBackground = new Texture(new FileHandle("MainBackground.jpg"), true);
		shapeRenderer = new ShapeRenderer();

		//TODO: Improve playerController to avoid instantiating, maybe some sort of dependency injection?
		//TODO: Also improve creation of the pad.
		player = new Player(new PlayerOneController(), shapeRenderer, PongGameRules.SCREEN_WIDTH / 2, PongGameRules.FIELD_VERTICAL_BOUNDS);
		player2 = new Player(new PlayerTwoController(), shapeRenderer, PongGameRules.SCREEN_WIDTH / 2, PongGameRules.SCREEN_HEIGHT - PongGameRules.FIELD_VERTICAL_BOUNDS);

		gameBall = new Ball(shapeRenderer);

	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(gameBackground, 0,0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		batch.end();

		player.getController().movePlayer(player.getPlayerPad());
		player2.getController().movePlayer(player2.getPlayerPad());
		gameBall.move();

		player.getPlayerPad().onCollide(gameBall);
		player2.getPlayerPad().onCollide(gameBall);

		shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
		player.getPlayerPad().draw();
		player2.getPlayerPad().draw();
		gameBall.draw();
		shapeRenderer.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		shapeRenderer.dispose();
		gameBackground.dispose();
	}
}
