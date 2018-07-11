package com.device.limaiyun.thingsboard.ui.fragment.home.CmriFragment.view;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.device.limaiyun.thingsboard.R;
import com.device.limaiyun.thingsboard.adapter.CmriAdapter;
import com.device.limaiyun.thingsboard.base.BaseFragment;
import com.device.limaiyun.thingsboard.bean.UsersBean;
import com.device.limaiyun.thingsboard.ui.fragment.home.CmriFragment.presenter.CmriPresenter;
import com.device.limaiyun.thingsboard.utils.PinyinComparator;
import com.device.limaiyun.thingsboard.utils.PinyinUtils;
import com.device.limaiyun.thingsboard.utils.SlideBar;
import com.device.limaiyun.thingsboard.utils.TitleItemDecoration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2018/4/16 0016.
 */

public class CmriFragment extends BaseFragment implements CmriView {

    private static final int ADDRESS_BOOK_OK = 1;
    private CmriPresenter presenter;
    @BindView(R.id.cmr_recyclerview)
    RecyclerView cmr_recyView;
    @BindView(R.id.sidrbar)
    SlideBar slideBar;
    private List<UsersBean.DataBean> name_beans;
    private CmriAdapter cmriAdapter;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case ADDRESS_BOOK_OK:
                    Bundle bundle = (Bundle) msg.obj;
                    UsersBean usersBean = (UsersBean) bundle.get("obj");
                    Collections.sort(name_beans,new PinyinComparator());
                    cmriAdapter = new CmriAdapter(getContext(),name_beans,usersBean);
                    decoration = new TitleItemDecoration(getContext(), name_beans);
                    cmr_recyView.addItemDecoration(decoration);
                    cmr_recyView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
                    cmr_recyView.setAdapter(cmriAdapter);
                    cmriAdapter.setOnClickListener(new CmriAdapter.OnClickListener() {
                        @Override
                        public void onItemCLickListener(int position) {

                        }

                        @Override
                        public void onItemLongCLickListener(int position) {

                        }
                    });
                    break;
            }
        }
    };
    private TitleItemDecoration decoration;

    @Override
    public void setUpData() {
        presenter.getCmri();
    }

    @Override
    public void setUpView() {

    }

    @Override
    public void init() {
        presenter = new CmriPresenter(this);
    }

    @Override
    public int getFragmentLayout() {
        return R.layout.fragment_cmr;
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
    public void getCmriSuc(UsersBean usersBean) {
        if (usersBean != null) {
            List<String> name_list = new ArrayList<>();
            for (int i = 0; i < usersBean.getData().size(); i++) {
                String name = usersBean.getData().get(i).getName();
                name_list.add(name);
            }
            name_beans = fillgetDatas(name_list.toArray());
            Bundle bundle = new Bundle();
            bundle.putSerializable("obj",usersBean);
            Message message = mHandler.obtainMessage(ADDRESS_BOOK_OK,bundle);

            mHandler.sendMessage(message);
        }
    }

    private List<UsersBean.DataBean> fillgetDatas(Object[] stringArray) {
        List<UsersBean.DataBean> mSortLists = new ArrayList<>();
        ArrayList<String> index = new ArrayList<>();
        for (int i = 0; i < stringArray.length; i++) {
            UsersBean.DataBean dataBean = new UsersBean.DataBean();
            dataBean.setName(String.valueOf(stringArray[i]));
            String pinYin = PinyinUtils.converterToFirstSpell(String.valueOf(stringArray[i]));
            String sortString = pinYin.substring(0, 1).toUpperCase();
            if (sortString.matches("[A-Z]")) {
                dataBean.setSortLetters(sortString.toUpperCase());
                if (!index.contains(sortString)) {
                    index.add(sortString);
                }
            }
            mSortLists.add(dataBean);
        }
        return mSortLists;
    }

    @Override
    public void getCmriFail() {

    }

    @Override
    protected void initImmersionBar() {
        super.initImmersionBar();
        mImmersionBar.titleBar(toolbar)
                .init();
    }
}
