package com.ryan.lib_bmob;

import com.ryan.lib_bmob.model.UserModel;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.LogInListener;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.listener.UpdateListener;

public class BmobUtil {

    public static interface OnBmobResultCallback {
        void onSuccess(BmobObject object);

        void onFailed(BmobException e);
    }

    /**
     * 邮箱+密码登录
     */
    public static void loginByEmailPwd(String email, String password, final OnBmobResultCallback callback) {

        BmobUser.loginByAccount("email", "password", new LogInListener<UserModel>() {

            @Override
            public void done(UserModel user, BmobException e) {
                if (e == null) {
                    callback.onSuccess(user);
                } else {
                    callback.onFailed(e);
                }
            }
        });
    }


    /**
     * 发送验证邮件
     */
    public static void emailVerify(String email, final OnBmobResultCallback callback) {

        BmobUser.requestEmailVerify(email, new UpdateListener() {

            @Override
            public void done(BmobException e) {
                if (e == null) {
                    if (callback != null)
                        callback.onSuccess(null);
                } else {
                    if (callback != null)
                        callback.onFailed(e);
                }
            }
        });
    }

    /**
     * 发送验证邮件
     */
    public static void register(String username,String password,String email, final OnBmobResultCallback callback) {

        UserModel userModel = new UserModel();
        userModel.setUsername(username);
        userModel.setPassword(password);
        userModel.setEmail(email);

        userModel.signUp(new SaveListener<UserModel>() {
            @Override
            public void done(UserModel userModel, BmobException e) {
                if (e != null){
                    callback.onFailed(e);
                }else {
                    callback.onSuccess(userModel);
                }
            }
        });
    }


}
