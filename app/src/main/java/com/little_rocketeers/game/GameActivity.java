package com.little_rocketeers.game;

/**
 * Created by Melanie on 03.07.2016.
 */
import com.little_rocketeers.game_framework.Screen;
import com.little_rocketeers.game_framework.implementation.AndroidGameActivity;

public class GameActivity extends AndroidGameActivity {
    @Override
    public Screen getInitScreen() {
        return new LoadingScreen(this);
    }
    @Override
    public void onBackPressed() {
        getCurrentScreen().backButton();
    }

}