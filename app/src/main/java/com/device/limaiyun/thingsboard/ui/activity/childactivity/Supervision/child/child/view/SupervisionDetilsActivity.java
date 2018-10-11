package com.device.limaiyun.thingsboard.ui.activity.childactivity.Supervision.child.child.view;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.device.limaiyun.thingsboard.R;
import com.device.limaiyun.thingsboard.base.BaseActivity;
import com.device.limaiyun.thingsboard.bean.SupervisionDetilsBean;
import com.device.limaiyun.thingsboard.ui.activity.childactivity.Supervision.child.child.presenter.SupervisionDetilsPresenter;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by ${Winter} on 2018/9/28.
 */
public class SupervisionDetilsActivity extends BaseActivity implements SupervisionDetilsView {
    private static final String TAG = "SupervisionDetilsActivity";
    @BindView(R.id.tv_detil_title)
    TextView tv_detil_title;
    @BindView(R.id.tv_detil_title1)
    TextView tv_detil_title1;
    private String title;
    private String description;
    @BindView(R.id.ll_back)
    LinearLayout ll_back;
    @BindView(R.id.tv_create_time)
    TextView tv_create_time;
    @BindView(R.id.tv_create_date)
    TextView tv_create_date;

    @BindView(R.id.tv_detil_content)
    TextView tv_detil_content;
    private SupervisionDetilsPresenter presenter;
    private String url;
    private String card_id;
    private String token;


    @Override
    protected int getLayout() {
        return R.layout.activity_supervision_detils;
    }

    @Override
    public void initImmersionBar() {
        super.initImmersionBar();
        mImmersionBar.titleBar(R.id.toolbar).init();
    }


    @SuppressLint("LongLogTag")
    @Override
    public void initView() {
        presenter = new SupervisionDetilsPresenter(this);
        Intent intent = getIntent();
        title = intent.getStringExtra("title");
        description = intent.getStringExtra("description");
        url = intent.getStringExtra("url");
        card_id = intent.getStringExtra("card_id");
        token = intent.getStringExtra("token");
    }


    @Override
    public void initData() {
        if (title != null && !title.equals(""))
            tv_detil_title.setText(title);
        tv_detil_title1.setText(title);
        presenter.getCardDetilContent(url,card_id,token);
    }

    @OnClick(R.id.ll_back)
    public void finishAct(){
        finish();
    }

    @Override
    public void showDetils(SupervisionDetilsBean detilsBean) {
        tv_detil_content.setText(detilsBean.getDescription());
        tv_create_date.setText(detilsBean.getDateLastActivity().substring(0,10));
        tv_create_time.setText(detilsBean.getDateLastActivity().substring(11,19));
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void dissmisProgress() {

    }
}
