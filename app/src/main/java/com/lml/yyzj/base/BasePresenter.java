package com.lml.yyzj.base;


import com.lml.yyzj.network.RetrofitHelper;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by liml on 2016/11/24.
 */
public class BasePresenter<T extends BaseView> {
    public T mView;
    public Api api;
    private CompositeSubscription compositeSubscription;

    public void attachView(T view) {
        this.mView = view;
        api = RetrofitHelper.builder().create(Api.class);
    }
    public void detachView(){
        this.mView = null;
        removeSubscription();
    }
    public void addSubscription(Subscription subscription){
        if (compositeSubscription==null)compositeSubscription = new CompositeSubscription();
        compositeSubscription.add(subscription);
    }
    public void removeSubscription(){
        if (compositeSubscription!=null)compositeSubscription.unsubscribe();
    }
}
