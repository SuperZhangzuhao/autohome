package com.zhangzuhao.dllo.autohome.ui.app;

import android.app.Application;
import android.content.Context;

import cn.sharesdk.framework.ShareSDK;

/**
 * Created by dllo on 16/9/8.
 * 当前应用的Context
 *
 */
public class AutoHomeApp extends Application {

    private  static Context context ;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        ShareSDK.initSDK(this);

    }
    public  static Context getContext(){
        return  context;
    }

}
