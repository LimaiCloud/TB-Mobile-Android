package com.device.limaiyun.thingsboard.ui.fragment.home.CmriFragment.model;

import android.text.TextUtils;
import android.util.Log;

import com.device.limaiyun.thingsboard.base.Configs;
import com.device.limaiyun.thingsboard.bean.UsersBean;
import com.device.limaiyun.thingsboard.utils.ToastUtils;
import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.Callback;
import com.lzy.okgo.model.Progress;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import okio.BufferedSource;

/**
 * Created by Administrator on 2018/7/5 0005.
 */

public class CmriModel implements CmriPort {
    @Override
    public void getCmri(String token, final CmriListener listener) {
        if (TextUtils.isEmpty(token) || token == null) {
            ToastUtils.showShortToast("无法获取用户信息");
            return;
        }
        OkGo.get(Configs.USERS + token)
                .tag(this)
                .execute(new Callback<Object>() {
                    @Override
                    public void onStart(Request<Object, ? extends Request> request) {

                    }

                    @Override
                    public void onSuccess(Response<Object> response) {
                        if (response.code() == 200) {
                            ResponseBody body = response.getRawResponse().body();
                            BufferedSource source = body.source();
                            try {
                                String result = source.readUtf8();
                                JSONObject object = new JSONObject(result);
                                UsersBean usersBean = new UsersBean();
                                int code = object.optInt("code");
                                usersBean.setCode(code);
                                if (code == 1) {
                                    JSONArray jsonArray = object.optJSONArray("data");
                                    List<UsersBean.DataBean> data_list = new ArrayList<>();
                                    for (int i = 0; i < jsonArray.length(); i++) {
                                        UsersBean.DataBean dataBean = new UsersBean.DataBean();
                                        JSONObject data_obj = jsonArray.optJSONObject(i);
                                        int uid = data_obj.optInt("uid");
                                        dataBean.setUid(uid);
                                        String account = data_obj.optString("account");
                                        dataBean.setAccount(account);
                                        String password = data_obj.optString("password");
                                        dataBean.setPassword(password);
                                        String tel = data_obj.optString("tel");
                                        dataBean.setTel(tel);
                                        String email = data_obj.optString("email");
                                        dataBean.setEmail(email);
                                        String role = data_obj.optString("role");
                                        dataBean.setRole(role);
                                        String title = data_obj.optString("title");
                                        dataBean.setTitle(title);
                                        String name = data_obj.optString("name");
                                        dataBean.setName(name);
                                        data_list.add(dataBean);
                                    }
                                    usersBean.setData(data_list);
                                    listener.getCmriSuc(usersBean);
                                } else {
                                    listener.getCmriFail();
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                            } catch (JSONException e) {
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
