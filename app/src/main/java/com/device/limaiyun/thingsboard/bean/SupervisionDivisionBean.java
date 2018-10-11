package com.device.limaiyun.thingsboard.bean;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ${Winter} on 2018/9/20.
 */
public class SupervisionDivisionBean {

    /**
     * _id : HKuSCkQuC4vewKzhg
     * title : Card title text
     * description :
     */

    private String _id;
    private String title;
    private String description;

    public static List<SupervisionDivisionBean> arraySupervisionDivisionBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<SupervisionDivisionBean>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<SupervisionDivisionBean> arraySupervisionDivisionBeanFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<SupervisionDivisionBean>>() {
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
