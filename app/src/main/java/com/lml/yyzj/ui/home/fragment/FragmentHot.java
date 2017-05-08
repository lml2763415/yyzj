package com.lml.yyzj.ui.home.fragment;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.lml.yyzj.R;
import com.lml.yyzj.base.BaseFragment;
import com.lml.yyzj.base.BasePresenter;
import com.lml.yyzj.service.StartService;

import butterknife.Bind;
import butterknife.ButterKnife;

import static com.bumptech.glide.gifdecoder.GifHeaderParser.TAG;

/**
 * Created by liml on 17/2/28.
 */
public class FragmentHot extends BaseFragment implements View.OnClickListener {
    @Bind(R.id.start)
    Button start;
    @Bind(R.id.bind)
    Button bind;

    private StartService.MyBinder myBinder;
    private ServiceConnection connection = new ServiceConnection() {


        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            myBinder = (StartService.MyBinder) iBinder;
            myBinder.print("hello service");
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_hot_layout;
    }

    @Override
    protected void initDataAndEvent() {
        start.setOnClickListener(this);
        bind.setOnClickListener(this);
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    public void progressDialog(boolean b) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.start:
                Intent intent = new Intent(mActivity,StartService.class);
                mActivity.startService(intent);
                break;
            case R.id.bind:
                Intent intent_bind = new Intent(mActivity,StartService.class);
                mActivity.bindService(intent_bind,connection, Context.BIND_AUTO_CREATE);
                break;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
        mActivity.unbindService(connection);
    }
}
