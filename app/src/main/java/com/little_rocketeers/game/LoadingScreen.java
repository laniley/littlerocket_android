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

    Context context;

    public LoadingScreen(Game game, Context context) {
        super(game);
        this.context = context;
    }


    @Override
    public void update(float deltaTime) {
       // Graphics g = game.getGraphics();
        //Assets.click = game.getAudio().createSound("explode.ogg");

        //if(this.isPortrait()) {
           // Assets.menu = g.newImage("loading_1280x800.png", ImageFormat.RGB565);
        //}
        //else {
           // Assets.menu = g.newImage("loading_800x1280.png", ImageFormat.RGB565);
        //}

       // game.setScreen(new MainMenuScreen(game));
    }


    @Override
    public void paint(float deltaTime) {

        Graphics g = game.getGraphics();

        if(this.isPortrait()) {
            g.drawImage(Assets.loadingPortrait, 0, 0);
        }
        else {
            g.drawImage(Assets.loadingLandscape, 0, 0);
        }
    }


    @Override
    public void pause() {


    }


    @Override
    public void resume() {
        Graphics g = game.getGraphics();

        if(this.isPortrait()) {
            g.drawImage(Assets.loadingPortrait, 0, 0);
        }
        else {
            g.drawImage(Assets.loadingLandscape, 0, 0);
        }

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
