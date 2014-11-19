package com.fosterb.platformer;

import com.badlogic.gdx.Game;
import com.fosterb.platformer.view.GameScreen;

public class Platformer extends Game {
    //taking map and setting it on the screen
    @Override
    public void create() {
        setScreen(new GameScreen());
    }
}
