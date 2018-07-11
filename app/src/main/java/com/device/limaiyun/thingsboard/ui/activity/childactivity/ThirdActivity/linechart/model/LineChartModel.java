package com.device.limaiyun.thingsboard.ui.activity.childactivity.ThirdActivity.linechart.model;

import android.text.TextUtils;

import com.device.limaiyun.thingsboard.base.Configs;
import com.device.limaiyun.thingsboard.bean.TokenBean;
import com.device.limaiyun.thingsboard.utils.ToastUtils;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft_17;
import org.java_websocket.handshake.ServerHandshake;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/7/3 0003.
 */

public class LineChartModel implements LineChartPort {
    private Draft_17 draft_17;
    private WebSocketClient client;
    private String entityId;
    private WebSocketClient client2;

    @Override
    public void getDashBoardDetil(final String entityId, final LineChartListener chartListener) {
        draft_17 = new Draft_17();
        this.entityId = entityId;
        try {
            client = new WebSocketClient(new URI(Configs.WS_URL + TokenBean.TOKEN), draft_17) {
                @Override
                public void onOpen(ServerHandshake handshakedata) {
                    String send = "{\"tsSubCmds\":[{\"entityType\":\"DEVICE\",\"entityId\":" + "\"" + entityId + "\"" + ",\"keys\":\"电量,电流\",\"startTs\":1530686122000,\"timeWindow\":61000,\"interval\":1000,\"limit\":500,\"agg\":\"NONE\",\"cmdId\":2}],\"historyCmds\":[{\"entityType\":\"DEVICE\",\"entityId\":" + "\"" + entityId + "\"" + ",\"keys\":\"电量,电流\",\"startTs\":1499150122000,\"endTs\":1530686122000,\"interval\":1000,\"limit\":100,\"agg\":\"NONE\",\"cmdId\":3}],\"attrSubCmds\":[]}";
                    client.send(send);
                }

                @Override
                public void onMessage(String message) {
                    if (message.isEmpty()) {
                        ToastUtils.showShortToast("暂无数据");
                        return;
                    }
                    try {
                        JSONObject object = new JSONObject(message);
                        JSONObject data = object.optJSONObject("data");

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
                        client.close();
                        client2.connect();
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
            client.connect();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        try {
            client2 = new WebSocketClient(new URI(Configs.WS_URL + TokenBean.TOKEN), draft_17) {
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
                        if (data_list.size()== 0) {
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
}
