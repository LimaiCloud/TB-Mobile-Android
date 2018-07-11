package com.device.limaiyun.thingsboard.ui.activity.login.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.device.limaiyun.thingsboard.R;
import com.device.limaiyun.thingsboard.base.BaseActivity;
import com.device.limaiyun.thingsboard.base.Configs;
import com.device.limaiyun.thingsboard.ui.activity.home.view.HomeActivity;
import com.device.limaiyun.thingsboard.ui.activity.login.presenter.LoginPresenter;
import com.device.limaiyun.thingsboard.utils.ToastUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
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
    private String username;
    private String password;
//    private String base_url;
    @BindView(R.id.checkbox)
    CheckBox checkBox;
    private boolean cb_boolean;
    private boolean exit_app;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle != null){
            exit_app = bundle.getBoolean("exit_app");
        }
        SharedPreferences account = getSharedPreferences("account", MODE_PRIVATE);
        username = account.getString("username", "");
        password = account.getString("password", "");
        cb_boolean = account.getBoolean("checkbox", false);
        SharedPreferences url = getSharedPreferences("login", MODE_PRIVATE);
        Configs.BASE_URL = url.getString("url", "");

        if (exit_app == false){
            autoLogin();
        }
    }

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
        //退出app收到的参数

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

    @Override
    public void loginError() {
        SharedPreferences sp = getSharedPreferences("account", MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        checkBox.setEnabled(true);
        checkBox.setChecked(false);
        edit.putString("username", null);
        edit.putString("password", null);
        etUsername.setText("");
        etPassword.setText("");
    }

    public void autoLogin() {
        if (cb_boolean == true) {
            checkBox.setChecked(true);
            if (username != null && !username.equals("") && password != null && !password.equals("")) {
                etUsername.setText(username);
                etPassword.setText(password);
                checkBox.setEnabled(false);
                mLoginPresenter.autologin(username, password, Configs.BASE_URL);
            }
        }
    }


    @OnClick(R.id.btn_login)
    public void Login(View view) {
        mLoginPresenter.login();
    }


    @OnClick(R.id.iv_bottom_bg)
    public void showBottomBg() {
        mLoginPresenter.showBottomBg(this);
    }

    @OnClick(R.id.checkbox)
    public void isChecked() {
        SharedPreferences sp = getSharedPreferences("account", MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        if (checkBox.isChecked()) {//记住密码
            edit.putString("username", etUsername.getText().toString());
            edit.putString("password", etPassword.getText().toString());
            edit.putBoolean("checkbox", checkBox.isChecked());
            edit.commit();
        } else {
            edit.putString("username", null);
            edit.putString("password", null);
        }
    }


    @Override
    public void initImmersionBar() {
        super.initImmersionBar();
        mImmersionBar.transparentBar().statusBarDarkFont(true).init();
    }

    @Override
    protected void onDestroy() {
        mLoginPresenter.onDestroy();
        super.onDestroy();
    }
}
