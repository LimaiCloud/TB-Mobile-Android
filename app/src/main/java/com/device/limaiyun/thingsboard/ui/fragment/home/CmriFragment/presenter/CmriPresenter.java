package com.device.limaiyun.thingsboard.ui.fragment.home.CmriFragment.presenter;

import android.media.session.MediaSession;

import com.device.limaiyun.thingsboard.base.BasePresenter;
import com.device.limaiyun.thingsboard.bean.TokenBean;
import com.device.limaiyun.thingsboard.bean.UsersBean;
import com.device.limaiyun.thingsboard.ui.fragment.home.CmriFragment.model.CmriListener;
import com.device.limaiyun.thingsboard.ui.fragment.home.CmriFragment.model.CmriModel;
import com.device.limaiyun.thingsboard.ui.fragment.home.CmriFragment.model.CmriPort;
import com.device.limaiyun.thingsboard.ui.fragment.home.CmriFragment.view.CmriView;

/**
 * Created by Administrator on 2018/7/5 0005.
 */

public class CmriPresenter extends BasePresenter implements CmriListener {
    private CmriView view;
    private CmriPort port;

    public CmriPresenter(CmriView view) {
        this.view = view;
        port = new CmriModel();
    }


    public void getCmri() {
        port.getCmri(TokenBean.TOKEN,this);
    }

    @Override
    public void getCmriSuc(UsersBean usersBean) {
        view.getCmriSuc(usersBean);
    }

    @Override
    public void getCmriFail() {
        view.getCmriFail();
    }
}
