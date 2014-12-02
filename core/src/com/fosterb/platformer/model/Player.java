package com.fosterb.platformer.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class Player {
    //sets the position and spritesheet variables
    public Vector2 position;
    public Texture spritesheet;

    public Player() {
        //sets the position of the player
        position = new Vector2(0, 0);
        //sets texture for the player to be drawn on
        spritesheet = new Texture(Gdx.files.internal("img/aliens.png"));

    }
}
