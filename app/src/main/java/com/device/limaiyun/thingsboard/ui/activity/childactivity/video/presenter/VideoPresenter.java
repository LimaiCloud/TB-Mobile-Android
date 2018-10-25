package com.device.limaiyun.thingsboard.ui.activity.childactivity.video.presenter;

import com.device.limaiyun.thingsboard.bean.YSAccessTokenBean;
import com.device.limaiyun.thingsboard.bean.YSVideoListBean;
import com.device.limaiyun.thingsboard.ui.activity.childactivity.video.model.VideoListener;
import com.device.limaiyun.thingsboard.ui.activity.childactivity.video.model.VideoModel;
import com.device.limaiyun.thingsboard.ui.activity.childactivity.video.model.VideoPort;
import com.device.limaiyun.thingsboard.ui.activity.childactivity.video.view.VideoMonitroView;
import com.device.limaiyun.thingsboard.utils.ToastUtils;

/**
 * Created by ${Winter} on 2018/10/16.
 */
public class VideoPresenter implements VideoListener {
    private VideoPort port;
    private VideoMonitroView view;

    public VideoPresenter(VideoMonitroView view) {
        this.view = view;
        port = new VideoModel();
    }

    public void getAccessToken(String key, String sercet) {
        view.showProgress();
        port.getAccessToken(key,sercet,this);
    }

    @Override
    public void getYSAccessTokenSuc(YSAccessTokenBean accessTokenBean) {
        view.preparShowVideoMonitorList(accessTokenBean);
    }

    @Override
    public void getYSAccessTokenFail() {
        view.dismissProgress();
        ToastUtils.showShortToast("获取视频列表失败");
    }

    @Override
    public void getVideoListSuc(YSVideoListBean ysVideoListBean,YSAccessTokenBean ysAccessTokenBean) {
        view.dismissProgress();
        view.showVideoMonitorList(ysVideoListBean,ysAccessTokenBean);
    }

    @Override
    public void getVideoListFail() {
        view.dismissProgress();
    }

    public void getVideoMonitorList(YSAccessTokenBean accessTokenBean) {
        port.getVideoMonitorList(accessTokenBean,this);
    }
}
