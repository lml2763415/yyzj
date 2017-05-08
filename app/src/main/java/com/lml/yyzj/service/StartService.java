package com.lml.yyzj.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by liml on 17/3/9.
 */

public class StartService extends Service{
    String TAG = "lml";
    public MyBinder myBinder = new MyBinder();

    @Override
    public void onCreate() {
        super.onCreate();
//        myBinder = new MyBinder();
        Log.d(TAG,"onCreate");
    }

    public StartService() {
        super();
        Log.d(TAG, "StartService: ");
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d(TAG, "onUnbind: ");
        return super.onUnbind(intent);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG,"onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.d(TAG,"onDestroy");
        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG,"onBind");
        return myBinder;
    }
    public class MyBinder extends Binder{

        public void print(String msg){
            Log.d(TAG,msg);
        }
    }
}
