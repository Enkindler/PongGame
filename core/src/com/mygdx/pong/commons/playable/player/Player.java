package com.mygdx.pong.commons.playable.player;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.pong.commons.input.interfaces.PlayerController;
import com.mygdx.pong.commons.playable.Pad;
import com.mygdx.pong.commons.playable.PlayerPad;

/**
 * Created by walter popovich on 12/17/2017.
 */

public class Player {

    private final PlayerController controller;
    private final Pad playerPad;
    //TODO: Should be private I think
    public int score;

    public Player(PlayerController playerController, Pad playerPad) {
        this.controller = playerController;
        this.playerPad = playerPad;
        this.score = 0;
    }

    public Player(PlayerController playerController, ShapeRenderer shapeRenderer) {
        this.controller = playerController;
        this.playerPad = new PlayerPad(shapeRenderer, 10, 10);
        this.score = 0;
    }

    public Player(PlayerController playerController, ShapeRenderer shapeRenderer, int posX, int posY) {
        this.controller = playerController;
        this.playerPad = new PlayerPad(shapeRenderer, posX, posY);
        this.score = 0;
    }


    public PlayerController getController() {
        return controller;
    }

    public Pad getPlayerPad() {
        return playerPad;
    }
}
