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

import java.util.Date;

public class Rocket extends AndroidSprite{
    // Constants are Here
    final int MOVESPEED = 10;

    private int speedX = 0;
    private int speedY = 0;

    private int rotation_speed = 5;


    public Rocket(Screen screen, Game game, Image image, int width, int height) {
        super(screen, game, image, width, height);

        this.setX((screen.getWidth() / 2) - (width / 2));
        this.setY(800);
    }

    public void update() {
        // move right
        if ((getX() + width) < screen.getWidth() && speedX > 0) {
            setX(getX() + speedX);
            rotateRight();
        }
        // move left
        else if (getX() > 0 && speedX < 0) {
            setX(getX() + speedX);
            rotateLeft();
        }
        else {
            resetToDefaultPosition();
        }
    }

    public void moveRight() { speedX = MOVESPEED; }

    public void moveLeft() {
        speedX = -MOVESPEED;
    }

    public void stop() {
        speedX = 0;
    }

    public int getAngle() {
        return angle;
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

    private void rotateLeft() {
        if ((this.angle - rotation_speed) > -45) {
            this.rotate(this.angle - rotation_speed);
        } else {
            this.rotate(-45);
        }
    }

    private void rotateRight() {
        if ((this.angle + rotation_speed) < 45) {
            this.rotate(this.angle + rotation_speed);
        } else {
            this.rotate(45);
        }
    }

    private void resetToDefaultPosition() {
        if ((this.angle - rotation_speed) > 0) {
            this.rotate(this.angle - rotation_speed);
        } else if ((this.angle + rotation_speed) < 0) {
            this.rotate(this.angle + rotation_speed);
        }
        else {
            this.rotate(0);
        }
    }

}
