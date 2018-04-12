package com.device.limaiyun.thingsboard.base;

import android.content.Context;

/**
 * Created by Administrator on 2018/4/9 0009.
 */

public abstract class BasePresenter<T extends BaseView,E extends BaseModel> {
    public Context mContext;
    public T mView;
    public E mModel;

    public void setVM(T mView,E mModel){
        this.mView = mView;
        this.mModel = mModel;
        this.onStart();
    }

    public void onStart() {}

    public void onDestroy(){}

    public void onLoadMore(){}

    public void onRefresh(){}


}
