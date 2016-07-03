package com.little_rocketeers.game_framework.implementation;

/**
 * Created by Melanie on 03.07.2016.
 */
import java.util.List;

import android.view.View.OnTouchListener;

import com.little_rocketeers.game_framework.Input.TouchEvent;

public interface TouchHandler extends OnTouchListener {
    public boolean isTouchDown(int pointer);

    public int getTouchX(int pointer);

    public int getTouchY(int pointer);

    public List<TouchEvent> getTouchEvents();
}
