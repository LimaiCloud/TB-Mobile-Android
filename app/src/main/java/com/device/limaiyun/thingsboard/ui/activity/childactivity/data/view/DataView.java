package com.device.limaiyun.thingsboard.ui.activity.childactivity.data.view;

import com.device.limaiyun.thingsboard.base.BaseView;
import com.device.limaiyun.thingsboard.bean.DashBoardsBean;
import com.device.limaiyun.thingsboard.bean.DeviceTypeBean;

/**
 * Created by Administrator on 2018/6/19 0019.
 */

public interface DataView extends BaseView {

//    void showDashBoard(DashBoardsBean dashBoardsBean);
    void showDashBoard(DeviceTypeBean deviceTypeBean);

}
