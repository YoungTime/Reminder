package com.ryan.lib_bmob.model;

import cn.bmob.v3.BmobObject;

public class BaseObject extends BmobObject {

    String date;
    String name;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
