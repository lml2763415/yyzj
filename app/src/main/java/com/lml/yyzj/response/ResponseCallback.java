package com.lml.yyzj.response;


import android.util.Log;

import com.lml.yyzj.util.Tools;

import rx.Subscriber;

/**
 * Created by liml on 2016/11/24.
 */
public abstract class ResponseCallback<T extends Response> extends Subscriber<T>{
    protected abstract void onResponse(T response);
    protected abstract void onFail(String msg);
    protected abstract void onException(String msg);
    protected abstract void onFinish();

    @Override
    public void onStart() {
        if (!Tools.isNetworkConnected()){
            onException("网络不可用");
            unsubscribe();
            onFinish();
        }
    }

    @Override
    public void onCompleted() {
        onFinish();
    }

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
        Log.d("lml","ResponseCallback "+e.getMessage());
        onException(e.getMessage());
        onFinish();
    }

    @Override
    public void onNext(T t) {
        if (t.getStatus().equals("0")){
            onResponse(t);
        }else {
            onFail("加载失败");
        }
    }

}
