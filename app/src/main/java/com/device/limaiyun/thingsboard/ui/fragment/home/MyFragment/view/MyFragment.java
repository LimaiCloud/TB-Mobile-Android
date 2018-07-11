package com.device.limaiyun.thingsboard.ui.fragment.home.MyFragment.view;

import android.content.Context;
import android.content.Intent;
import android.widget.RelativeLayout;

import com.device.limaiyun.thingsboard.R;
import com.device.limaiyun.thingsboard.base.BaseFragment;
import com.device.limaiyun.thingsboard.ui.activity.childactivity.ThirdActivity.set.view.SettingActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/4/16 0016.
 */

public class MyFragment extends BaseFragment {

    @BindView(R.id.rl_setting)
    RelativeLayout rl_setting;
    @BindView(R.id.rl_edit)
    RelativeLayout rl_edit;
    private Context mContext;

    @Override
    public void setUpData() {

    }

    @Override
    public void setUpView() {
        mContext = getContext();
    }

    @Override
    public void init() {

    }

    @Override
    public int getFragmentLayout() {
        return R.layout.fragment_my;
    }

    @OnClick(R.id.rl_setting)
    public void setAct(){
        Intent intent = new Intent(mContext, SettingActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.rl_edit)
    public void editAct(){

    }
}
