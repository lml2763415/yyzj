package com.lml.yyzj.ui.home.fragment;

import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lml.yyzj.R;
import com.lml.yyzj.base.BaseFragment;
import com.lml.yyzj.bean.HomeRecommend;
import com.lml.yyzj.ui.home.contract.FragmentHomeContract;
import com.lml.yyzj.view.BannerLayout;

import java.util.ArrayList;

import butterknife.Bind;

/**
 * Created by liml on 17/2/28.
 */

public class FragmentHome extends BaseFragment<FragmentHomeContract.Presenter> implements FragmentHomeContract.View {
    @Bind(R.id.banner)
    BannerLayout banner;
    @Bind(R.id.image)
    ImageView image;
    @Bind(R.id.bottomtitle)
    TextView title;


    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_home_layout;
    }

    @Override
    protected void initDataAndEvent() {
        mPresenter.getBanner(-1);
        mPresenter.getRecommend(-1);
    }

    @Override
    protected FragmentHomeContract.Presenter createPresenter() {
        return new FragmentHomeContract.Presenter(this);
    }


    @Override
    public void progressDialog(boolean b) {

    }

    @Override
    public void setBanner(ArrayList<String> list) {
        banner.setViewUrls(list);
    }

    @Override
    public void setRequest() {

    }

    @Override
    public void setRecommend(HomeRecommend.DataBean.PromptInfoBean promptInfoBean) {
        Glide.with(mActivity).load(promptInfoBean.getImage().getPath()).into(image);
        title.setText(promptInfoBean.getTitle());
    }


}
