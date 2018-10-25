package com.device.limaiyun.thingsboard.ui.activity.childactivity.video.child.videoplay.view;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.ProgressBar;

import com.device.limaiyun.thingsboard.R;
import com.device.limaiyun.thingsboard.base.BaseActivity;
import com.videogo.openapi.EZConstants;
import com.videogo.openapi.EZOpenSDK;
import com.videogo.openapi.EZPlayer;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * Created by ${Winter} on 2018/10/16.
 */
public class VideoPlayActivity extends BaseActivity implements SurfaceHolder.Callback {

    @BindView(R.id.realplay_sv)
    SurfaceView realplay_sv;
    private String accesstoken;

    private SurfaceHolder mRealPlaySh = null;
    private EZPlayer mEZPlayer;
    @BindView(R.id.progressbar)
    ProgressBar progressBar;
    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                //播放成功的回调
                case EZConstants.EZRealPlayConstants.MSG_REALPLAY_PLAY_SUCCESS:
                    break;
                default:
                    break;
            }
        }
    };

    @Override
    protected int getLayout() {
        return R.layout.activity_video_play;
    }

    @Override
    public void initView() {
        progressBar.setVisibility(View.VISIBLE);
        mRealPlaySh = realplay_sv.getHolder();
        mRealPlaySh.addCallback(VideoPlayActivity.this);
        Intent intent = getIntent();
        accesstoken = intent.getStringExtra("accesstoken");
        String deviceSerial = intent.getStringExtra("deviceSerial");
        int channelNo = intent.getIntExtra("channelNo", -1);
        String channelName = intent.getStringExtra("channelName");
        if (accesstoken != null)
        EZOpenSDK.getInstance().setAccessToken(accesstoken);
        mEZPlayer = EZOpenSDK.getInstance().createPlayer(deviceSerial, channelNo);
//        mEZPlayer.setHandler(mHandler);
        mEZPlayer.setSurfaceHold(mRealPlaySh);
        mEZPlayer.startRealPlay();//播放
        progressBar.setVisibility(View.GONE);
    }

    @OnClick(R.id.ll_back)
    public void finAct(){
        finish();
    }

    @Override
    public void initImmersionBar() {
        super.initImmersionBar();
        mImmersionBar.titleBar(R.id.toolbar).init();
    }

    @Override
    protected void onStop() {
        super.onStop();
        //停止直播
        mEZPlayer.stopRealPlay();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mEZPlayer.release();
    }


    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        if (mEZPlayer != null) {

            mEZPlayer.setSurfaceHold(holder);
        } else {

        }
        mRealPlaySh = holder;
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        if (mEZPlayer != null) {
            mEZPlayer.setSurfaceHold(null);
        }
        mRealPlaySh = null;
    }
}
