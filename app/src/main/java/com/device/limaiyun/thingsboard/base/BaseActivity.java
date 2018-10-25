package com.device.limaiyun.thingsboard.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.device.limaiyun.thingsboard.app.App;
import com.device.limaiyun.thingsboard.ui.activity.login.view.LoginActivity;
import com.gyf.barlibrary.ImmersionBar;

import java.util.LinkedList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity extends FragmentActivity {
    private BaseActivity activity;
    private Unbinder mUnbinder;
    private App mApp;
    private static final List<Activity> mActivitys = new LinkedList<Activity>();
    protected ImmersionBar mImmersionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        synchronized (mActivitys) {
            mActivitys.add(this);
        }
        if (isImmersionBarEnabled())
        initImmersionBar();
        mApp = App.getInstance();
        mUnbinder = ButterKnife.bind(this);
        activity = this;

        initView();
        initFragment();
        initData();
        initEvent();
    }

    public void initImmersionBar() {
        //在BaseActivity里初始化
        mImmersionBar = ImmersionBar.with(this);
        mImmersionBar.init();
    }
    /**
     * 是否可以使用沉浸式
     * Is immersion bar enabled boolean.
     *
     * @return the boolean
     */
    protected boolean isImmersionBarEnabled() {
        return true;
    }

    public void initEvent() {

    }

    public void initData() {

    }

    public void initFragment() {

    }

    public void initView() {
    }


    /**
     * Activity layout
     *
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
     *
     * @param clazz
     */
    public void startActivity(Class<? extends Activity> clazz) {
        startActivity(new Intent(this, clazz));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        synchronized (mActivitys) {
            mActivitys.remove(activity);
        }
        mUnbinder.unbind();
        mImmersionBar.with(this).destroy(); //必须调用该方法，防止内存泄漏
//        mDialog.dismiss();
    }

    /**
     * 关闭所有Activity
     */
    public static void finishAllActivity(){
        for (Activity activity : mActivitys){
            if (!activity.equals(LoginActivity.class)){
                if (!activity.isFinishing()){
                    activity.finish();
                }
            }
        }
    }
}
