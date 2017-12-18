package com.mygdx.pong.commons.balls;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Circle;
import com.mygdx.pong.commons.interfaces.Drawable;
import com.mygdx.pong.commons.interfaces.Movable;

public class Ball implements Drawable, Movable {

	private ShapeRenderer shapeRenderer;
	protected int radius = 5;

	protected float posX;
	protected float posY;
	protected int directionX;
	protected int directionY;
	protected int speed = 150;
	protected Circle ballCollider;

	public Ball(ShapeRenderer shapeRenderer) {
		this.shapeRenderer = shapeRenderer;
		this.directionX = -1;
		this.directionY = -1;
		this.posX = 600;
		this.posY = 600;
		ballCollider = new Circle(posX, posY, radius);
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
	}

	protected float getPosXModifier() {
		return (speed * Gdx.graphics.getDeltaTime() * directionX);
	}

	protected float getPosYModifier() {
		return (speed * Gdx.graphics.getDeltaTime() * directionY);
	}
}
