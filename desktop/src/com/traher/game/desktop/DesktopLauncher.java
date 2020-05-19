package com.traher.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.traher.game.MyWarshipGame;

public class DesktopLauncher {
    public static void main (String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.title = "War Ship Game";
//        config.width = 800;
//        config.height = 600;
        new LwjglApplication(new MyWarshipGame(), config);
    }

}
