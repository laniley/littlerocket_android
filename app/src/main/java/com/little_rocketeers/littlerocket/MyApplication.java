package com.little_rocketeers.littlerocket;

import android.app.Application;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Base64;
import android.util.Log;
import com.facebook.FacebookSdk;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
/*
        FacebookSdk.sdkInitialize(getApplicationContext());
        try {
            System.out.println(getPackageName());
            PackageInfo info = getPackageManager().getPackageInfo(
                    "com.little_rocketeers.android_game_framework",  // replace with your unique package name
                    PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.e("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (PackageManager.NameNotFoundException e) {
            Log.e("NameNotFoundException", e.getMessage() + " - " + getPackageName());
        } catch (NoSuchAlgorithmException e) {
            Log.e("NoSuchAlgorithm:", e.getMessage());
        }
*/
    }
}