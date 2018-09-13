package com.device.limaiyun.thingsboard.ui.activity.childactivity.Supervision.model;

import com.device.limaiyun.thingsboard.bean.WeKanBoardBean;

import java.util.List;

/**
 * Created by ${Winter} on 2018/9/11.
 */
public interface SupervisionListener {

    void getWeKanUserTokenSuc(String userid,String token);

    void getWeKanUserTokenFail();

    void showBoardsSuc( List<WeKanBoardBean> weKanBoardBeans);

    void showBoardFail();
}
