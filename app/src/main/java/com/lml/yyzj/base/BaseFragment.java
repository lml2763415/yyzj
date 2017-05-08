package com.lml.yyzj.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.lml.yyzj.util.ToastUtils;

import butterknife.ButterKnife;

/**
 * Created by liml on 2016/11/25.
 */
public abstract class BaseFragment<T extends BasePresenter> extends Fragment implements BaseView{
    public T mPresenter;
    public Activity mActivity;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d("lml","onCreateView");
        View view = inflater.inflate(getLayoutRes(), null);
        ButterKnife.bind(this, view);
        mActivity = getActivity();
        mPresenter = createPresenter();
        initDataAndEvent();
        return view;
    }



    protected abstract int getLayoutRes();

    protected abstract void initDataAndEvent();

    protected abstract T createPresenter();

    @Override
    public void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
        if (mPresenter!=null)mPresenter.detachView();
    }

    @Override
    public void showError(String error) {
        ToastUtils.showToast(getActivity(),error);
    }

    @Override
    public void setVisible() {

    }
}
