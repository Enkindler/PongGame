package com.mygdx.pong.commons.input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.mygdx.pong.commons.input.interfaces.PlayerController;
import com.mygdx.pong.commons.playable.Pad;

import java.security.Key;

/**
 * Created by walter popovich on 12/17/2017.
 */

public class PlayerOneController implements PlayerController {


    @Override
    public void movePlayer(Pad pad) {
        if(Gdx.input.isKeyPressed(Input.Keys.A)) {
            moveLeft(pad);
        }

        if(Gdx.input.isKeyPressed(Input.Keys.D)) {
            moveRight(pad);
        }
    }
}
