package com.fosterb.platformer.controller;

import com.fosterb.platformer.model.Player;

public class PlayerController {

    public static Player player;

    public static void initializeController(){
        player = new Player(70, 100);
    }

    public static void update(float deltaTime){
        //begins drawing the player
        player.update(deltaTime);
    }
}
