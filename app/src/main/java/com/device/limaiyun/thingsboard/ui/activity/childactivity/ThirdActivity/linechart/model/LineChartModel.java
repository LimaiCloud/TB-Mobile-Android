package com.device.limaiyun.thingsboard.ui.activity.childactivity.ThirdActivity.linechart.model;

import android.util.Log;

import com.device.limaiyun.thingsboard.base.Configs;
import com.device.limaiyun.thingsboard.bean.TokenBean;
import com.device.limaiyun.thingsboard.utils.ToastUtils;
import com.device.limaiyun.thingsboard.utils.env.Constant;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.Callback;
import com.lzy.okgo.model.Progress;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft_17;
import org.java_websocket.handshake.ServerHandshake;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import okhttp3.ResponseBody;
import okio.BufferedSource;

/**
 * Created by Administrator on 2018/7/3 0003.
 */

public class LineChartModel implements LineChartPort {
    private Draft_17 draft_17;
    private WebSocketClient client;
    private String entityId;
    private WebSocketClient client2;

    @Override
    public void getDashBoardDetil(final String entityId, final String lTime, final LineChartListener chartListener) {
        draft_17 = new Draft_17();
        this.entityId = entityId;
        try {
            client = new WebSocketClient(new URI(Constant.API_WS_URL + TokenBean.TOKEN), draft_17) {
                @Override
                public void onOpen(ServerHandshake handshakedata) {
                    if (lTime != null) {
                        Log.e("lTime", lTime);
                        Long i = Long.parseLong(lTime) - 604799797;
//                        String send = "{\"tsSubCmds\":[{\"entityType\":\"DEVICE\",\"entityId\":" + "\"" + entityId + "\"" + ",\"keys\":\"daliy#数量,daliy#电量\",\"startTs\":" + "\"" + lTime + "\"" + ",\"timeWindow\":604801000,\"interval\":1000,\"limit\":500,\"agg\":\"NONE\",\"cmdId\":2}],\"historyCmds\":[{\"entityType\":\"DEVICE\",\"entityId\":" + "\"" + entityId + "\"" + ",\"keys\":\"daliy#数量,daliy#电量\",\"startTs\":"+"\""+lTime+"\""+",\"endTs\":1530686122000,\"interval\":1000,\"limit\":100,\"agg\":\"NONE\",\"cmdId\":3}],\"attrSubCmds\":[]}";
                        String send = "{\"tsSubCmds\":[{\"entityType\":\"DEVICE\",\"entityId\":" + "\"" + entityId + "\"" + ",\"keys\":\"daliy#数量,daliy#电量\",\"startTs\":" + i + ",\"timeWindow\":604801000,\"interval\":1000,\"limit\":7,\"agg\":\"NONE\",\"cmdId\":1}],\"historyCmds\":[],\"attrSubCmds\":[]}";

                        client.send(send);
                        Log.e("lTime", send);
                    }
                }

                @Override
                public void onMessage(String message) {
                    Log.e("message", message);
                    if (message.isEmpty()) {
                        ToastUtils.showShortToast("暂无数据");
                        return;
                    }
                    try {
                        JSONObject object = new JSONObject(message);
                        JSONObject data = object.optJSONObject("data");
//
                        Iterator<String> iterator = data.keys();
                        List<String> key_title = new ArrayList<>();
                        List<List<Map<Long, String>>> data_list = new ArrayList<>();
                        while (iterator.hasNext()) {
                            String key = iterator.next();
                            key_title.add(key);
                            JSONArray jsonArray = data.optJSONArray(key);
                            List<Map<Long, String>> key_value_list = new ArrayList<>();
                            for (int i = 0; i < jsonArray.length(); i++) {
                                Map<Long, String> map = new HashMap<>();
                                JSONArray jsonArray1 = jsonArray.getJSONArray(i);
                                long time = jsonArray1.optLong(0);
                                String value = jsonArray1.optString(1);
                                map.put(time, value);
                                key_value_list.add(map);
                            }
                            data_list.add(key_value_list);
                        }
                        if (data_list.size() == 0) {
                            chartListener.getDashBoardDetilFail();
                        } else {
                            chartListener.getEtcSuc(key_title, data_list);
                        }
//                        }

                        client.close();
//                        client2.connect();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }

                @Override
                public void onClose(int code, String reason, boolean remote) {

                }

                @Override
                public void onError(Exception ex) {

                }
            }

            ;
            client.connect();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        try {
            client2 = new WebSocketClient(new URI(Constant.API_WS_URL + TokenBean.TOKEN), draft_17) {
                @Override
                public void onOpen(ServerHandshake handshakedata) {
                    String send = "{\"tsSubCmds\":[{\"entityType\":\"DEVICE\",\"entityId\":" + "\"" + entityId + "\"" + ",\"keys\":\"count,state\",\"startTs\":1530084349000,\"timeWindow\":604801000,\"interval\":1000,\"limit\":200,\"agg\":\"NONE\",\"cmdId\":1}],\"historyCmds\":[],\"attrSubCmds\":[]}";
                    client2.send(send);
                }

                @Override
                public void onMessage(String message) {
                    if (message.isEmpty()) {
                        ToastUtils.showShortToast("暂无数据");
                        return;
                    }
                    JSONObject object = null;
                    try {
                        object = new JSONObject(message);
                        JSONObject data = object.optJSONObject("data");
                        if (data == null) {
                            chartListener.getDashBoardDetilFail();
                            return;
                        }
                        Iterator<String> iterator = data.keys();
                        List<String> key_title = new ArrayList<>();
                        List<List<Map<Long, String>>> data_list = new ArrayList<>();
                        List<Map<Long, String>> key_value_list = new ArrayList<>();
                        while (iterator.hasNext()) {
                            String key = iterator.next();
                            key_title.add(key);
                            JSONArray jsonArray = data.optJSONArray(key);
                            for (int i = 0; i < jsonArray.length(); i++) {
                                Map<Long, String> map = new HashMap<>();
                                JSONArray jsonArray1 = jsonArray.getJSONArray(i);
                                long time = jsonArray1.optLong(0);
                                String value = jsonArray1.optString(1);
                                map.put(time, value);
                                key_value_list.add(map);
                            }
                            data_list.add(key_value_list);
                        }
                        if (data_list.size() == 0) {
                            chartListener.getDashBoardDetilFail();
                        } else {
                            chartListener.getCountSuc(key_title, data_list);

                        }
                        client2.close();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }

                @Override
                public void onClose(int code, String reason, boolean remote) {

                }

                @Override
                public void onError(Exception ex) {
                }
            };
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void getTime(final LineChartListener listener) {
        OkGo.get(Constant.SERVER_URL_STR + Constant.API_GET_TIME)
                .headers(Configs.Authorization, Configs.BEARER + Configs.SPACE + TokenBean.TOKEN)
                .tag(this)
                .execute(new Callback<Object>() {
                    @Override
                    public void onStart(Request<Object, ? extends Request> request) {


                    }

                    @Override
                    public void onSuccess(Response<Object> response) {
                        String time = null;
                        if (response.code() == 200) {
                            ResponseBody body = response.getRawResponse().body();
                            BufferedSource source = body.source();
                            try {
                                time = source.readUtf8();

                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            Log.e("lTime", time);
                            listener.getTime(time);
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
