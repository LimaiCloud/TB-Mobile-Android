package com.device.limaiyun.thingsboard.ui.fragment.supervision.model;

/**
 * Created by ${Winter} on 2018/9/20.
 */
public interface SupervisionFragmentPort {
    void getSupervisionData(String url,String token,SupervisionFragmentListener listener);

    void putSupervisionStatus(String url,String title,String description, String mtoken, String chiose_id,SupervisionFragmentListener listener);
}
