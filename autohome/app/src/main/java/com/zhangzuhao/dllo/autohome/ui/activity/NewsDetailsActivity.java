package com.zhangzuhao.dllo.autohome.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.zhangzuhao.dllo.autohome.R;

/**
 * Created by dllo on 16/9/29.
 * 最新页面的详情页面
 */
public class NewsDetailsActivity extends AbsBaseActivity {
    private WebView mWebView;
    private WebSettings mWebSetting;
    private String mUrl;
    private TextView goBack;

    @Override
    protected int setLayout() {
        return R.layout.activity_newsdetails;
    }

    @Override
    protected void initViews() {
        mWebView = byView(R.id.newsdetails_web);
        goBack = byView(R.id.newsdetails_backtv);
        /**
         * 返回的点击事件
         */
        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    @Override
    protected void initDatas() {
        mWebView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideKeyEvent(WebView view, KeyEvent event) {
                return false;
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }
        });
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        mUrl = bundle.getString("key");
        /**
         * 设置WebView
         */
        mWebSetting = mWebView.getSettings();
        mWebSetting.setJavaScriptEnabled(true);
        mWebSetting.setJavaScriptCanOpenWindowsAutomatically(true);
        mWebSetting.setAppCacheEnabled(true);
        mWebSetting.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        mWebSetting.setSupportZoom(true);
        mWebSetting.setUseWideViewPort(true);
        mWebSetting.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        mWebSetting.setDisplayZoomControls(true);
        mWebSetting.setDefaultFontSize(6);
        mWebView.loadUrl(mUrl);
        Log.d("mmm", mUrl);
    }
}
