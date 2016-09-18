package com.zhangzuhao.dllo.autohome.ui.adapter.vpadapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by dllo on 16/9/10.
 * 论坛的ViewPager的适配器
 */
public class ForumVpAdapter extends FragmentPagerAdapter {
    private List<Fragment>fragments;


    public ForumVpAdapter(FragmentManager fm , List<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
