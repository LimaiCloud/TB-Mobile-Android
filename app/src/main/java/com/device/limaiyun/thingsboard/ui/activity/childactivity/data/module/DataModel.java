package com.device.limaiyun.thingsboard.ui.activity.childactivity.data.module;

import com.device.limaiyun.thingsboard.base.Configs;
import com.device.limaiyun.thingsboard.bean.DashBoardsBean;
import com.device.limaiyun.thingsboard.bean.DeviceTypeBean;
import com.device.limaiyun.thingsboard.bean.TokenBean;
import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.Callback;
import com.lzy.okgo.model.Progress;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;

import java.io.IOException;

import okhttp3.ResponseBody;
import okio.BufferedSource;

/**
 * Created by Administrator on 2018/6/19 0019.
 */

public class DataModel implements DataPort {

    private DashBoardsBean boardsBean;

    @Override
    public void getDashBoards(String scopes,String customerId, final DashboardsListener listener) {
        if (TokenBean.TOKEN == null | TokenBean.TOKEN.equals("")) {
            listener.TokenIsEmpty();
            return;
        }
//        OkGo.<DashBoardsBean>get(Configs.BASE_URL + Configs.API_TENANT_DASHBOARDS + 10)
//                .headers(Configs.Authorization, Configs.BEARER + Configs.SPACE + TokenBean.TOKEN)
//                .tag(this)
//                .execute(new Callback<DashBoardsBean>() {
//                    @Override
//                    public void onStart(Request<DashBoardsBean, ? extends Request> request) {
//
//                    }
//
//                    @Override
//                    public void onSuccess(Response<DashBoardsBean> response) {
//                        if (response.code() == 200) {
//                            ResponseBody body = response.getRawResponse().body();
//                            BufferedSource source = body.source();
//                            try {
//                                String result = source.readUtf8();
//                                if (result != null) {
//                                    Gson gson = new Gson();
//                                    boardsBean = gson.fromJson(result, DashBoardsBean.class);
//                                    listener.getDashBoardSuc(boardsBean);
//                                }
//                            } catch (IOException e) {
//                                e.printStackTrace();
//                            }
//                        }
//                    }
//
//                    @Override
//                    public void onCacheSuccess(Response<DashBoardsBean> response) {
//
//                    }
//
//                    @Override
//                    public void onError(Response<DashBoardsBean> response) {
//
//                    }
//
//                    @Override
//                    public void onFinish() {
//
//                    }
//
//                    @Override
//                    public void uploadProgress(Progress progress) {
//
//                    }
//
//                    @Override
//                    public void downloadProgress(Progress progress) {
//
//                    }
//
//                    @Override
//                    public DashBoardsBean convertResponse(okhttp3.Response response) throws Throwable {
//
//                        return null;
//                    }
//                });
        if (scopes != null && scopes.equals("CUSTOMER_USER")) {
            OkGo.get(Configs.BASE_URL + Configs.API_CUSTOMER + customerId + Configs.CUSTOMER_DEVICES)
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

                                    listener.getDashBoardSuc(deviceTypeBean);
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
        } else {
            OkGo.get(Configs.BASE_URL + Configs.API_DEVICE_TYPES)
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
                                    listener.getDashBoardSuc(deviceTypeBean);
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
