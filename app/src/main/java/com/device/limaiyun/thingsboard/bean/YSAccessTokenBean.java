package com.device.limaiyun.thingsboard.bean;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ${Winter} on 2018/10/16.
 */
public class YSAccessTokenBean {

    /**
     * data : {"accessToken":"at.6c514m682yfxin3x54j9f955c1vy9l4n-5fi63jopul-0no3rlc-auqscnatj","expireTime":1540262066141}
     * code : 200
     * msg : 操作成功!
     */

    private DataBean data;
    private String code;
    private String msg;

    public static List<YSAccessTokenBean> arrayYSAccessTokenBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<YSAccessTokenBean>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<YSAccessTokenBean> arrayYSAccessTokenBeanFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<YSAccessTokenBean>>() {
            }.getType();

            return new Gson().fromJson(jsonObject.getString(str), listType);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new ArrayList();


    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static class DataBean {
        /**
         * accessToken : at.6c514m682yfxin3x54j9f955c1vy9l4n-5fi63jopul-0no3rlc-auqscnatj
         * expireTime : 1540262066141
         */

        private String accessToken;
        private long expireTime;

        public static List<DataBean> arrayDataBeanFromData(String str) {

            Type listType = new TypeToken<ArrayList<DataBean>>() {
            }.getType();

            return new Gson().fromJson(str, listType);
        }

        public static List<DataBean> arrayDataBeanFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);
                Type listType = new TypeToken<ArrayList<DataBean>>() {
                }.getType();

                return new Gson().fromJson(jsonObject.getString(str), listType);

            } catch (JSONException e) {
                e.printStackTrace();
            }

            return new ArrayList();


        }

        public String getAccessToken() {
            return accessToken;
        }

        public void setAccessToken(String accessToken) {
            this.accessToken = accessToken;
        }

        public long getExpireTime() {
            return expireTime;
        }

        public void setExpireTime(long expireTime) {
            this.expireTime = expireTime;
        }
    }
}
