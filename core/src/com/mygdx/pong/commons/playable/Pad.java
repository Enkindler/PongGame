package com.mygdx.pong.commons.playable;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.pong.commons.balls.Ball;
import com.mygdx.pong.commons.interfaces.Drawable;

public class Pad implements Drawable {

	private ShapeRenderer shapeRenderer;

	//TODO: Make getters and setters for this
	//TODO: Make this private and use getters!
	//FIXME: THIS VARIABLE SHOULD BE INT NOT DOUBLE!
	public double posX = 10;
	public int posY = 10;

	public int padSpeed = 50;
	public int padWidth = 100;
	public int padHeight = 10;

	protected Rectangle padCollider;



	public Pad(ShapeRenderer shapeRenderer) {
		this.shapeRenderer = shapeRenderer;
	}

	public Pad(ShapeRenderer shapeRenderer, int posX, int posY){
		this.shapeRenderer = shapeRenderer;
		this.posX = posX;
		this.posY = posY;
		this.padCollider = new Rectangle(posX, posY, padWidth, padHeight);
	}

	@Override
	public void draw() {
		shapeRenderer.box(padCollider.x, padCollider.y, 0, padCollider.width, padCollider.height, 0);
//		shapeRenderer.box(new Double(posX).intValue(),posY,0, padWidth,padHeight,0);
	}

	public Rectangle getPadCollider() {
		return padCollider;
	}

	public void modifyXPosition(float xPositionModifier) {
		this.padCollider.x = this.padCollider.x + xPositionModifier;
	}

	public void setXPosition(float newXPosition) {
		this.padCollider.x = newXPosition;
	}

	//TODO: Improve this. Ball should instead be an interface or something that implements a getter to the actual collider
	//TODO: Or something of the sort
	public void onCollide(Ball other) {
		Circle ballCollider = other.getBallCollider();

		if(Intersector.overlaps(ballCollider, this.padCollider)) {
			other.directionY *= -1;
		}

	}
}
