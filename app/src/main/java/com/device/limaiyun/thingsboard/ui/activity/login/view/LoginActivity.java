package com.device.limaiyun.thingsboard.ui.activity.login.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.device.limaiyun.thingsboard.R;
import com.device.limaiyun.thingsboard.base.BaseActivity;
import com.device.limaiyun.thingsboard.ui.activity.home.view.HomeActivity;
import com.device.limaiyun.thingsboard.ui.activity.login.presenter.LoginPresenter;
import com.device.limaiyun.thingsboard.utils.ToastUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity implements LoginView {


    @BindView(R.id.et_username)
    EditText etUsername;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.iv_bottom_bg)
    ImageView ivBottomBg;
    @BindView(R.id.login_progressbar)
    ProgressBar loginProgressbar;
    private LoginPresenter mLoginPresenter;

    /**
     * show layout
     *
     * @return
     */
    @Override
    protected int getLayout() {
        return R.layout.activity_login;
    }

    @Override
    public void initView() {
        mLoginPresenter = new LoginPresenter(this);
    }

    /**
     * get account name
     */
    @Override
    public String getUsername() {
        return etUsername.getText().toString().trim();
    }

    /**
     * get account password
     */
    @Override
    public String getPassword() {
        return etPassword.getText().toString().trim();
    }

    @Override
    public void showToast(String msg) {
        ToastUtils.showShortToast(msg);
    }

    @Override
    public void showLoading() {
        loginProgressbar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hinddenLoading() {
        loginProgressbar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void jumpActivity() {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public View showIpPopwindow() {
        View view = LayoutInflater.from(LoginActivity.this).inflate(R.layout.bottom_bg, null);
        return view;
    }


    @OnClick(R.id.btn_login)
    public void Login(View view) {
        mLoginPresenter.login();
    }


    @OnClick(R.id.iv_bottom_bg)
    public void showBottomBg() {
        mLoginPresenter.showBottomBg();
    }


    @Override
    protected void onDestroy() {
        mLoginPresenter.onDestroy();
        super.onDestroy();
    }


}
