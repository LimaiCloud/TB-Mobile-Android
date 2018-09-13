package com.device.limaiyun.thingsboard.ui.fragment.home.HomeFragment.presenter;

import android.content.Context;

import com.device.limaiyun.thingsboard.base.BasePresenter;
import com.device.limaiyun.thingsboard.bean.WantedBean;
import com.device.limaiyun.thingsboard.ui.fragment.home.HomeFragment.model.CustomerModel;
import com.device.limaiyun.thingsboard.ui.fragment.home.HomeFragment.model.CustomerPort;
import com.device.limaiyun.thingsboard.ui.fragment.home.HomeFragment.model.OnWantedListener;
import com.device.limaiyun.thingsboard.ui.fragment.home.HomeFragment.view.HomeView;

import java.util.List;

/**
 * Created by Administrator on 2018/6/25 0025.
 */

public class HomePresenter extends BasePresenter implements OnWantedListener {

    private CustomerPort port;
    private HomeView view;

    public HomePresenter(HomeView view) {
        this.view = view;
        port = new CustomerModel();
    }

    public void getTitle(Context context) {
        port.getTitle(context,this);
    }

    @Override
    public void getWantedSuc(List<WantedBean> wantedBean) {
        view.getWantedTitle(wantedBean);
    }

    @Override
    public void getWantedFail() {

    }
}
