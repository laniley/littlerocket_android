package com.little_rocketeers.littlerocket;

/**
 * Created by Melanie on 03.07.2016.
 */

import com.little_rocketeers.game_framework.interfaces.Screen;
import com.little_rocketeers.game_framework.implementation.AndroidGameActivity;

public class GameActivity extends AndroidGameActivity {

    boolean firstTimeCreate = true;

    @Override
    public Screen getInitScreen() {

        if(firstTimeCreate) {
            Assets.load(this);
            firstTimeCreate = false;
        }

        return new InitLoadingScreen(this, getApplicationContext());
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