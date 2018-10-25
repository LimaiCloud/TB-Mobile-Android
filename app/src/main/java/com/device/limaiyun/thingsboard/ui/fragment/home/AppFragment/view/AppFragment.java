package com.device.limaiyun.thingsboard.ui.fragment.home.AppFragment.view;

import android.support.v7.widget.Toolbar;
import android.widget.RelativeLayout;

import com.device.limaiyun.thingsboard.R;
import com.device.limaiyun.thingsboard.base.BaseFragment;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/4/16 0016.
 */

public class AppFragment extends BaseFragment {

    @BindView(R.id.rl_ar)
    RelativeLayout rl_ar;
    @BindView(R.id.rl_intelligent)
    RelativeLayout rl_intelligent;
    @BindView(R.id.rl_analy)
    RelativeLayout rl_analy;
    @BindView(R.id.rl_dm)
    RelativeLayout rl_dm;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    public void setUpData() {

    }

    @Override
    public void setUpView() {

    }

    @Override
    public void init() {

    }

    @Override
    protected void initImmersionBar() {
        super.initImmersionBar();
        mImmersionBar.titleBar(toolbar)
                .init();
    }

    @Override
    public int getFragmentLayout() {
        return R.layout.fragment_app;
    }

    @OnClick(R.id.rl_ar)
    public void vrAct() {

    }

    @OnClick(R.id.rl_intelligent)
    public void intellAct() {

    }

    @OnClick(R.id.rl_analy)
    public void analyAct() {

    }

    @OnClick(R.id.rl_dm)
    public void dmAct() {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mImmersionBar != null)
            mImmersionBar.destroy();
    }

    @Override
    protected void lazyLoad() {

    }
}
