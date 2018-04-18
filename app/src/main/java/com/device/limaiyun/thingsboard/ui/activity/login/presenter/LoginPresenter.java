package com.device.limaiyun.thingsboard.ui.activity.login.presenter;

import android.view.View;
import android.widget.PopupWindow;

import com.device.limaiyun.thingsboard.R;
import com.device.limaiyun.thingsboard.base.BasePresenter;
import com.device.limaiyun.thingsboard.ui.activity.login.model.BottomBgModel;
import com.device.limaiyun.thingsboard.ui.activity.login.model.BottomBgPort;
import com.device.limaiyun.thingsboard.ui.activity.login.model.LoginModel;
import com.device.limaiyun.thingsboard.ui.activity.login.model.LoginPort;
import com.device.limaiyun.thingsboard.ui.activity.login.model.OnLoginListener;
import com.device.limaiyun.thingsboard.ui.activity.login.view.LoginView;
import com.device.limaiyun.thingsboard.utils.ToastUtils;

/**
 * Created by Administrator on 2018/4/11 0011.
 */

public class LoginPresenter extends BasePresenter implements OnLoginListener {

    private LoginView mLoginView;
    private LoginPort mLoginPort;
    private BottomBgPort mBottomBgPort;

    public LoginPresenter( LoginView mLoginView) {
        this.mLoginView = mLoginView;
        mLoginPort = new LoginModel();
        mBottomBgPort = new BottomBgModel();
    }


    public void login() {
        String username = mLoginView.getUsername();
        String password = mLoginView.getPassword();
        mLoginPort.login(username,password,this);
    }

    public void showBottomBg(){
        View view = mLoginView.showIpPopwindow();
        mBottomBgPort.showBottomBg(view);
    }


    @Override
    public void onUsernameError() {
        mLoginView.showToast("用户名/密码错误");
    }

    @Override
    public void onSuccess() {
        mLoginView.showToast("登录成功");
        mLoginView.jumpActivity();
    }

    @Override
    public void onError() {
        mLoginView.showToast("登录失败");
    }

    @Override
    public void onUnaOrPwdEmpty() {
        mLoginView.showToast("用户名或密码为空");
    }

    @Override
    public void onDestroy() {
        mLoginView = null;
    }
}
