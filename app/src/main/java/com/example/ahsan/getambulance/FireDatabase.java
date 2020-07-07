package com.example.ahsan.getambulance;

import android.app.Application;

import com.firebase.client.Firebase;

/**
 * Created by AHSAN on 21-Mar-18.
 */

public class FireDatabase extends Application {
    @Override
    public void onCreate()
    {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}
