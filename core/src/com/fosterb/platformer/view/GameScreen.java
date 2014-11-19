package com.fosterb.platformer.view;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

public class GameScreen implements Screen{
    //created the variables
    public TiledMap map;
    public OrthogonalTiledMapRenderer renderer;
    public OrthographicCamera camera;


    public GameScreen() {
        //set the map variable to our level we made
        map = new TmxMapLoader().load("map/level01.tmx");
        renderer = new OrthogonalTiledMapRenderer(map, 1/70f);
        //set the size of map
        camera = new OrthographicCamera(14f, 14f);
        //set the position of the camera
        camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0f);
    }

    @Override
    public void render(float delta) {
        camera.update();
        //updates camera when there is movement
        renderer.setView(camera);
        //renders the map
        renderer.render();

    }

    @Override
    public void resize(int width, int height) {

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
