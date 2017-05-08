package com.lml.yyzj.network;

import com.lml.yyzj.base.Api;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by liml on 17/2/28.
 */

public class RetrofitHelper {
    private static Retrofit retrofitHelper;

    public synchronized static Retrofit builder() {
        if (retrofitHelper!=null)return retrofitHelper;
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.readTimeout(20000, TimeUnit.MILLISECONDS);
        retrofitHelper = new Retrofit.Builder().baseUrl(Api.Host)
                .client(builder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return retrofitHelper;
    }
}
