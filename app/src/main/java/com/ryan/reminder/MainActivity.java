package com.ryan.reminder;


import android.content.Intent;
import android.os.Bundle;

import com.ryan.lib_common.SPUtil;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (SPUtil.getInstance(this).getStringData("token").isEmpty()){
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        }
    }
}
