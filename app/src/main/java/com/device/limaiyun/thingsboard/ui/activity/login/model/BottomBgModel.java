package com.device.limaiyun.thingsboard.ui.activity.login.model;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;

import com.device.limaiyun.thingsboard.R;
import com.device.limaiyun.thingsboard.base.Configs;

import butterknife.OnClick;


/**
 * Created by Administrator on 2018/4/18 0018.
 */

public class BottomBgModel implements BottomBgPort {
    private AlertDialog dialog;

    @Override
    public void showBottomBg(final Context mContext, View view) {
        if (view != null) {
            final EditText editText = view.findViewById(R.id.et_ip_address);
            Button btn_cancle = view.findViewById(R.id.btn_cancle);
            Button btn_comfirm = view.findViewById(R.id.btn_comfirm);
            AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
            builder.setView(view);
            dialog = builder.show();
            SharedPreferences sp = mContext.getSharedPreferences("login", Context.MODE_PRIVATE);
            String url = sp.getString("url", "");
            if (url!=null){
                editText.setText(url);
                Configs.BASE_URL = url;
            }

            btn_cancle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialog.dismiss();
                }
            });
            btn_comfirm.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("CommitPrefEdits")
                @Override
                public void onClick(View view) {
                    dialog.dismiss();
                    String ip = editText.getText().toString();
                    if (ip != null && !ip.equals("") && !ip.contains("http://")) {
                        Configs.BASE_URL = "http://" + ip;
                    } else if (ip != null && !ip.equals("") && ip.contains("http://")) {
                        Configs.BASE_URL = ip;
                    }
                    SharedPreferences sp = mContext.getSharedPreferences("login", Context.MODE_PRIVATE);
                    SharedPreferences.Editor edit = sp.edit();
                    edit.putString("url",Configs.BASE_URL).commit();
                }
            });
        }
    }
}
