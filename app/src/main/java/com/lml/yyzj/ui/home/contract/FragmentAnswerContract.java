package com.lml.yyzj.ui.home.contract;

import com.lml.yyzj.base.BasePresenter;
import com.lml.yyzj.base.BaseView;
import com.lml.yyzj.bean.AnswerBean;
import com.lml.yyzj.response.DialogResponseCallback;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by liml on 17/3/14.
 */

public interface FragmentAnswerContract{
    interface View extends BaseView{
        void refresh(AnswerBean.DataBean data);
        void setAnswer(AnswerBean.DataBean data);
        void loadMore(AnswerBean.DataBean data);

    }
     class Persenter extends BasePresenter<View>{
        public Persenter(View view) {
            attachView(view);
        }
         public void loadMore(int userid,int pageNum,int pageSize){
             api.getAnswer(userid,pageNum,pageSize).observeOn(AndroidSchedulers.mainThread())
                     .subscribeOn(Schedulers.io())
                     .subscribe(new DialogResponseCallback<AnswerBean>(mView,false) {
                         @Override
                         protected void onResponse(AnswerBean response) {
                             mView.loadMore(response.getData());
                         }
                     });
         }
        public void refresh(int userid,int pageNum,int pageSize){
            api.getAnswer(userid,pageNum,pageSize)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe(new DialogResponseCallback<AnswerBean>(mView,false) {
                        @Override
                        protected void onResponse(AnswerBean response) {
                            mView.refresh(response.getData());
                        }
                    });
        }
        public void loadAnswer(int userid,int pageNum,int pageSize){
            api.getAnswer(userid,pageNum,pageSize)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe(new DialogResponseCallback<AnswerBean>(mView,false) {
                        @Override
                        protected void onResponse(AnswerBean response) {
                            mView.setAnswer(response.getData());
                        }
                    });
        }
    }
}
