package com.mygdx.pong.commons.input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.mygdx.pong.commons.playable.Pad;

public class PlayerController {

	public static void movePlayer(Pad pad) {
		if(Gdx.input.isKeyPressed(Input.Keys.A)) {
			moveLeft(pad);
		}

		if(Gdx.input.isKeyPressed(Input.Keys.D)) {
			System.out.println("MoveRight ");
			moveRight(pad);
		}
	}

	public static void moveRight(Pad pad) {
		//FIXME: posX should be Integer not Double!
		//TODO: There is a weird issue with this operation whe using posX as an integer
		pad.posX += 5 * pad.padSpeed * Gdx.graphics.getDeltaTime();

		if (pad.posX >= Gdx.graphics.getWidth() - pad.padWidth - 10) {
			pad.posX = Gdx.graphics.getWidth() - pad.padWidth - 10;
		}
	}

	public static void moveLeft(Pad pad) {
		pad.posX -= 5 * pad.padSpeed * Gdx.graphics.getDeltaTime();

		if(pad.posX <= 10) {
			pad.posX = 10;
		}
	}


}
