package com.little_rocketeers.game;

/**
 * Created by Melanie on 03.07.2016.
 */
import android.content.Context;
import android.content.res.Configuration;

import java.util.List;

import com.little_rocketeers.game_framework.Game;
import com.little_rocketeers.game_framework.Graphics;
import com.little_rocketeers.game_framework.Screen;
import com.little_rocketeers.game_framework.Input.TouchEvent;

public class MainMenuScreen extends Screen {

    Context context;

    public MainMenuScreen(Game game, Context context) {
        super(game);
        this.context = context;
    }


    @Override
    public void update(float deltaTime) {
        Graphics g = game.getGraphics();
        List<TouchEvent> touchEvents = game.getInput().getTouchEvents();


        int len = touchEvents.size();
        for (int i = 0; i < len; i++) {
            TouchEvent event = touchEvents.get(i);
            if (event.type == TouchEvent.TOUCH_UP) {


                if (inBounds(event, 0, 0, 250, 250)) {
                    //START GAME
                    game.setScreen(new GameScreen(game));
                }


            }
        }
    }


    private boolean inBounds(TouchEvent event, int x, int y, int width,
                             int height) {
        if (event.x > x && event.x < x + width - 1 && event.y > y
                && event.y < y + height - 1)
            return true;
        else
            return false;
    }


    @Override
    public void paint(float deltaTime) {
        Graphics g = game.getGraphics();
        if(this.isPortrait()) {
            g.drawImage(Assets.menuPortrait, 0, 0);
        }
        else {
            g.drawImage(Assets.menuLandscape, 0, 0);
        }
    }


    @Override
    public void pause() {
    }


    @Override
    public void resume() {
        Graphics g = game.getGraphics();
        if(this.isPortrait()) {
            g.drawImage(Assets.menuPortrait, 0, 0);
        }
        else {
            g.drawImage(Assets.menuLandscape, 0, 0);
        }
    }


    @Override
    public void dispose() {


    }


    @Override
    public void backButton() {
        //Display "Exit GameActivityActivity?" Box


    }

    private boolean isPortrait() {
        return this.context.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT;
    }
}
