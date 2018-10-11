package com.device.limaiyun.thingsboard.ui.activity.childactivity.Supervision.addSupervisionChild.model;

import com.device.limaiyun.thingsboard.base.Configs;
import com.device.limaiyun.thingsboard.bean.AddSupervisionBean;
import com.device.limaiyun.thingsboard.bean.WeKanTitleBean;
import com.google.gson.Gson;
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
 * Created by ${Winter} on 2018/10/9.
 */
public class AddSupervisionModel implements AddSupervisionPort{
    @Override
    public void getSupervisionTitles(final String url, String wekan_token, final AddSupervisionListener listener) {
        OkGo.get(url)
                .tag(this)
                .headers(Configs.Authorization,Configs.BEARER+Configs.SPACE+wekan_token)
                .execute(new Callback<Object>() {
                    @Override
                    public void onStart(Request<Object, ? extends Request> request) {

                    }

                    @Override
                    public void onSuccess(Response<Object> response) {
                        if (response.code() == 200){
                            ResponseBody body = response.getRawResponse().body();
                            try {
                                String result = body.source().readUtf8();
                                List<WeKanTitleBean> weKanTitleBeans = WeKanTitleBean.arrayWeKanTitleBeanFromData(result);
                                if (weKanTitleBeans != null){
                                    listener.getTitleSuc(weKanTitleBeans,url);
                                }else {
                                    listener.getTitleFail();
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
    public void postAddSupervision(String title, String description, String url, String list_id, String user_id, String token, final AddSupervisionListener listener) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("title",title);
        map.put("description",description);
        map.put("authorId",user_id);
        map.put("swimlaneId",list_id);
        JSONObject jsonObject = new JSONObject(map);
        OkGo.post(url)
                .tag(this)
                .headers(Configs.Authorization,Configs.BEARER+Configs.SPACE+token)
                .headers(Configs.CONTENT_TYPE,Configs.APPLICATION_JSON)
                .upJson(jsonObject)
                .execute(new Callback<Object>() {
                    @Override
                    public void onStart(Request<Object, ? extends Request> request) {

                    }

                    @Override
                    public void onSuccess(Response<Object> response) {
                        if (response.code()==200){
                            try {
                                String result = response.getRawResponse().body().source().readUtf8();
                                Gson gson = new Gson();
                                AddSupervisionBean addSupervisionBean = gson.fromJson(result, AddSupervisionBean.class);
                                listener.postAddSupervisionSuc(addSupervisionBean);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }else {
                            listener.postAddSupervisionFail();
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
