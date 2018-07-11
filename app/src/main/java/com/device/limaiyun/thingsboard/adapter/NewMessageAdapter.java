package com.device.limaiyun.thingsboard.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.device.limaiyun.thingsboard.R;

/**
 * Created by Administrator on 2018/6/14 0014.
 */

public class NewMessageAdapter extends RecyclerView.Adapter<NewMessageAdapter.NewMessageViewHolder> {


    @Override
    public NewMessageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.new_message_item, null);
        NewMessageViewHolder holder = new NewMessageViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(NewMessageViewHolder holder, int position) {
        holder.tv_content.setText("昨日生成54件产品中，没有发现异常产品，一切正常");
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    class NewMessageViewHolder extends RecyclerView.ViewHolder{
        TextView tv_content;
        public NewMessageViewHolder(View itemView) {
            super(itemView);
            tv_content = itemView.findViewById(R.id.tv_content);
        }
    }
}
