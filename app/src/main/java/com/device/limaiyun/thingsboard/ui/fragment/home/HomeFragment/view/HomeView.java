package com.device.limaiyun.thingsboard.ui.fragment.home.HomeFragment.view;

import com.device.limaiyun.thingsboard.bean.WantedBean;

import java.util.List;

/**
 * Created by Administrator on 2018/6/25 0025.
 */

public interface HomeView {
    void initCustomerSuc();

    void initCustomerFail();

    void getWantedTitle(List<WantedBean> wantedBean);
}
