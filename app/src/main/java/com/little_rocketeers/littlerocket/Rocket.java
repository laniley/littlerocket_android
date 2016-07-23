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

    private int speedX = 0;
    private int speedY = 0;


    public Rocket(Screen screen, Game game, int width, int height) {
        super(screen, game, width, height);

        this.setX((screen.getWidth() / 2) - (width / 2));
        this.setY(800);
    }

    public void update() {
        // Moves Rocket
        if ((getX() + (2.5 * width)) < screen.getWidth() && speedX > 0) {
            this.rotate(45);
            setX(getX() + speedX);
            setY(getY() - speedX);
        }
        else if ((getX() - (1.5 * width)) > 0 && speedX < 0) {
            System.out.println(getX() - (1.5 * width));
            this.rotate(-45);
            setX(getX() + speedX);
            setY(getY() + speedX);
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
