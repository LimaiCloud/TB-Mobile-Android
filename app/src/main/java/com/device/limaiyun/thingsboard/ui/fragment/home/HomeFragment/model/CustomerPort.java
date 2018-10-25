package com.device.limaiyun.thingsboard.ui.fragment.home.HomeFragment.model;

import android.content.Context;

/**
 * Created by Administrator on 2018/6/25 0025.
 */

public interface CustomerPort {
    void getCustomer();

    void getTitle(Context context,OnWantedListener listener);
}
