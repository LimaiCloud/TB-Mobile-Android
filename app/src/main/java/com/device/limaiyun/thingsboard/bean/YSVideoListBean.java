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
public class YSVideoListBean {

    /**
     * page : {"total":1,"page":0,"size":2}
     * data : [{"deviceSerial":"142954663","channelNo":1,"channelName":"C5C(142954663)测试设备","status":1,"isShared":"0","picUrl":"https://statics.ys7.com/device/assets/imgs/public/homeDevice.jpeg","isEncrypt":0,"videoLevel":0}]
     * code : 200
     * msg : 操作成功!
     */

    private PageBean page;
    private String code;
    private String msg;
    private List<DataBean> data;

    public static List<YSVideoListBean> arrayYSVideoListBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<YSVideoListBean>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<YSVideoListBean> arrayYSVideoListBeanFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<YSVideoListBean>>() {
            }.getType();

            return new Gson().fromJson(jsonObject.getString(str), listType);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new ArrayList();


    }

    public PageBean getPage() {
        return page;
    }

    public void setPage(PageBean page) {
        this.page = page;
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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class PageBean {
        /**
         * total : 1
         * page : 0
         * size : 2
         */

        private int total;
        private int page;
        private int size;

        public static List<PageBean> arrayPageBeanFromData(String str) {

            Type listType = new TypeToken<ArrayList<PageBean>>() {
            }.getType();

            return new Gson().fromJson(str, listType);
        }

        public static List<PageBean> arrayPageBeanFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);
                Type listType = new TypeToken<ArrayList<PageBean>>() {
                }.getType();

                return new Gson().fromJson(jsonObject.getString(str), listType);

            } catch (JSONException e) {
                e.printStackTrace();
            }

            return new ArrayList();


        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public int getPage() {
            return page;
        }

        public void setPage(int page) {
            this.page = page;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }
    }

    public static class DataBean {
        /**
         * deviceSerial : 142954663
         * channelNo : 1
         * channelName : C5C(142954663)测试设备
         * status : 1
         * isShared : 0
         * picUrl : https://statics.ys7.com/device/assets/imgs/public/homeDevice.jpeg
         * isEncrypt : 0
         * videoLevel : 0
         */

        private String deviceSerial;
        private int channelNo;
        private String channelName;
        private int status;
        private String isShared;
        private String picUrl;
        private int isEncrypt;
        private int videoLevel;

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

        public String getDeviceSerial() {
            return deviceSerial;
        }

        public void setDeviceSerial(String deviceSerial) {
            this.deviceSerial = deviceSerial;
        }

        public int getChannelNo() {
            return channelNo;
        }

        public void setChannelNo(int channelNo) {
            this.channelNo = channelNo;
        }

        public String getChannelName() {
            return channelName;
        }

        public void setChannelName(String channelName) {
            this.channelName = channelName;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getIsShared() {
            return isShared;
        }

        public void setIsShared(String isShared) {
            this.isShared = isShared;
        }

        public String getPicUrl() {
            return picUrl;
        }

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }

        public int getIsEncrypt() {
            return isEncrypt;
        }

        public void setIsEncrypt(int isEncrypt) {
            this.isEncrypt = isEncrypt;
        }

        public int getVideoLevel() {
            return videoLevel;
        }

        public void setVideoLevel(int videoLevel) {
            this.videoLevel = videoLevel;
        }
    }
}
