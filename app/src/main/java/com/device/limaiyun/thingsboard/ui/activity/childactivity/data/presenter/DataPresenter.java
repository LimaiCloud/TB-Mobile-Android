package com.device.limaiyun.thingsboard.ui.activity.childactivity.data.presenter;

import com.device.limaiyun.thingsboard.base.BasePresenter;
import com.device.limaiyun.thingsboard.bean.DashBoardsBean;
import com.device.limaiyun.thingsboard.bean.DeviceTypeBean;
import com.device.limaiyun.thingsboard.ui.activity.childactivity.data.module.DashboardsListener;
import com.device.limaiyun.thingsboard.ui.activity.childactivity.data.module.DataModel;
import com.device.limaiyun.thingsboard.ui.activity.childactivity.data.module.DataPort;
import com.device.limaiyun.thingsboard.ui.activity.childactivity.data.view.DataView;

/**
 * Created by Administrator on 2018/6/19 0019.
 */

public class DataPresenter extends BasePresenter implements DashboardsListener {
    private DataView view;
    private DataPort port;

    public DataPresenter(DataView view) {
        this.view = view;
        port = new DataModel();

    }

    public void getDataDashBoards() {
        port.getDashBoards(this);
    }


    @Override
    public void getDashBoardSuc(DeviceTypeBean deviceTypeBean) {
        view.showDashBoard(deviceTypeBean);
    }

    @Override
    public void getDashBoardFai() {

    }

    @Override
    public void TokenIsEmpty() {

    }
}
