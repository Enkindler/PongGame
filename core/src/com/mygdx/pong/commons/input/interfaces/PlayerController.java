package com.mygdx.pong.commons.input.interfaces;

import com.badlogic.gdx.Gdx;
import com.mygdx.pong.PongGameController;
import com.mygdx.pong.commons.playable.Pad;

public interface PlayerController {

	void movePlayer(Pad pad);

	default void moveRight(Pad pad) {
		float positionModifier = calculatePositionModifier(pad);
		pad.modifyXPosition(positionModifier);

		if(pad.getPadCollider().x >=Gdx.graphics.getWidth() - pad.padWidth - PongGameController.FIELD_HORIZONTAL_BOUNDS) {
			pad.setXPosition(Gdx.graphics.getWidth() - pad.padWidth - PongGameController.FIELD_HORIZONTAL_BOUNDS);
		}
	}

	default void moveLeft(Pad pad) {
		float positionModifier = calculatePositionModifier(pad) * -1;
		pad.modifyXPosition(positionModifier);

		if(pad.getPadCollider().x <= PongGameController.FIELD_HORIZONTAL_BOUNDS) {
			pad.setXPosition(PongGameController.FIELD_HORIZONTAL_BOUNDS);
		}
	}

	default float calculatePositionModifier(Pad pad) {
		float tmpPosX = 5 * pad.padSpeed * Gdx.graphics.getDeltaTime();
		return tmpPosX;
	}


}
