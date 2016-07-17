package com.little_rocketeers.littlerocket;

/**
 * Created by Melanie on 03.07.2016.
 */

import com.little_rocketeers.game_framework.interfaces.Image;
import com.little_rocketeers.game_framework.interfaces.Music;
import com.little_rocketeers.game_framework.interfaces.Sound;

public class Assets {
    public static Image
            loading,
            background,
            button,
            rocket;
    public static Sound click;
    public static Music themeMusic;

    //private static MediaPlayer mpintro;

    public static void load(GameActivity game) {
        // TODO Auto-generated method stub
        themeMusic = game.getAudio().createMusic("maintheme.mp3");
        themeMusic.setLooping(true);
        themeMusic.setVolume(0.85f);
        //theme.play();
    }
}
