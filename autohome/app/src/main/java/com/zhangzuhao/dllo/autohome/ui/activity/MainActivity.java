package com.zhangzuhao.dllo.autohome.ui.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.zhangzuhao.dllo.autohome.R;
import com.zhangzuhao.dllo.autohome.ui.fragment.FindFragment;
import com.zhangzuhao.dllo.autohome.ui.fragment.FindcarFragment;
import com.zhangzuhao.dllo.autohome.ui.fragment.ForumFragment;
import com.zhangzuhao.dllo.autohome.ui.fragment.MeFragment;
import com.zhangzuhao.dllo.autohome.ui.fragment.RecommendFragment;


public class MainActivity extends AbsBaseActivity {
    private RadioButton recommendRb, forumRb, findcarRb, findRb, meRb;
    private RadioGroup radioGroup;


    @Override
    protected int setLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initViews() {
        recommendRb = (RadioButton) findViewById(R.id.recommend_rb);
        forumRb = (RadioButton) findViewById(R.id.forum_rb);
        findcarRb = (RadioButton) findViewById(R.id.findcar_rb);
        findRb = (RadioButton) findViewById(R.id.find_rb);
        meRb = (RadioButton) findViewById(R.id.me_rb);
        radioGroup = (RadioGroup) findViewById(R.id.main_rg);


        /**
         * GadioGroup的点击事件 , 替换占位布局
         */
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                switch (checkedId) {
                    case R.id.recommend_rb:
                        ft.replace(R.id.main_fl, new RecommendFragment());
                        break;
                    case R.id.forum_rb:
                        ft.replace(R.id.main_fl, new ForumFragment());
                        break;
                    case R.id.findcar_rb:
                        ft.replace(R.id.main_fl, new FindcarFragment());
                        break;
                    case R.id.find_rb:
                        ft.replace(R.id.main_fl, new FindFragment());
                        break;
                    case R.id.me_rb:
                        ft.replace(R.id.main_fl, new MeFragment());
                        break;
                }
                ft.commit();
            }
        });
    }

    @Override
    protected void initDatas() {


    }

}