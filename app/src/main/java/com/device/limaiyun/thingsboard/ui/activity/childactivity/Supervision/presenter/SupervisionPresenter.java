package com.device.limaiyun.thingsboard.ui.activity.childactivity.Supervision.presenter;

import com.device.limaiyun.thingsboard.base.BasePresenter;
import com.device.limaiyun.thingsboard.bean.WeKanBoardBean;
import com.device.limaiyun.thingsboard.ui.activity.childactivity.Supervision.model.SupervisionListener;
import com.device.limaiyun.thingsboard.ui.activity.childactivity.Supervision.model.SupervisionModel;
import com.device.limaiyun.thingsboard.ui.activity.childactivity.Supervision.model.SupervisionProt;
import com.device.limaiyun.thingsboard.ui.activity.childactivity.Supervision.view.SupervisionView;
import com.device.limaiyun.thingsboard.utils.env.Constant;

import java.util.List;

/**
 * Created by ${Winter} on 2018/9/11.
 */
public class SupervisionPresenter extends BasePresenter implements SupervisionListener {
    private SupervisionProt prot;
    private SupervisionView view;

    public SupervisionPresenter(SupervisionView view) {
        this.view = view;
        prot = new SupervisionModel();
    }

    public void getUserToken(String username, String password) {
        prot.getUserToken(Constant.API_SUPERVISIONPRESENTER + Constant.API_SUPERVISIONPRESENTER_LOGIN, username, password, this);
    }

    @Override
    public void getWeKanUserTokenSuc(String userid, String token) {
        view.getBoards(userid, token);
    }

    @Override
    public void getWeKanUserTokenFail() {

    }

    public void getUserBoards(String userid, String token) {
        prot.getUserBoard(Constant.API_SUPERVISIONPRESENTER + Constant.API_WEKAN_USERS, userid, token, this);
    }

    @Override
    public void showBoardsSuc(List<WeKanBoardBean> weKanBoardBeans) {
        view.showBoards(weKanBoardBeans);
    }

    @Override
    public void showBoardFail() {

    }

}
