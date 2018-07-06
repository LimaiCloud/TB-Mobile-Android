package com.device.limaiyun.thingsboard.base;

/**
 * Created by Administrator on 2018/4/18 0018.
 */

public class Configs {
    public static String BASE_URL = "";
    public static String API_AUTH_LOGIN = "/api/auth/login";
    public static String API_DEVICE_TYPES = "/api/tenant/devices?limit=10&textSearch=";
    public static String API_TENANT_DASHBOARDS = "/api/tenant/dashboards?limit=";
    public static String WS_URL = "ws://thingsdevice.limaicloud.com/api/ws/plugins/telemetry?token=";
    public static String USERS = "http://thingscontacts.limaicloud.com/users?token=";
    public static String Authorization = "X-Authorization";
    public static String BEARER = "Bearer";
    public static String SPACE = " ";
}
