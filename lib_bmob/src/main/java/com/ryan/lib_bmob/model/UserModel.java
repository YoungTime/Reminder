package com.ryan.lib_bmob.model;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.listener.SaveListener;
import io.reactivex.disposables.Disposable;

public class UserModel extends BmobUser {


    @Override
    public <T> Disposable signUp(SaveListener<T> listener) {
        return super.signUp(listener);
    }
}
