package com.device.limaiyun.thingsboard.app;

import android.app.Activity;
import android.app.Application;

import com.device.limaiyun.thingsboard.utils.Utils;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheEntity;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.cookie.CookieJarImpl;
import com.lzy.okgo.cookie.store.DBCookieStore;
import com.lzy.okgo.https.HttpsUtils;
import com.lzy.okgo.interceptor.HttpLoggingInterceptor;
import com.lzy.okgo.model.HttpHeaders;
import com.lzy.okgo.model.HttpParams;


import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;
import javax.net.ssl.X509TrustManager;

import okhttp3.OkHttpClient;

/**
 * Created by Administrator on 2018/4/10 0010.
 */

public class App extends Application {
    private static App instance;
    private Set<Activity> activities;

    public static synchronized App getInstance(){
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        Utils.init(this);
        OkGo.getInstance().init(instance);
    }





    /**
     * add activity
     * @param act
     */
    public void getActivity(Activity act){
        if (activities == null){
            activities = new HashSet<>();
        }
        activities.add(act);
    }

    /**
     * remove activity
     * @param act
     */
    public void removeActivity(Activity act){
        if (activities != null){
            activities.remove(act);
        }
    }

    /**
     * exit APP
     */
    public void exitApp(){
        if (activities != null){
            synchronized (activities){
                for (Activity act:activities) {
                    act.finish();
                }
            }
        }
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(0);
    }


}
