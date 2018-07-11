package com.device.limaiyun.thingsboard.utils;

import com.device.limaiyun.thingsboard.bean.UsersBean;

import java.util.Comparator;

/**
 * Created by ${Winter} on 2017/8/1.
 */

public class PinyinComparator  implements Comparator<UsersBean.DataBean> {

    public int compare(UsersBean.DataBean o1, UsersBean.DataBean o2) {
        //这里主要是用来对ListView里面的数据根据ABCDEFG...来排序
        if (o1.getSortLetters().equals("@")
                || o2.getSortLetters().equals("#")) {
            return -1;
        } else if (o1.getSortLetters().equals("#")
                || o2.getSortLetters().equals("@")) {
            return 1;
        } else {
            return o1.getSortLetters().compareTo(o2.getSortLetters());
        }
    }
}

