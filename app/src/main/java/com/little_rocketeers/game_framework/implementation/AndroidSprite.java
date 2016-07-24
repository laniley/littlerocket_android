package com.little_rocketeers.game_framework.implementation;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;

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

    private int centerX;
    private int centerY;

    protected int angle = 0;
    private Matrix matrix;

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

        this.width = width;
        this.height = height;
    }

    public void rotate(int newAngle) {
        newAngle = newAngle % 360;
        this.angle = newAngle;
    }

    public void paint() {
        matrix.setRotate(angle, width / 2, height / 2);
        matrix.postTranslate(x, y);
        this.canvas.drawBitmap(((AndroidImage)Assets.rocket).bitmap, matrix, null);
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
