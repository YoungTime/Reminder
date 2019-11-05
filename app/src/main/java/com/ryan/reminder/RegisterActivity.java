package com.ryan.reminder;

import androidx.appcompat.app.AppCompatActivity;
import cn.bmob.v3.BmobObject;
import cn.bmob.v3.exception.BmobException;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.ryan.lib_bmob.BmobUtil;
import com.ryan.lib_common.StringUtil;
import com.ryan.lib_common.ToastUtil;

public class RegisterActivity extends AppCompatActivity {

    private TextInputLayout tilUsername;
    private TextInputLayout tilEmail;
    private TextInputLayout tilPassword;
    private TextInputLayout tilPasswordSure;
    private EditText etUsername;
    private EditText etPassword;
    private EditText etEmail;
    private EditText etPasswordSure;
    private Button btnRegister;
    private TextView tvLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
        initListener();
    }

    private void initView(){
        tilUsername = findViewById(R.id.til_register_username);
        tilEmail = findViewById(R.id.til_register_email);
        tilPassword = findViewById(R.id.til_register_password);
        tilPasswordSure = findViewById(R.id.til_register_password_sure);
        etUsername = findViewById(R.id.et_register_username);
        etEmail = findViewById(R.id.et_register_email);
        etPassword = findViewById(R.id.et_register_password);
        etPasswordSure = findViewById(R.id.et_register_password_sure);
        btnRegister = findViewById(R.id.btn_register);
        tvLogin = findViewById(R.id.tv_register_login);
    }


    private void initListener(){

        btnRegister.setOnClickListener(view ->{
            if (etUsername.getText().toString().isEmpty()){
                tilUsername.setError("用户名不能为空");
                return;
            }
            if (etEmail.getText().toString().isEmpty()){
                tilEmail.setError("邮箱不能为空");
                return;
            }
            if (etPassword.getText().toString().isEmpty()){
                tilPassword.setError("密码不能为空");
                return;
            }
            if (etPasswordSure.getText().toString().isEmpty()){
                tilPasswordSure.setError("确认密码不能为空");
                return;
            }
            BmobUtil.register(etUsername.getText().toString(), etPassword.getText().toString(), etEmail.getText().toString(), new BmobUtil.OnBmobResultCallback() {
                @Override
                public void onSuccess(BmobObject object) {
                    startActivity(new Intent(RegisterActivity.this,VerifyEmailActivity.class));
                }

                @Override
                public void onFailed(BmobException e) {
                    System.out.println(e);
                    Toast.makeText(RegisterActivity.this,e.getMessage(),Toast.LENGTH_SHORT).show();
                }
            });

        });
        etPasswordSure.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.toString().isEmpty()){
                    tilPasswordSure.setErrorEnabled(false);
                    return;
                }
                if (!etPassword.getText().toString().contentEquals(s)){
                    tilPasswordSure.setError("确认密码不一致");
                }else {
                    tilPasswordSure.setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        etEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.toString().isEmpty()){
                    tilEmail.setErrorEnabled(false);
                    return;
                }
                if (!StringUtil.isEmail(s.toString())){
                    tilEmail.setError("请输入正确的邮箱");
                }else {
                    tilEmail.setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        tvLogin.setOnClickListener(view->{
            startActivity(new Intent(this,LoginActivity.class));
            finish();
        });
        addTextListener(etUsername,tilUsername);
        addTextListener(etPassword,tilPassword);
    }



    private void addTextListener(EditText et, final TextInputLayout til){
        et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().isEmpty()){
                    til.setErrorEnabled(false);
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

}
