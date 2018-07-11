package com.device.limaiyun.thingsboard.ui.activity.childactivity.ThirdActivity.set.presenter;

import com.device.limaiyun.thingsboard.base.BasePresenter;
import com.device.limaiyun.thingsboard.ui.activity.childactivity.ThirdActivity.set.view.SettingView;

/**
 * Created by Administrator on 2018/7/4 0004.
 */

public class SettingPresenter extends BasePresenter {
    private SettingView view;

    public SettingPresenter(SettingView view) {
        this.view = view;
    }

    public void exitApp() {
        view.exitAppSuc();
    }
}
