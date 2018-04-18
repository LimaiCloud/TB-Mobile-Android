package com.device.limaiyun.thingsboard.ui.fragment.home.MessageFragment.view;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.device.limaiyun.thingsboard.R;
import com.device.limaiyun.thingsboard.base.BaseFragment;
import com.device.limaiyun.thingsboard.base.Configs;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2018/4/16 0016.
 */

public class MessageFragment extends BaseFragment {
    @BindView(R.id.tv_message)
    TextView tvMessage;
    Unbinder unbinder;

    @Override
    protected void setUpData() {
        tvMessage.setText(Configs.BASE_URL);
    }

    @Override
    protected void setUpView() {
    }

    @Override
    protected void init() {

    }

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_msg;
    }


}
