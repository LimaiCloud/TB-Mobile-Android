package com.device.limaiyun.thingsboard.ui.fragment.child.all.model;

import com.device.limaiyun.thingsboard.bean.DeviceTypeBean;

import java.util.List;

/**
 * Created by Administrator on 2018/5/10 0010.
 */

public interface OnDeviceTypeListener {
    void getDeviceTypeSuccess(DeviceTypeBean datas);

    void getDeviceTypeFaild();
}
