package com.device.limaiyun.thingsboard.ui.activity.childactivity.Supervision.child.model;

import com.device.limaiyun.thingsboard.bean.WeKanTitleBean;

import java.util.List;

/**
 * Created by ${Winter} on 2018/9/19.
 */
public interface SupervisionTaskDivisionListener {

    void getTitleSuc(List<WeKanTitleBean> weKanTitleBeans,String url);
    void getTitleFail();
}
