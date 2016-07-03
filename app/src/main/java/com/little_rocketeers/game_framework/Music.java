package com.little_rocketeers.game_framework;

/**
 * Created by Melanie on 03.07.2016.
 */
public interface Music {
    public void play();
    public void stop();
    public void pause();
    public void setLooping(boolean looping);
    public void setVolume(float volume);
    public boolean isPlaying();
    public boolean isStopped();
    public boolean isLooping();
    public void dispose();
    void seekBegin();
}
