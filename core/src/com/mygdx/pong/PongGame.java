package com.mygdx.pong;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.pong.commons.balls.Ball;
import com.mygdx.pong.commons.utils.CommonDrawer;
import com.mygdx.pong.commons.utils.CommonFactory;

//TODO: In the future, remove global rules, instead use some sort of map class to have different levels with different rules.

public class PongGame extends ApplicationAdapter {
	SpriteBatch batch;
	ShapeRenderer shapeRenderer;
	Ball gameBall;

	PongGameController pongGameController;

	BitmapFont font;

	@Override
	public void create () {

		this.resize(PongGameController.SCREEN_WIDTH, PongGameController.SCREEN_HEIGHT);
		batch = new SpriteBatch();
		shapeRenderer = CommonFactory.getCommonShapeRenderer();
		font = new BitmapFont();

		//TODO: Improve playerController to avoid instantiating, maybe some sort of dependency injection?
		//TODO: Also improve creation of the pad.
		pongGameController = CommonFactory.getPongGameControllerInstance();

		gameBall = pongGameController.getBall();

	}

	@Override
	public void render () {
		CommonDrawer.drawUI(batch, pongGameController);

		pongGameController.getPlayer1().getController().movePlayer(pongGameController.getPlayer1().getPlayerPad());
		pongGameController.getPlayer2().getController().movePlayer(pongGameController.getPlayer2().getPlayerPad());
		gameBall.move();

		pongGameController.getPlayer1().getPlayerPad().onCollide(gameBall);
		pongGameController.getPlayer2().getPlayerPad().onCollide(gameBall);

		shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
		pongGameController.getPlayer1().getPlayerPad().draw();
		pongGameController.getPlayer2().getPlayerPad().draw();
		gameBall.draw();
		shapeRenderer.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		shapeRenderer.dispose();
		pongGameController.disponse();
	}
}
