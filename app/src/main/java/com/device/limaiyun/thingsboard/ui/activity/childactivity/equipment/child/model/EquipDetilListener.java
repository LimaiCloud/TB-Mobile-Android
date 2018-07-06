package com.device.limaiyun.thingsboard.ui.activity.childactivity.equipment.child.model;

import com.device.limaiyun.thingsboard.bean.EquipmentDetialBean;

/**
 * Created by Administrator on 2018/6/27 0027.
 */

public interface EquipDetilListener {

    void getNewDetilOnSuc(EquipmentDetialBean bean);

    void getNewDetilOnFail();
}
