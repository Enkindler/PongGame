package com.mygdx.pong.commons.balls;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Circle;
import com.mygdx.pong.PongGame;
import com.mygdx.pong.PongGameController;
import com.mygdx.pong.commons.interfaces.Drawable;
import com.mygdx.pong.commons.interfaces.Movable;
import com.mygdx.pong.commons.utils.CommonFactory;

public class Ball implements Drawable, Movable {

	private ShapeRenderer shapeRenderer;
	protected int radius = 5;

	//TODO: THis SHOULDN'T BE PUBLIC FFS
	public int directionX;
	public int directionY;
	protected int speed = 150;
	protected Circle ballCollider;

	public Ball(ShapeRenderer shapeRenderer) {
		this.shapeRenderer = shapeRenderer;
		ballCollider = new Circle(10, 10, radius);
	}


	@Override
	public void draw() {
		shapeRenderer.circle(ballCollider.x, ballCollider.y, ballCollider.radius);
	}

	@Override
	//TODO: There should be a better way to do this. Right now there could be chance for the ball to get stuck somewhere.
	//TODO: Maybe a directional speed should be considered too, instead of a global ball speed or something of the sort.
	public void move() {
		this.ballCollider.x = this.ballCollider.x + this.getPosXModifier();
		this.ballCollider.y = this.ballCollider.y + this.getPosYModifier();

		if(this.ballCollider.x <= 0) {
			this.ballCollider.x = 0;
			this.directionX *= -1;
		}

		if(this.ballCollider.x >= PongGameController.SCREEN_WIDTH) {
			this.ballCollider.x = PongGameController.SCREEN_WIDTH;
			this.directionX *= -1;
		}

		if(this.ballCollider.y < 0 || this.ballCollider.y > PongGameController.SCREEN_HEIGHT) {
			//TODO: Improve this! Its pretty ugly!
//			PongGame.get.score(this.ballCollider.y < 0);
			CommonFactory.getPongGameControllerInstance().score(this.ballCollider.y < 0);
			CommonFactory.getPongGameControllerInstance().resetGame();
		}
	}

	protected float getPosXModifier() {
		return (speed * Gdx.graphics.getDeltaTime() * directionX);
	}

	protected float getPosYModifier() {
		return (speed * Gdx.graphics.getDeltaTime() * directionY);
	}

	public Circle getBallCollider() {
		return this.ballCollider;
	}
}
