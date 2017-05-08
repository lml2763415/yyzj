package com.lml.yyzj.view;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.ImageView;

import com.lml.yyzj.R;

/**
 * Created by liml on 17/3/9.
 */

public class RotateLoading extends Dialog{
    private Context context;
    private ImageView image;

    public RotateLoading(Context context) {
        super(context,R.style.loading);
        this.context = context;
        init();
    }


    public RotateLoading(Context context, int theme) {
        super(context, R.style.loading);
        this.context = context;
        init();
    }

    private void init() {

        setContentView(R.layout.custom_loading);
        getWindow().getAttributes().width = getWindow().getWindowManager().getDefaultDisplay().getWidth()-100;
        image = (ImageView)findViewById(R.id.loading);
    }


    @Override
    public void show() {
        super.show();
        Animation animation = AnimationUtils.loadAnimation(context, R.anim.loading_rotate);
        image.startAnimation(animation);
    }

    @Override
    public void dismiss() {
        image.clearAnimation();
        super.dismiss();
    }
}
