package com.device.limaiyun.thingsboard.ui.activity.childactivity.equipment.child.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.device.limaiyun.thingsboard.R;
import com.device.limaiyun.thingsboard.adapter.DetilAdapter;
import com.device.limaiyun.thingsboard.base.BaseActivity;
import com.device.limaiyun.thingsboard.bean.EquipmentDetialBean;
import com.device.limaiyun.thingsboard.ui.activity.childactivity.equipment.child.presenter.EqipDetiPresenter;
import com.device.limaiyun.thingsboard.utils.SpacesItemDecoration;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * Created by Administrator on 2018/6/26 0026.
 */

public class EquipmentDetilActivity extends BaseActivity implements EqipmentDetiView {


    private String entityid;
    private EqipDetiPresenter presenter;
    @BindView(R.id.tv_empty)
    TextView tv_empty;
    @BindView(R.id.ll_back)
    LinearLayout ll_back;
    @BindView(R.id.detil_recyclerView)
    RecyclerView recyclerview;
//    @BindView(R.id.progressbar)
//    ProgressBar progressBar;
    private DetilAdapter adapter;
    private Context mContext;

    @Override
    protected int getLayout() {
        return R.layout.activity_equipment_detil;
    }

    @Override
    public void initView() {
        Intent intent = getIntent();
        Bundle b = intent.getExtras();
        entityid = b.getString("entityid");
        Log.e("---------", entityid);
        presenter = new EqipDetiPresenter(this);
        mContext = this;
    }

    @Override
    public void initImmersionBar() {
        super.initImmersionBar();
        mImmersionBar.titleBar(R.id.toolbar).init();
    }

    @Override
    public void initData() {
        if (entityid != null && !entityid.equals("")) {
            new Thread() {
                @Override
                public void run() {
                    super.run();
                    presenter.getNewDetial(entityid);
                }
            }.start();
        }
    }

    @Override
    public void getNewDetilMessageSuc(final EquipmentDetialBean bean) {
        if (bean.getData().getKey().size() == 0) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    tv_empty.setVisibility(View.VISIBLE);
                }
            });
        } else if (bean.getData().getKey().size() > 0) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    adapter = new DetilAdapter(bean.getData());
                    LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
                    layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                    recyclerview.setLayoutManager(layoutManager);
//                    recyclerview.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));
                    recyclerview.setAdapter(adapter);
                    recyclerview.addItemDecoration(new SpacesItemDecoration(40));
                }
            });
        }
    }

    @Override
    public void getNewDetilMessageFail() {

    }

    @OnClick(R.id.ll_back)
    public void finishAct() {
        finish();
    }

//    @Override
//    public void showToast(String msg) {
//        ToastUtils.showLongToast(msg);
//    }
//
//    @Override
//    public void showLoading() {
////        progressBar.setVisibility(View.VISIBLE);
//    }
//
//    @Override
//    public void hinddenLoading() {
////        progressBar.setVisibility(View.GONE);
//    }
}
