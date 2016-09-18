package com.zhangzuhao.dllo.autohome.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zhangzuhao.dllo.autohome.ui.activity.AbsBaseActivity;

/**
 * Created by dllo on 16/9/8.
 * fragment的基类
 */
public abstract class AbsBaseFragment extends Fragment {

    protected Context context ;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context ;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(setLayout() , container , false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        /**
         * 初始化组件
         */
        initViews();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        /**
         * 使用
         */
        initDatas();
    }
    protected abstract int setLayout();
    /**
     * 初始化数据
     */
    protected abstract void initViews();
    /**
     * 使用数据
     */
    protected abstract void initDatas();
    /**
     *简化findviewbyid
     */
    protected <T extends View> T byView(int resId){
        return (T)getView().findViewById(resId);
    }
    /**
     * 跳转不传值
     */
   protected void goTo(Class<? extends AbsBaseActivity> to){
       context.startActivity(new Intent(context , to));
   }
}
