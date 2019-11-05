package com.ryan.reminder;

import android.app.Application;

import com.ryan.lib_bmob.BmobConfig;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        BmobConfig.initBomb(this);
    }
}
