package com.little_rocketeers.game;

/**
 * Created by Melanie on 03.07.2016.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.content.res.Configuration;
import android.util.Log;

import com.little_rocketeers.game_framework.Screen;
import com.little_rocketeers.game_framework.implementation.AndroidGameActivity;

public class GameActivity extends AndroidGameActivity {

    boolean firstTimeCreate = true;

    @Override
    public Screen getInitScreen() {

        if(firstTimeCreate) {
            Assets.load(this);
            firstTimeCreate = false;
        }

        return new InitLoadingScreen(this);
    }

    @Override
    public void onBackPressed() {
        getCurrentScreen().backButton();
    }

    @Override
    public void onResume() {
        super.onResume();
        //Assets.themeMusic.play();
    }

    @Override
    public void onPause() {
        super.onPause();
        //Assets.themeMusic.pause();
    }
}