package com.device.limaiyun.thingsboard.ui.activity.childactivity.video.view;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.device.limaiyun.thingsboard.R;
import com.device.limaiyun.thingsboard.adapter.VideoMonitorListAdapter;
import com.device.limaiyun.thingsboard.base.BaseActivity;
import com.device.limaiyun.thingsboard.base.Configs;
import com.device.limaiyun.thingsboard.bean.YSAccessTokenBean;
import com.device.limaiyun.thingsboard.bean.YSVideoListBean;
import com.device.limaiyun.thingsboard.ui.activity.childactivity.video.child.videoplay.view.VideoPlayActivity;
import com.device.limaiyun.thingsboard.ui.activity.childactivity.video.presenter.VideoPresenter;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by ${Winter} on 2018/10/16.
 */
public class VideoActivity extends BaseActivity implements VideoMonitroView{

    @BindView(R.id.rv_video)
    RecyclerView rv_video;
    private VideoPresenter presenter;
    private Context mContext;
    @BindView(R.id.progressbar)
    ProgressBar progressBar;

    @Override
    protected int getLayout() {
        return R.layout.activity_video;
    }

    @Override
    public void initImmersionBar() {
        super.initImmersionBar();
        mImmersionBar.titleBar(R.id.toolbar).init();
    }

    @Override
    public void initView() {
        mContext = this;
        presenter = new VideoPresenter(this);
    }

    @OnClick(R.id.ll_back)
    public void finAct(){
        finish();
    }

    @Override
    public void initData() {
        presenter.getAccessToken(Configs.YS_APP_KEY,Configs.YS_APP_SERCET);
    }


    @Override
    public void preparShowVideoMonitorList(YSAccessTokenBean accessTokenBean) {
        presenter.getVideoMonitorList(accessTokenBean);
    }

    @Override
    public void showVideoMonitorList(final YSVideoListBean ysVideoListBean, final YSAccessTokenBean ysAccessTokenBean) {
        VideoMonitorListAdapter listAdapter = new VideoMonitorListAdapter(this,ysVideoListBean);
        rv_video.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        rv_video.setAdapter(listAdapter);
        listAdapter.setOnItemClickListener(new VideoMonitorListAdapter.OnItemClickListener() {
            @Override
            public void OnClickListener(int position) {
                Intent intent = new Intent(mContext,VideoPlayActivity.class);
                intent.putExtra("accesstoken",ysAccessTokenBean.getData().getAccessToken());
                intent.putExtra("deviceSerial",ysVideoListBean.getData().get(position).getDeviceSerial());
                intent.putExtra("channelNo",ysVideoListBean.getData().get(position).getChannelNo());
                intent.putExtra("channelName",ysVideoListBean.getData().get(position).getChannelName());
                startActivity(intent);
            }

            @Override
            public void OnLongCLickListener(int position) {

            }
        });
    }

    @Override
    public void dismissProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }
}
