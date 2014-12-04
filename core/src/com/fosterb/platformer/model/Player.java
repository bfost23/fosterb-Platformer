package com.fosterb.platformer.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class Player {
    //sets the position and spritesheet variables
    public Vector2 position;
    public Texture spritesheet;
    public TextureRegion[] spriteFrames;

    public Player() {
        //sets the position of the player
        position = new Vector2(0, 0);
        //sets texture for the player to be drawn on
        spritesheet = new Texture(Gdx.files.internal("img/aliens.png"));
        //splits spritesheet into seperate players
        TextureRegion[][] spriteSheetFrame = TextureRegion.split(spritesheet, 70, 100);
        int counter = 0;
        //counts the number of players in the spritesheet
        for(int row = 0; row < spriteSheetFrame.length;){
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

    }
    public void draw(Batch spriteBatch){
        //connects to the spriteSheet and displayed the player
        spriteBatch.draw(spriteFrames[0], 0, 0, 70, 100);
    }
    public void update(float deltaTime){

    }
}
