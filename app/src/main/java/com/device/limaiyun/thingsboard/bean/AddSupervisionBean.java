package com.device.limaiyun.thingsboard.bean;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ${Winter} on 2018/10/10.
 */
public class AddSupervisionBean {

    /**
     * _id : TK9FEbMLfFhztKekg
     */

    private String _id;

    public static List<AddSupervisionBean> arrayAddSupervisionBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<AddSupervisionBean>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<AddSupervisionBean> arrayAddSupervisionBeanFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<AddSupervisionBean>>() {
            }.getType();

            return new Gson().fromJson(jsonObject.getString(str), listType);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new ArrayList();


    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }
}
