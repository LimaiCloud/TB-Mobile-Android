package com.device.limaiyun.thingsboard.ui.activity.childactivity.data.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.device.limaiyun.thingsboard.R;
import com.device.limaiyun.thingsboard.adapter.DashBoardsAdapter;
import com.device.limaiyun.thingsboard.base.BaseActivity;
import com.device.limaiyun.thingsboard.bean.DeviceTypeBean;
import com.device.limaiyun.thingsboard.ui.activity.childactivity.ThirdActivity.linechart.view.LineChartActivity;
import com.device.limaiyun.thingsboard.ui.activity.childactivity.data.presenter.DataPresenter;
import com.device.limaiyun.thingsboard.utils.ToastUtils;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/5/29 0029.
 */

public class DataActivity extends BaseActivity implements DataView {

    @BindView(R.id.recyclerview)
    RecyclerView recyclerView;
    DashBoardsAdapter boardsAdapter;
    DataPresenter presenter;
    @BindView(R.id.ll_back)
    LinearLayout ll_back;
    private Context mContext;
    private String scopes;
    private String customerId;

    @Override
    protected int getLayout() {
        return R.layout.activity_data;
    }

    @Override
    public void initView() {
        mContext = this;
        presenter = new DataPresenter(this);
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        scopes = extras.getString("scopes");
        customerId = extras.getString("customerId");
    }

    @Override
    public void initData() {
        presenter.getDataDashBoards(mContext,scopes,customerId);
    }

    @Override
    public void initImmersionBar() {
        super.initImmersionBar();
        mImmersionBar.titleBar(R.id.toolbar).init();
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
    public void showDashBoard(final DeviceTypeBean deviceTypeBean) {
        if (deviceTypeBean != null) {
            boardsAdapter = new DashBoardsAdapter(deviceTypeBean);
            recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
            recyclerView.setAdapter(boardsAdapter);

            boardsAdapter.setListener(new DashBoardsAdapter.OnItemClickListener() {
                @Override
                public void OnClickListener(int position) {
                    Intent intent = new Intent(mContext,LineChartActivity.class);
                    intent.putExtra("name",deviceTypeBean.getData().get(position).getName());
                    intent.putExtra("entityId",deviceTypeBean.getData().get(position).getId().getId());
                    startActivity(intent);
                }

                @Override
                public void OnLongClickListener(int position) {
                    ToastUtils.showShortToast("chang");
                }
            });
        }
    }
    @OnClick(R.id.ll_back)
    public void backHome(){
        finish();
    }
}
