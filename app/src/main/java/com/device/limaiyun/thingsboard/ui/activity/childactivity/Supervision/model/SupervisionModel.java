package com.device.limaiyun.thingsboard.ui.activity.childactivity.Supervision.model;

import android.util.Log;

import com.device.limaiyun.thingsboard.base.Configs;
import com.device.limaiyun.thingsboard.bean.WeKanBoardBean;
import com.device.limaiyun.thingsboard.bean.WeKanUserToken;
import com.device.limaiyun.thingsboard.utils.env.Constant;
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
import okio.BufferedSource;

/**
 * Created by ${Winter} on 2018/9/11.
 */
public class SupervisionModel implements SupervisionProt {
    @Override
    public void getUserToken(String url, String username, String password, final SupervisionListener listener) {
        HashMap<String,Object> map = new HashMap<>();
        map.put("username",username);
        map.put("password",password);
        JSONObject jsonObject = new JSONObject(map);
        OkGo.post(url)
                .tag(this)
                .upJson(jsonObject)
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
                                Gson gson = new Gson();
                                WeKanUserToken weKanUserToken = gson.fromJson(result, WeKanUserToken.class);
                                if (weKanUserToken != null){
                                    listener.getWeKanUserTokenSuc(weKanUserToken.getId(),weKanUserToken.getToken());
                                }else {
                                    listener.getWeKanUserTokenFail();
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
    public void getUserBoard(String url, final String userId, final String token, final SupervisionListener listener) {
//        HashMap<String,Object> map = new HashMap<>();
//        map.put("action","takeOwnership");
//        JSONObject jsonObject = new JSONObject(map);
        OkGo.get(url+userId+ Constant.API_WEKAN_BOARDS)
                .headers(Configs.Authorization,Configs.BEARER+Configs.SPACE+token)
                .headers(Configs.CONTENT_TYPE,Configs.APPLICATION_JSON)
//                .upJson(jsonObject)
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
                                Log.e("resuslt",result);
                                List<WeKanBoardBean> weKanBoardBeans = WeKanBoardBean.arrayWeKanBoardBeanFromData(result);
//                                Gson gson = new Gson();
//                                WeKanBoardBean weKanBoardBean = gson.fromJson(result, WeKanBoardBean.class);
                                if (weKanBoardBeans != null){
                                    listener.showBoardsSuc(weKanBoardBeans, token,userId);
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
