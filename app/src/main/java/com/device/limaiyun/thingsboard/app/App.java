package com.device.limaiyun.thingsboard.app;

import android.app.Activity;
import android.app.Application;

import com.device.limaiyun.thingsboard.utils.Utils;

import java.util.HashSet;
import java.util.Set;

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

        initOkhttpClient();
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

    public void initOkhttpClient(){

    }
}
