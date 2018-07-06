package com.device.limaiyun.thingsboard.bean;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/6/26 0026.
 */

public class EquipmentDetialBean {


    /**
     * subscriptionId : 2
     * errorCode : 0
     * errorMsg : null
     * data : {"count":[[1529893520162,"0"]],"state":[[1529997140174,"0"]]}
     * latestValues : {"count":1529893520162,"state":1529997140174}
     */

    private int subscriptionId;
    private int errorCode;
    private Object errorMsg;
    private DataBean data;
    private LatestValuesBean latestValues;

    public int getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(int subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public Object getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(Object errorMsg) {
        this.errorMsg = errorMsg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public LatestValuesBean getLatestValues() {
        return latestValues;
    }

    public void setLatestValues(LatestValuesBean latestValues) {
        this.latestValues = latestValues;
    }

    public static class DataBean {
        private List<List<Map<Long, String>>> key;
        private List<String> title;

        public List<String> getTitle() {
            return title;
        }

        public void setTitle(List<String> title) {
            this.title = title;
        }

        public List<List<Map<Long, String>>> getKey() {
            return key;
        }

        public void setKey(List<List<Map<Long, String>>> key) {
            this.key = key;
        }
    }

    public static class LatestValuesBean {
        /**
         * count : 1529893520162
         * state : 1529997140174
         */

        private long key;


        public long getKey() {
            return key;
        }

        public void setKey(long key) {
            this.key = key;
        }


    }
}
