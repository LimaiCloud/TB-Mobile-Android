package com.device.limaiyun.thingsboard.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2018/7/2 0002.
 */

public class TimeUtils {

    /*
    * 将时间戳转换为时间
    * 精确到秒
    */
    public static String stampToTime(String s){
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd HH:mm:ss");
        long lt = new Long(s);
        Date date = new Date(lt);
        res = simpleDateFormat.format(date);
        return res;
    }

    /*
     * 将时间戳转换为时间
     * 精确到日
     */
    public static String stampToDate(String s){
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd");
        long lt = new Long(s);
        Date date = new Date(lt);
        res = simpleDateFormat.format(date);
        return res;
    }

//    public static String dateToStamp(){
//        String lTime = null;
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date date = new Date(System.currentTimeMillis());
//        String stamp = simpleDateFormat.format(date);
//        try {
//            date = simpleDateFormat.parse(stamp);
//            long time = date.getTime();
//             lTime = String.valueOf(time);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        return lTime;
//    }
}
