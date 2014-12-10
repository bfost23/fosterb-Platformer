package com.fosterb.platformer.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.fosterb.platformer.model.Player;

public class GameScreen implements Screen{
    //created the variables
    public TiledMap map;
    public OrthogonalTiledMapRenderer renderer;
    public OrthographicCamera camera;
    public Batch spriteBatch;
    public Player player;


    public GameScreen() {
        //set the map variable to our level we made
        map = new TmxMapLoader().load("map/level01.tmx");
        renderer = new OrthogonalTiledMapRenderer(map, 1/70f);
        //storing height and width of window into variables
        float width = Gdx.graphics.getWidth();
        float height = Gdx.graphics.getHeight();
        //set the size of map
        camera = new OrthographicCamera(14f, 14f * (height / width));
        //set the position of the camera
        camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0f);

        spriteBatch = renderer.getSpriteBatch();
        player = new Player();
    }

    @Override
    public void render(float delta) {
        //set color that will clear screen
        Gdx.gl.glClearColor(0.76f, 0.88f, 0.93f, 1f);
        //clears game screen with the color that was set
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();
        //updates camera when there is movement
        renderer.setView(camera);
        //renders the map
        renderer.render();
        //begins drawing the player
        player.update(delta);
        spriteBatch.begin();
        //draws the player
        player.draw(spriteBatch);
        //ends drawing the player
        spriteBatch.end();

    }

    @Override
    public void resize(int width, int height) {
        //updates the camera height and width
        camera.viewportWidth = 14f;
        camera.viewportHeight = 14f * height / width;
        camera.update();
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
