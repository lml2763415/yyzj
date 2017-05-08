package com.lml.yyzj.ui.home.fragment;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
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

/**
 * Created by liml on 17/2/28.
 */
public class FragmentMine extends BaseFragment implements View.OnClickListener {
    @Bind(R.id.start)
    Button start;
    @Bind(R.id.stop)
    Button stop;
    @Bind(R.id.t3)
    Button t3;
    @Bind(R.id.t4)
    Button t4;
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
        return R.layout.fragment_mine_layout;
    }

    @Override
    protected void initDataAndEvent() {
        start.setOnClickListener(this);
        stop.setOnClickListener(this);
        t3.setOnClickListener(this);
        t4.setOnClickListener(this);

    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    public void progressDialog(boolean b) {

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.start:
                Intent startIntent = new Intent(mActivity, StartService.class);
                mActivity.bindService(startIntent, connection, Context.BIND_AUTO_CREATE);
                break;
            case R.id.stop:
//                Intent stopIntent = new Intent(mActivity, StartService.class);
//                mActivity.stopService(stopIntent);
                break;
            case R.id.t3:
                myBinder.print("hello service");
                break;
            case R.id.t4:

                break;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }
}
