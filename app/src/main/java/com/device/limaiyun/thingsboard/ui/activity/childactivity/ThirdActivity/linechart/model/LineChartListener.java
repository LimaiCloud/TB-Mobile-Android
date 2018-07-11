package com.device.limaiyun.thingsboard.ui.activity.childactivity.ThirdActivity.linechart.model;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/7/3 0003.
 */

public interface LineChartListener {

    void getEtcSuc(List<String> title,List<List<Map<Long,String>>> listList);
    void getCountSuc(List<String> title,List<List<Map<Long,String>>> listList);
    void getDashBoardDetilFail();
}
