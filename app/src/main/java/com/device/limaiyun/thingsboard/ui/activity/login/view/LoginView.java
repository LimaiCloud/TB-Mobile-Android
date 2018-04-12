package com.device.limaiyun.thingsboard.ui.activity.login.view;

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
     *
     * @param msg
     */
    void showToast(String msg);

    /**
     *
     */
    void showLoading();

    /**
     *
     */
    void hinddenLoading();

    /**
     *
     */
    void jumpActivity();

}
