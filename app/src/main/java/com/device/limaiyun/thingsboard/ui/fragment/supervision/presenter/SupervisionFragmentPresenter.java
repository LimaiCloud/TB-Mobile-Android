package com.device.limaiyun.thingsboard.ui.fragment.supervision.presenter;

import com.device.limaiyun.thingsboard.bean.SupervisionDivisionBean;
import com.device.limaiyun.thingsboard.ui.fragment.supervision.model.SupervisionFragmentListener;
import com.device.limaiyun.thingsboard.ui.fragment.supervision.model.SupervisionFragmentModel;
import com.device.limaiyun.thingsboard.ui.fragment.supervision.model.SupervisionFragmentPort;
import com.device.limaiyun.thingsboard.ui.fragment.supervision.view.SupervisionFragmentView;
import com.device.limaiyun.thingsboard.utils.env.Constant;

import java.util.List;

/**
 * Created by ${Winter} on 2018/9/20.
 */
public class SupervisionFragmentPresenter implements SupervisionFragmentListener {
    private SupervisionFragmentView view;
    private SupervisionFragmentPort port;

    public SupervisionFragmentPresenter(SupervisionFragmentView view) {
        this.view = view;
        port = new SupervisionFragmentModel();
    }


    public void getSupervisionData( String url, String id,String token) {
        view.showProgress();
        port.getSupervisionData(url+"/"+id+ Constant.API_CARDS,token,this);
    }

    @Override
    public void getSupervisionDivisionDataSuc(List<SupervisionDivisionBean> supervisionDivisionBeans,String url,String token) {
        view.dismissProgress();
        view.showData(supervisionDivisionBeans,url,token);
    }

    @Override
    public void getSupervisionDivisionDatafail() {
        view.dismissProgress();
        view.dontShowData();
    }

    @Override
    public void putStatusSuc(String url ,String token) {
        view.refreshView(url,token);
        view.dismissProgress();
        //更改状态成功
    }

    @Override
    public void putStatusFail() {
        //更改状态失败
        view.dismissProgress();
    }

    public void putSupervisionStatus(String url,String title,String description, String mtoken, String chiose_id) {
        view.showProgress();
        port.putSupervisionStatus(url,title,description,mtoken,chiose_id,this);
    }

    public void getSupervisionData(String url, String token) {
        port.getSupervisionData(url,token,this);
    }
}
