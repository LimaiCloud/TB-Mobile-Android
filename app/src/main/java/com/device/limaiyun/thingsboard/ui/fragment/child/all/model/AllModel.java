package com.device.limaiyun.thingsboard.ui.fragment.child.all.model;


import android.content.Context;

import com.auth0.android.jwt.JWT;
import com.device.limaiyun.thingsboard.base.Configs;
import com.device.limaiyun.thingsboard.bean.DeviceTypeBean;
import com.device.limaiyun.thingsboard.bean.TokenBean;
import com.device.limaiyun.thingsboard.refreshToken.RefreshTokenModel;
import com.device.limaiyun.thingsboard.refreshToken.RefreshTokenPort;
import com.device.limaiyun.thingsboard.utils.env.Constant;
import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.Callback;
import com.lzy.okgo.model.Progress;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;

import java.io.IOException;
import java.util.List;

import okhttp3.ResponseBody;
import okio.BufferedSource;

/**
 * Created by Administrator on 2018/5/14 0014.
 */

public class AllModel implements AllPort {


    private String customerId;
    private List<String> scopes;

    //RefreshToken
    private RefreshTokenPort refreshTokenPort;

    @Override
    public void getDevuceType(final Context mContext, final OnDeviceTypeListener onDeviceTypeListener) {
        if (TokenBean.TOKEN != "") {
            JWT jwt = new JWT(TokenBean.TOKEN);
            customerId = jwt.getClaim("customerId").asString();
            scopes = jwt.getClaim("scopes").asList(String.class);
        }
        String scope = scopes.get(0);
        if (scope!=null && scope.equals("CUSTOMER_USER")){
            OkGo.get(Constant.API_SERVE_URL + Constant.API_CUSTOMER + customerId + Constant.API_CUSTOMER_DEVICES)
                    .headers(Configs.Authorization, Configs.BEARER + Configs.SPACE + TokenBean.TOKEN)
                    .tag(this)
                    .execute(new Callback<Object>() {
                        @Override
                        public void onStart(Request<Object, ? extends Request> request) {

                        }

                        @Override
                        public void onSuccess(Response<Object> response) {
                            if (response.code() == 200) {
                                ResponseBody raw_body = response.getRawResponse().body();
                                BufferedSource source = raw_body.source();
                                try {
                                    String result = source.readUtf8();
                                    Gson gson = new Gson();
                                    DeviceTypeBean deviceTypeBean = gson.fromJson(result, DeviceTypeBean.class);

                                    onDeviceTypeListener.getDeviceTypeSuccess(deviceTypeBean);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }else if (response.code() == 401){
                             refreshTokenPort = new RefreshTokenModel();
                             refreshTokenPort.refreshToken(mContext);
                            }
                        }

                        @Override
                        public void onCacheSuccess(Response<Object> response) {

                        }

                        @Override
                        public void onError(Response<Object> response) {

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
                        public Object convertResponse(okhttp3.Response response) throws Throwable {
                            return null;
                        }
                    });
        }else {
            OkGo.get(Constant.SERVER_URL_STR + Constant.API_DEVICE_TYPE)
                    .headers(Configs.Authorization, Configs.BEARER + Configs.SPACE + TokenBean.TOKEN)
                    .tag(this)
                    .execute(new Callback<Object>() {
                        @Override
                        public void onStart(Request<Object, ? extends Request> request) {

                        }

                        @Override
                        public void onSuccess(Response<Object> response) {
                            if (response.code() == 200) {
                                ResponseBody raw_body = response.getRawResponse().body();
                                BufferedSource source = raw_body.source();
                                try {
                                    String result = source.readUtf8();
                                    Gson gson = new Gson();
                                    DeviceTypeBean deviceTypeBean = gson.fromJson(result, DeviceTypeBean.class);

//
                                    onDeviceTypeListener.getDeviceTypeSuccess(deviceTypeBean);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        }

                        @Override
                        public void onCacheSuccess(Response<Object> response) {

                        }

                        @Override
                        public void onError(Response<Object> response) {

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
                        public Object convertResponse(okhttp3.Response response) throws Throwable {
                            return null;
                        }
                    });
        }
    }
}
