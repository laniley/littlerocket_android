package com.little_rocketeers.game_framework;

/**
 * Created by Melanie on 03.07.2016.
 */
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.content.SharedPreferences;

public interface FileIO {
    public InputStream readFile(String file) throws IOException;
    public OutputStream writeFile(String file) throws IOException;
    public InputStream readAsset(String file) throws IOException;
    public SharedPreferences getSharedPref();
}
