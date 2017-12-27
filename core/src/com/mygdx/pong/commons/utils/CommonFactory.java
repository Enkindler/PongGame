package com.mygdx.pong.commons.utils;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.pong.PongGameController;

public class CommonFactory {

    private static PongGameController pongGameControllerInstance;
    private static ShapeRenderer commonShapeRenderer;

    public static PongGameController getPongGameControllerInstance() {
        if(pongGameControllerInstance == null) {
            pongGameControllerInstance = new PongGameController(getCommonShapeRenderer());
        }
        return pongGameControllerInstance;
    }

    public static ShapeRenderer getCommonShapeRenderer() {
        if(commonShapeRenderer == null) {
            commonShapeRenderer = new ShapeRenderer();
        }
        return commonShapeRenderer;
    }
}
