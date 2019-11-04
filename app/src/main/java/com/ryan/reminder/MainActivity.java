package com.ryan.reminder;


import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.ryan.lib_bmob.BmobUtil;
import com.ryan.lib_bmob.BombConfig;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editText = findViewById(R.id.et_email);

        findViewById(R.id.btn_ver_email).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BmobUtil.emailVerify(editText.getText().toString(), null);
                BmobUtil.register("",null);
                BmobUtil.d();
            }
        });
    }
}
