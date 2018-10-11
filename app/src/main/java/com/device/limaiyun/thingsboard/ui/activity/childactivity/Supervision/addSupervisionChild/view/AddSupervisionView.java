package com.device.limaiyun.thingsboard.ui.activity.childactivity.Supervision.addSupervisionChild.view;

import com.device.limaiyun.thingsboard.bean.AddSupervisionBean;
import com.device.limaiyun.thingsboard.bean.WeKanTitleBean;

import java.util.List;

/**
 * Created by ${Winter} on 2018/10/9.
 */
public interface AddSupervisionView {

    void showProgressBar();


    void dismissProgressBar();

    void showPupWindow(List<WeKanTitleBean> weKanTitleBeans, String url);


    void finishAct(AddSupervisionBean bean);
}
