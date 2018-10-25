package com.device.limaiyun.thingsboard.ui.activity.childactivity.video.view;

import com.device.limaiyun.thingsboard.bean.YSAccessTokenBean;
import com.device.limaiyun.thingsboard.bean.YSVideoListBean; /**
 * Created by ${Winter} on 2018/10/16.
 */
public interface VideoMonitroView {
    void preparShowVideoMonitorList(YSAccessTokenBean accessTokenBean);

    void showVideoMonitorList(YSVideoListBean ysVideoListBean,YSAccessTokenBean ysAccessTokenBean);

    void dismissProgress();

    void showProgress();
}
