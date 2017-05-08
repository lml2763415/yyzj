package com.lml.yyzj.ui.home.fragment;


import android.content.Intent;
import android.view.View;

import com.lml.yyzj.R;
import com.lml.yyzj.base.BaseFragment;
import com.lml.yyzj.base.BasePresenter;
import com.lml.yyzj.service.StartService;
import com.lml.yyzj.view.ButtonView;

import butterknife.Bind;

/**
 * Created by liml on 17/2/28.
 */
public class FragmentNews extends BaseFragment implements View.OnClickListener {
    @Bind(R.id.bt)
    ButtonView bt;

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_news_layout;
    }

    @Override
    protected void initDataAndEvent() {
        bt.setOnClickListener(this);
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
        Intent intent = new Intent(mActivity,StartService.class);
        mActivity.startService(intent);
    }
}
