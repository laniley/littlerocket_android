package com.little_rocketeers.littlerocket;

/**
 * Created by Melanie on 03.07.2016.
 */

import android.content.Intent;

import com.facebook.AccessToken;
import com.little_rocketeers.game_framework.interfaces.Screen;
import com.little_rocketeers.game_framework.implementation.AndroidGameActivity;

public class GameActivity extends AndroidGameActivity {

    AccessToken accessToken;
    boolean firstTimeCreate = true;

    @Override
    public Screen getInitScreen() {

        accessToken = AccessToken.getCurrentAccessToken();
        System.out.println("accessToken: " + accessToken);

        if(accessToken == null) {
            Intent myIntent = new Intent(this, LoginActivity.class);
            //myIntent.putExtra("key", value); //Optional parameters
            this.startActivity(myIntent);
        }

        if(firstTimeCreate) {
            Assets.load(this);
            firstTimeCreate = false;
        }

        return new InitLoadingScreen(this, getApplicationContext());
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

    @Override
    public void onBackPressed() {
        getCurrentScreen().backButton();
    }
}