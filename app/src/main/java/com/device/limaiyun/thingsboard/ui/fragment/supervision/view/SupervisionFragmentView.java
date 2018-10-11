package com.device.limaiyun.thingsboard.ui.fragment.supervision.view;

import com.device.limaiyun.thingsboard.bean.SupervisionDivisionBean;

import java.util.List; /**
 * Created by ${Winter} on 2018/9/20.
 */
public interface SupervisionFragmentView {

    void showData(List<SupervisionDivisionBean> supervisionDivisionBeans,String url,String token);

    void dontShowData();

    void showProgress();

    void dismissProgress();

    void refreshView(String url,String token);
}
