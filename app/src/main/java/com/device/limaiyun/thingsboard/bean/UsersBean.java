package com.device.limaiyun.thingsboard.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2018/7/5 0005.
 */

public class UsersBean implements Serializable{


    /**
     * code : 1
     * data : [{"uid":1,"account":"qiyue","password":"E10ADC3949BA59ABBE56E057F20F883E","company":1,"tel":null,"email":null,"role":"1","title":"奇跃管理员","name":"奇跃橡塑"},{"uid":6,"account":"yunan","password":"E10ADC3949BA59ABBE56E057F20F883E","company":1,"tel":null,"email":null,"role":"2","title":"奇跃经理","name":"于楠"}]
     */

    private int code;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * uid : 1
         * account : qiyue
         * password : E10ADC3949BA59ABBE56E057F20F883E
         * company : 1
         * tel : null
         * email : null
         * role : 1
         * title : 奇跃管理员
         * name : 奇跃橡塑
         */

        private int uid;
        private String account;
        private String password;
        private int company;
        private Object tel;
        private Object email;
        private String role;
        private String title;
        private String name;
        private String sortLetters;

        public String getSortLetters() {
            return sortLetters;
        }

        public void setSortLetters(String sortLetters) {
            this.sortLetters = sortLetters;
        }

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public String getAccount() {
            return account;
        }

        public void setAccount(String account) {
            this.account = account;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public int getCompany() {
            return company;
        }

        public void setCompany(int company) {
            this.company = company;
        }

        public Object getTel() {
            return tel;
        }

        public void setTel(Object tel) {
            this.tel = tel;
        }

        public Object getEmail() {
            return email;
        }

        public void setEmail(Object email) {
            this.email = email;
        }

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
