package com.device.limaiyun.thingsboard.ui.fragment.home.MyFragment.view;

import android.content.Context;
import android.content.Intent;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.auth0.android.jwt.JWT;
import com.device.limaiyun.thingsboard.R;
import com.device.limaiyun.thingsboard.base.BaseFragment;
import com.device.limaiyun.thingsboard.bean.TokenBean;
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
    @BindView(R.id.tv_email)
    TextView textEmail;
    private String subject;

    @Override
    public void setUpData() {

    }

    @Override
    public void setUpView() {
        mContext = getContext();
        if (subject != null && !subject.equals("")){
            textEmail.setText(subject);
        }
    }

    @Override
    public void init() {
        JWT jwt = new JWT(TokenBean.getInstence().getToken());
        subject = jwt.getSubject();
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
