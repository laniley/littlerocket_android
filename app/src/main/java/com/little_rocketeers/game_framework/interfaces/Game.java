package com.little_rocketeers.game_framework.interfaces;

import android.content.res.AssetManager;
import android.graphics.Bitmap;

/**
 * Created by Melanie on 03.07.2016.
 */
public interface Game {
    public Audio getAudio();
    public Input getInput();
    public FileIO getFileIO();
    public Graphics getGraphics();
    public void setScreen(Screen screen);
    public Screen getCurrentScreen();
    public Screen getInitScreen();
    public AssetManager getAssetManager();
    public Bitmap getFrameBuffer();
}
