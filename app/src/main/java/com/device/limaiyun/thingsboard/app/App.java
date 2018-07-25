package com.device.limaiyun.thingsboard.app;

import android.app.Activity;
import android.app.Application;

import com.device.limaiyun.thingsboard.utils.Utils;
import com.device.limaiyun.thingsboard.utils.env.Constant;
import com.device.limaiyun.thingsboard.utils.env.ProperUtil;
import com.lzy.okgo.OkGo;
import com.tencent.bugly.Bugly;

import java.io.File;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

import ren.yale.android.cachewebviewlib.CacheType;
import ren.yale.android.cachewebviewlib.WebViewCacheInterceptor;
import ren.yale.android.cachewebviewlib.WebViewCacheInterceptorInst;
import ren.yale.android.cachewebviewlib.config.CacheExtensionConfig;

/**
 * Created by Administrator on 2018/4/10 0010.
 */

public class App extends Application {
    private static App instance;
    private Set<Activity> activities;

    public static synchronized App getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        Bugly.init(getApplicationContext(), "362244f72b", false);
        Utils.init(this);
        OkGo.getInstance().init(instance);


        getBaseUrl();

        WebViewCacheInterceptor.Builder builder = new WebViewCacheInterceptor.Builder(this);

        builder.setCachePath(new File(this.getCacheDir(), "static"))//这是缓存路径，默认getCacgetDir，CacheWebViewcache
                .setCacheSize(1024 * 1024 * 100)//设置缓存大小 为100M
                .setConnectTimeoutSecond(20)//设置http请求链接超时，默认20秒
                .setReadTimeoutSecond(20)//设置http请求链接读取超时，默认20秒
                .setCacheType(CacheType.FORCE);//设置缓存为正常模式，默认模式为强制缓存静态资源

        CacheExtensionConfig config = new CacheExtensionConfig();
        builder.setCacheExtensionConfig(config);
        builder.setAssetsDir("static");
        builder.setDebug(true);
        WebViewCacheInterceptorInst.getInstance().init(builder);
    }

    private void getBaseUrl() {
        Properties properties = ProperUtil.getUrlProper(getApplicationContext());
        Constant.API_SERVE_URL = properties.getProperty(Constant.SERVER_URL_STR);
        Constant.API_AUTH_LOGIN = properties.getProperty(Constant.LOGIN_URL);
        Constant.API_DEVICE_TYPE = properties.getProperty(Constant.DEVICE_TYPE);
        Constant.API_CUSTOMER = properties.getProperty(Constant.CUSTOMER);
        Constant.API_CUSTOMER_DEVICES = properties.getProperty(Constant.CUSTOMER_DEVICES);
        Constant.API_TENANT_DASHBOARDS = properties.getProperty(Constant.TENANT_DASHBOARDS);
        Constant.API_GET_TIME=properties.getProperty(Constant.GET_TIME);
        Constant.API_WANTED = properties.getProperty(Constant.WANTED);
        Constant.API_WS_URL=properties.getProperty(Constant.WEBSOCKET);
        Constant.API_USERS = properties.getProperty(Constant.USERS);
    }


    /**
     * add activity
     *
     * @param act
     */
    public void getActivity(Activity act) {
        if (activities == null) {
            activities = new HashSet<>();
        }
        activities.add(act);
    }

    /**
     * remove activity
     *
     * @param act
     */
    public void removeActivity(Activity act) {
        if (activities != null) {
            activities.remove(act);
        }
    }

    /**
     * exit APP
     */
    public void exitApp() {
        if (activities != null) {
            synchronized (activities) {
                for (Activity act : activities) {
                    act.finish();
                }
            }
        }
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(0);
    }


}
