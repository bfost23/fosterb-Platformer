package com.fosterb.platformer.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class CameraController {

    public static OrthographicCamera camera;
    public static void initializeController(){
        //storing height and width of window into variables
        float width = Gdx.graphics.getWidth();
        float height = Gdx.graphics.getHeight();
        //set the size of map
        camera = new OrthographicCamera(14f, 14f * (height / width));
        //set the position of the camera
        camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0f);

    }

    public static void update(){
        camera.update();
    }
    public static void resize(int width, int height){
        //updates the camera height and width
        camera.viewportWidth = 14f;
        camera.viewportHeight = 14f * height / width;
        camera.update();
    }

}
