package com.little_rocketeers.littlerocket;

/**
 * Created by Melanie on 03.07.2016.
 */
import android.content.Context;

import com.little_rocketeers.game_framework.interfaces.Game;
import com.little_rocketeers.game_framework.interfaces.Graphics;
import com.little_rocketeers.game_framework.interfaces.Graphics.ImageFormat;
import com.little_rocketeers.game_framework.interfaces.Screen;

public class InitLoadingScreen extends Screen {

    public InitLoadingScreen(Game game, Context context) {
        super(game, context);
    }

    @Override
    public void update(float deltaTime) {
        Graphics g = game.getGraphics();
        Assets.loading = g.newImage("loading_800x1280.png", ImageFormat.RGB565);

        game.setScreen(new LoadingScreen(game, context));
    }

    @Override
    public void paint(float deltaTime) {

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
