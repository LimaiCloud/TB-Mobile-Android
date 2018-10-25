package com.device.limaiyun.thingsboard.ui.activity.childactivity.Supervision.addSupervisionChild.view;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.device.limaiyun.thingsboard.R;
import com.device.limaiyun.thingsboard.adapter.SupervisionDialoggAdapter;
import com.device.limaiyun.thingsboard.base.BaseActivity;
import com.device.limaiyun.thingsboard.bean.AddSupervisionBean;
import com.device.limaiyun.thingsboard.bean.WeKanTitleBean;
import com.device.limaiyun.thingsboard.ui.activity.childactivity.Supervision.addSupervisionChild.presenter.AddSupervisionPreseneter;
import com.device.limaiyun.thingsboard.utils.ToastUtils;

import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by ${Winter} on 2018/10/9.
 */
public class AddSupervisionActivity extends BaseActivity implements AddSupervisionView {


    private static final int ADD_SUP_SUC = 2;
    private String board_id;
    private String wekan_token;
    private AddSupervisionPreseneter preseneter;
    private String list_id;
    @BindView(R.id.tv_change_status)
    TextView tv_change_status;
    @BindView(R.id.et_title)
    EditText et_title;
    @BindView(R.id.et_description)
    EditText et_description;
    @BindView(R.id.progressbar)
    ProgressBar progressBar;
    private String setText;
    private String board_url;
    private String user_id;

    @Override
    protected int getLayout() {
        return R.layout.activity_add_supervision;
    }

    @Override
    public void initView() {
        preseneter = new AddSupervisionPreseneter(this);
    }

    @Override
    public void initData() {
        Intent intent = getIntent();
        board_id = intent.getStringExtra("board_id");
        wekan_token = intent.getStringExtra("wekan_token");
        user_id = intent.getStringExtra("user_id");
    }

    @Override
    public void initImmersionBar() {
        super.initImmersionBar();
        mImmersionBar.titleBar(R.id.toolbar).init();
    }

    @OnClick(R.id.tv_change_status)
    public void showPupList() {
        preseneter.getTitles(board_id, wekan_token);
    }

    @OnClick(R.id.ll_back)
    public void finishAct() {
        finish();
    }

    @OnClick(R.id.btn_create)
    public void createSupervision() {
        if (et_title != null && !et_title.getText().toString().equals("") &&
                et_description != null && !et_description.getText().toString().equals("") &&
                list_id != null && !list_id.equals("")) {
            if (board_url != null && !board_url.equals("") &&
                    user_id != null && !user_id.equals("")) {
                preseneter.addSupervision(et_title.getText().toString(), et_description.getText().toString(), board_url, list_id, user_id, wekan_token);
            }
        } else {
            ToastUtils.showShortToast("请填写完整信息");
        }
    }


    @Override
    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void dismissProgressBar() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showPupWindow(List<WeKanTitleBean> weKanTitleBeans, String url) {
        showChangeTitles(weKanTitleBeans, url);
    }

    @Override
    public void finishAct(AddSupervisionBean bean) {
        if (bean != null && !bean.equals("")) {
            setResult(ADD_SUP_SUC);
            finish();
        }
    }

    private void showChangeTitles(final List<WeKanTitleBean> weKanTitleBeans, String url) {
        for (int i = 0; i < weKanTitleBeans.size(); i++) {
            if (list_id != null && !list_id.equals("") &&
                    weKanTitleBeans.get(i).get_id().equals(list_id)) {
                weKanTitleBeans.get(i).setChecked(true);
            }
        }
        board_url = url;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater mmLayoutInflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = mmLayoutInflater.inflate(R.layout.dialog_supervision, null);

        ListView listview = view.findViewById(R.id.listview);
        TextView btn_supervision_cancle = view.findViewById(R.id.btn_supervision_cancle);
        TextView btn_supervision_comfirm = view.findViewById(R.id.btn_supervision_comfirm);
        builder.setCancelable(true);
        builder.setView(view);
        final AlertDialog dialog = builder.create();

        Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable());

        final SupervisionDialoggAdapter mAdapter = new SupervisionDialoggAdapter(this, weKanTitleBeans);
        listview.setAdapter(mAdapter);
        listview.setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                for (WeKanTitleBean titleBean : weKanTitleBeans) {
                    titleBean.setChecked(false);
                }
                weKanTitleBeans.get(position).setChecked(true);
                list_id = weKanTitleBeans.get(position).get_id();
                setText = weKanTitleBeans.get(position).getTitle();
                mAdapter.notifyDataSetChanged();
            }
        });

        btn_supervision_cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();

            }
        });
        btn_supervision_comfirm.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (list_id != null && !list_id.equals("")) {
                    tv_change_status.setText(setText);
                    dialog.dismiss();
                } else {
                    ToastUtils.showShortToast("请选择状态");
                }
            }
        });
        dialog.show();
    }
}
