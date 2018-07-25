package com.device.limaiyun.thingsboard.utils;

import android.content.Context;
import android.widget.TextView;

import com.device.limaiyun.thingsboard.R;
import com.github.mikephil.charting.components.MarkerView;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.utils.MPPointF;

/**
 * Created by ${Winter} on 2018/7/19.
 */
public class MyMarkerView extends MarkerView {
    private TextView tvcontent;

    /**
     * Constructor. Sets up the MarkerView with a custom layout resource.
     *
     * @param context
     * @param layoutResource the layout resource to use for the MarkerView
     */
    public MyMarkerView(Context context, int layoutResource) {
        super(context, layoutResource);
        tvcontent = findViewById(R.id.tvContent);
    }

    @Override
    public void refreshContent(Entry e, Highlight highlight) {
        tvcontent.setText(e.getY() + "");
    }

    @Override
    public MPPointF getOffset() {
        return new MPPointF(-(getWidth() / 2), getHeight());
    }
}
