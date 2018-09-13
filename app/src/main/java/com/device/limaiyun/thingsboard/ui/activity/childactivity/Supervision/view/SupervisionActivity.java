package com.device.limaiyun.thingsboard.ui.activity.childactivity.Supervision.view;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.device.limaiyun.thingsboard.R;
import com.device.limaiyun.thingsboard.adapter.SupervisionAdapter;
import com.device.limaiyun.thingsboard.base.BaseActivity;
import com.device.limaiyun.thingsboard.bean.WeKanBoardBean;
import com.device.limaiyun.thingsboard.ui.activity.childactivity.Supervision.presenter.SupervisionPresenter;
import com.device.limaiyun.thingsboard.utils.SpacesItemDecoration;
import com.device.limaiyun.thingsboard.utils.ToastUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by ${Winter} on 2018/9/10.
 */
public class SupervisionActivity extends BaseActivity implements SupervisionView {

    private SupervisionPresenter sup_presenter;
    @BindView(R.id.supervision_recyclerview)
    RecyclerView recyclerView;
    @BindView(R.id.ll_back)
    LinearLayout ll_back;
    @BindView(R.id.iv_add_supervision)
    ImageView iv_add_supervision;
    private Context mContext;

    @Override
    protected int getLayout() {
        return R.layout.activity_supervision;
    }

    @Override
    public void initData() {
        mContext = this;
        sup_presenter = new SupervisionPresenter(this);
        sup_presenter.getUserToken("liuxudong", "asdf@123");
    }

    @OnClick(R.id.ll_back)
    public void finishAct() {
        finish();
    }

    @OnClick(R.id.iv_add_supervision)
    public void addSupervision() {
        ToastUtils.showLongToast("添加");
    }

    @Override
    public void initImmersionBar() {
        super.initImmersionBar();
        mImmersionBar.titleBar(R.id.toolbar).init();
    }

    @Override
    public void getBoards(String userid, String token) {
        sup_presenter.getUserBoards(userid, token);
    }

    @Override
    public void showBoards(List<WeKanBoardBean> weKanBoardBeans) {
        SupervisionAdapter adapter = new SupervisionAdapter(mContext, weKanBoardBeans);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new SpacesItemDecoration(40));
        adapter.setListener(new SupervisionAdapter.OnItemClickListener() {
            @Override
            public void onItemClickListener(int position) {
                ToastUtils.showLongToast("点击");
            }

            @Override
            public void onItemLongClickListener(int position) {
                ToastUtils.showLongToast("长按");
            }
        });
    }
}
