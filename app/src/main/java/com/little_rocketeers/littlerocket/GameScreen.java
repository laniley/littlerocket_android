package com.little_rocketeers.littlerocket;

/**
 * Created by Melanie on 03.07.2016.
 */
import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;

import com.little_rocketeers.game_framework.interfaces.Game;
import com.little_rocketeers.game_framework.interfaces.Graphics;
import com.little_rocketeers.game_framework.interfaces.Image;
import com.little_rocketeers.game_framework.interfaces.Screen;
import com.little_rocketeers.game_framework.interfaces.Input.TouchEvent;

public class GameScreen extends Screen {

    enum GameState {
        Ready, Running, Paused, GameOver
    }

    GameState state = GameState.Ready;

    private static Background bg1, bg2;
    private static Rocket rocket;

    // Variable Setup
    // You would create game objects here.

    int livesLeft = 1;
    Typeface myTypeface;
    Paint paint;

    public GameScreen(Game game, Context context) {
        super(game, context);

        // Initialize game objects here
        bg1 = new Background(0, 0);
        bg2 = new Background(0, -1280);

        rocket = new Rocket(this, game);

        myTypeface = Typeface.createFromAsset(context.getAssets(), "fonts/kraash_black.ttf");

        // Defining a paint object
        paint = new Paint();
        paint.setTextSize(45);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setAntiAlias(true);
        paint.setColor(Color.parseColor("#303637"));
        paint.setTypeface(myTypeface);

    }

    @Override
    public void update(float deltaTime) {
        List<TouchEvent> touchEvents = game.getInput().getTouchEvents();

        // Depending on the state of the game, we call a different update methods.

        if (state == GameState.Ready)
            updateReady(touchEvents);
        if (state == GameState.Running)
            updateRunning(touchEvents, deltaTime);
        if (state == GameState.Paused)
            updatePaused(touchEvents);
        if (state == GameState.GameOver)
            updateGameOver(touchEvents);
    }

    private void updateReady(List<TouchEvent> touchEvents) {
        handleStartMenuTouchEvents(touchEvents);
    }

    private void updateRunning(List<TouchEvent> touchEvents, float deltaTime) {
       // Assets.themeMusic.play();
        // 1. All touch input is handled here:
        int len = touchEvents.size();

        for (int i = 0; i < len; i++) {

            TouchEvent event = touchEvents.get(i);

            if (event.type == TouchEvent.TOUCH_DOWN) {

                if (event.x > getWidth() / 2) {
                    // Move right.
                    rocket.moveRight();

                }
                else if (event.x < getWidth() / 2) {
                    // Move left.
                    rocket.moveLeft();

                }

            }


            if (event.type == TouchEvent.TOUCH_UP) {
                rocket.stop();
            }
        }

        // 2. Check miscellaneous events like death:

        if (livesLeft == 0) {
            state = GameState.GameOver;
        }

        bg1.update();
        bg2.update();
        rocket.update();
    }

    private void updatePaused(List<TouchEvent> touchEvents) {
        handleStartMenuTouchEvents(touchEvents);
    }

    private void updateGameOver(List<TouchEvent> touchEvents) {
        int len = touchEvents.size();
        for (int i = 0; i < len; i++) {
            TouchEvent event = touchEvents.get(i);
            if (event.type == TouchEvent.TOUCH_UP) {
                if (event.x > 300 && event.x < 980 && event.y > 100
                        && event.y < 500) {
                    nullify();
                    return;
                }
            }
        }

    }

    private void handleStartMenuTouchEvents(List<TouchEvent> touchEvents) {
        int len = touchEvents.size();

        for (int i = 0; i < len; i++) {

            TouchEvent event = touchEvents.get(i);

            if (event.type == TouchEvent.TOUCH_UP) {
                /* x, y, width, height */
                if (inBounds(event, (800/2) - (430/2), (1280/2) - (165/2), 430, 165)) {
                    bg1.setSpeed(20);
                    bg2.setSpeed(20);
                    state = GameState.Running;
                }
            }
        }
    }

    @Override
    public void paint(float deltaTime) {
        Graphics g = game.getGraphics();

        // First draw the game elements.
        g.drawImage(Assets.background, bg1.getBgX(), bg1.getBgY());
        g.drawImage(Assets.background, bg2.getBgX(), bg2.getBgY());
        rocket.paint(Assets.rocket);

        // Secondly, draw the UI above the game elements.
        if (state == GameState.Ready)
            drawReadyUI();
        if (state == GameState.Running)
            drawRunningUI();
        if (state == GameState.Paused)
            drawPausedUI();
        if (state == GameState.GameOver)
            drawGameOverUI();

    }

    private void nullify() {

        // Set all variables to null. You will be recreating them in the
        // constructor.
        paint = null;
        bg1 = null;
        bg2 = null;
        rocket = null;

        // Call garbage collector to clean up memory.
        System.gc();
    }

    private void drawReadyUI() {
        Graphics g = game.getGraphics();

        g.drawARGB(155, 0, 0, 0);

        g.drawImage(Assets.button, (800/2) - (430/2), (1280/2) - (165/2));
        g.drawString("START", (800/2), (int)((1280/2) - ((paint.descent() + paint.ascent()) / 2) + 10), paint);

    }

    private void drawRunningUI() {
        Graphics g = game.getGraphics();

    }

    private void drawPausedUI() {
        Graphics g = game.getGraphics();
        // Darken the entire screen so you can display the Paused screen.
        g.drawARGB(155, 0, 0, 0);

        g.drawImage(Assets.button, (800/2) - (430/2), (1280/2) - (165/2));
        g.drawString("START", (800/2), (int)((1280/2) - ((paint.descent() + paint.ascent()) / 2) + 10), paint);

    }

    private void drawGameOverUI() {
        Graphics g = game.getGraphics();
        g.drawRect(0, 0, 1281, 801, Color.BLACK);
        g.drawString("GAME OVER.", 640, 300, paint);

    }



    @Override
    public void pause() {
        if (state == GameState.Running)
            state = GameState.Paused;

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }

    @Override
    public void backButton() {
        if (state == GameState.Running) {
            pause();
        }
        else {
            Intent myIntent = new Intent(context, LoginActivity.class);
            myIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(myIntent);
        }
    }
}
