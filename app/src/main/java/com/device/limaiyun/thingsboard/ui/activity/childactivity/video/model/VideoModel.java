package com.device.limaiyun.thingsboard.ui.activity.childactivity.video.model;

import com.device.limaiyun.thingsboard.base.Configs;
import com.device.limaiyun.thingsboard.bean.YSAccessTokenBean;
import com.device.limaiyun.thingsboard.bean.YSVideoListBean;
import com.device.limaiyun.thingsboard.utils.env.Constant;
import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.Callback;
import com.lzy.okgo.model.Progress;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;

import java.io.IOException;

/**
 * Created by ${Winter} on 2018/10/16.
 */
public class VideoModel implements VideoPort {
    @Override
    public void getAccessToken(String key, String sercet, final VideoListener listener) {
        OkGo.post(Constant.API_YS_TOKEN)
                .headers(Configs.CONTENT_TYPE,Configs.APPLICATION_X_WWW_FORM_URLENCODED)
                .params(Configs.YS_APP_KEY, Configs.YS_KEY)
                .params(Configs.YS_APP_SERCET,Configs.YS_SERCET)
                .tag(this)
                .execute(new Callback<Object>() {
                    @Override
                    public void onStart(Request<Object, ? extends Request> request) {

                    }

                    @Override
                    public void onSuccess(Response<Object> response) {
                        if (response.code() == 200){
                            try {
                                String result = response.getRawResponse().body().source().readUtf8();
                                YSAccessTokenBean accessTokenBean = new Gson().fromJson(result, YSAccessTokenBean.class);
                                listener.getYSAccessTokenSuc(accessTokenBean);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }else {
                            listener.getYSAccessTokenFail();
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

    @Override
    public void getVideoMonitorList(final YSAccessTokenBean accessTokenBean, final VideoListener listener) {
        OkGo.post(Constant.API_YS_VIDEO_LIST)
                .headers(Configs.CONTENT_TYPE,Configs.APPLICATION_X_WWW_FORM_URLENCODED)
                .params(Configs.YS_ACCESS_TOKEN,accessTokenBean.getData().getAccessToken())
                .params(Configs.YS_PAGE_START,0)
                .params(Configs.YS_PAGE_SIZE,10)
                .tag(this)
                .execute(new Callback<Object>() {
                    @Override
                    public void onStart(Request<Object, ? extends Request> request) {

                    }

                    @Override
                    public void onSuccess(Response<Object> response) {
                        if (response.code()==200){
                            try {
                                String result = response.getRawResponse().body().source().readUtf8();
                                YSVideoListBean ysVideoListBean = new Gson().fromJson(result, YSVideoListBean.class);
                                listener.getVideoListSuc(ysVideoListBean,accessTokenBean);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }else {
                            listener.getVideoListFail();
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
