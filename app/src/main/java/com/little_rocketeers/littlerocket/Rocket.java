package com.little_rocketeers.littlerocket;

import android.content.res.AssetManager;
import android.graphics.Bitmap;

import com.little_rocketeers.game_framework.implementation.AndroidGraphics;
import com.little_rocketeers.game_framework.interfaces.Game;
import com.little_rocketeers.game_framework.interfaces.Graphics;
import com.little_rocketeers.game_framework.interfaces.Image;
import com.little_rocketeers.game_framework.interfaces.Screen;

/**
 * Created by Melanie on 09.07.2016.
 */
import com.little_rocketeers.game_framework.implementation.AndroidSprite;

public class Rocket extends AndroidSprite{
    // Constants are Here
    final int MOVESPEED = 10;

    private final Screen screen;

    private int speedX = 0;
    private int speedY = 0;


    public Rocket(Screen screen, Game game) {
        // width, height
        super(game);

        this.screen = screen;
        this.setCenterX((screen.getWidth() / 2) - 50);
        this.setCenterY(800);
    }

    public void update() {
        // Moves Rocket
        if ((getCenterX() + 100) < screen.getWidth() && speedX > 0) {
            setCenterX(getCenterX() + speedX);
            this.rotate(45);
        }
        else if (getCenterX() > 0 && speedX < 0) {
            setCenterX(getCenterX() + speedX);
            this.rotate(-45);
        }
    }

    public void moveRight() {
        speedX = MOVESPEED;
    }

    public void moveLeft() {
        speedX = -MOVESPEED;
    }

    public void stop() {
        speedX = 0;
    }

    public int getSpeedX() {
        return speedX;
    }

    public int getSpeedY() {
        return speedY;
    }

    public void setSpeedX(int speedX) {
        this.speedX = speedX;
    }

    public void setSpeedY(int speedY) {
        this.speedY = speedY;
    }


}
