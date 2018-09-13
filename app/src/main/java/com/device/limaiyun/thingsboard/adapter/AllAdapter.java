package com.device.limaiyun.thingsboard.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.auth0.android.jwt.JWT;
import com.device.limaiyun.thingsboard.R;
import com.device.limaiyun.thingsboard.bean.DeviceTypeBean;
import com.device.limaiyun.thingsboard.bean.TokenBean;

import java.util.List;


/**
 * Created by Administrator on 2018/5/11 0011.
 */

public class AllAdapter extends RecyclerView.Adapter<AllAdapter.AllAdapterViewHolder> {

    private List<DeviceTypeBean.DataBean> list;
    private OnItemClickListener listener;


    public AllAdapter(List<DeviceTypeBean.DataBean> data) {
        list = data;
    }

    @Override
    public AllAdapter.AllAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.all_item, null);
        AllAdapterViewHolder holder = new AllAdapterViewHolder(v);

        return holder;
    }

    @Override
    public void onBindViewHolder(AllAdapter.AllAdapterViewHolder holder, final int position) {
        holder.tv_title.setText(list.get(position).getName());
        holder.tv_device_type.setText(list.get(position).getType());
        JWT jwt = new JWT(TokenBean.getInstence().getToken());
        String customerId = jwt.getClaim("customerId").asString();
        holder.tv_teanant_id.setText(customerId);
        if (listener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.setOnClickListener(position);
                }
            });
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    listener.setOnLongClickListener(position);
                    return true;
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return list.size() > 0 ? list.size() : 0;
    }

    public class AllAdapterViewHolder extends RecyclerView.ViewHolder {
        TextView tv_title;
        TextView tv_device_type;
        TextView tv_teanant_id;

        public AllAdapterViewHolder(View itemView) {
            super(itemView);
            tv_title = itemView.findViewById(R.id.tv_title);
            tv_device_type = itemView.findViewById(R.id.tv_device_type);
            tv_teanant_id = itemView.findViewById(R.id.tv_teanant_id);
        }
    }

    public interface OnItemClickListener {
        void setOnClickListener(int position);

        void setOnLongClickListener(int position);
    }

    public void setListener(OnItemClickListener listener) {
        this.listener = listener;
    }
}
