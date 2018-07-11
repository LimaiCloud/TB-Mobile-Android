package com.device.limaiyun.thingsboard.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.device.limaiyun.thingsboard.R;
import com.device.limaiyun.thingsboard.bean.EquipmentDetialBean;
import com.device.limaiyun.thingsboard.utils.SpacesItemDecoration;

/**
 * Created by Administrator on 2018/6/29 0029.
 */

public class DetilAdapter extends RecyclerView.Adapter<DetilAdapter.DetilViewHolder> {

    private EquipmentDetialBean.DataBean list;
    private DetilChildAdapter childAdapter;

    public DetilAdapter(EquipmentDetialBean.DataBean data) {
        this.list = data;
    }


    @Override
    public DetilViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.detil_item, null);
        DetilViewHolder viewHolder = new DetilViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(DetilViewHolder holder, int position) {
        holder.textView.setText(list.getTitle().get(position));
        Log.e("list_getkey", list.getKey() + "");
        Log.e("list_getkey", list.getKey().get(position) + "");
        childAdapter = new DetilChildAdapter(list.getKey().get(position));
        holder.recyclerView.setAdapter(childAdapter);
    }


    @Override
    public int getItemCount() {
        Log.e("list_getkey",list.getTitle().size()+"");
        return list.getTitle().size() > 0 ? list.getTitle().size() : 0;
    }


    static class DetilViewHolder extends RecyclerView.ViewHolder {
        RecyclerView recyclerView;
        TextView textView;

        public DetilViewHolder(View itemView) {
            super(itemView);
            recyclerView = itemView.findViewById(R.id.recyclerview);
            recyclerView.setLayoutManager(new LinearLayoutManager(itemView.getContext(), LinearLayoutManager.VERTICAL, false));
            recyclerView.addItemDecoration(new SpacesItemDecoration(1));
            textView = itemView.findViewById(R.id.tv_title);
        }
    }

}
