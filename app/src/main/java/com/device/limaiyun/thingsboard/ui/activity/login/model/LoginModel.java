package com.device.limaiyun.thingsboard.ui.activity.login.model;

import android.util.Log;

import com.device.limaiyun.thingsboard.bean.TokenBean;
import com.device.limaiyun.thingsboard.utils.env.Constant;
import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.Progress;
import com.lzy.okgo.request.base.Request;

import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;

import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.BufferedSource;

/**
 * Created by Administrator on 2018/4/11 0011.
 */
public class LoginModel implements LoginPort {

    @Override
    public void login(String username, final String password, final OnLoginListener onLoginListener) {
        if (username.isEmpty() || password.isEmpty()) {
            onLoginListener.onUnaOrPwdEmpty();
            return;
        }
        if (username != null && password != null && !username.equals("") && !password.equals("")) {

            if (username.contains("@")) {
                username = username;
            } else {
                username = username + "@limaicloud.com";
            }
            HashMap<String,Object> map = new HashMap<>();
            map.put("username",username);
            map.put("password",password);
            JSONObject jsonObject = new JSONObject(map);
//            String parmer1 = "{\"username\":" + "\"" + username + "\"" + ",\"password\":" + "\"" + password + "\"" + "}";
            OkGo.post(Constant.API_SERVE_URL + Constant.API_AUTH_LOGIN)
                    .headers("Content-Type", "application/json")
                    .headers("Accept", "application/json")
                    .upJson(jsonObject)
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
//                                        TokenBean.TOKEN = tokenBean.getToken();
                                        TokenBean.getInstence().setToken(tokenBean.getToken());
                                        onLoginListener.onSuccess(tokenBean);
                                    }
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            } else {
                                onLoginListener.onError();
                            }
                        }

                        @Override
                        public void onCacheSuccess(com.lzy.okgo.model.Response<Object> response) {
                        }

                        @Override
                        public void onError(com.lzy.okgo.model.Response<Object> response) {
                            onLoginListener.onError();
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


}
