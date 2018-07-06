package com.device.limaiyun.thingsboard.ui.activity.childactivity.data.module;

import com.device.limaiyun.thingsboard.bean.DashBoardsBean;

/**
 * Created by Administrator on 2018/6/19 0019.
 */

public interface DataPort {
    void getDashBoards(DashboardsListener listener);
}
