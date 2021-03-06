package com.device.limaiyun.thingsboard.ui.activity.login.model;

import com.device.limaiyun.thingsboard.bean.TokenBean;

/**
 * Created by Administrator on 2018/4/11 0011.
 */

public interface OnLoginListener {

    /**
     * username Error
     */
    void onUsernameError();

    /**
     * login success
     */
    void onSuccess(TokenBean tokenBean);

    /**
     * login error
     */
    void onError();

    /**
     * username or password is Empty
     */
    void onUnaOrPwdEmpty();
}
