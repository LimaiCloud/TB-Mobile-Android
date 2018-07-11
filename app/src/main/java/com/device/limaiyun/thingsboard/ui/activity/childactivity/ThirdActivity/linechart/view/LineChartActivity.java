package com.device.limaiyun.thingsboard.ui.activity.childactivity.ThirdActivity.linechart.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.device.limaiyun.thingsboard.R;
import com.device.limaiyun.thingsboard.adapter.LineEtcAdapter;
import com.device.limaiyun.thingsboard.base.BaseActivity;
import com.device.limaiyun.thingsboard.ui.activity.childactivity.ThirdActivity.linechart.presenter.LineChartPresenter;

import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/7/3 0003.
 */

public class LineChartActivity extends BaseActivity implements LineChartView {

    private Context mContext;
    @BindView(R.id.tv_line_chart_title)
    TextView tv_title;
    private LineChartPresenter presenter;
    private String entityId;
    @BindView(R.id.ll_back)
    LinearLayout ll_back;
    @BindView(R.id.listview_etc)
    ListView listview_etc;
    @BindView(R.id.listview_count)
    ListView listview_count;
    private LineEtcAdapter etcAdapter;
    @BindView(R.id.tv_empty)
    TextView tv_empty;

    @Override
    protected int getLayout() {
        return R.layout.activity_line_chart;
    }

    @Override
    public void initView() {

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String name = bundle.getString("name");
        entityId = bundle.getString("entityId");
        if (name != null) {
            tv_title.setText(name);
        }
        presenter = new LineChartPresenter(this);
        mContext = this;
    }

    @Override
    public void initData() {
        new Thread() {
            @Override
            public void run() {
                super.run();
                if (entityId != null && !entityId.equals("")) {

                    presenter.getDashBoardDetil(entityId);
                }
            }
        }.start();
    }

    @Override
    public void initImmersionBar() {
        super.initImmersionBar();
        mImmersionBar.titleBar(R.id.toolbar).init();
    }

    @OnClick(R.id.ll_back)
    public void finishAct() {
        finish();
    }

    @Override
    public void showToast(String msg) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hinddenLoading() {

    }

    @Override
    public void showEtcLinChart(final List<String> title, final List<List<Map<Long, String>>> list) {
        if (list != null) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    etcAdapter = new LineEtcAdapter(mContext, title, list);
                    listview_etc.setAdapter(etcAdapter);
                }
            });
        }
    }

    @Override
    public void showCountLinChart(final List<String> title, final List<List<Map<Long, String>>> list) {
        if (list != null) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    etcAdapter = new LineEtcAdapter(mContext, title, list);
                    listview_count.setAdapter(etcAdapter);
                }
            });
        }
    }

    @Override
    public void showEmpty() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {

                tv_empty.setVisibility(View.VISIBLE);
            }
        });
    }
}
