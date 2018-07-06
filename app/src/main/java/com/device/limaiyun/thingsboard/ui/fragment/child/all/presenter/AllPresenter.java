package com.device.limaiyun.thingsboard.ui.fragment.child.all.presenter;

import android.support.v7.widget.LinearLayoutManager;

import com.device.limaiyun.thingsboard.base.BasePresenter;
import com.device.limaiyun.thingsboard.bean.DeviceTypeBean;
import com.device.limaiyun.thingsboard.ui.fragment.child.all.model.AllModel;
import com.device.limaiyun.thingsboard.ui.fragment.child.all.model.AllPort;
import com.device.limaiyun.thingsboard.ui.fragment.child.all.model.OnDeviceTypeListener;
import com.device.limaiyun.thingsboard.ui.fragment.child.all.view.AllView;
import com.device.limaiyun.thingsboard.utils.ToastUtils;

import java.util.List;

/**
 * Created by Administrator on 2018/5/14 0014.
 */

public class AllPresenter extends BasePresenter implements OnDeviceTypeListener{
    private AllView mAllView;
    private AllPort mAllPort;

    public AllPresenter(AllView allView) {
        this.mAllView = allView;
        mAllPort = new AllModel();
    }


    public void getDeviceType() {
        mAllPort.getDevuceType(this);
    }


    @Override
    public void getDeviceTypeSuccess(DeviceTypeBean bean) {
        mAllView.showItemData(bean);
        ToastUtils.showShortToast("获取数据成功");
    }

    @Override
    public void getDeviceTypeFaild() {
        ToastUtils.showShortToast("获取数据失败");
    }
}
