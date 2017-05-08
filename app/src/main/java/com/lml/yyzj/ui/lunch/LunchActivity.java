package com.lml.yyzj.ui.lunch;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.lml.yyzj.R;
import com.lml.yyzj.base.BaseActivity;
import com.lml.yyzj.ui.home.activity.MainActivity;
import com.lml.yyzj.util.SPUtils;
import com.lml.yyzj.util.Tools;

import java.util.concurrent.TimeUnit;

import butterknife.Bind;
import rx.Observable;
import rx.functions.Action1;

/**
 * Created by liml on 17/2/28.
 */

public class LunchActivity extends BaseActivity<LunchContract.Presenter> implements LunchContract.View {
    @Bind(R.id.guide_bg)
    ImageView bg;

    @Override
    protected int getLayoutRes() {
        return R.layout.lunch_layout;
    }

    @Override
    protected LunchContract.Presenter createPresenter() {
        return new LunchContract.Presenter(this);
    }

    @Override
    protected void initEventAndData(Bundle savedInstanceState) {
        //第一次进入app
        boolean b = SPUtils.showGuide(this);
        if (b){
            Observable.timer(2,TimeUnit.SECONDS).subscribe(new Action1<Long>() {
                @Override
                public void call(Long aLong) {
                    mActivity.finish();
                    Tools.startActivity(mActivity,SplashActivity.class);
                }
            });

        }else {
        mPresenter.getAD();
        }
    }

    @Override
    public void getAD(String path) {

        if (!TextUtils.isEmpty(path))Glide.with(this).load(path).into(bg);
        //一秒后跳到主页
        Observable.timer(2,TimeUnit.SECONDS).subscribe(new Action1<Long>() {
            @Override
            public void call(Long aLong) {
                mActivity.finish();
                Tools.startActivity(mActivity,MainActivity.class);
            }
        });
    }
}
