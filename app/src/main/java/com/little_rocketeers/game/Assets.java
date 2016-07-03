package com.little_rocketeers.game;

/**
 * Created by Melanie on 03.07.2016.
 */
import android.media.MediaPlayer;

import com.little_rocketeers.game_framework.Image;
import com.little_rocketeers.game_framework.Music;
import com.little_rocketeers.game_framework.Sound;

public class Assets {
    public static Image menu, initloading;
    public static Sound click;
    public static Music theme;

    //private static MediaPlayer mpintro;

    public static void load(GameActivity game) {
        // TODO Auto-generated method stub
        theme = game.getAudio().createMusic("maintheme.mp3");
        theme.setLooping(true);
        theme.setVolume(0.85f);
        //theme.play();
    }
}
