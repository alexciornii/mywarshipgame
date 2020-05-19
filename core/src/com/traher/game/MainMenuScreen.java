package com.traher.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import static com.traher.game.GameConstants.GAME_WORLD_HEIGHT;
import static com.traher.game.GameConstants.GAME_WORLD_WIDTH;
import static com.traher.game.GameConstants.SCREEN_HEIGHT;
import static com.traher.game.GameConstants.SCREEN_WIDTH;
import static com.traher.game.GameConstants.SKIN;

public class MainMenuScreen implements Screen {

    private static final float BUTTON_SIZE = .25F;
    private static final float BUTTON_WIDTH = SCREEN_WIDTH * BUTTON_SIZE;
    private static final float BUTTON_HEIGHT = SCREEN_HEIGHT * BUTTON_SIZE;
    private static final String[] BUTTONS = {"Start", "About", "Settings"};

    private final OrthographicCamera camera;
    private final MyWarshipGame game;
    private final Table table;
    private final Stage stage;

    public MainMenuScreen(MyWarshipGame game) {
        this.game = game;
        this.camera = new OrthographicCamera();
        this.table = new Table();

        table.setWidth(GAME_WORLD_WIDTH);
        table.setHeight(GAME_WORLD_HEIGHT);
        table.align(Align.center);

        float aspectRatio = (float) SCREEN_HEIGHT / (float) SCREEN_WIDTH;
        camera.setToOrtho(false, game.screenPort.getScreenWidth(), game.screenPort.getScreenWidth());
        camera.position.set(GAME_WORLD_WIDTH / 2, GAME_WORLD_HEIGHT / 2, 0);
        Viewport viewport = new FitViewport(GAME_WORLD_WIDTH * aspectRatio, GAME_WORLD_HEIGHT, camera);

        for (String buttonName : BUTTONS) {
            Button button = new TextButton(buttonName, SKIN,"small");
            button.setSize(BUTTON_WIDTH, BUTTON_HEIGHT);
            table.add(button);
            button.addListener(new InputListener(){
                @Override
                public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                    game.setScreen(new GameScreen(game));
                    dispose();
                    return true;
                }
            });
            table.row();
        }

        stage = new Stage(viewport);
        Gdx.input.setInputProcessor(stage);
        stage.addActor(table);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 1.0F, 1.0F, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();

        game.batch.setProjectionMatrix(camera.combined);
        game.batch.begin();
        stage.act();
        stage.draw();
        game.batch.end();
    }

    @Override
    public void show() {

    }

    @Override
    public void resize(int width, int height) {
        game.screenPort.update(width, height);
        camera.position.set(GAME_WORLD_WIDTH / 2, GAME_WORLD_HEIGHT / 2, 0);
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
        stage.dispose();
    }

}
