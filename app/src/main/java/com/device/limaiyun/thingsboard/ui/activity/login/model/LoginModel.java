package com.device.limaiyun.thingsboard.ui.activity.login.model;

/**
 * Created by Administrator on 2018/4/11 0011.
 */

public class LoginModel implements LoginPort {

    @Override
    public void login(String username, String password, OnLoginListener onLoginListener) {
        if (username.isEmpty() || password.isEmpty()) {
            onLoginListener.onUnaOrPwdEmpty();
            return;
        }
        if (username != null && password != null && !username.equals("") && !username.equals("")) {
            onLoginListener.onSuccess();
        }
    }
}
