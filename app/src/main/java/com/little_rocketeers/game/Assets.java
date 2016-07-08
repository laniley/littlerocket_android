package com.little_rocketeers.game;

/**
 * Created by Melanie on 03.07.2016.
 */
import android.media.MediaPlayer;

import com.little_rocketeers.game_framework.Image;
import com.little_rocketeers.game_framework.Music;
import com.little_rocketeers.game_framework.Sound;

public class Assets {
    public static Image
            loadingPortrait,
            loadingLandscape,
            menuPortrait,
            menuLandscape;
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
