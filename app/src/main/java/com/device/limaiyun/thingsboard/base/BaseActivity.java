package com.device.limaiyun.thingsboard.base;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.device.limaiyun.thingsboard.R;
import com.device.limaiyun.thingsboard.app.App;
import com.device.limaiyun.thingsboard.utils.ToastUtils;

import java.util.LinkedList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity extends Activity {
    private BaseActivity activity;
    private Unbinder mUnbinder;
    private Dialog mDialog;
    private BaseProgressDialog progressDialog;
    private App mApp;
    private static final List<Activity> mActivitys = new LinkedList<Activity>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        synchronized (mActivitys){
            mActivitys.add(this);
        }
        mApp = (App) getApplication();
        mUnbinder = ButterKnife.bind(this);
        activity = this;

        initView();
    }

    public void initView() {}



    /**
     * Activity layout
     * @return
     */
    protected abstract int getLayout();

    @Override
    protected void onResume() {
        super.onResume();
        activity = this;
    }

    @Override
    protected void onPause() {
        super.onPause();
        activity = this;
    }

    /**
     * start Activity
     * @param clazz
     */
    public void startActivity(Class<? extends Activity> clazz){
        startActivity(new Intent(this,clazz));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        synchronized (mActivitys){
            mActivitys.remove(activity);
        }
        mUnbinder.unbind();
        mDialog.dismiss();
    }
}
