package com.fosterb.platformer.controller;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.fosterb.platformer.model.Bodies;
import com.fosterb.platformer.model.CollisionListener;
import com.fosterb.platformer.model.Level;
import com.fosterb.platformer.model.Player;
import com.fosterb.platformer.model.Sprite;

import javafx.scene.Camera;

public class LevelController {
    public static final float UNIT_SCALE = 1 / 70f;

    public static Level level;
    public static OrthogonalTiledMapRenderer renderer;
    public static Batch spriteBatch;
    public static World gameWorld;
    public static Array<Body> worldBodies;
    private static Box2DDebugRenderer debugRenderer;


    public static void initializeController() {

        level = new Level("map/level01.tmx");
        gameWorld = new World(new Vector2(0, -10), true);
        gameWorld.setContactListener(new CollisionListener());
        //initialized new array
        worldBodies = new Array<Body>();
        renderer = new OrthogonalTiledMapRenderer(level.map, UNIT_SCALE);
        debugRenderer = new Box2DDebugRenderer();
        spriteBatch = renderer.getSpriteBatch();
        createLevelBodies();

    }

    public static void draw() {
        spriteBatch.setProjectionMatrix(CameraController.camera.combined);
        spriteBatch.begin();
        //draws the player
        PlayerController.draw(spriteBatch);
        //ends drawing the player
        spriteBatch.end();

        spriteBatch.setProjectionMatrix(CameraController.inputCamera.combined);
        InputController.draw(spriteBatch);

        debugRenderer.render(gameWorld, CameraController.camera.combined);
    }

    public static void update(float deltaTime) {
        //updates camera when there is movement
        renderer.setView(CameraController.camera);
        //renders the map
        renderer.render();
        PlayerController.update(deltaTime);
        updateWorldBodies();
        //determines velocity and position of objects
        gameWorld.step(1 / 60f, 1, 1);
    }

    private static void updateWorldBodies() {
        //clears the array
        worldBodies.clear();
        //places all bodies into the array
        gameWorld.getBodies(worldBodies);

        for (Body body : worldBodies) {
            Sprite spriteBody = (Player)body.getUserData();

            if (spriteBody != null) {
                spriteBody.position = body.getPosition();
            }
        }
    }
    private static void createLevelBodies(){
        MapObjects mapObjects = level.getLayerObjects(level.getMapLayer("collision"));

        for (MapObject mapObject : mapObjects){
            Bodies.createBody(mapObject);
        }
        MapObjects mapObjects1 = level.getLayerObjects(level.getMapLayer("blocks"));

        for (MapObject mapObject : mapObjects1){
            Bodies.createBody(mapObject);
        }
    }
}
