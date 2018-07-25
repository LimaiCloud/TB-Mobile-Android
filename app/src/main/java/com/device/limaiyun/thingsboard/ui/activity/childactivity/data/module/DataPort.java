package com.device.limaiyun.thingsboard.ui.activity.childactivity.data.module;

import android.content.Context;

/**
 * Created by Administrator on 2018/6/19 0019.
 */

public interface DataPort {
    void getDashBoards(Context mContext, String customerId, String scopes, DashboardsListener listener);
}
