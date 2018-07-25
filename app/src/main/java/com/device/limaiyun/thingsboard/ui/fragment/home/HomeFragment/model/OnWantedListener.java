package com.device.limaiyun.thingsboard.ui.fragment.home.HomeFragment.model;

import com.device.limaiyun.thingsboard.bean.WantedBean;

import java.util.List;

/**
 * Created by ${Winter} on 2018/7/20.
 */
public interface OnWantedListener {
    void getWantedSuc(List<WantedBean> wantedBean);
    void getWantedFail();
}
