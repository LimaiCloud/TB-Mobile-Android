package com.device.limaiyun.thingsboard.ui.activity.childactivity.Supervision.model;

/**
 * Created by ${Winter} on 2018/9/11.
 */
public interface SupervisionProt {

    void getUserToken(String url,String username,String password,SupervisionListener listener);

    void getUserBoard(String url,String userId,String token,SupervisionListener listener);
}
