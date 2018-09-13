package com.device.limaiyun.thingsboard.ui.activity.childactivity.ThirdActivity.linechart.view;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.ValueCallback;
import android.webkit.WebBackForwardList;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.device.limaiyun.thingsboard.R;
import com.device.limaiyun.thingsboard.base.BaseActivity;
import com.device.limaiyun.thingsboard.utils.env.Constant;

import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;
import ren.yale.android.cachewebviewlib.WebViewCacheInterceptorInst;

/**
 * Created by Administrator on 2018/7/3 0003.
 */

public class LineChartActivity extends BaseActivity implements LineChartView {

    private Context mContext;
    @BindView(R.id.tv_line_chart_title)
    TextView tv_title;
    //    private LineChartPresenter presenter;
    private String entityId;
    @BindView(R.id.ll_back)
    LinearLayout ll_back;
    //    @BindView(R.id.listview_etc)
//    ListView listview_etc;
//    @BindView(R.id.listview_count)
//    ListView listview_count;
//    private LineEtcAdapter etcAdapter;
//    @BindView(R.id.tv_empty)
//    TextView tv_empty;
    @BindView(R.id.linechart_webview)
    WebView linechart_webview;
    @BindView(R.id.webview_bar)
    ProgressBar webview_bar;
    private String username;
    private String password;


    @Override
    protected int getLayout() {
        return R.layout.activity_line_chart;
    }

    @Override
    public void initView() {
        SharedPreferences sp = getSharedPreferences("account", MODE_PRIVATE);
        username = sp.getString("username", "");
        password = sp.getString("password", "");
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String name = bundle.getString("name");
        entityId = bundle.getString("entityId");
        Log.e("entityId", entityId);
        if (name != null) {
            tv_title.setText(name);
        }
        mContext = this;
    }

    @Override
    public void initData() {
        initWebViewSeeting();
//        linechart_webview.setWebChromeClient(new WebChromeClient());
        linechart_webview.setWebViewClient(new WebViewClient() {

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                webview_bar.setVisibility(View.VISIBLE);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                webview_bar.setVisibility(View.GONE);
//                String postData = null;
//                if (username.contains("@")) {
//                    username = username;
//                } else if (!username.contains("@")) {
//                    username = username + "@limaicloud.com";
//                }
//                try {
//                    postData = "username=" + Base64.encodeToString(username.getBytes(),Base64.NO_WRAP |     Base64.NO_PADDING | Base64.URL_SAFE) +
//                            "&password=" + Base64.encodeToString(password.getBytes(), Base64.NO_WRAP |     Base64.NO_PADDING | Base64.URL_SAFE);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//                String map ="{\"username\": \"343152747@qq.com\", \"password\": \"123456\"}";
//                view.postUrl(Configs.BASE_URL + Configs.API_AUTH_LOGIN, postData.getBytes());

                if (url.equals(Constant.API_SERVE_URL + "/")) {
                    loginWebView(view, username, password);//模拟webview登录
                } else if (url.contains(Constant.API_HOME)) {
                    linechart_webview.loadUrl(Constant.API_SERVE_URL + Constant.API_DASHBOARD);
                }
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                if (Build.VERSION.SDK_INT < 26) {
                    view.loadUrl(Constant.API_SERVE_URL);
                    return true;
                }
                return false;
            }

            @Nullable
            @Override
            public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest request) {
                return WebViewCacheInterceptorInst.getInstance().interceptRequest(view, request);
            }

            @Nullable
            @Override
            public WebResourceResponse shouldInterceptRequest(WebView view, String url) {
                return WebViewCacheInterceptorInst.getInstance().interceptRequest(view, url);
            }
        });

//        Map<String, String> map = new HashMap<>();
//        map.put("username", username);
//        map.put("password", password);
        WebViewCacheInterceptorInst.getInstance().loadUrl(linechart_webview, Constant.API_SERVE_URL);
    }

    private void loginWebView(WebView view, String username, String password) {
        if (username.contains("@")) {
            username = username;
        } else if (!username.contains("@")) {
            username = username + "@limaicloud.com";
        }
        String strJS = null;
//        strJS = String.format("javascript:document.getElementsByTagName('button')[0].click();document.getElementById('username-input').value='" + username + "';" +
//                "document.getElementById('password-input').value='" + password + "';document.getElementsByTagName('button')[0].click();document.getElementsByTagName('button')[0].click();");
//        strJS = String.format("javascript:document.getElementsByTagName('md-input-container')[1].className = 'md-block md-icon-left md-tb-dark-theme md-input-has-value';document.getElementById('password-input').click();document.getElementById('password-input').value='" + password + "';"+"document.getElementsByTagName('md-input-container')[0].className = 'md-block md-icon-left md-tb-dark-theme md-input-has-value';document.getElementById('username-input').value='" + username + "';document.getElementsByTagName('button')[0].click();document.getElementsByTagName('button')[0].click()");
//            strJS = String.format("javascript:document.getElementsByTagName('md-input-container')[0].className = 'md-block md-icon-left md-tb-dark-theme md-input-has-value’;document.getElementsByTagName('md-input-container')[1].className = 'md-block md-icon-left md-tb-dark-theme md-input-has-value md-input-focused’;document.getElementById('password-input').value = '123456’;document.getElementsByTagName('md-input-container')[1].className = 'md-block md-icon-left md-tb-dark-theme md-input-has-value’;document.getElementsByTagName('button')[0].click();");
//            strJS =String.format("javascript:document.getElementsByTagName('md-input-container')[0].className = 'md-block md-icon-left md-tb-dark-theme md-input-has-value md-input-focused';document.getElementById('username-input').value = '343152747@qq.com';document.getElementsByTagName('md-input-container')[0].className = 'md-block md-icon-left md-tb-dark-theme md-input-has-value';document.getElementsByTagName('md-input-container')[1].className = 'md-block md-icon-left md-tb-dark-theme md-input-has-value md-input-focused';document.getElementById('password-input').value = '123456';document.getElementsByTagName('md-input-container')[1].className = 'md-block md-icon-left md-tb-dark-theme md-input-has-value';document.getElementsByTagName('button')[0].click();");
// strJS = "$('#usernamae-input').val('qiyue@limaicloud.com').trigger('input');$('#password-input').val('123456').trigger('input');";
//        strJS = String.format("javascript:document.getElementByName('username-input').value = 'qiyue@limaicloud.com';angular.element($('#username-input')).triggerHandler('change');angular.element($('#password-input')).triggerHandler('focus');document.getElementByName('password-input').value = '123456';angular.element($('#password-input')).triggerHandler('change');document.getElementsByTagName('button')[0].click();");
        strJS = String.format("javascript:var username = document.getElementById('username-input');\n" +
                "username.value = '" + username + "';\n" +
                "username.dispatchEvent(new Event('input'));\n" +
                "var password = document.getElementById('password-input');\n" +
                "password.value = '" + password + "';\n" +
                "password.dispatchEvent(new Event('input'));\n" +
                "document.getElementsByTagName('button')[0].click();\n");
        Log.e("strJs", strJS);
        view.evaluateJavascript(strJS, new ValueCallback<String>() {
            @Override
            public void onReceiveValue(String value) {
                linechart_webview.loadUrl(Constant.API_SERVE_URL + Constant.API_DASHBOARD);
            }
        });
    }

    private void initWebViewSeeting() {
        WebSettings webSettings = linechart_webview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        linechart_webview.requestFocus();
        webSettings.setDomStorageEnabled(true);
        webSettings.setAllowFileAccess(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setSupportZoom(true);
        webSettings.setBuiltInZoomControls(false);
        webSettings.setDisplayZoomControls(false);

        webSettings.setDefaultTextEncodingName("UTF-8");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            webSettings.setAllowFileAccessFromFileURLs(true);
            webSettings.setAllowUniversalAccessFromFileURLs(true);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            CookieManager cookieManager = CookieManager.getInstance();
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            webSettings.setMixedContentMode(
                    WebSettings.MIXED_CONTENT_COMPATIBILITY_MODE);
        }
    }

    @Override
    public void initImmersionBar() {
        super.initImmersionBar();
        mImmersionBar.titleBar(R.id.toolbar).init();
    }

    @OnClick(R.id.ll_back)
    public void finishAct() {
        if (linechart_webview.canGoBack()) {
            WebBackForwardList webBackForwardList = linechart_webview.copyBackForwardList();
            if (webBackForwardList.getCurrentIndex() > 1) {
                String historyUrl = webBackForwardList.getItemAtIndex(webBackForwardList.getCurrentIndex() - 1).getUrl();
                if (!historyUrl.equals(Constant.API_SERVE_URL)) {
                    linechart_webview.goBack();
                }
            } else {
                finish();
            }
        }
    }

    @Override
    public void showToast(String msg) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hinddenLoading() {

    }

    @Override
    public void showEtcLinChart(final List<String> title, final List<List<Map<Long, String>>> data) {
        if (title != null) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
//                    etcAdapter = new LineEtcAdapter(mContext,title,data);
//                    listview_etc.setAdapter(etcAdapter);
                }
            });
        }
    }

    @Override
    public void showCountLinChart(final List<String> title, final List<List<Map<Long, String>>> list) {
        if (list != null) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
//                    etcAdapter = new LineEtcAdapter(mContext, title, list);
//                    listview_count.setAdapter(etcAdapter);
                }
            });
        }
    }

    @Override
    public void showEmpty() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {

//                tv_empty.setVisibility(View.VISIBLE);
            }
        });
    }

    @Override
    public void getTimeSuc(final String lTime) {
        if (lTime == null) return;
        new Thread() {
            @Override
            public void run() {
                super.run();
                if (entityId != null && !entityId.equals("")) {
//                    if (lTime != null){
                    Log.e("lTime", lTime);
//                        presenter.getDashBoardDetil(entityId,lTime);
//                    }
                }
            }
        }.start();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.KEYCODE_BACK) {
            if (linechart_webview.canGoBack()) {
                WebBackForwardList webBackForwardList = linechart_webview.copyBackForwardList();
                if (webBackForwardList.getCurrentIndex() > 1) {
                    String historyUrl = webBackForwardList.getItemAtIndex(webBackForwardList.getCurrentIndex() - 1).getUrl();
                    if (!historyUrl.equals(Constant.SERVER_URL_STR)) {
                        linechart_webview.goBack();
                        return true;
                    }
                } else {
                    finish();
                    return true;
                }
            } else {
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }
}
