package com.device.limaiyun.thingsboard.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.device.limaiyun.thingsboard.R;
import com.device.limaiyun.thingsboard.bean.WeKanTitleBean;

import java.util.List;

/**
 * Created by ${Winter} on 2018/9/21.
 */
public class SupervisionDialoggAdapter extends BaseAdapter {

    private List<WeKanTitleBean> titles;
    private Activity mmContext;
    private LayoutInflater mLayoutInflater;

    public SupervisionDialoggAdapter(Activity mContext, List<WeKanTitleBean> divisionBeans) {
        this.mmContext = mContext;
        titles = divisionBeans;
        mLayoutInflater = LayoutInflater.from(mmContext);

    }


    @Override
    public int getCount() {
        return titles.size() > 0 ? titles.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return titles.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        final int index = position;
        if (convertView == null){
            viewHolder = new ViewHolder();
            convertView = mLayoutInflater.inflate(R.layout.item_dialog, null);
            viewHolder.tv_title = convertView.findViewById(R.id.tv_titles);
            viewHolder.checkBox = convertView.findViewById(R.id.checkbox);
            viewHolder.iv_status = convertView.findViewById(R.id.iv_status);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.tv_title.setText(titles.get(position).getTitle());
        if (titles.get(position).getTitle().equals("待办任务")){
            viewHolder.iv_status.setImageResource(R.mipmap.daiban_icon);
        }else if (titles.get(position).getTitle().equals("进行中")){
            viewHolder.iv_status.setImageResource(R.mipmap.jinxing_icon);
        }else if (titles.get(position).getTitle().equals("完成")){
            viewHolder.iv_status.setImageResource(R.mipmap.finish_icon);
        }else if (titles.get(position).getTitle().equals("暂不处理")){
            viewHolder.iv_status.setImageResource(R.mipmap.zanbuchuli_icon);
        }else {
            viewHolder.iv_status.setImageResource(R.mipmap.default_status_icon);
        }


        if (titles.get(position).isChecked){
            viewHolder.checkBox.setChecked(true);
        }else {
            viewHolder.checkBox.setChecked(false);
        }



        return convertView;
    }

    public class ViewHolder {
         TextView tv_title;
         CheckBox checkBox;
         ImageView iv_status;

    }
//    //返回当前CheckBox选中的位置,便于获取值.
//    public int getSelectPosition() {
//        return tempPosition;
//    }

}
