package com.device.limaiyun.thingsboard.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.device.limaiyun.thingsboard.R;
import com.device.limaiyun.thingsboard.bean.SupervisionDivisionBean;
import com.device.limaiyun.thingsboard.bean.WeKanTitleBean;
import com.device.limaiyun.thingsboard.ui.fragment.supervision.presenter.SupervisionFragmentPresenter;
import com.device.limaiyun.thingsboard.utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by ${Winter} on 2018/9/20.
 */
public class SupervisionFragmentAdapter extends RecyclerView.Adapter<SupervisionFragmentAdapter.ViewHolder> {

    private List<SupervisionDivisionBean> divisionBeans;
    private LayoutInflater mLayoutInflater;
    private Activity mContext;
    private OnItemClickListener clickListener;
    private ArrayList<WeKanTitleBean> titles;
    private String url;
    private SupervisionFragmentPresenter mpresenter;
    private String mtoken;
    private String chiose_id;


    public void setClickListener(OnItemClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public SupervisionFragmentAdapter(Activity activity, List<SupervisionDivisionBean> supervisionDivisionBeans,
                                      ArrayList<WeKanTitleBean> title_lists, String url,
                                      SupervisionFragmentPresenter presenter, String token) {
        this.mContext = activity;
        this.divisionBeans = supervisionDivisionBeans;
        this.mLayoutInflater = LayoutInflater.from(mContext);
        titles = title_lists;
        this.url = url;
        mpresenter = presenter;
        mtoken = token;
    }

    @Override
    public SupervisionFragmentAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.item_fragment_supervision, null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(SupervisionFragmentAdapter.ViewHolder holder, final int position) {
        holder.tv_sup_title.setText(divisionBeans.get(position).getTitle());
        holder.tv_content.setText(divisionBeans.get(position).getDescription());
        holder.iv_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(mContext,position);
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.onItemClickListener(position);
            }
        });
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                clickListener.onItemLongClickListner(position);
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return divisionBeans.size() > 0 ? divisionBeans.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_sup_title;
        private ImageView iv_edit;
        private TextView tv_content;

        public ViewHolder(View itemView) {
            super(itemView);
            tv_sup_title = itemView.findViewById(R.id.tv_sup_title);
            iv_edit = itemView.findViewById(R.id.iv_edit);
            tv_content= itemView.findViewById(R.id.tv_content);
        }
    }

    public interface OnItemClickListener {
        void onItemClickListener(int position);

        void onItemLongClickListner(int position);
    }

    private void showDialog(Context mmContext, final int position) {

        AlertDialog.Builder builder = new AlertDialog.Builder(mmContext);
        LayoutInflater mmLayoutInflater = (LayoutInflater) mmContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = mmLayoutInflater.inflate(R.layout.dialog_supervision, null);

        ListView listview = view.findViewById(R.id.listview);
        TextView btn_supervision_cancle = view.findViewById(R.id.btn_supervision_cancle);
        TextView btn_supervision_comfirm = view.findViewById(R.id.btn_supervision_comfirm);
        builder.setCancelable(true);
        builder.setView(view);
        final AlertDialog dialog = builder.create();

        Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable());

        final SupervisionDialoggAdapter mAdapter = new SupervisionDialoggAdapter(this.mContext, titles);
        listview.setAdapter(mAdapter);
        listview.setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                for (WeKanTitleBean titleBean : titles) {
                    titleBean.setChecked(false);
                }
                titles.get(position).setChecked(true);
                chiose_id = titles.get(position).get_id();
                mAdapter.notifyDataSetChanged();
            }
        });

        btn_supervision_cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();

            }
        });
        Log.e("urlurl",url+"/"+divisionBeans.get(position).get_id());
        btn_supervision_comfirm.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (chiose_id != null && !chiose_id.equals("")) {
                    mpresenter.putSupervisionStatus(url+"/"+divisionBeans.get(position).get_id(),divisionBeans.get(position).getTitle(),divisionBeans.get(position).getDescription(), mtoken, chiose_id);
                    dialog.dismiss();
                } else {
                    ToastUtils.showShortToast("请选择状态");
                }
            }
        });
        dialog.show();
    }
}
