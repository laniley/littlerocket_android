package com.little_rocketeers.game_framework.implementation;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.little_rocketeers.game_framework.interfaces.Game;
import com.little_rocketeers.game_framework.interfaces.Sprite;
import com.little_rocketeers.game_framework.interfaces.Graphics;
import com.little_rocketeers.game_framework.interfaces.Image;

/**
 * Created by Melanie on 23.07.2016.
 */
public class AndroidSprite extends AndroidGraphics implements Sprite {

    private Bitmap bitmap;
    private Canvas canvas;
    private Paint paint;

    private int x;
    private int y;

    private int width;
    private int height;

    private int centerX;
    private int centerY;

    private int angle = 0;

    public AndroidSprite(Game game, int width, int height) {

        super(game.getAssetManager(), game.getFrameBuffer());

        this.paint = new Paint();
        paint.setTextSize(45);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setAntiAlias(true);
        paint.setColor(Color.parseColor("#303637"));

        this.canvas = new Canvas(game.getFrameBuffer());
        this.width = width;
        this.height = height;
    }

    public void rotate(int newAngle) {

        newAngle = newAngle % 360;

        if(this.angle != newAngle) {
            int delta = 0;
            if(newAngle > this.angle) {
                delta = newAngle - this.angle;
            }
            else if(newAngle < this.angle) {
                delta = -1 * (this.angle - newAngle);
            }
            this.canvas.rotate(delta, 400, this.getCenterY());
            this.angle = newAngle;
        }
    }

    public void paint(Image Image) {
        this.canvas.drawBitmap(((AndroidImage)Image).bitmap, this.getCenterX(), this.y, null);
    }

    // SETTER / GETTER

    public int getCenterX() {
        return centerX;
    }

    public int getCenterY() {
        return centerY;
    }

    public void setCenterX(int centerX) {
        this.centerX = centerX;
    }

    private void setCenterY(int centerY) {
        this.centerY = centerY;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
        this.setCenterY(y + ( height/2 ) );
    }
}