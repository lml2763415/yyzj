package com.lml.yyzj.ui.lunch;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

import com.lml.yyzj.R;
import com.lml.yyzj.ui.home.activity.MainActivity;
import com.lml.yyzj.util.SPUtils;
import com.lml.yyzj.util.ToastUtils;
import com.lml.yyzj.util.Tools;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by liml on 17/2/28.
 */

public class SplashActivity extends AppCompatActivity {
    @Bind(R.id.guide_vp)
    ViewPager guideVp;
    private int[] guides = {R.mipmap.guide1, R.mipmap.guide2, R.mipmap.guide3};

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Transition explode = TransitionInflater.from(this).inflateTransition(R.transition.fade);
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        setContentView(R.layout.splash_layout);
        ButterKnife.bind(this);
        ArrayList<ImageView> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setBackgroundResource(guides[i]);
            list.add(imageView);
        }
        GuideAdapter adapter = new GuideAdapter(list,this);
        guideVp.setAdapter(adapter);
    }


}
