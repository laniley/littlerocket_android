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

    private int centerX;
    private int centerY;
    private int angle = 0;

    public AndroidSprite(Game game) {

        super(game.getAssetManager(), game.getFrameBuffer());

        this.paint = new Paint();
        paint.setTextSize(45);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setAntiAlias(true);
        paint.setColor(Color.parseColor("#303637"));

        this.canvas = new Canvas(game.getFrameBuffer());
    }

    public void rotate(int newAngle) {
        /*
        newAngle = newAngle % 360;
        if(this.angle != newAngle) {
            int delta = 0;
            if(newAngle > this.angle) {
                delta = newAngle - this.angle;
            }
            else if(newAngle < this.angle) {
                delta = -1 * (this.angle - newAngle);
            }
            this.canvas.rotate(delta, centerX, centerY);
            this.angle = newAngle;
        }
        */
        this.canvas.rotate(newAngle, centerX, centerY);
    }

    public void paint(Image Image) {
        this.canvas.drawBitmap(((AndroidImage)Image).bitmap, this.getCenterX(), this.getCenterY(), null);
    }

    public int getCenterX() {
        return centerX;
    }

    public int getCenterY() {
        return centerY;
    }

    public void setCenterX(int centerX) {
        this.centerX = centerX;
    }

    public void setCenterY(int centerY) {
        this.centerY = centerY;
    }
}
