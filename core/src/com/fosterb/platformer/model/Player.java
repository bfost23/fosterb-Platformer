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
    public Texture spriteSheet;
    public TextureRegion[] spriteFrames;

    public Animation animation;
    private float stateTime;

    public Player() {
        //sets the position of the player
        position = new Vector2(9, 3);
        //sets texture for the player to be drawn on
        spriteSheet = new Texture(Gdx.files.internal("img/aliens.png"));
        //splits spritesheet into seperate players
        TextureRegion[][] spriteSheetFrame = TextureRegion.split(spriteSheet, 70, 100);
        int counter = 0;
        //counts the number of players in the spritesheet
        for(int row = 0; row < spriteSheetFrame.length; row++){
          for(int column = 0; column < spriteSheetFrame[row].length; column++){
            counter++;
          }
        }
        //creating space for our sprites
        spriteFrames = new TextureRegion[counter];

        counter = 0;
        for(TextureRegion[] row : spriteSheetFrame){
           for (TextureRegion sprite : row){
               //puts each sprite into spriteFrames
               spriteFrames[counter++] = sprite;
           }
        }
        //setting texture region for the player
        TextureRegion[] animationFrames = new TextureRegion[2];
        //specifies which sprites to use for animation
        animationFrames[0] = spriteFrames[12];
        animationFrames[1] = spriteFrames[13];
        animation = new Animation(.07f, animationFrames);

        stateTime = 0f;
    }
    public void draw(Batch spriteBatch){
        //connects to the spriteSheet and displayed the player
        spriteBatch.draw(animation.getKeyFrame(stateTime, true), position.x, position.y, 70 * (1/70f), 100 * (1/70f));

    }
    public void update(float deltaTime){
        stateTime += deltaTime;
        //moves player in the up direction
        position.y += deltaTime;
    }
}
