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

public class InitLoadingScreen extends Screen {

    Context context;

    public InitLoadingScreen(Game game, Context context) {
        super(game);
        this.context = context;
    }

    @Override
    public void update(float deltaTime) {
        Graphics g = game.getGraphics();

        Assets.loadingLandscape = g.newImage("loading_1280x800.png", ImageFormat.RGB565);
        Assets.loadingPortrait = g.newImage("loading_800x1280.png", ImageFormat.RGB565);

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

    private boolean isPortrait() {
        return this.context.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT;
    }
}
