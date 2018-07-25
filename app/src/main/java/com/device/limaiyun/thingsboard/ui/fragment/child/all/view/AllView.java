package com.device.limaiyun.thingsboard.ui.fragment.child.all.view;

import com.device.limaiyun.thingsboard.base.BaseView;
import com.device.limaiyun.thingsboard.bean.DeviceTypeBean;

import java.util.List;

/**
 * Created by Administrator on 2018/5/14 0014.
 */

public interface AllView extends BaseView {
    void showItemData(DeviceTypeBean bean);
    void refreshToken();
}
