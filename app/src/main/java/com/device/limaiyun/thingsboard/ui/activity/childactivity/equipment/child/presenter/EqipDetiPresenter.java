package com.device.limaiyun.thingsboard.ui.activity.childactivity.equipment.child.presenter;

import com.device.limaiyun.thingsboard.bean.EquipmentDetialBean;
import com.device.limaiyun.thingsboard.ui.activity.childactivity.equipment.child.model.EqipDetiModel;
import com.device.limaiyun.thingsboard.ui.activity.childactivity.equipment.child.model.EqipDetiPort;
import com.device.limaiyun.thingsboard.ui.activity.childactivity.equipment.child.model.EquipDetilListener;
import com.device.limaiyun.thingsboard.ui.activity.childactivity.equipment.child.view.EqipmentDetiView;

/**
 * Created by Administrator on 2018/6/27 0027.
 */

public class EqipDetiPresenter implements EquipDetilListener{
    private EqipmentDetiView view;
    private EqipDetiPort port;

    public EqipDetiPresenter(EqipmentDetiView view) {
        this.view = view;
        port = new EqipDetiModel();
    }

    public void getNewDetial(String id) {
//        view.showLoading();
        port.getNewDetial(id,this);
    }

    @Override
    public void getNewDetilOnSuc(EquipmentDetialBean bean) {
//        view.hinddenLoading();
//        view.showToast("获取成功");
        view.getNewDetilMessageSuc(bean);
    }

    @Override
    public void getNewDetilOnFail() {
//        view.hinddenLoading();
//        view.showToast("获取失败");
    }
}
