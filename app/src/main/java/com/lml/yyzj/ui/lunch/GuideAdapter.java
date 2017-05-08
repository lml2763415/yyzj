package com.lml.yyzj.ui.lunch;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.lml.yyzj.ui.home.activity.MainActivity;
import com.lml.yyzj.util.SPUtils;
import com.lml.yyzj.util.Tools;

import java.util.List;

/**
 * Created by liml on 17/2/28.
 */

public class GuideAdapter extends PagerAdapter{
    private List<ImageView> guides;
    private Context context;

    public GuideAdapter(List<ImageView> guides, Context context) {
        this.guides = guides;
        this.context = context;
    }

    @Override
    public int getCount() {
        return guides.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public int getItemPosition(Object object) {
        return super.getItemPosition(object);
    }

    @Override
    public Object instantiateItem(final ViewGroup container, final int position) {
        ImageView imageView = guides.get(position);
        container.addView(imageView);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (position==2) {
                    ((SplashActivity)context).finish();
                    SPUtils.setGuideOver(context);
                    Tools.startActivity(context, MainActivity.class);
                }
            }
        });
        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(guides.get(position));
    }
}
