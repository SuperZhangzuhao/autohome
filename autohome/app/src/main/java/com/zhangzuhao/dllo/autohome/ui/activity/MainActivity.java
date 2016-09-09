package com.zhangzuhao.dllo.autohome.ui.activity;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.RadioButton;

import com.zhangzuhao.dllo.autohome.R;
import com.zhangzuhao.dllo.autohome.ui.fragment.FindFragment;
import com.zhangzuhao.dllo.autohome.ui.fragment.FindcarFragment;
import com.zhangzuhao.dllo.autohome.ui.fragment.ForumFragment;
import com.zhangzuhao.dllo.autohome.ui.fragment.MeFragment;
import com.zhangzuhao.dllo.autohome.ui.fragment.RecommendFragment;

public class MainActivity extends AbsBaseActivity implements CompoundButton.OnCheckedChangeListener {
    private RadioButton recommendRb, forumRb, findcarRb, findRb, meRb;

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

        recommendRb.setOnCheckedChangeListener(this);
        forumRb.setOnCheckedChangeListener(this);
        findcarRb.setOnCheckedChangeListener(this);
        findRb.setOnCheckedChangeListener(this);
        meRb.setOnCheckedChangeListener(this);

    }

    @Override
    protected void initDatas() {

    }
     //  点击替换Fragment
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        FragmentManager fm  = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        switch (buttonView.getId()){
            case R.id.recommend_rb://推荐
               ft.replace(R.id.main_fl , new RecommendFragment());
                break;
            case R.id.forum_rb: //论坛
                ft.replace(R.id.main_fl , new ForumFragment());
                break;
            case R.id.findcar_rb: //找车
                ft.replace(R.id.main_fl , new FindcarFragment());
                break;
            case R.id.find_rb:   //发现
                ft.replace(R.id.main_fl , new FindFragment());
                break;
            case R.id.me_rb:   //我
                ft.replace(R.id.main_fl , new MeFragment());
                break;
        }
        ft.commit();
    }
}