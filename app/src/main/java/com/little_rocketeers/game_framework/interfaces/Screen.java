package com.little_rocketeers.game_framework.interfaces;

import android.content.Context;
import android.view.Display;
import android.view.WindowManager;

/**
 * Created by Melanie on 03.07.2016.
 */
public abstract class Screen {

    protected final Game game;
    protected final Context context;
    protected final int width = 800;
    protected final int height = 1280;

    public Screen(Game game, Context context) {
        this.game = game;
        this.context = context;
    }

    public abstract void update(float deltaTime);
    public abstract void paint(float deltaTime);
    public abstract void pause();
    public abstract void resume();
    public abstract void dispose();
    public abstract void backButton();

    public boolean inBounds(Input.TouchEvent event, int x, int y, int width, int height) {
        if (event.x > x && event.x < x + width - 1 && event.y > y && event.y < y + height - 1)
            return true;
        else
            return false;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

}
