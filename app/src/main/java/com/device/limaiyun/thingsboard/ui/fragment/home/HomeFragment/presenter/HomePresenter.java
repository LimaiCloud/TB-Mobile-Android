package com.device.limaiyun.thingsboard.ui.fragment.home.HomeFragment.presenter;

import com.device.limaiyun.thingsboard.base.BasePresenter;
import com.device.limaiyun.thingsboard.ui.fragment.home.HomeFragment.model.CustomerModel;
import com.device.limaiyun.thingsboard.ui.fragment.home.HomeFragment.model.CustomerPort;
import com.device.limaiyun.thingsboard.ui.fragment.home.HomeFragment.view.HomeView;

/**
 * Created by Administrator on 2018/6/25 0025.
 */

public class HomePresenter extends BasePresenter {

    private CustomerPort port;
    private HomeView view;

    public HomePresenter(HomeView view) {
        this.view = view;
        port = new CustomerModel();
    }
}
