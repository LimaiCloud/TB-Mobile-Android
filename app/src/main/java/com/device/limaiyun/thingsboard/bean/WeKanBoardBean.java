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
public class WeKanBoardBean {


    /**
     * _id : kEZAvHmggGDpufvJ8
     * title : 博萨任务督办
     */

    private String _id;
    private String title;

    public static List<WeKanBoardBean> arrayWeKanBoardBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<WeKanBoardBean>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<WeKanBoardBean> arrayWeKanBoardBeanFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<WeKanBoardBean>>() {
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
}
