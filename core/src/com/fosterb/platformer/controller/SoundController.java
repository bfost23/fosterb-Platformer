package com.fosterb.platformer.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;

public class SoundController {
    public static Music music;

    public static void initializeSoundController(){
        music = Gdx.audio.newMusic(Gdx.files.internal("sound/madonna.mp3"));
    }

    public static void play(String soundName){
        if (soundName.equalsIgnoreCase("music")){
            music.play();
            music.setLooping(true);
        }
    }
}
