package com.device.limaiyun.thingsboard.bean;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ${Winter} on 2018/9/19.
 */
public class WeKanTitleBean implements Parcelable{


    /**
     * _id : noLEcox92Hk4srEpp
     * title : 待办任务
     */

    private String _id;
    private String title;
    public boolean isChecked;

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public static Creator<WeKanTitleBean> getCREATOR() {
        return CREATOR;
    }

    public WeKanTitleBean(Parcel source) {
        this._id = source.readString();
        this.title = source.readString();
    }

    public static List<WeKanTitleBean> arrayWeKanTitleBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<WeKanTitleBean>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<WeKanTitleBean> arrayWeKanTitleBeanFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<WeKanTitleBean>>() {
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


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(_id);
    }
    public static final Parcelable.Creator<WeKanTitleBean> CREATOR = new Parcelable.Creator<WeKanTitleBean>() {
        @Override
        public WeKanTitleBean createFromParcel(Parcel source) {
            return new WeKanTitleBean(source);
        }

        @Override
        public WeKanTitleBean[] newArray(int size) {
            return new WeKanTitleBean[size];
        }
    };
}
