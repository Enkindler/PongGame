package com.mygdx.pong.commons.input.interfaces;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.mygdx.pong.commons.PongGameRules;
import com.mygdx.pong.commons.playable.Pad;

public interface PlayerController {

	void movePlayer(Pad pad);

	default void moveRight(Pad pad) {
		//FIXME: posX should be Integer not Double!
		//TODO: There is a weird issue with this operation whe using posX as an integer
		pad.posX += 5 * pad.padSpeed * Gdx.graphics.getDeltaTime();

		if (pad.posX >= Gdx.graphics.getWidth() - pad.padWidth - PongGameRules.FIELD_HORIZONTAL_BOUNDS) {
			pad.posX = Gdx.graphics.getWidth() - pad.padWidth - PongGameRules.FIELD_HORIZONTAL_BOUNDS;
		}
	}

	default void moveLeft(Pad pad) {
		pad.posX -= 5 * pad.padSpeed * Gdx.graphics.getDeltaTime();

		if(pad.posX <= PongGameRules.FIELD_HORIZONTAL_BOUNDS) {
			pad.posX = PongGameRules.FIELD_HORIZONTAL_BOUNDS;
		}
	}


}
