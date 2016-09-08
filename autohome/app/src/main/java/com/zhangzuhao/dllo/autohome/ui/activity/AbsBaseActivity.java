package com.zhangzuhao.dllo.autohome.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by dllo on 16/9/8.
 * Activity的基类
 *
 */
public abstract class AbsBaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置布局
        setContentView(setLayout());
        //初始化组件
        initViews();
        //初始化数据
        initDatas();


    }
    /**
     * 这是布局文件
     * @return R.Layout.xx
     */
    protected abstract int setLayout();
    /**
     * 初始化组件
     */
    protected abstract void initViews();
    /**
     * 初始化数据
     */
    protected abstract void initDatas();

    /**
     *简化findviewbyid
     */
    protected <T extends View > T byView(int resId){

        return (T) findViewById(resId);
    }
    /**
     * 跳转但带传值
     */
    protected void goTo(Context from , Class<? extends  AbsBaseActivity>to , Bundle extras){
        Intent intent = new Intent(from , to );
        intent.putExtras(extras);
        startActivity(intent);
    }
    /**
     * 跳转但不带值
     */
    protected void goTo(Context from , Class<? extends  AbsBaseActivity>to ){

        startActivity(new Intent(from , to));
    }

}
