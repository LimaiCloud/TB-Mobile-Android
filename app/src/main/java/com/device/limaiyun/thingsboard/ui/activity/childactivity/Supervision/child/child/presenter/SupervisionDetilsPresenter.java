package com.device.limaiyun.thingsboard.ui.activity.childactivity.Supervision.child.child.presenter;

import com.device.limaiyun.thingsboard.base.BasePresenter;
import com.device.limaiyun.thingsboard.bean.SupervisionDetilsBean;
import com.device.limaiyun.thingsboard.ui.activity.childactivity.Supervision.child.child.model.SupervisionDetilsListener;
import com.device.limaiyun.thingsboard.ui.activity.childactivity.Supervision.child.child.model.SupervisionDetilsModel;
import com.device.limaiyun.thingsboard.ui.activity.childactivity.Supervision.child.child.model.SupervisionDetilsPort;
import com.device.limaiyun.thingsboard.ui.activity.childactivity.Supervision.child.child.view.SupervisionDetilsView;

/**
 * Created by ${Winter} on 2018/9/29.
 */
public class SupervisionDetilsPresenter extends BasePresenter implements SupervisionDetilsListener {
    private SupervisionDetilsView view;
    private SupervisionDetilsPort port;

    public SupervisionDetilsPresenter(SupervisionDetilsView view) {
        this.view = view;
        port = new SupervisionDetilsModel();
    }


    public void getCardDetilContent(String url, String card_id, String token) {
        view.showProgress();
        port.getCardDetis(url + "/" + card_id, token,this);
    }

    @Override
    public void getSupervisionDetilsSuc(SupervisionDetilsBean supervisionDetilsBean) {
        view.showDetils(supervisionDetilsBean);
        view.dissmisProgress();
    }

    @Override
    public void getSupervisionDetilsFail() {
        view.dissmisProgress();
    }
}