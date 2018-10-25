package com.device.limaiyun.thingsboard.ui.activity.childactivity.Supervision.child.presenter;

import com.device.limaiyun.thingsboard.bean.WeKanTitleBean;
import com.device.limaiyun.thingsboard.ui.activity.childactivity.Supervision.child.model.SupervisionTaskDisivisonModel;
import com.device.limaiyun.thingsboard.ui.activity.childactivity.Supervision.child.model.SupervisionTaskDivisionListener;
import com.device.limaiyun.thingsboard.ui.activity.childactivity.Supervision.child.model.SupervisionTaskDivisionPort;
import com.device.limaiyun.thingsboard.ui.activity.childactivity.Supervision.child.view.SupervisionTaskDivisionView;
import com.device.limaiyun.thingsboard.utils.env.Constant;

import java.util.List;

/**
 * Created by ${Winter} on 2018/9/19.
 */
public class SupervisionTaskDivisionPresenter implements SupervisionTaskDivisionListener {
    private SupervisionTaskDivisionView view;
    private SupervisionTaskDivisionPort port;

    public SupervisionTaskDivisionPresenter(SupervisionTaskDivisionView view) {
        this.view = view;
        port = new SupervisionTaskDisivisonModel();
    }


    public void getTitle( String id,String token) {
        port.getTitle(Constant.API_SUPERVISIONPRESENTER+Constant.API_+Constant.API_WEKAN_BOARDS+"/"+id+Constant.API_WEKAN_LISTS,token,this);
    }

    @Override
    public void getTitleSuc(List<WeKanTitleBean> weKanTitleBeans,String url) {
        view.showPageIndictor(weKanTitleBeans,url);
    }

    @Override
    public void getTitleFail() {

    }
}
