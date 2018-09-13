package com.device.limaiyun.thingsboard.ui.activity.childactivity.Supervision.view;

import com.device.limaiyun.thingsboard.bean.WeKanBoardBean;

import java.util.List;

/**
 * Created by ${Winter} on 2018/9/11.
 */
public interface SupervisionView {

    void getBoards(String userid,String token);
    void showBoards( List<WeKanBoardBean> weKanBoardBean);
}
