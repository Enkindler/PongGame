package com.mygdx.pong;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.pong.commons.balls.Ball;
import com.mygdx.pong.commons.input.PlayerOneController;
import com.mygdx.pong.commons.input.interfaces.PlayerTwoController;
import com.mygdx.pong.commons.playable.player.Player;

public class PongGameController {

	public static final int SCREEN_WIDTH = 800;
	public static final int SCREEN_HEIGHT = 600;
	public static final int FIELD_HORIZONTAL_BOUNDS = 0;
	public static final int FIELD_VERTICAL_BOUNDS = 100;

	public static final int PLAYER_ONE_STARTING_HORIZONTAL = SCREEN_WIDTH / 2;
	public static final int PLAYER_ONE_STARTING_VERTICAL = SCREEN_HEIGHT - FIELD_VERTICAL_BOUNDS;

	private Player player1;
	private Player player2;
	private Ball ball;

	public PongGameController(ShapeRenderer shapeRenderer) {
		player1 = new Player(new PlayerOneController(), shapeRenderer, PongGameController.SCREEN_WIDTH / 2, PongGameController.FIELD_VERTICAL_BOUNDS);
		player2 = new Player(new PlayerTwoController(), shapeRenderer, PongGameController.SCREEN_WIDTH / 2, PongGameController.SCREEN_HEIGHT - PongGameController.FIELD_VERTICAL_BOUNDS);
		ball = new Ball(shapeRenderer);
		setBallInitParameters();
	}

	public Player getPlayer1() {
		return player1;
	}

	public Player getPlayer2() {
		return player2;
	}

	public Ball getBall() {
		return ball;
	}

	public void score(boolean playerOneScore) {
		if(playerOneScore) {
			getPlayer1().score++;
		}
		else {
			getPlayer2().score++;
		}
	}

	public void resetGame() {
		setBallInitParameters();
	}

	public void setBallInitParameters() {
		ball.directionX = -1;
		ball.directionY = -1;
		ball.getBallCollider().x = PongGameController.SCREEN_WIDTH / 2;
		ball.getBallCollider().y = PongGameController.SCREEN_HEIGHT / 2;
	}
}
