package com.device.limaiyun.thingsboard.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.device.limaiyun.thingsboard.R;
import com.device.limaiyun.thingsboard.utils.TimeUtils;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/7/2 0002.
 */

public class DetilChildAdapter extends RecyclerView.Adapter<DetilChildAdapter.ViewHolder> {
    private List<Map<Long, String>> mapList;

    public DetilChildAdapter(List<Map<Long, String>> maps) {
        this.mapList = maps;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.detil_child_item, null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        for (int i = 0; i < mapList.size(); i++) {
            Map<Long, String> map = mapList.get(i);
            Iterator<Long> iterator = map.keySet().iterator();
            while (iterator.hasNext()) {
                Long aLong = iterator.next();
                String count = map.get(aLong);
                String time = TimeUtils.stampToTime(String.valueOf(aLong));
                holder.tv_time.setText(time);
                holder.tv_count.setText(count);
            }
        }
    }

    @Override
    public int getItemCount() {
        Log.e("mapList",mapList.size()+"");
        return mapList.size() > 0 ? mapList.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_time;
        TextView tv_count;

        public ViewHolder(View itemView) {
            super(itemView);
            tv_time = itemView.findViewById(R.id.tv_time);
            tv_count = itemView.findViewById(R.id.tv_count);
        }
    }
}
