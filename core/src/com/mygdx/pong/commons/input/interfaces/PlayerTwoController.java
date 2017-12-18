package com.mygdx.pong.commons.input.interfaces;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.mygdx.pong.commons.playable.Pad;

/**
 * Created by walter popovich on 12/17/2017.
 */

public class PlayerTwoController implements PlayerController {


    @Override
    public void movePlayer(Pad pad) {
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            moveLeft(pad);
        }

        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            moveRight(pad);
        }
    }
}
