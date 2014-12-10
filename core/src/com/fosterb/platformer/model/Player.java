package com.fosterb.platformer.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class Player {
    //sets the position and spritesheet variables
    public Vector2 position;
    public Animation animation;
    public SpriteSheet spriteSheet;
    private float stateTime;

    public int width;
    public int height;

    public Player() {
        //sets the position of the player
        position = new Vector2(9, 3);
        width = 70;
        height = 100;

        spriteSheet = new SpriteSheet("img/aliens.png", width, height);
        //creates animation
        animation = spriteSheet.createAnimation();

        stateTime = 0f;
    }
    public void draw(Batch spriteBatch){
        //connects to the spriteSheet and displayed the player
        spriteBatch.draw(animation.getKeyFrame(stateTime, true), position.x, position.y, width * (1/70f), height * (1/70f));

    }
    public void update(float deltaTime){
        stateTime += deltaTime;
        //moves player in the up direction
        position.y += deltaTime;
    }
}
