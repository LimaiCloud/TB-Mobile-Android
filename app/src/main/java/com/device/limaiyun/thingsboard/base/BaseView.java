package com.device.limaiyun.thingsboard.base;

/**
 * Created by Administrator on 2018/4/9 0009.
 */

public interface BaseView {

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
}
