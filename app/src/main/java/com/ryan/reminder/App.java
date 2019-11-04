package com.ryan.reminder;

import android.app.Application;

import com.ryan.lib_bmob.BmobUtil;
import com.ryan.lib_bmob.BombConfig;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        BombConfig.initBomb(this);
    }
}
