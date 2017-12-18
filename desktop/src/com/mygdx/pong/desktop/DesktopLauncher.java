package com.mygdx.pong.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.pong.PongGame;
import com.mygdx.pong.commons.PongGameRules;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = PongGameRules.SCREEN_WIDTH;
		config.height = PongGameRules.SCREEN_HEIGHT;
		new LwjglApplication(new PongGame(), config);
	}
}
