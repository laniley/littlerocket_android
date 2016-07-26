package com.little_rocketeers.game_framework.implementation;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;

import com.little_rocketeers.game_framework.interfaces.Game;
import com.little_rocketeers.game_framework.interfaces.Screen;
import com.little_rocketeers.game_framework.interfaces.Sprite;
import com.little_rocketeers.game_framework.interfaces.Image;
import com.little_rocketeers.littlerocket.Assets;

/**
 * Created by Melanie on 23.07.2016.
 */
public class AndroidSprite extends AndroidGraphics implements Sprite {

    protected Canvas canvas;
    protected Screen screen;
    protected Image image;
    private Paint paint;

    private int x;
    private int y;

    protected int width;
    protected int height;

    protected int centerX;
    protected int centerY;

    public RectF collisionBox = new RectF(0,0,0,0);

    protected int angle = 0;
    private Matrix matrix;
    private Matrix collisionMatrix;

    public AndroidSprite(Screen screen, Game game, Image image, int width, int height) {

        super(game.getAssetManager(), game.getFrameBuffer());

        this.paint = new Paint();
        paint.setTextSize(45);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setAntiAlias(true);
        paint.setColor(Color.parseColor("#303637"));

        this.canvas = new Canvas(game.getFrameBuffer());
        this.screen = screen;
        this.image = image;

        this.matrix = new Matrix();
        this.collisionMatrix = new Matrix();

        this.width = width;
        this.height = height;
    }

    public void rotate(int newAngle) {
        newAngle = newAngle % 360;
        this.angle = newAngle;
    }

    public void paint() {

        canvas.save();
        canvas.rotate(angle, x + width/2, y + height/2);
        canvas.drawRect(collisionBox, paint);
        canvas.restore();

        // rotate rocket
        matrix.setRotate(angle, width / 2, height / 2);
        // set to position
        matrix.postTranslate(x, y);
/*
        collisionMatrix.setRotate(angle, 300, 800);
        collisionMatrix.mapRect(collisionBox);
        collisionMatrix.postTranslate(x, y);
        */

        canvas.drawBitmap(((AndroidImage)Assets.rocket).bitmap, matrix, null);
    }

    // SETTER / GETTER
    public int getCenterX() {
        return centerX;
    }

    public int getCenterY() {
        return centerY;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setCenterX(int centerX) {
        this.centerX = centerX;
    }

    private void setCenterY(int centerY) {
        this.centerY = centerY;
    }

    public void setX(int x) {
        this.x = x;
        this.setCenterX(x + ( width/2 ) );
    }

    public void setY(int y) {
        this.y = y;
        this.setCenterY(y + ( height/2 ) );
    }
}
