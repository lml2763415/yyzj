package com.lml.yyzj.base;

import android.app.Application;

/**
 * Created by liml on 2016/11/24.
 */
public class App extends Application {
    public static App instance;

    public synchronized static App getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

}
