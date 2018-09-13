package com.device.limaiyun.thingsboard.bean;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ${Winter} on 2018/9/11.
 */
public class WeKanUserToken {


    /**
     * id : 6zAdix88mzTZNYWB6
     * token : WamMr32HBdScf2r8PcETUFzC_FaADYkPFn_YVL44uT7
     * tokenExpires : 2018-12-10T05:54:40.587Z
     */

    private String id;
    private String token;
    private String tokenExpires;

    public static List<WeKanUserToken> arrayWeKanUserTokenFromData(String str) {

        Type listType = new TypeToken<ArrayList<WeKanUserToken>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<WeKanUserToken> arrayWeKanUserTokenFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<WeKanUserToken>>() {
            }.getType();

            return new Gson().fromJson(jsonObject.getString(str), listType);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new ArrayList();


    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTokenExpires() {
        return tokenExpires;
    }

    public void setTokenExpires(String tokenExpires) {
        this.tokenExpires = tokenExpires;
    }
}
