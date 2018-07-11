package com.device.limaiyun.thingsboard.adapter;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.device.limaiyun.thingsboard.R;
import com.device.limaiyun.thingsboard.bean.DashBoardsBean;
import com.device.limaiyun.thingsboard.bean.DeviceTypeBean;

/**
 * Created by Administrator on 2018/6/19 0019.
 */

public class DashBoardsAdapter extends RecyclerView.Adapter<DashBoardsAdapter.DashBoardsViewHolder> {
    //    private DashBoardsBean boardsBean;
    private DeviceTypeBean deviceTypeBean;
    private OnItemClickListener listener;

    public void setListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public DashBoardsAdapter(DeviceTypeBean deviceTypeBean) {
        this.deviceTypeBean = deviceTypeBean;
    }

    @Override
    public DashBoardsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dashboards_item, null);
        DashBoardsViewHolder holder = new DashBoardsViewHolder(view);
        return holder;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onBindViewHolder(DashBoardsViewHolder holder, final int position) {
//        holder.ll_data_bg.setBackground();
        holder.tv_dashboard_title.setText(deviceTypeBean.getData().get(position).getName());
        if (position % 4 == 0) {
            holder.iv_dashboard_bg.setImageResource(R.mipmap.dashboard_blue);
        } else if (position % 4 == 1) {
            holder.iv_dashboard_bg.setImageResource(R.mipmap.dashboard_orange);
        } else if (position % 4 == 2) {
            holder.iv_dashboard_bg.setImageResource(R.mipmap.dashboard_purple);
        } else if (position % 4 == 3) {
            holder.iv_dashboard_bg.setImageResource(R.mipmap.dashboard_soft_blue);
        }
        if (listener != null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.OnClickListener(position);
                }
            });
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    listener.OnLongClickListener(position);
                    return true;
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return deviceTypeBean.getData().size() > 0 ? deviceTypeBean.getData().size() : 0;
    }

    public class DashBoardsViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_dashboard_bg;
        TextView tv_dashboard_title;

        public DashBoardsViewHolder(View itemView) {
            super(itemView);
            iv_dashboard_bg = itemView.findViewById(R.id.iv_dashboard_bg);
            tv_dashboard_title = itemView.findViewById(R.id.tv_dashboard_title);
        }
    }

    public interface OnItemClickListener{
        void OnClickListener(int position);
        void OnLongClickListener(int position);
    }
}
