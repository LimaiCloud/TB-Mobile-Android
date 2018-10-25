package com.device.limaiyun.thingsboard.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.device.limaiyun.thingsboard.R;
import com.device.limaiyun.thingsboard.bean.YSVideoListBean;

/**
 * Created by ${Winter} on 2018/10/16.
 */
public class VideoMonitorListAdapter extends RecyclerView.Adapter<VideoMonitorListAdapter.ViewHolder> {

    private Context mContext;
    private LayoutInflater mLayoutInfalter;
    private YSVideoListBean mYSVideoListBean;
    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public VideoMonitorListAdapter(Context context, YSVideoListBean ysVideoListBean) {
        mContext = context;
        mLayoutInfalter=LayoutInflater.from(mContext);
        mYSVideoListBean = ysVideoListBean;
    }

    @Override
    public VideoMonitorListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInfalter.inflate(R.layout.item_video_list, null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(VideoMonitorListAdapter.ViewHolder holder, final int position) {
        holder.tv_video_title.setText(mYSVideoListBean.getData().get(position).getChannelName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.OnClickListener(position);
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                onItemClickListener.OnLongCLickListener(position);
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return mYSVideoListBean.getData().size() >0?mYSVideoListBean.getData().size():0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_video_title;
        public ViewHolder(View itemView) {
            super(itemView);
            tv_video_title = itemView.findViewById(R.id.tv_video_title);
        }
    }

    public interface OnItemClickListener{
        void OnClickListener(int position);
        void OnLongCLickListener(int position);
    }
}
