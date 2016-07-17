package com.little_rocketeers.littlerocket;

/**
 * Created by Melanie on 09.07.2016.
 */
public class Background {
    private int bgX, bgY, speed;

    public Background(int x, int y){
        bgX = x;
        bgY = y;
        speed = 0;
    }

    public void update() {
        bgY += speed;

        if (bgY >= 1280){
            bgY = -1280;
        }
    }

    public int getBgX() {
        return bgX;
    }

    public int getBgY() {
        return bgY;
    }

    public int getSpeed() {
        return speed;
    }

    public void setBgX(int bgX) {
        this.bgX = bgX;
    }

    public void setBgY(int bgY) {
        this.bgY = bgY;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

}
