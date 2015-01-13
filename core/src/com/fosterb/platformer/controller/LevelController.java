package com.fosterb.platformer.controller;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;

public class LevelController {
    public static final float UNIT_SCALE = 1/70f;

    public static TiledMap map;
    public static OrthogonalTiledMapRenderer renderer;
    public static Batch spriteBatch;
    public static World gameWorld;
    private static Box2DDebugRenderer debugRenderer;


    public static void initializeController(){
        //set the map variable to our level we made
        map = new TmxMapLoader().load("map/level01.tmx");
        gameWorld = new World(new Vector2(0, -9.8f), true);
        renderer = new OrthogonalTiledMapRenderer(map, UNIT_SCALE);
        debugRenderer = new Box2DDebugRenderer();
        spriteBatch = renderer.getSpriteBatch();

    }

    public static void draw(){
        spriteBatch.begin();
        //draws the player
        PlayerController.player.draw(spriteBatch);
        //ends drawing the player
        spriteBatch.end();
        debugRenderer.render(gameWorld, CameraController.camera.combined);
    }
    public static void update(float deltaTime){
        //updates camera when there is movement
        renderer.setView(CameraController.camera);
        //renders the map
        renderer.render();
    }
}
