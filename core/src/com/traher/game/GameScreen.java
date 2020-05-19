package com.traher.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import static com.traher.game.GameConstants.SCREEN_HEIGHT;
import static com.traher.game.GameConstants.SCREEN_WIDTH;

public class GameScreen implements Screen {

    private final MyWarshipGame game;
    private final ShapeRenderer shapeRenderer;
    private OrthographicCamera camera;
    private SpriteBatch batch;

    GameScreen(MyWarshipGame game) {
        this.game = game;
        this.shapeRenderer = new ShapeRenderer();
        this.batch = new SpriteBatch();
        this.camera = new OrthographicCamera();
        camera.setToOrtho(false, SCREEN_WIDTH, SCREEN_HEIGHT);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 1.0F, 1.0F, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();

        game.batch.setProjectionMatrix(camera.combined);
        game.batch.begin();
        final int startWidth = 370;
        final int startHeight = SCREEN_HEIGHT - 10;

        game.batch.end();

//        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
//        shapeRenderer.setColor(Color.BLACK);
//        shapeRenderer.rect(SCREEN_WIDTH * .03F, SCREEN_HEIGHT * .05F, SCREEN_WIDTH * .45F, SCREEN_HEIGHT * .9F);
//        shapeRenderer.rect(SCREEN_WIDTH / 2 + SCREEN_WIDTH * .03F, SCREEN_HEIGHT * .05F, SCREEN_WIDTH * .45F, SCREEN_HEIGHT * .9F);
//        shapeRenderer.end();
//
//        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
//        shapeRenderer.setColor(Color.WHITE);
//        shapeRenderer.rect(30, 70, 300, 300);
//        shapeRenderer.end();
//
//        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
//        shapeRenderer.setColor(Color.BLACK);
//
//        for (int i = 0; i <= 10; i++) {
//            shapeRenderer.line(30, startWidth - (30 * i), 330, startWidth - (30 * i));
//            shapeRenderer.line(startHeight + (30 * i), 70, startHeight + (30 * i), 370);
//        }
//        shapeRenderer.end();
    }

    @Override
    public void show() {

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        batch.dispose();
    }

}
