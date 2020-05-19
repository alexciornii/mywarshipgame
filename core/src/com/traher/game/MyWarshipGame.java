package com.traher.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class MyWarshipGame extends Game {
    
    protected SpriteBatch batch;
    protected BitmapFont font;
    public Viewport screenPort;
    
    @Override
    public void create () {
        batch = new SpriteBatch();
        font = new BitmapFont();
        font.setColor(Color.BLACK);
        screenPort = new ScreenViewport();
        screenPort.apply(true);
//        this.setScreen(new MainMenuScreen(this));
        this.setScreen(new GameScreen(this));
    }

    @Override
    public void render () {
        super.render();
    }
    
    @Override
    public void dispose () {
        super.dispose();
        batch.dispose();
        font.dispose();
    }

}
