package com.device.limaiyun.thingsboard.ui.activity.childactivity.Supervision.child.child.model;

import com.device.limaiyun.thingsboard.bean.SupervisionDetilsBean;

/**
 * Created by ${Winter} on 2018/9/29.
 */
public interface SupervisionDetilsListener {

    void getSupervisionDetilsSuc(SupervisionDetilsBean supervisionDetilsBean);

    void getSupervisionDetilsFail();
}
