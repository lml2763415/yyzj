package com.lml.yyzj.ui.home.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.lml.yyzj.R;
import com.lml.yyzj.base.BaseActivity;
import com.lml.yyzj.base.BasePresenter;
import com.lml.yyzj.ui.home.fragment.FragmentAnswer;
import com.lml.yyzj.ui.home.fragment.FragmentHome;
import com.lml.yyzj.ui.home.fragment.FragmentHot;
import com.lml.yyzj.ui.home.fragment.FragmentMine;
import com.lml.yyzj.ui.home.fragment.FragmentNews;

import butterknife.Bind;

public class MainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener {

    @Bind(R.id.rg_nav)
    RadioGroup rgNav;
    private FragmentManager manager;
    private Fragment mContent;
    private FragmentHome homeFragment;
    private FragmentAnswer answerFragment;
    private FragmentNews newsFragment;
    private FragmentHot hotFragment;
    private FragmentMine mineFragment;


    @Override
    protected int getLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected void initEventAndData(Bundle savedInstanceState) {
        manager = getSupportFragmentManager();
        if (savedInstanceState!=null){
            initFragment();
        }
        rgNav.setOnCheckedChangeListener(this);
        ((RadioButton)rgNav.getChildAt(0)).setChecked(true);
    }

    private void initFragment() {
        homeFragment = (FragmentHome) manager.findFragmentByTag("home");
        answerFragment = (FragmentAnswer) manager.findFragmentByTag("answer");
        newsFragment = (FragmentNews) manager.findFragmentByTag("news");
        hotFragment = (FragmentHot) manager.findFragmentByTag("hot");
        mineFragment = (FragmentMine) manager.findFragmentByTag("mine");
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (i){
            case R.id.sy:
                if (homeFragment==null)homeFragment = new FragmentHome();
                switchContent(mContent,homeFragment,"home");
                break;
            case R.id.jd:
                if (answerFragment==null)answerFragment = new FragmentAnswer();
                switchContent(mContent,answerFragment,"answer");
                break;
            case R.id.zs:
                if (newsFragment==null)newsFragment = new FragmentNews();
                switchContent(mContent,newsFragment,"news");
                break;
            case R.id.rt:
                if (hotFragment==null)hotFragment = new FragmentHot();
                switchContent(mContent,hotFragment,"hot");
                break;
            case R.id.wd:
                if (mineFragment==null)mineFragment = new FragmentMine();
                switchContent(mContent,mineFragment,"mine");
                break;
        }
    }
    public void switchContent(Fragment from, Fragment to, String tag) {
        if(mContent!=null){
            Log.d("lml","mContent!=null");
        }
        FragmentTransaction transaction = manager.beginTransaction();
        if(mContent==null){
            if(!to.isAdded())transaction.add(R.id.fl_container,to,tag).commit();
        }else {
            if(to.isAdded()){
                transaction.hide(from).show(to).commit();
            }else {
                transaction.hide(from).add(R.id.fl_container,to,tag).commit();
            }
        }
        mContent = to;

    }
}
