package com.little_rocketeers.game_framework.interfaces;

import com.little_rocketeers.game_framework.interfaces.Game;

/**
 * Created by Melanie on 03.07.2016.
 */
public abstract class Screen {
    protected final Game game;

    public Screen(Game game) {
        this.game = game;
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

}
