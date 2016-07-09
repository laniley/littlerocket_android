package com.little_rocketeers.game;

/**
 * Created by Melanie on 03.07.2016.
 */
import android.content.Context;
import android.content.res.Configuration;

import com.little_rocketeers.game_framework.Game;
import com.little_rocketeers.game_framework.Graphics;
import com.little_rocketeers.game_framework.Graphics.ImageFormat;
import com.little_rocketeers.game_framework.Screen;

public class LoadingScreen extends Screen {


    public LoadingScreen(Game game) {
        super(game);
    }


    @Override
    public void update(float deltaTime) {
        Graphics g = game.getGraphics();

        Assets.start_menu = g.newImage("start_menu_800x1280.png", ImageFormat.ARGB8888);
        Assets.background = g.newImage("background_800x1280.png", ImageFormat.RGB565);
        Assets.button = g.newImage("button_430x165.png", ImageFormat.ARGB4444);

        Assets.rocket = g.newImage("rocket_50x140.png", ImageFormat.ARGB4444);

        game.setScreen(new MainMenuScreen(game));
    }


    @Override
    public void paint(float deltaTime) {

        Graphics g = game.getGraphics();
        g.drawImage(Assets.loading, 0, 0);

    }


    @Override
    public void pause() {


    }


    @Override
    public void resume() {

    }


    @Override
    public void dispose() {


    }


    @Override
    public void backButton() {


    }
}
