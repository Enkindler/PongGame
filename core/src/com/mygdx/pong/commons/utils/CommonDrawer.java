package com.mygdx.pong.commons.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.pong.PongGameController;

public class CommonDrawer {

	public static void drawUI(SpriteBatch spriteBatch, PongGameController pongGameController) {
		spriteBatch.begin();
		spriteBatch.draw(pongGameController.getGameWorld().getWorldBackground(), 0,0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

		pongGameController.getGameFont().draw(spriteBatch, "Player One Score: " + pongGameController.getPlayer1().score, 10, PongGameController.SCREEN_HEIGHT - 20);
		pongGameController.getGameFont().draw(spriteBatch, "Player Two Score: " + pongGameController.getPlayer2().score, PongGameController.SCREEN_WIDTH - 200,
				PongGameController.SCREEN_HEIGHT - 20);
		spriteBatch.end();
	}
}
