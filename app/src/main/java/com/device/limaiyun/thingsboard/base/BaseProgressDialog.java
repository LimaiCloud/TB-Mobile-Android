package com.device.limaiyun.thingsboard.base;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.widget.ProgressBar;

import com.device.limaiyun.thingsboard.R;

/**
 * Created by Administrator on 2018/4/10 0010.
 */

public class BaseProgressDialog extends Dialog {

    public static  BaseProgressDialog getInstance(Context context){
        return new BaseProgressDialog(context);
    }

    public BaseProgressDialog(@NonNull Context context) {
        this(context, R.style.progress_dialog);
        initUI();
    }

    public BaseProgressDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
        initUI();
    }

    protected BaseProgressDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        initUI();
    }

    private void initUI() {
        setContentView(new ProgressBar(getContext()));
        getWindow().getAttributes().gravity = Gravity.CENTER;
        setCanceledOnTouchOutside(false);
    }
}
