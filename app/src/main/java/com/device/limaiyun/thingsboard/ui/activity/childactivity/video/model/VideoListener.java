package com.device.limaiyun.thingsboard.ui.activity.childactivity.video.model;

import com.device.limaiyun.thingsboard.bean.YSAccessTokenBean;
import com.device.limaiyun.thingsboard.bean.YSVideoListBean;

/**
 * Created by ${Winter} on 2018/10/16.
 */
public interface VideoListener {

    void getYSAccessTokenSuc(YSAccessTokenBean accessTokenBean);

    void getYSAccessTokenFail();


    void getVideoListSuc(YSVideoListBean ysVideoListBean,YSAccessTokenBean accesstoken);

    void getVideoListFail();
}
