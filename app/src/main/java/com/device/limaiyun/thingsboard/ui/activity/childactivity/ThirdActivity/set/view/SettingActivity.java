package com.device.limaiyun.thingsboard.ui.activity.childactivity.ThirdActivity.set.view;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.LinearLayout;

import com.device.limaiyun.thingsboard.R;
import com.device.limaiyun.thingsboard.base.BaseActivity;
import com.device.limaiyun.thingsboard.ui.activity.childactivity.ThirdActivity.set.presenter.SettingPresenter;
import com.device.limaiyun.thingsboard.ui.activity.login.view.LoginActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/7/4 0004.
 */

public class SettingActivity extends BaseActivity implements SettingView {
    @BindView(R.id.btn_exit)
    Button btn_exit;
    private SettingPresenter presenter;
    @BindView(R.id.ll_back)
    LinearLayout ll_back;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected int getLayout() {
        return R.layout.activity_set;
    }

    @Override
    public void initView() {
        presenter = new SettingPresenter(this);
    }

    @OnClick(R.id.btn_exit)
    public void exitApp() {
        presenter.exitApp();
    }

    @Override
    public void showToast(String msg) {

    }


    @Override
    public void initImmersionBar() {
        super.initImmersionBar();
        mImmersionBar.titleBar(R.id.toolbar).init();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hinddenLoading() {

    }

    @SuppressLint("CommitPrefEdits")
    @Override
    public void exitAppSuc() {
//        SharedPreferences sp = getSharedPreferences("account", MODE_PRIVATE);
//        SharedPreferences.Editor edit = sp.edit();
//        edit.putBoolean("checkbox", false);
//        edit.commit();
        SharedPreferences account = getSharedPreferences("account", MODE_PRIVATE);
        SharedPreferences login_url = getSharedPreferences("login", MODE_PRIVATE);
//        username = account.getString("username", "");
//        password = account.getString("password", "");
//        cb_boolean = account.getBoolean("checkbox", false);
//        SharedPreferences url = getSharedPreferences("url", MODE_PRIVATE);
//        base_url = url.getString("url", "");
        SharedPreferences.Editor edit = account.edit();
        SharedPreferences.Editor edit_url = login_url.edit();
        edit.putString("username", null);
        edit.putString("password", null);
        edit.putBoolean("checkbox", false);
        edit_url.putString("url", null).commit();
        edit.commit();
        Intent intent = new Intent(this, LoginActivity.class);
        intent.putExtra("exit_app", true);
        startActivity(intent);
        finishAllActivity();

    }

    @Override
    public void exitAppFai() {

    }

    @OnClick(R.id.ll_back)
    public void finishAct() {
        finish();
    }


    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);

    }
}
