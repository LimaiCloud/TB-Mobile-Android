package com.device.limaiyun.thingsboard.ui.activity.childactivity.Supervision.child.model;

import com.device.limaiyun.thingsboard.base.Configs;
import com.device.limaiyun.thingsboard.bean.WeKanTitleBean;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.Callback;
import com.lzy.okgo.model.Progress;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;

import java.io.IOException;
import java.util.List;

import okhttp3.ResponseBody;

/**
 * Created by ${Winter} on 2018/9/19.
 */
public class SupervisionTaskDisivisonModel implements SupervisionTaskDivisionPort {


    @Override
    public void getTitle(final String url, String token, final SupervisionTaskDivisionListener listener) {
        OkGo.get(url)
                .tag(this)
                .headers(Configs.Authorization,Configs.BEARER+Configs.SPACE+token)
                .execute(new Callback<Object>() {
                    @Override
                    public void onStart(Request<Object, ? extends Request> request) {

                    }

                    @Override
                    public void onSuccess(Response<Object> response) {
                        if (response.code() == 200){
                            ResponseBody body = response.getRawResponse().body();
                            try {
                                String result = body.source().readUtf8();
                                List<WeKanTitleBean> weKanTitleBeans = WeKanTitleBean.arrayWeKanTitleBeanFromData(result);
                                if (weKanTitleBeans != null){
                                    listener.getTitleSuc(weKanTitleBeans,url);
                                }else {
                                    listener.getTitleFail();
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }

                    @Override
                    public void onCacheSuccess(Response<Object> response) {

                    }

                    @Override
                    public void onError(Response<Object> response) {

                    }

                    @Override
                    public void onFinish() {

                    }

                    @Override
                    public void uploadProgress(Progress progress) {

                    }

                    @Override
                    public void downloadProgress(Progress progress) {

                    }

                    @Override
                    public Object convertResponse(okhttp3.Response response) throws Throwable {
                        return null;
                    }
                });
    }
}
