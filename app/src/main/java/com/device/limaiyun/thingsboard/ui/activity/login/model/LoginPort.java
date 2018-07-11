package com.device.limaiyun.thingsboard.ui.activity.login.model;

import com.device.limaiyun.thingsboard.ui.activity.login.presenter.LoginPresenter;

/**
 * Created by Administrator on 2018/4/11 0011.
 */

public interface LoginPort {
    void login(String username,String password,OnLoginListener onLoginListener);

}
