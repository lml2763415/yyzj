package com.lml.yyzj.ui.lunch;

import com.lml.yyzj.base.BasePresenter;
import com.lml.yyzj.base.BaseView;
import com.lml.yyzj.bean.LunchBean;
import com.lml.yyzj.response.DialogResponseCallback;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by liml on 17/2/28.
 */

public interface LunchContract {
    interface View extends BaseView{
        void getAD(String path);
    }
    class Presenter extends BasePresenter<View>{
        public Presenter(View view) {
            attachView(view);
        }
        public void getAD(){
            Subscription subscribe = api.getLunchAD().observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe(new DialogResponseCallback<LunchBean>(mView, false) {
                        @Override
                        protected void onResponse(LunchBean response) {
                            String path = response.getData().getFestival().getImage().getPath();
                            mView.getAD(path);
                        }
                    });
            addSubscription(subscribe);
        }
    }
}
