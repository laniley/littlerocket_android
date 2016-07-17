package com.little_rocketeers.game_framework.interfaces;

/**
 * Created by Melanie on 03.07.2016.
 */
import com.little_rocketeers.game_framework.interfaces.Graphics.ImageFormat;

public interface Image {
    public int getWidth();
    public int getHeight();
    public ImageFormat getFormat();
    public void dispose();
}
