package com.lml.yyzj.base;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;


import com.lml.yyzj.util.ToastUtils;

import butterknife.ButterKnife;

/**
 * Created by liml on 2016/11/24.
 */
public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity implements BaseView{
    public Activity mActivity;
    public T mPresenter;
    public ProgressDialog dialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(getLayoutRes());
        mActivity = this;
        ButterKnife.bind(this);
        dialog = new ProgressDialog(mActivity);
        dialog.setMessage("loading");
        dialog.setCancelable(false);
        mPresenter = createPresenter();
        initEventAndData(savedInstanceState);
    }

    protected abstract int getLayoutRes();
    protected abstract T createPresenter();
    protected abstract void initEventAndData(Bundle savedInstanceState);

    @Override
    public void progressDialog(boolean b) {
        if(b){
            dialog.show();
        }else {
            dialog.dismiss();
        }
    }

    @Override
    public void showError(String error) {
//        Toast.makeText(mActivity,error,Toast.LENGTH_SHORT).show();
        ToastUtils.showToast(this,error);
        Log.d("lml","error="+error);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter!=null)mPresenter.detachView();
    }

    @Override
    public void setVisible() {

    }
}
