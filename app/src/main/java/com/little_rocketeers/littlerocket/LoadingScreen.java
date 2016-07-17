package com.little_rocketeers.littlerocket;

/**
 * Created by Melanie on 03.07.2016.
 */
import android.content.Context;

import com.little_rocketeers.game_framework.interfaces.Game;
import com.little_rocketeers.game_framework.interfaces.Graphics;
import com.little_rocketeers.game_framework.interfaces.Graphics.ImageFormat;
import com.little_rocketeers.game_framework.interfaces.Screen;

public class LoadingScreen extends Screen {

    private Context context;

    public LoadingScreen(Game game, Context context) {
        super(game);
        this.context = context;
    }


    @Override
    public void update(float deltaTime) {
        Graphics g = game.getGraphics();

        Assets.background = g.newImage("background_800x1280.png", ImageFormat.RGB565);
        Assets.button = g.newImage("button_430x165.png", ImageFormat.ARGB4444);

        Assets.rocket = g.newImage("rocket.png", ImageFormat.ARGB4444);

        game.setScreen(new GameScreen(game, context));
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
