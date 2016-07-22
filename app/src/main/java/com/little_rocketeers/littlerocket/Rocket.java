package com.little_rocketeers.littlerocket;

import com.little_rocketeers.game_framework.interfaces.Game;
import com.little_rocketeers.game_framework.interfaces.Graphics;
import com.little_rocketeers.game_framework.interfaces.Image;
import com.little_rocketeers.game_framework.interfaces.Screen;

/**
 * Created by Melanie on 09.07.2016.
 */

public class Rocket {
    // Constants are Here
    final int MOVESPEED = 10;

    private final Screen screen;

    private int centerX;
    private int centerY = 800;

    private int speedX = 0;
    private int speedY = 0;

    public Rocket(Screen screen) {
        this.screen = screen;
        centerX = (screen.getWidth() / 2) - 50;
    }

    public void update() {
        // Moves Rocket
        if ((centerX + 100) < screen.getWidth() && speedX > 0) {
            centerX += speedX;
        }
        else if (centerX > 0 && speedX < 0) {
            centerX += speedX;
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

    public int getCenterX() {
        return centerX;
    }

    public int getCenterY() {
        return centerY;
    }

    public int getSpeedX() {
        return speedX;
    }

    public int getSpeedY() {
        return speedY;
    }

    public void setCenterX(int centerX) {
        this.centerX = centerX;
    }

    public void setCenterY(int centerY) {
        this.centerY = centerY;
    }

    public void setSpeedX(int speedX) {
        this.speedX = speedX;
    }

    public void setSpeedY(int speedY) {
        this.speedY = speedY;
    }
}
