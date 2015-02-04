package com.fosterb.platformer.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class CameraController {

    public static OrthographicCamera camera;
    public static OrthographicCamera inputCamera;

    public static float widthScale;
    public static float heightScale;

    public static void initializeController(){
        //storing height and width of window into variables
        float width = Gdx.graphics.getWidth();
        float height = Gdx.graphics.getHeight();
        //set the size of map
        camera = new OrthographicCamera(14f, 14f * (height / width));
        inputCamera = new OrthographicCamera(14f, 14f * (height / width));
        inputCamera.position.set(inputCamera.viewportWidth / 2f, inputCamera.viewportHeight / 2f, 0);
        inputCamera.update();
    }

    public static void update()
    {
        camera.position.set(PlayerController.player.position.x, PlayerController.player.position.y, 0);
        camera.update();
    }
    public static void resize(int width, int height){
        //updates the camera height and width
        camera.viewportWidth = 14f;
        camera.viewportHeight = 14f * height / width;
        camera.update();

        inputCamera.viewportWidth = 14f;
        inputCamera.viewportHeight = 14f * height / width;
        inputCamera.position.set(inputCamera.viewportWidth / 2f, inputCamera.viewportHeight / 2f, 0);
        inputCamera.update();

        widthScale = width / inputCamera.viewportWidth * LevelController.UNIT_SCALE;
        heightScale = height / inputCamera.viewportHeight * LevelController.UNIT_SCALE;
    }

}
