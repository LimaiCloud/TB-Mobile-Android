package com.device.limaiyun.thingsboard.ui.activity.childactivity.Supervision.child.child.model;

import com.device.limaiyun.thingsboard.base.Configs;
import com.device.limaiyun.thingsboard.bean.SupervisionDetilsBean;
import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.Callback;
import com.lzy.okgo.model.Progress;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;

import java.io.IOException;

/**
 * Created by ${Winter} on 2018/9/29.
 */
public class SupervisionDetilsModel implements SupervisionDetilsPort {
    @Override
    public void getCardDetis(String url, String token, final SupervisionDetilsListener listener) {
        OkGo.get(url)
                .tag(this)
                .headers(Configs.Authorization, Configs.BEARER + Configs.SPACE + token)
                .execute(new Callback<Object>() {
                    @Override
                    public void onStart(Request<Object, ? extends Request> request) {

                    }

                    @Override
                    public void onSuccess(Response<Object> response) {
                        if(response.code() == 200){
                            try {
                                String result = response.getRawResponse().body().source().readUtf8();
                                Gson gson = new Gson();
                                SupervisionDetilsBean supervisionDetilsBean = gson.fromJson(result, SupervisionDetilsBean.class);
                                if (supervisionDetilsBean != null){
                                    listener.getSupervisionDetilsSuc(supervisionDetilsBean);
                                }else {
                                    listener.getSupervisionDetilsFail();
                                }
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
