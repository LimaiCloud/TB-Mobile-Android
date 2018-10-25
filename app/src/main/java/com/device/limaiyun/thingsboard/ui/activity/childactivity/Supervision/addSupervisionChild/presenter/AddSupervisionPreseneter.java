package com.device.limaiyun.thingsboard.ui.activity.childactivity.Supervision.addSupervisionChild.presenter;

import com.device.limaiyun.thingsboard.bean.AddSupervisionBean;
import com.device.limaiyun.thingsboard.bean.WeKanTitleBean;
import com.device.limaiyun.thingsboard.ui.activity.childactivity.Supervision.addSupervisionChild.model.AddSupervisionListener;
import com.device.limaiyun.thingsboard.ui.activity.childactivity.Supervision.addSupervisionChild.model.AddSupervisionModel;
import com.device.limaiyun.thingsboard.ui.activity.childactivity.Supervision.addSupervisionChild.model.AddSupervisionPort;
import com.device.limaiyun.thingsboard.ui.activity.childactivity.Supervision.addSupervisionChild.view.AddSupervisionView;
import com.device.limaiyun.thingsboard.utils.ToastUtils;
import com.device.limaiyun.thingsboard.utils.env.Constant;

import java.util.List;

/**
 * Created by ${Winter} on 2018/10/9.
 */
public class AddSupervisionPreseneter implements AddSupervisionListener {
    private AddSupervisionView view;
    private AddSupervisionPort port;

    public AddSupervisionPreseneter(AddSupervisionView view) {
        this.view = view;
        port=new AddSupervisionModel();
    }

    public void getTitles(String board_id, String wekan_token) {
        port.getSupervisionTitles(Constant.API_SUPERVISIONPRESENTER+Constant.API_+Constant.API_WEKAN_BOARDS+"/"+board_id+Constant.API_WEKAN_LISTS,wekan_token,this);
    }

    @Override
    public void getTitleSuc(List<WeKanTitleBean> weKanTitleBeans,String url) {
        view.showPupWindow(weKanTitleBeans,url);
    }

    @Override
    public void getTitleFail() {

    }

    @Override
    public void postAddSupervisionSuc(AddSupervisionBean bean) {
        view.dismissProgressBar();
        view.finishAct(bean);
    }

    @Override
    public void postAddSupervisionFail() {
        view.dismissProgressBar();
        ToastUtils.showShortToast("添加任务失败");
    }

    public void addSupervision(String title, String description,String booard_url, String list_id,String user_id,String token) {
        port.postAddSupervision(title,description,booard_url+"/"+list_id+Constant.API_CARDS,list_id,user_id,token,this);
    }
}
