package com.mygdx.pong.commons.playable;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
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



	public Pad(ShapeRenderer shapeRenderer) {
		this.shapeRenderer = shapeRenderer;
	}

	public Pad(ShapeRenderer shapeRenderer, int posX, int posY){
		this.shapeRenderer = shapeRenderer;
		this.posX = posX;
		this.posY = posY;
	}

	@Override
	public void draw() {
		shapeRenderer.box(new Double(posX).intValue(),posY,0, padWidth,padHeight,0);
	}
}
