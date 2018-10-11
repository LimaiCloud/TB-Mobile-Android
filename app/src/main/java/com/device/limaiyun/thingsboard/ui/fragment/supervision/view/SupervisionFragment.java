package com.device.limaiyun.thingsboard.ui.fragment.supervision.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.device.limaiyun.thingsboard.R;
import com.device.limaiyun.thingsboard.adapter.SupervisionFragmentAdapter;
import com.device.limaiyun.thingsboard.base.BaseFragment;
import com.device.limaiyun.thingsboard.bean.SupervisionDivisionBean;
import com.device.limaiyun.thingsboard.bean.WeKanTitleBean;
import com.device.limaiyun.thingsboard.ui.activity.childactivity.Supervision.child.child.view.SupervisionDetilsActivity;
import com.device.limaiyun.thingsboard.ui.fragment.supervision.presenter.SupervisionFragmentPresenter;
import com.device.limaiyun.thingsboard.utils.SpacesItemDecoration;
import com.device.limaiyun.thingsboard.utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by ${Winter} on 2018/9/20.
 */
public class SupervisionFragment
        extends BaseFragment implements SupervisionFragmentView {

    @BindView(R.id.recyclerview)
    RecyclerView recyclerView;
    @BindView(R.id.progressbar)
    ProgressBar progressBar;
    public static final String ARGUMENT = "argument";
    public static final String URL = "url";
    public static final String TOKEN = "token";
    public static final String TITLES = "titles";
    private String ID;
    private SupervisionFragmentPresenter presenter;
    private ArrayList<WeKanTitleBean> title_lists;


    @Override
    public void setUpData() {

    }

    @Override
    public void setUpView() {
    }

    @Override
    public void init() {
        recyclerView.addItemDecoration(new SpacesItemDecoration(40));
    }

    @Override
    public int getFragmentLayout() {
        return R.layout.fragment_supervision;
    }

    @Override
    protected void lazyLoad() {
        Bundle bundle = getArguments();
        if (bundle != null) {
            ID = bundle.getString(ARGUMENT);
            String url = bundle.getString(URL);
            String token = bundle.getString(TOKEN);
            title_lists = bundle.getParcelableArrayList(TITLES);

            if (ID != null && !ID.equals("")) {
                presenter = new SupervisionFragmentPresenter(this);
                presenter.getSupervisionData(url, ID, token);
            }
        }
    }

    public static Fragment newInstance(String url, String id, String token, List<WeKanTitleBean> weKanTitleBeans) {
        SupervisionFragment supervisionFragment = new SupervisionFragment();
        Bundle bundle = new Bundle();
        bundle.putString(URL, url);
        bundle.putString(ARGUMENT, id);
        bundle.putString(TOKEN, token);
        bundle.putParcelableArrayList(TITLES, (ArrayList<? extends Parcelable>) weKanTitleBeans);
        supervisionFragment.setArguments(bundle);
        return supervisionFragment;
    }

    @Override
    public void showData(final List<SupervisionDivisionBean> supervisionDivisionBeans, final String url, final String token) {
        SupervisionFragmentAdapter adapter = new SupervisionFragmentAdapter(getActivity(), supervisionDivisionBeans, title_lists, url, presenter, token);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));

        recyclerView.setAdapter(adapter);
        adapter.setClickListener(new SupervisionFragmentAdapter.OnItemClickListener() {
            @Override
            public void onItemClickListener(int position) {
                Intent intent = new Intent(getContext(), SupervisionDetilsActivity.class);
                intent.putExtra("title",supervisionDivisionBeans.get(position).getTitle());
                intent.putExtra("description",supervisionDivisionBeans.get(position).getDescription());
                intent.putExtra("card_id",supervisionDivisionBeans.get(position).get_id());
                intent.putExtra("url",url);
                intent.putExtra("token",token);
                startActivity(intent);
            }

            @Override
            public void onItemLongClickListner(int position) {
                ToastUtils.showLongToast("长按");
            }
        });
    }

    @Override
    public void dontShowData() {

    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void dismissProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void refreshView(String url,String token) {
        presenter.getSupervisionData(url,token);
    }
}
