package com.lml.yyzj.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.lml.yyzj.base.Constants;

/**
 * Created by liml on 17/2/28.
 */

public class SPUtils {
    public static boolean showGuide(Context context){
        SharedPreferences sp = context.getSharedPreferences(Constants.SP_GUIDE, Context.MODE_PRIVATE);
        return sp.getBoolean(Constants.iS_GUIDE,true);
    }
    public static void setGuideOver(Context context){
        SharedPreferences sp = context.getSharedPreferences(Constants.SP_GUIDE, Context.MODE_PRIVATE);
        sp.edit().putBoolean(Constants.iS_GUIDE,false).commit();
    }
}
