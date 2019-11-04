package com.ryan.lib_bmob;

import android.content.Context;

import cn.bmob.v3.Bmob;

public class BombConfig {


    public static void initBomb(Context context){
        Bmob.initialize(context, "5ea4f6f45c3b1636dc1c203469f4250e");
    }

}
