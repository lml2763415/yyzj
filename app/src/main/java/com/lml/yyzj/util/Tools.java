package com.lml.yyzj.util;

import android.app.Activity;
import android.app.ActivityOptions;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityOptionsCompat;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.lml.yyzj.R;
import com.lml.yyzj.base.App;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;
import static com.google.gson.internal.$Gson$Preconditions.checkNotNull;

/**
 * Created by liml on 2016/11/24.
 */
public class Tools {
    public static boolean isNetworkConnected() {
            ConnectivityManager mConnectivityManager = (ConnectivityManager) App.getInstance()
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo mNetworkInfo = mConnectivityManager.getActiveNetworkInfo();
            if (mNetworkInfo != null) {
                return mNetworkInfo.isAvailable();
            }
        return false;
    }
    public static void hideKeyboard(Context context, View view){
        InputMethodManager imm = (InputMethodManager) context
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
    public static void addFragmentToActivity (@NonNull FragmentManager fragmentManager,
                                              @NonNull Fragment fragment, int frameId) {
        checkNotNull(fragmentManager);
        checkNotNull(fragment);
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(frameId, fragment);
        transaction.commit();
    }
    public static void startActivity(Context context, Class<?> activity){
        Intent intent = new Intent(context, activity);
        ActivityOptionsCompat compat = ActivityOptionsCompat.makeCustomAnimation(context, R.anim.fade_in, R.anim.fade_out);
        context.startActivity(intent,compat.toBundle());
    }

    public static void hashHandler(){
        HashMap<Integer, String> map = new HashMap<>();
        Hashtable<Integer, String> hashtable = new Hashtable<>();
        for (int i = 0 ; i <10;i++){
            map.put(i,"x"+i);
            map.put(null,null);
            hashtable.put(i,"y"+i);
        }
        for (Map.Entry entry :map.entrySet()){
            Log.d("lml","hashmap"+entry.getValue().toString()+entry.getKey());
        }

        for (Map.Entry entry :hashtable.entrySet()){
            Log.d("lml","hashtable"+entry.getValue().toString()+entry.getKey());
        }
        
    }
}
