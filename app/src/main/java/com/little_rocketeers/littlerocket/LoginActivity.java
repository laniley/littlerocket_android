package com.little_rocketeers.littlerocket;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.Profile;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.facebook.login.widget.ProfilePictureView;

import java.io.IOException;

public class LoginActivity extends Activity {

    private CallbackManager callbackManager;
    private LoginButton loginButton;
    private Button playButton;
    private Drawable d;
    private ProfilePictureView profilePictureView;

    Typeface myTypeface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        myTypeface = Typeface.createFromAsset(getApplicationContext().getAssets(), "fonts/kraash_black.ttf");

        // Initialize the SDK before executing any other operations,
        // especially, if using Facebook UI elements.
        FacebookSdk.sdkInitialize(getApplicationContext());

        setContentView(R.layout.activity_login);

        playButton = (Button) findViewById(R.id.play_button);
        playButton.setTypeface(myTypeface);

        try {
            d = Drawable.createFromStream(getAssets().open("button_430x165.png"), null);
            playButton.setBackgroundDrawable(d);
        }
        catch(IOException e) {
            Log.d("IOException", e.getMessage());
        }

        callbackManager = CallbackManager.Factory.create();

        profilePictureView = (ProfilePictureView) findViewById(R.id.profilePicture);

        loginButton = (LoginButton) this.findViewById(R.id.login_button);
        loginButton.setReadPermissions("public_profile", "user_friends");
        loginButton.registerCallback(callbackManager, mCallBack);
    }

    @Override
    public void onResume() {
        super.onResume();
/*
        if(AccessToken.getCurrentAccessToken() == null) {
            playButton.setVisibility(View.INVISIBLE);

            profilePictureView.destroyDrawingCache();
        }
        else {
        */
            playButton.setVisibility(View.VISIBLE);
/*
            //profilePictureView.setProfileId(Profile.getCurrentProfile().getId());
        }
        */
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    private FacebookCallback<LoginResult> mCallBack = new FacebookCallback<LoginResult>() {
        @Override
        public void onSuccess(LoginResult loginResult) {
            Log.e("Successful logged in", loginResult.getAccessToken().toString());

            //profilePictureView.setProfileId(Profile.getCurrentProfile().getId());

            playButton.setVisibility(View.VISIBLE);
        }

        @Override
        public void onCancel() {
            System.out.println("Login aborted by user.");
        }

        @Override
        public void onError(FacebookException e) {
            Log.e("Login error", e.getMessage());
        }
    };

    public void startGame(View view) {
        Intent myIntent = new Intent(LoginActivity.this, GameActivity.class);
        startActivity(myIntent);
    }

}
