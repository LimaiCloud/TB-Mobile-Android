package com.device.limaiyun.thingsboard.adapter;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.device.limaiyun.thingsboard.R;
import com.device.limaiyun.thingsboard.utils.MyMarkerView;
import com.device.limaiyun.thingsboard.utils.TimeUtils;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.formatter.IValueFormatter;
import com.github.mikephil.charting.utils.ViewPortHandler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/7/4 0004.
 */

public class LineEtcAdapter extends BaseAdapter {
    private Context mmContext;
    private List<String> mTitle;
    private List<List<Map<Long, String>>> mList;
    private LayoutInflater mLayoutInflater;

    public LineEtcAdapter(Context mContext,  List<String> title,List<List<Map<Long, String>>> data) {
        mmContext = mContext;
        this.mList= data;
        mTitle = title;
        mLayoutInflater = LayoutInflater.from(mmContext);
    }

    @Override
    public int getCount() {
        return mTitle.size() > 0 ? mTitle.size() : 0;
    }

    @Override
    public Object getItem(int i) {
        return mTitle.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int position, View contentView, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if (contentView == null) {
            holder = new ViewHolder();
            contentView = mLayoutInflater.inflate(R.layout.line_chart_ite, null);
            holder.line_chart = contentView.findViewById(R.id.line_chart);
            contentView.setTag(holder);
        } else {
            holder = (ViewHolder) contentView.getTag();
        }
        holder.line_chart.setEnabled(true);
        holder.line_chart.setBackgroundColor(Color.WHITE);
        holder.line_chart.setHighlightPerDragEnabled(true);
        Description description = new Description();
        description.setText("");
        holder.line_chart.setDescription(description);
        holder.line_chart.setMarker(new MyMarkerView(mmContext,R.layout.markview));

        //矩形背景框设置
        holder.line_chart.setDrawGridBackground(true);
        holder.line_chart.setGridBackgroundColor(Color.WHITE);
        //边界设置
//        viewHolder.line_chart.setDrawBorders(false);
        holder.line_chart.setScaleXEnabled(false);
        holder.line_chart.setScaleYEnabled(false);

        ArrayList<String> xValues = new ArrayList<>();//x轴数据
        ArrayList<Entry> yValues = new ArrayList<>();//y轴数据
        ArrayList<String> data_list = new ArrayList<>();

        for (int i = 0; i < mList.get(position).size(); i++) {
            Map<Long, String> map = mList.get(position).get(i);
            Iterator<Long> iterator = map.keySet().iterator();
            while (iterator.hasNext()) {
                Long key = iterator.next();
                String time = TimeUtils.stampToDate(String.valueOf(key));
                xValues.add(time);
                String value = map.get(key);
                data_list.add(value);
            }
        }
            if (xValues.size() > 0) {
                Collections.reverse(xValues);
            }
            if (data_list.size() > 0) {
                Collections.reverse(data_list);
            }

            for (int i = 0; i < data_list.size(); i++) {
                String s = data_list.get(i);
                float aFloat = Float.parseFloat(s);
                yValues.add(new Entry(i, aFloat));
            }


            MyXFormatter formatter = new MyXFormatter(xValues);
            LineDataSet dataSet = new LineDataSet(yValues, mTitle.get(position));
            dataSet.setColor(Color.GRAY);
            dataSet.setLineWidth(2.0f);
            dataSet.setValueFormatter(new IValueFormatter() {
                @Override
                public String getFormattedValue(float value, Entry entry, int dataSetIndex, ViewPortHandler viewPortHandler) {
                    return value +"";
                }
            });
            LineData lineData = new LineData(dataSet);
            holder.line_chart.setData(lineData);
            lineData.setValueTextSize(12.0f);

            //获取X轴
            XAxis xAxis = holder.line_chart.getXAxis();
            YAxis yAxis = holder.line_chart.getAxisLeft();
            holder.line_chart.getAxisRight().setEnabled(false);
            xAxis.setEnabled(true);
            xAxis.setDrawGridLines(false);
            xAxis.setGridColor(Color.RED);
            xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
            xAxis.setDrawAxisLine(true);
            xAxis.setAxisLineColor(Color.GRAY);
            xAxis.setAxisLineWidth(1.5f);
            xAxis.setGridColor(Color.GRAY);
            xAxis.setValueFormatter(formatter);
            xAxis.setGridLineWidth(1.0f);

            //设置Y轴
            yAxis.setDrawAxisLine(true);
            yAxis.setEnabled(true);
            yAxis.setDrawGridLines(true);
            yAxis.setGridColor(Color.GRAY);
            yAxis.setGridLineWidth(1.0f);
            yAxis.setAxisLineColor(Color.BLACK);
            yAxis.setAxisMaximum(500);
            yAxis.setAxisMinimum(0);

        return contentView;
    }

    public static class ViewHolder {
        LineChart line_chart;
    }

    public class MyXFormatter implements IAxisValueFormatter {

        private ArrayList mValues;

        public MyXFormatter(ArrayList values) {
            this.mValues = values;
        }

        private static final String TAG = "MyXFormatter";

        @Override
        public String getFormattedValue(float value, AxisBase axis) {
            // "value" represents the position of the label on the axis (x or y)
            Log.d(TAG, "----->getFormattedValue: " + value);
            return (String) mValues.get((int) value % mValues.size());
        }
    }

}
