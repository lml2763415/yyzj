package com.lml.yyzj.util;

import android.content.Context;
import android.widget.Toast;


/**
 * Created by liml on 2016/11/24.
 */
public class ToastUtils {
    static Toast toast;

    public static void showToast(Context mContext, String text){
        if (toast != null) {
            toast.setText(text);
        } else {
            toast = Toast.makeText(mContext,text, Toast.LENGTH_SHORT);
        }

        toast.show();
    }
}
