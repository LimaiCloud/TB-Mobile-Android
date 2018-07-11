package com.device.limaiyun.thingsboard.ui.activity.childactivity.data.module;

import com.device.limaiyun.thingsboard.bean.DashBoardsBean;
import com.device.limaiyun.thingsboard.bean.DeviceTypeBean;

/**
 * Created by Administrator on 2018/6/19 0019.
 */

public interface DashboardsListener {
//    void getDashBoardSuc(DashBoardsBean dashBoardsBean);
    void getDashBoardSuc(DeviceTypeBean deviceTypeBean);

    void getDashBoardFai();

    void TokenIsEmpty();
}
