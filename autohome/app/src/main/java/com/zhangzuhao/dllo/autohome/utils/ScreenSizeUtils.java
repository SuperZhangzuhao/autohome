package com.zhangzuhao.dllo.autohome.utils;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/**
 * Created by dllo on 16/9/13.
 * 屏幕适配工具类
 */
public class ScreenSizeUtils {
    //整合频幕适配数据
    public enum ScreenState{
        WIDTH,HEIGHT

    }
    public static int getScreenSize(Context context ,ScreenState state){
        //获取窗口管理者
        WindowManager manager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        //创建显示尺寸
        DisplayMetrics metrics = new DisplayMetrics();
        //将窗口的尺寸设置给显示尺寸
        manager.getDefaultDisplay().getMetrics(metrics);
        switch (state){
            case WIDTH:
                return metrics.widthPixels;
            case  HEIGHT:
                return metrics.heightPixels;
            default:
                return metrics.heightPixels;
        }

    }


}
