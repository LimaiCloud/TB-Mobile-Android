package com.device.limaiyun.thingsboard.ui.activity.childactivity.equipment.child.model;

import android.util.Log;

import com.device.limaiyun.thingsboard.bean.EquipmentDetialBean;
import com.device.limaiyun.thingsboard.bean.TokenBean;
import com.device.limaiyun.thingsboard.utils.ToastUtils;
import com.device.limaiyun.thingsboard.utils.env.Constant;

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
 * Created by Administrator on 2018/6/27 0027.
 */

public class EqipDetiModel implements EqipDetiPort {
    private Draft_17 draft_17;
    private WebSocketClient client;
    private String entityId;
    private EquipmentDetialBean detialBean;

    @Override
    public void getNewDetial(String id, final EquipDetilListener listener) {
        draft_17 = new Draft_17();
        entityId = id;
        Log.e("---------", entityId);
//        client.send("\"enttyId\":"+"\""+entityId+"\"");
        try {
            client = new WebSocketClient(new URI(Constant.API_WS_URL + TokenBean.getInstence().getToken()), draft_17) {
                @Override
                public void onOpen(ServerHandshake handshakedata) {
//                    String sent = "{\"tsSubCmds\":[{\"entityType\":\"DEVICE\",\"entityId\":"+"\""+entityId+"\"" +",\"scope\":\"LATEST_TELEMETRY\",\"cmdId\":2}],\"historyCmds\":[],\"attrSubCmds\":[]}";
//                    Log.e("---------", sent);
                    client.send("{\"tsSubCmds\":[{\"entityType\":\"DEVICE\",\"entityId\":" + "\"" + entityId + "\"" + ",\"scope\":\"LATEST_TELEMETRY\",\"cmdId\":2}],\"historyCmds\":[],\"attrSubCmds\":[]}");

                }

                @Override
                public void onMessage(String message) {
                    if (message.isEmpty()) {
                        ToastUtils.showShortToast("暂无数据");
                        return;
                    }
                    try {
                        JSONObject object = new JSONObject(message);
                        detialBean = new EquipmentDetialBean();
                        int subscriptionId = object.optInt("subscriptionId");
                        detialBean.setSubscriptionId(subscriptionId);
                        int errorCode = object.optInt("errorCode");
                        detialBean.setErrorCode(errorCode);
                        Object errorMsg = object.opt("errorMsg");
                        detialBean.setErrorMsg(errorMsg);
                        JSONObject latestValues = object.optJSONObject("latestValues");
                        EquipmentDetialBean.LatestValuesBean latestValuesBean = new EquipmentDetialBean.LatestValuesBean();
                        detialBean.setLatestValues(latestValuesBean);
                        JSONObject data = object.optJSONObject("data");
                        EquipmentDetialBean.DataBean dataBean = new EquipmentDetialBean.DataBean();
                        detialBean.setData(dataBean);
                        Iterator<String> iterator = data.keys();
                        List<List<Map<Long, String>>> key_list = new ArrayList<>();
                        dataBean.setKey(key_list);
                        ArrayList<String> title = new ArrayList<>();
                        dataBean.setTitle(title);
                        while (iterator.hasNext()) {
                            String key = iterator.next();
                            title.add(key);
                            long last_count = latestValues.getLong(key);
                            detialBean.getLatestValues().setKey(last_count);

                            JSONArray jsonArray = data.optJSONArray(key);
                            List<Map<Long, String>> list_map = new ArrayList<>();
                            for (int i = 0; i < jsonArray.length(); i++) {
                                Map<Long, String> map = new HashMap<>();
                                JSONArray jsonArray1 = jsonArray.getJSONArray(i);
                                Long time = jsonArray1.optLong(0);
                                String number = jsonArray1.optString(1);
                                map.put(time, number);
                                list_map.add(map);
                                key_list.add(list_map);
                                dataBean.getKey().set(i,list_map);
//                                dataBean.getKey().get(i).add(map);
                            }
                        }
                        listener.getNewDetilOnSuc(detialBean);
                        client.close();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }

                @Override
                public void onClose(int code, String reason, boolean remote) {
                    Log.e("------------",reason.toString());
                }

                @Override
                public void onError(Exception ex) {
                }
            };
            client.connect();

        } catch (URISyntaxException e) {
            Log.e("ws", e.toString());
            e.printStackTrace();
        }
    }
}
