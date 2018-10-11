package com.device.limaiyun.thingsboard.ui.activity.childactivity.Supervision.addSupervisionChild.model;

/**
 * Created by ${Winter} on 2018/10/9.
 */
public interface AddSupervisionPort {

    void getSupervisionTitles(String url,String wekan_token,AddSupervisionListener listener);

    void postAddSupervision(String title, String description, String url,String list_id, String user_id,String token,AddSupervisionListener listener);
}
