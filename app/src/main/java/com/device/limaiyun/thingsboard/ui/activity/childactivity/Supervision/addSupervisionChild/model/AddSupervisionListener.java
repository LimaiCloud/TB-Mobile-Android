package com.device.limaiyun.thingsboard.ui.activity.childactivity.Supervision.addSupervisionChild.model;

import com.device.limaiyun.thingsboard.bean.AddSupervisionBean;
import com.device.limaiyun.thingsboard.bean.WeKanTitleBean;

import java.util.List;

/**
 * Created by ${Winter} on 2018/10/9.
 */
public interface AddSupervisionListener {
    void getTitleSuc(List<WeKanTitleBean> weKanTitleBeans,String url);
    void getTitleFail();

    void postAddSupervisionSuc(AddSupervisionBean bean);
    void postAddSupervisionFail();
}
