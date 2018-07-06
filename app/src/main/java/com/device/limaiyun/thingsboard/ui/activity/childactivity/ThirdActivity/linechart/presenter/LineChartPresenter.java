package com.device.limaiyun.thingsboard.ui.activity.childactivity.ThirdActivity.linechart.presenter;

import com.device.limaiyun.thingsboard.base.BasePresenter;
import com.device.limaiyun.thingsboard.ui.activity.childactivity.ThirdActivity.linechart.model.LineChartListener;
import com.device.limaiyun.thingsboard.ui.activity.childactivity.ThirdActivity.linechart.model.LineChartModel;
import com.device.limaiyun.thingsboard.ui.activity.childactivity.ThirdActivity.linechart.model.LineChartPort;
import com.device.limaiyun.thingsboard.ui.activity.childactivity.ThirdActivity.linechart.view.LineChartView;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/7/3 0003.
 */

public class LineChartPresenter extends BasePresenter implements LineChartListener {

    private LineChartView view;
    private LineChartPort port;

    public LineChartPresenter(LineChartView view) {
        this.view = view;
        port = new LineChartModel();
    }


    public void getDashBoardDetil(String entityId) {
        port.getDashBoardDetil(entityId,this);
    }


    @Override
    public void getEtcSuc(List<String> title, List<List<Map<Long, String>>> listList) {
        view.showEtcLinChart(title,listList);
    }

    @Override
    public void getCountSuc(List<String> title, List<List<Map<Long, String>>> listList) {
        view.showCountLinChart(title,listList);
    }

    @Override
    public void getDashBoardDetilFail() {
        view.showEmpty();
    }
}
