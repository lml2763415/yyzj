package com.lml.yyzj.response;

import android.util.Log;

import com.lml.yyzj.base.BaseView;


/**
 * Created by liml on 2016/11/24.
 */
public abstract class DialogResponseCallback<T extends Response> extends ResponseCallback<T> {
    public BaseView baseView;
    private boolean progerss;//是否使用progressdialog

    public DialogResponseCallback(BaseView baseView, boolean b) {
        this.baseView = baseView;
        this.progerss = b;
    }

    @Override
    public void onStart() {
        if (baseView != null&&progerss) baseView.progressDialog(true);
        super.onStart();
        Log.d("lml","onStart");
    }

    @Override
    protected void onFinish() {
        Log.d("lml","Finish");
        if (baseView != null) baseView.progressDialog(false);
    }

    @Override
    protected void onFail(String msg) {
        //服务器返回的错误 参数错误或其他
        baseView.showError("系统错误" + msg);
    }

    @Override
    protected void onException(String msg) {
        //http返回错误 网络错误或其他
        baseView.showError("网络错误 DialogResponseCallback " + msg);
    }
}
