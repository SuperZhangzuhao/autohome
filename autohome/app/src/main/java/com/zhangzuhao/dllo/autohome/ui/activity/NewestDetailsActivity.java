package com.zhangzuhao.dllo.autohome.ui.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.zhangzuhao.dllo.autohome.R;
import com.zhangzuhao.dllo.autohome.model.bean.NewestListViewBean;
import com.zhangzuhao.dllo.autohome.model.db.CollectBean;
import com.zhangzuhao.dllo.autohome.model.db.LiteOrmInstance;
import com.zhangzuhao.dllo.autohome.ui.fragment.recommendfragments.NewestFragment;

import cn.sharesdk.onekeyshare.OnekeyShare;

/**
 * Created by dllo on 16/9/29.
 * 最新页面的详情页面
 */
public class NewestDetailsActivity extends AbsBaseActivity {
    private WebView mWebView;
    private WebSettings mWebSetting;
    private String mUrl;
    private TextView goBack;
    private ImageView collectImg;
    private ImageView shareImg;
    private  Boolean isCollect = false;
    private NewestListViewBean.ResultBean.NewslistBean mBean;
    private String title , time , imgUrl , replayCount;

    @Override
    protected int setLayout() {
        return R.layout.activity_newestdetails;
    }

    @Override
    protected void initViews() {
        mWebView = byView(R.id.newestdetails_web);
        goBack = byView(R.id.newestdetails_backtv);
        collectImg = byView(R.id.newestdetails_shoucang);
        shareImg = byView(R.id.newestdetails_fenxiangimg);

        /**
         * 返回的点击事件
         */
        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        /**
         * 收藏的点击事件
         */
        collectImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isCollect == false){
                    isCollect = true ;
                    collectImg.setImageResource(R.mipmap.staryes);
                    CollectBean cb = new CollectBean(title , imgUrl , time , replayCount , mUrl);
                    LiteOrmInstance.getInstance().insert(cb);
                    Toast.makeText(NewestDetailsActivity.this, "收藏成功", Toast.LENGTH_SHORT).show();
                }else if (isCollect == true){
                    isCollect =false ;
                    collectImg.setImageResource(R.mipmap.starno);
                    LiteOrmInstance.getInstance().deleteByTitle(title);
                    Toast.makeText(NewestDetailsActivity.this, "取消收藏", Toast.LENGTH_SHORT).show();
                }
            }
        });
        shareImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnekeyShare oks = new OnekeyShare();
                //关闭sso授权
                oks.disableSSOWhenAuthorize();

// 分享时Notification的图标和文字  2.5.9以后的版本不调用此方法
                //oks.setNotification(R.drawable.ic_launcher, getString(R.string.app_name));
                // title标题，印象笔记、邮箱、信息、微信、人人网和QQ空间使用
//                oks.setTitle(getString(R.string.share));
                // titleUrl是标题的网络链接，仅在人人网和QQ空间使用
                oks.setTitleUrl("http://sharesdk.cn");
                // text是分享文本，所有平台都需要这个字段
                oks.setText("我是分享文本");
                // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
                oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
                // url仅在微信（包括好友和朋友圈）中使用
                oks.setUrl("http://sharesdk.cn");
                // comment是我对这条分享的评论，仅在人人网和QQ空间使用
                oks.setComment("我是测试评论文本");
                // site是分享此内容的网站名称，仅在QQ空间使用
                oks.setSite(getString(R.string.app_name));
                // siteUrl是分享此内容的网站地址，仅在QQ空间使用
                oks.setSiteUrl("http://sharesdk.cn");

// 启动分享GUI
                oks.show(NewestDetailsActivity.this);
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
        title = bundle.getString("title");
        time = bundle.getString("time");
        imgUrl = bundle.getString("imgUrl");
        replayCount = bundle.getString("replayCount");

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
    /**
     * 返回的点击事件
     */

    @Override
    protected void onResume() {
        super.onResume();
       if(LiteOrmInstance.getInstance().queryByTitle(title).size() > 0){
           collectImg.setImageResource(R.mipmap.staryes);
           isCollect = true;
       }
    }
}
