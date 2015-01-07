package com.fosterb.platformer.model;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class SpriteSheet {
     public Texture spriteSheet;
    public TextureRegion[] spriteFrames;
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
   public Animation createAnimation(int startFrame, int lastFrame, float animationSpeed){
       //finding out the amount of frames
       int counter = (lastFrame + 1) - startFrame;
       //setting texture region for the player
       TextureRegion[] animationFrames = new TextureRegion[counter];
       for(int index = lastFrame; index >= startFrame; index--){
           counter--;
           //specifies which sprites to use for animation
           animationFrames[counter] = spriteFrames[index];

       }

       return new Animation(animationSpeed, animationFrames);
   }
    public Animation flipAnimation(Animation originalAnimation,  boolean flipX, boolean flipY){
        //counts the amount of frames in the animation
        int frameCount = originalAnimation.getKeyFrames().length;
        TextureRegion[] flippedFrames = new TextureRegion[frameCount];
        //flips the animation
        for (int index = 0; index < frameCount; index++){
            flippedFrames[index] = new TextureRegion(originalAnimation.getKeyFrames()[index]);
            flippedFrames[index].flip(flipX, flipY);

        }

        return new Animation(originalAnimation.getAnimationDuration(), flippedFrames);
    }
}
