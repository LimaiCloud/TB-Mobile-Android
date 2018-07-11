package com.device.limaiyun.thingsboard.ui.fragment.child.all.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ListView;

import com.device.limaiyun.thingsboard.R;
import com.device.limaiyun.thingsboard.adapter.AllAdapter;
import com.device.limaiyun.thingsboard.base.BaseFragment;
import com.device.limaiyun.thingsboard.bean.DeviceTypeBean;
import com.device.limaiyun.thingsboard.ui.activity.childactivity.equipment.child.view.EquipmentDetilActivity;
import com.device.limaiyun.thingsboard.ui.fragment.child.all.model.AllModel;
import com.device.limaiyun.thingsboard.ui.fragment.child.all.presenter.AllPresenter;
import com.device.limaiyun.thingsboard.utils.ToastUtils;

import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2018/5/11 0011.
 */

public class AllFragment extends BaseFragment implements AllView {
    @BindView(R.id.re_all)
    RecyclerView re_all;
    private AllAdapter adapter;
    private AllPresenter mAllPresenter;
    private Context mContext;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getContext();
    }

    @Override
    public void setUpData() {
        mAllPresenter.getDeviceType();
    }

    @Override
    public void setUpView() {

    }


    @Override
    public void init() {
        mAllPresenter = new AllPresenter(this);
    }

    @Override
    public int getFragmentLayout() {
        return R.layout.all_fragment;
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
    public void showItemData(final DeviceTypeBean bean) {
        adapter = new AllAdapter( bean.getData());
        re_all.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        re_all.setAdapter(adapter);

        adapter.setListener(new AllAdapter.OnItemClickListener() {
            @Override
            public void setOnClickListener(int position) {
                Intent intent = new Intent(mContext,EquipmentDetilActivity.class);
                intent.putExtra("entityid",bean.getData().get(position).getId().getId());
                startActivity(intent);
            }

            @Override
            public void setOnLongClickListener(int position) {
            }
        });
    }


}
