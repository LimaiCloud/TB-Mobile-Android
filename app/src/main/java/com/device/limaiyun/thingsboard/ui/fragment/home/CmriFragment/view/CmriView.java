package com.device.limaiyun.thingsboard.ui.fragment.home.CmriFragment.view;

import com.device.limaiyun.thingsboard.base.BaseView;
import com.device.limaiyun.thingsboard.bean.UsersBean;

/**
 * Created by Administrator on 2018/7/5 0005.
 */

public interface CmriView extends BaseView {

    void getCmriSuc(UsersBean usersBean);

    void getCmriFail();
}
