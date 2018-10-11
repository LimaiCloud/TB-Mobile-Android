package com.device.limaiyun.thingsboard.ui.fragment.supervision.model;

import com.device.limaiyun.thingsboard.base.Configs;
import com.device.limaiyun.thingsboard.bean.SupervisionDivisionBean;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.Callback;
import com.lzy.okgo.model.Progress;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;

import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import okhttp3.ResponseBody;

/**
 * Created by ${Winter} on 2018/9/20.
 */
public class SupervisionFragmentModel implements SupervisionFragmentPort {
    private String list_url;

    @Override
    public void getSupervisionData(final String url, final String token, final SupervisionFragmentListener listener) {
        list_url = url;
        OkGo.get(url)
                .tag(this)
                .headers(Configs.Authorization, Configs.BEARER + Configs.SPACE + token)
                .execute(new Callback<Object>() {
                    @Override
                    public void onStart(Request<Object, ? extends Request> request) {

                    }

                    @Override
                    public void onSuccess(Response<Object> response) {
                        if (response.code() == 200) {
                            ResponseBody body = response.getRawResponse().body();
                            try {
                                String result = body.source().readUtf8();
                                List<SupervisionDivisionBean> supervisionDivisionBeans = SupervisionDivisionBean.arraySupervisionDivisionBeanFromData(result);
                                if (supervisionDivisionBeans != null) {
                                    listener.getSupervisionDivisionDataSuc(supervisionDivisionBeans, url, token);
                                } else {
                                    listener.getSupervisionDivisionDatafail();
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

    @Override
    public void putSupervisionStatus(final String url, String title, String description, final String mtoken, String chiose_id, final SupervisionFragmentListener listener) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("title", title);
        map.put("listId", chiose_id);
        map.put("description", description);
        JSONObject object = new JSONObject(map);
        OkGo.put(url)
                .tag(this)
                .headers(Configs.Authorization, Configs.BEARER + Configs.SPACE + mtoken)
                .headers(Configs.CONTENT_TYPE, Configs.APPLICATION_JSON)
                .upJson(object)
                .execute(new Callback<Object>() {
                    @Override
                    public void onStart(Request<Object, ? extends Request> request) {

                    }

                    @Override
                    public void onSuccess(Response<Object> response) {
                        if (response.code() == 200) {
                            try {
                                String result = response.getRawResponse().body().source().readUtf8();
                                if (result != null && list_url != null && !list_url.equals("")) {
                                    listener.putStatusSuc(list_url, mtoken);
                                } else {
                                    listener.putStatusFail();
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
