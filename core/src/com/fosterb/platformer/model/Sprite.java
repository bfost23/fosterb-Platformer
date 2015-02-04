package com.fosterb.platformer.model;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.fosterb.platformer.controller.LevelController;

import java.util.HashMap;

public class Sprite {
    //sets the position and spritesheet variables
    public Body physicsBody;
    public Vector2 position;
    public String currentAnimation;
    public String direction;

    public SpriteSheet spriteSheet;
    private float stateTime;
    public float width;
    public float height;
    protected HashMap<String, Animation> playerAnimations;

    public Sprite(Vector2 position, int width, int height, String sheetPath){
        //sets the position of the player
        this.position = position;
        spriteSheet = new SpriteSheet(sheetPath, width, height);
        this.width = width * LevelController.UNIT_SCALE;
        this.height = height * LevelController.UNIT_SCALE;
        playerAnimations = new HashMap<String, Animation>();

        stateTime = 0f;
        direction = "right";
    }

    public void draw(Batch spriteBatch){
        //connects to the spriteSheet and displayed the player

        spriteBatch.draw(playerAnimations.get(currentAnimation).getKeyFrame(stateTime, true), position.x, position.y, width, height);
    }
    public void update(float deltaTime){
        stateTime += deltaTime;
    }
}
