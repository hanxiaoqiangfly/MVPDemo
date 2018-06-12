package com.sailei.mvpdemo;

import android.app.Application;

import com.sailei.slibrary.SL;

/**
 * @author 韩晓强
 * @date 2018/6/12
 * @describe
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        SL.init(this);
    }
}
