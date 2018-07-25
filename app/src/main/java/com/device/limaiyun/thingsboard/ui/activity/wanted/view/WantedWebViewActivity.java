package com.device.limaiyun.thingsboard.ui.activity.wanted.view;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.device.limaiyun.thingsboard.R;
import com.device.limaiyun.thingsboard.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by ${Winter} on 2018/7/20.
 */
public class WantedWebViewActivity extends BaseActivity {

    @BindView(R.id.wb_wanted)
    WebView wb_wanted;
    @BindView(R.id.ll_back)
    LinearLayout ll_back;
    private String link_url;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.wanted_bar)
    ProgressBar wanted_bar;

    @Override
    protected int getLayout() {
        return R.layout.activity_wanted_webview;
    }

    @Override
    public void initView() {
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        link_url = extras.getString("link");
        Log.e("link", link_url);
    }

    @Override
    public void initData() {
        if (link_url != null && !link_url.equals("")) {
            final WebSettings webSettings = wb_wanted.getSettings();
            webSettings.setJavaScriptEnabled(true);
            webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
            webSettings.setCacheMode(WebSettings.LOAD_NO_CACHE);
            webSettings.setDomStorageEnabled(true);
            webSettings.setDatabaseEnabled(true);
            webSettings.setAppCacheEnabled(true);
            webSettings.setAllowFileAccess(true);
            webSettings.setSavePassword(true);
            webSettings.setSupportZoom(true);
            webSettings.setBuiltInZoomControls(true);
            webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
            webSettings.setUseWideViewPort(true);

            wb_wanted.setWebViewClient(new WebViewClient(){
                @Override
                public void onPageStarted(WebView view, String url, Bitmap favicon) {
                    wanted_bar.setVisibility(View.VISIBLE);
                }

                @Override
                public void onPageFinished(WebView view, String url) {
                    wanted_bar.setVisibility(View.GONE);
                }
            });
            wb_wanted.loadUrl(link_url);
        }
    }

    @OnClick(R.id.ll_back)
    public void finishAct(){
        finish();
    }

    @Override
    public void initImmersionBar() {
        super.initImmersionBar();
        mImmersionBar.titleBar(R.id.toolbar).init();
    }
}
