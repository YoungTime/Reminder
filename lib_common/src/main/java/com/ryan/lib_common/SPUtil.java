package com.ryan.lib_common;

import android.content.Context;
import android.content.SharedPreferences;

public class SPUtil {

    private static final String SP_NAME = "REMINDER_SP";

    private static SPUtil instance = null;
    private static SharedPreferences sharedPreferences;
    private SPUtil(Context context) {
        sharedPreferences = context.getSharedPreferences(SP_NAME,Context.MODE_PRIVATE);
    }

    public static SPUtil getInstance(Context context) {

        if (instance == null) {
            instance = new SPUtil(context);
        }
        return instance;
    }


    public void saveStringData(String key,String data){
        sharedPreferences.edit().putString(key,data).apply();
    }

    public String getStringData(String key){
        return sharedPreferences.getString(key,"");
    }

    public void saveBooleanData(String key,boolean flag){
        sharedPreferences.edit().putBoolean(key,flag).apply();
    }

    public boolean getBooleanData(String key){
        return sharedPreferences.getBoolean(key,false);
    }

    public void saveIntData(String key,int data){
        sharedPreferences.edit().putInt(key,data).apply();
    }

    public int getIntData(String key){
        return sharedPreferences.getInt(key,-1);
    }
    public void saveLongData(String key,long data){
        sharedPreferences.edit().putLong(key,data).apply();
    }

    public long getLongData(String key){
        return sharedPreferences.getLong(key,-1);
    }

    public void removeData(String key){
        sharedPreferences.edit().remove(key).apply();
    }


}
