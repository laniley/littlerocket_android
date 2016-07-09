package com.little_rocketeers.game;

/**
 * Created by Melanie on 03.07.2016.
 */
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.Paint;

import java.util.List;

import com.little_rocketeers.game_framework.Game;
import com.little_rocketeers.game_framework.Graphics;
import com.little_rocketeers.game_framework.Screen;
import com.little_rocketeers.game_framework.Input.TouchEvent;

public class MainMenuScreen extends Screen {

    private static Background bg;
    Paint paint;

    public MainMenuScreen(Game game) {
        super(game);

        bg = new Background(0, 0);

        paint = new Paint();
        paint.setTextSize(60);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setAntiAlias(true);
        paint.setColor(Color.parseColor("#303637"));
    }


    @Override
    public void update(float deltaTime) {
        Graphics g = game.getGraphics();
        List<TouchEvent> touchEvents = game.getInput().getTouchEvents();


        int len = touchEvents.size();
        for (int i = 0; i < len; i++) {
            TouchEvent event = touchEvents.get(i);
            if (event.type == TouchEvent.TOUCH_UP) {
                if (inBounds(event, 186, 557, 425, 165)) {
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
        g.drawImage(Assets.background, 0,0);
        g.drawImage(Assets.button, (800/2) - (430/2), (1280/2) - (165/2));
        g.drawString("START", (800/2), (int)((1280/2) - ((paint.descent() + paint.ascent()) / 2)), paint);
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
        // leave the game
        android.os.Process.killProcess(android.os.Process.myPid());
    }
}
