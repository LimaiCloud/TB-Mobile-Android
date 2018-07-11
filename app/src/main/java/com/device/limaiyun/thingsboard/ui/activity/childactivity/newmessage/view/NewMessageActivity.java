package com.device.limaiyun.thingsboard.ui.activity.childactivity.newmessage.view;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.LinearLayout;

import com.device.limaiyun.thingsboard.R;
import com.device.limaiyun.thingsboard.adapter.NewMessageAdapter;
import com.device.limaiyun.thingsboard.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/6/13 0013.
 */

public class NewMessageActivity extends BaseActivity {
    @BindView(R.id.recyclerview)
    RecyclerView recyclerView;
    NewMessageAdapter messageAdapter;
    @BindView(R.id.new_toolbar)
    Toolbar toolbar;
    @BindView(R.id.ll_back)
    LinearLayout ll_back;

    @Override
    protected int getLayout() {
        return R.layout.activity_new_message;
    }

    @Override
    public void initView() {
        messageAdapter = new NewMessageAdapter();
    }

    @Override
    public void initData() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(messageAdapter);
    }

    @Override
    public void initImmersionBar() {
        super.initImmersionBar();
        mImmersionBar.titleBar(R.id.new_toolbar).init();
    }
    @OnClick(R.id.ll_back)
    public void finishAc(){
        finish();
    }
}
