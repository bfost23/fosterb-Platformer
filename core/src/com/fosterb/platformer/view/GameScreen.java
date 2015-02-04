package com.fosterb.platformer.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.fosterb.platformer.controller.CameraController;
import com.fosterb.platformer.controller.InputController;
import com.fosterb.platformer.controller.LevelController;
import com.fosterb.platformer.controller.PlayerController;

public class GameScreen implements Screen{

    public GameScreen() {
        LevelController.initializeController();
        CameraController.initializeController();
        PlayerController.initializeController();
        InputController.initializeController();

    }

    @Override
    public void render(float delta) {
        //set color that will clear screen
        Gdx.gl.glClearColor(0.76f, 0.88f, 0.93f, 1f);
        //clears game screen with the color that was set
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        CameraController.update();
         LevelController.update(delta);
        PlayerController.update(delta);

        LevelController.draw();
    }

    @Override
    public void resize(int width, int height) {
        CameraController.resize(width, height);
    }

    @Override
    public void show() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
}
