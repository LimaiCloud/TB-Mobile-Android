package com.device.limaiyun.thingsboard.refreshToken;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.device.limaiyun.thingsboard.bean.TokenBean;
import com.device.limaiyun.thingsboard.utils.ToastUtils;
import com.device.limaiyun.thingsboard.utils.env.Constant;
import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.Progress;
import com.lzy.okgo.request.base.Request;

import java.io.IOException;

import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.BufferedSource;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by Administrator on 2018/7/12 0012.
 */

public class RefreshTokenModel implements RefreshTokenPort {

    @Override
    public void refreshToken(Context mContext) {
        SharedPreferences account = mContext.getSharedPreferences("account", MODE_PRIVATE);
        String username = account.getString("username", "");
        String password = account.getString("password", "");
//        SharedPreferences url = mContext.getSharedPreferences("login", MODE_PRIVATE);
//        Configs.BASE_URL = url.getString("url", "");

        String parmer1 = "{\"username\":" + "\"" + username + "\"" + ",\"password\":" + "\"" + password + "\"" + "}";
        OkGo.post(Constant.API_SERVE_URL + Constant.API_AUTH_LOGIN)
                .headers("Content-Type", "application/json")
                .headers("Accept", "application/json")
                .upJson(parmer1)
                .tag(this)
                .execute(new com.lzy.okgo.callback.Callback<Object>() {
                    @Override
                    public void onStart(Request<Object, ? extends Request> request) {
                    }

                    @Override
                    public void onSuccess(com.lzy.okgo.model.Response<Object> response) {
                        Log.e("response", "2:" + response.toString());
                        if (response.code() == 200) {
                            ResponseBody raw_body = response.getRawResponse().body();
                            BufferedSource source = raw_body.source();
                            try {
                                String token = source.readUtf8();
                                if (token != null) {
                                    Gson gson = new Gson();
                                    TokenBean tokenBean = gson.fromJson(token, TokenBean.class);
                                    TokenBean.getInstence().setToken(tokenBean.getToken());
                                    ToastUtils.showShortToast("Refresh Token Success!");
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        } else {
                            ToastUtils.showShortToast("Refresh Token Fail!!");
                        }
                    }

                    @Override
                    public void onCacheSuccess(com.lzy.okgo.model.Response<Object> response) {
                    }

                    @Override
                    public void onError(com.lzy.okgo.model.Response<Object> response) {

                    }

                    @Override
                    public void onFinish() {
                    }

                    @Override
                    public void uploadProgress(Progress progress) {

                    }

                    @Override
                    public void downloadProgress(Progress progress) {

                    }

                    @Override
                    public Object convertResponse(Response response) throws Throwable {
                        return null;
                    }
                });
    }
}
