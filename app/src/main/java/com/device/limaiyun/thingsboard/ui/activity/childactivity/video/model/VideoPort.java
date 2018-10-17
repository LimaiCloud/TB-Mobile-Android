package com.device.limaiyun.thingsboard.ui.activity.childactivity.video.model;

import com.device.limaiyun.thingsboard.bean.YSAccessTokenBean; /**
 * Created by ${Winter} on 2018/10/16.
 */
public interface VideoPort {
    void getAccessToken(String key, String sercet,VideoListener listener);

    void getVideoMonitorList(YSAccessTokenBean accessTokenBean,VideoListener listener);
}
