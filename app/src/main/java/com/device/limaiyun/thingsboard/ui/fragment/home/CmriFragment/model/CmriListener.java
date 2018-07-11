package com.device.limaiyun.thingsboard.ui.fragment.home.CmriFragment.model;

import com.device.limaiyun.thingsboard.bean.UsersBean;

/**
 * Created by Administrator on 2018/7/5 0005.
 */

public interface CmriListener {

    void getCmriSuc(UsersBean usersBean);
    void getCmriFail();
}
