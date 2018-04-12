package com.device.limaiyun.thingsboard.ui.activity.login.presenter;

import com.device.limaiyun.thingsboard.R;
import com.device.limaiyun.thingsboard.ui.activity.login.model.LoginModel;
import com.device.limaiyun.thingsboard.ui.activity.login.model.LoginPort;
import com.device.limaiyun.thingsboard.ui.activity.login.model.OnLoginListener;
import com.device.limaiyun.thingsboard.ui.activity.login.view.LoginView;
import com.device.limaiyun.thingsboard.utils.ToastUtils;

/**
 * Created by Administrator on 2018/4/11 0011.
 */

public class LoginPresenter implements OnLoginListener {

    private LoginView mLoginView;
    private LoginPort mLoginPort;

    public LoginPresenter( LoginView mLoginView) {
        this.mLoginView = mLoginView;
        mLoginPort = new LoginModel();
    }


    public void login() {
        String username = mLoginView.getUsername();
        String password = mLoginView.getPassword();
        mLoginPort.login(username,password,this);
    }


    @Override
    public void onUsernameError() {
        mLoginView.showToast(String.valueOf(R.string.una_pwd_error));
    }

    @Override
    public void onSuccess() {
        mLoginView.showToast(String.valueOf(R.string.login_success));
        mLoginView.jumpActivity();
    }

    @Override
    public void onError() {
        mLoginView.showToast(String.valueOf(R.string.login_error));
    }

    @Override
    public void onUnaOrPwdEmpty() {
        mLoginView.showToast(String.valueOf(R.string.una_pwd_empty));
    }
}
