package com.device.limaiyun.thingsboard.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.device.limaiyun.thingsboard.R;
import com.device.limaiyun.thingsboard.bean.UsersBean;

import java.util.List;

/**
 * Created by Administrator on 2018/7/5 0005.
 */

public class CmriAdapter extends RecyclerView.Adapter<CmriAdapter.ViewHolder> {

    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private List<UsersBean.DataBean> dataBeans;
    private OnClickListener onClickListener;
    private UsersBean mUserBean;



    public CmriAdapter(Context context, List<UsersBean.DataBean> name_beans, UsersBean usersBean) {
        mContext = context;
        mLayoutInflater = LayoutInflater.from(mContext);
        dataBeans = name_beans;
        mUserBean = usersBean;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.item_crm, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.tv_crm_name.setText(mUserBean.getData().get(position).getName());
        holder.tv_cmr_title.setText(mUserBean.getData().get(position).getTitle());
        holder.tv_crmcomapny.setText("博萨集团");
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickListener.onItemCLickListener(position);
            }
        });
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                onClickListener.onItemLongCLickListener(position);
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataBeans.size() > 0 ? dataBeans.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_crm_name;
        TextView tv_cmr_title;
        TextView tv_crmcomapny;
        public ViewHolder(View itemView) {
            super(itemView);
            tv_crm_name = itemView.findViewById(R.id.tv_crm_name);
            tv_cmr_title = itemView.findViewById(R.id.tv_cmr_title);
            tv_crmcomapny = itemView.findViewById(R.id.tv_crmcomapny);
        }
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public interface OnClickListener{
        void onItemCLickListener(int position);
        void onItemLongCLickListener(int position);
    }
}
