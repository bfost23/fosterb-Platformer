package com.fosterb.platformer.model;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class SpriteSheet {
    public Texture spriteSheet;
    public TextureRegion[] spriteFrames;
    public Animation animation;
    public SpriteSheet(String pathtofile, int width, int height) {
        //sets texture for the player to be drawn on
        spriteSheet = new Texture(Gdx.files.internal(pathtofile));
        //splits spritesheet into seperate players
        TextureRegion[][] spriteSheetFrame = TextureRegion.split(spriteSheet, width, height);
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

    }
   public Animation createAnimation(){
       //setting texture region for the player
       TextureRegion[] animationFrames = new TextureRegion[2];
       //specifies which sprites to use for animation
       animationFrames[0] = spriteFrames[12];
       animationFrames[1] = spriteFrames[13];
       animation = new Animation(.07f, animationFrames);
       return animation;
   }
}
