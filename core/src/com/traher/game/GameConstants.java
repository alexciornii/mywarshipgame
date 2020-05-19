package com.traher.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

public class GameConstants {

    public static final int SCREEN_WIDTH = Gdx.graphics.getWidth();
    public static final int SCREEN_HEIGHT = Gdx.graphics.getHeight();
    public static final int GAME_WORLD_WIDTH = 800;
    public static final int GAME_WORLD_HEIGHT = 600;
    public static final Skin SKIN = new Skin(Gdx.files.internal("skin/glassy-ui.json"));

    public static final Map<String, Texture> LETTERS_MAP= new HashMap<>();
    static {
        final String[] letters = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
        final String imagePathPattern = "images/letters/{0}.png";
        for (String letter : letters) {
            LETTERS_MAP.put(letter, new Texture(Gdx.files.internal(MessageFormat.format(imagePathPattern, letter))));
        }
    }

    public static final Map<String, Texture> NUMBERS_MAP= new HashMap<>();

    static {
        final String[] numbers = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        final String numbersPathPattern = "images/numbers/{0}.png";
        for (String number : numbers) {
            NUMBERS_MAP.put(number, new Texture(Gdx.files.internal(MessageFormat.format(numbersPathPattern, number))));
        }
    }

}
