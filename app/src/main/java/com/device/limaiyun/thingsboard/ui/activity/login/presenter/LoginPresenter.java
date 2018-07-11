package com.device.limaiyun.thingsboard.ui.activity.login.presenter;

import android.content.Context;
import android.view.View;
import android.widget.PopupWindow;

import com.device.limaiyun.thingsboard.R;
import com.device.limaiyun.thingsboard.base.BasePresenter;
import com.device.limaiyun.thingsboard.base.Configs;
import com.device.limaiyun.thingsboard.bean.TokenBean;
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

    public LoginPresenter(LoginView mLoginView) {
        this.mLoginView = mLoginView;
        mLoginPort = new LoginModel();
        mBottomBgPort = new BottomBgModel();
    }


    public void login() {
        String username = mLoginView.getUsername();
        String password = mLoginView.getPassword();
        if (username != null && password != null && !username.equals("") && !password.equals("") && Configs.BASE_URL.equals("")) {
            ToastUtils.showShortToast("请添加服务器地址");
            return;
        }
        mLoginView.showLoading();
        mLoginPort.login(username, password, this);
    }

    public void showBottomBg(Context mContext) {
        View view = mLoginView.showIpPopwindow();
        mBottomBgPort.showBottomBg(mContext,view);
    }


    @Override
    public void onUsernameError() {
        mLoginView.showToast("用户名/密码错误");
    }

    @Override
    public void onSuccess(TokenBean tokenBean) {
        mLoginView.hinddenLoading();
        mLoginView.showToast("登录成功");
        mLoginView.jumpActivity();

    }

    @Override
    public void onError() {
        mLoginView.hinddenLoading();
        mLoginView.showToast("登录失败");
        mLoginView.loginError();
    }

    @Override
    public void onUnaOrPwdEmpty() {
        mLoginView.showToast("用户名或密码为空");
    }

    @Override
    public void onDestroy() {
        mLoginView = null;
    }

    public void autologin(String username, String password,String base_url) {
        if (username != null && password != null && !username.equals("") && !password.equals("") && base_url.equals("")) {
            ToastUtils.showShortToast("请添加服务器地址");
            return;
        }
        mLoginView.showLoading();
        mLoginPort.login(username, password,this);
    }
}
