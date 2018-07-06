package com.device.limaiyun.thingsboard.ui.activity.childactivity.alarm.view;

import android.widget.LinearLayout;

import com.device.limaiyun.thingsboard.R;
import com.device.limaiyun.thingsboard.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/7/5 0005.
 */

public class AlarmActivity extends BaseActivity{

    @BindView(R.id.ll_back)
    LinearLayout ll_back;
    @Override
    protected int getLayout() {
        return R.layout.activity_alarm;
    }

    @Override
    public void initImmersionBar() {
        super.initImmersionBar();
        mImmersionBar.titleBar(R.id.toolbar).init();
    }

    @OnClick(R.id.ll_back)
    public void finishAct(){
        finish();
    }
}
