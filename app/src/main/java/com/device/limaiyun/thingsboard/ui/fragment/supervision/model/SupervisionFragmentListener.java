package com.device.limaiyun.thingsboard.ui.fragment.supervision.model;

import com.device.limaiyun.thingsboard.bean.SupervisionDivisionBean;

import java.util.List;

/**
 * Created by ${Winter} on 2018/9/20.
 */
public interface SupervisionFragmentListener {
    void getSupervisionDivisionDataSuc(List<SupervisionDivisionBean> supervisionDivisionBeans,String url,String token);
    void getSupervisionDivisionDatafail();

    void putStatusSuc(String utl,String token);

    void putStatusFail();
}
