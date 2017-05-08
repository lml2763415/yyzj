package com.lml.yyzj.ui.home.contract;

import com.lml.yyzj.base.BasePresenter;
import com.lml.yyzj.base.BaseView;
import com.lml.yyzj.bean.BannerBean;
import com.lml.yyzj.bean.HomeRecommend;
import com.lml.yyzj.response.DialogResponseCallback;

import java.util.ArrayList;
import java.util.List;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by liml on 17/2/28.
 */

public interface FragmentHomeContract {
    interface View extends BaseView{
        void setBanner(ArrayList<String> list);
        void setRequest();
        void setRecommend(HomeRecommend.DataBean.PromptInfoBean list);
    }
    class Presenter extends BasePresenter<View>{
        public Presenter(View view) {
            attachView(view);
        }
        public void getBanner(int userId){
            Subscription subscribe = api.getBanner(userId).observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe(new DialogResponseCallback<BannerBean>(mView, false) {
                        @Override
                        protected void onResponse(BannerBean response) {
                            List<BannerBean.DataBean.ListBean> list = response.getData().getList();
                            ArrayList<String> arrayList = new ArrayList<>();
                            for (BannerBean.DataBean.ListBean bean : list) {
                                arrayList.add(bean.getImage().getPath());
                            }
                            mView.setBanner(arrayList);
                        }
                    });
            addSubscription(subscribe);
        }
        public void getQuestion(){

        }
        public void getRecommend(int userId){
            Subscription subscribe = api.getRecommend(userId).observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe(new DialogResponseCallback<HomeRecommend>(mView, false) {
                        @Override
                        protected void onResponse(HomeRecommend response) {
                            HomeRecommend.DataBean.PromptInfoBean promptInfo = response.getData().getPromptInfo();
                            mView.setRecommend(promptInfo);
                        }
                    });
            addSubscription(subscribe);
        }
    }
}
