package com.device.limaiyun.thingsboard.ui.activity.childactivity.ThirdActivity.linechart.view;

import com.device.limaiyun.thingsboard.base.BaseView;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/7/3 0003.
 */

public interface LineChartView extends BaseView {


    void showEtcLinChart(List<String> title,List<List<Map<Long, String>>> data);

    void showCountLinChart(List<String> title, List<List<Map<Long, String>>> list);

    void showEmpty();

    void getTimeSuc(String lTime);
}