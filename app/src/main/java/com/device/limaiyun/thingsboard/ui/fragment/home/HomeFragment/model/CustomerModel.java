package com.device.limaiyun.thingsboard.ui.fragment.home.HomeFragment.model;

import android.content.Context;

import com.device.limaiyun.thingsboard.bean.WantedBean;
import com.device.limaiyun.thingsboard.refreshToken.RefreshTokenModel;
import com.device.limaiyun.thingsboard.utils.env.Constant;
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
 * Created by Administrator on 2018/6/25 0025.
 */

public class CustomerModel implements CustomerPort {

    private List<WantedBean> wantedBeans;
    private RefreshTokenModel refreshTokenModel;

    @Override
    public void getCustomer() {

    }

    @Override
    public void getTitle(final Context context, final OnWantedListener listener) {
        OkGo.get(Constant.API_WANTED)
                .tag(this)
                .execute(new Callback<Object>() {
                    @Override
                    public void onStart(Request<Object, ? extends Request> request) {

                    }

                    @Override
                    public void onSuccess(Response<Object> response) {
                        if (response.code() == 200){
                            ResponseBody body = response.getRawResponse().body();
                            BufferedSource source = body.source();
                            try {
                                String result = source.readUtf8();
                                wantedBeans = WantedBean.arrayWantedBeanFromData(result);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            listener.getWantedSuc(wantedBeans);
                        }else if (response.code() == 401){
                            refreshTokenModel = new RefreshTokenModel();
                            refreshTokenModel.refreshToken(context);
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
