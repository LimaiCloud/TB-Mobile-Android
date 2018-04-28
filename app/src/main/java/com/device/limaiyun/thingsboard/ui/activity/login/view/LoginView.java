package com.device.limaiyun.thingsboard.ui.activity.login.view;

import android.view.View;
import android.widget.PopupWindow;

import com.device.limaiyun.thingsboard.base.BaseView;

/**
 * Created by Administrator on 2018/4/10 0010.
 */

public interface LoginView extends BaseView {

    /**
     * get accountname
     */
    String getUsername();

    /**
     * get username password
     */
    String getPassword();

    /**
     *   show message
     * @param msg
     */
    void showToast(String msg);

    /**
     * show progress dialog
     */
    void showLoading();

    /**
     * progress dialog dimiss
     */
    void hinddenLoading();

    /**
     * start Activity
     */
    void jumpActivity();

    View showIpPopwindow();


}
