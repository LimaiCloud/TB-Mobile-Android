package com.device.limaiyun.thingsboard.ui.activity.childactivity.Supervision.child.child.view;

import com.device.limaiyun.thingsboard.bean.SupervisionDetilsBean;

/**
 * Created by ${Winter} on 2018/9/29.
 */
public interface SupervisionDetilsView {
    void showDetils(SupervisionDetilsBean detilsBean);

    void showProgress();

    void dissmisProgress();
}
