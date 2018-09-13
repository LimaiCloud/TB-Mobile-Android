package com.device.limaiyun.thingsboard.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.device.limaiyun.thingsboard.R;
import com.device.limaiyun.thingsboard.bean.WeKanBoardBean;
import com.device.limaiyun.thingsboard.utils.ToastUtils;

import java.util.List;

/**
 * Created by ${Winter} on 2018/9/11.
 */
public class SupervisionAdapter extends RecyclerView.Adapter<SupervisionAdapter.ViewHolder> {

    private List<WeKanBoardBean> weKanBoardBeans;
    private Context mContext;
    private LayoutInflater mLayoutInfalter;
    private OnItemClickListener listener;

    public void setListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public SupervisionAdapter(Context mContext, List<WeKanBoardBean> weKanBoardBeans) {
        this.mContext = mContext;
        this.weKanBoardBeans = weKanBoardBeans;
        mLayoutInfalter = LayoutInflater.from(mContext);
    }

    @Override
    public SupervisionAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInfalter.inflate(R.layout.item_supervision, null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(SupervisionAdapter.ViewHolder holder, final int position) {
        holder.tv_sup_title.setText(weKanBoardBeans.get(position).getTitle());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClickListener(position);
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                listener.onItemLongClickListener(position);
                return true;
            }
        });
        holder.iv_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtils.showLongToast("编辑");
            }
        });
    }

    @Override
    public int getItemCount() {
        return weKanBoardBeans.size()>0?weKanBoardBeans.size():0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_sup_title;
        TextView tv_sup_time;
        ImageView iv_edit;
        public ViewHolder(View itemView) {
            super(itemView);
            tv_sup_title = itemView.findViewById(R.id.tv_sup_title);
            tv_sup_time = itemView.findViewById(R.id.tv_sup_time);
            iv_edit = itemView.findViewById(R.id.iv_edit);
        }
    }

    public interface OnItemClickListener{
        void onItemClickListener(int position);
        void onItemLongClickListener(int position);
    }
}
