package com.device.limaiyun.thingsboard.ui.fragment.home.CmriFragment.model;

import android.content.Context;

/**
 * Created by Administrator on 2018/7/5 0005.
 */

public interface CmriPort {
    void getCmri(Context context,String token, CmriListener listener);
}
