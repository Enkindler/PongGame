package com.mygdx.pong.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.pong.PongGame;
import com.mygdx.pong.PongGameController;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = PongGameController.SCREEN_WIDTH;
		config.height = PongGameController.SCREEN_HEIGHT;
		new LwjglApplication(new PongGame(), config);
	}
}
