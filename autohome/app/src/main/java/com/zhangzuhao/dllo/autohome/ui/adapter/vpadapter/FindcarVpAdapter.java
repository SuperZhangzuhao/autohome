package com.zhangzuhao.dllo.autohome.ui.adapter.vpadapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by dllo on 16/9/10.
 */
public class FindcarVpAdapter extends FragmentPagerAdapter {
    private List<Fragment> findCarFragments ;

    public FindcarVpAdapter(FragmentManager fm , List<Fragment> findCarFragments) {
        super(fm);
        this.findCarFragments = findCarFragments;
    }

    @Override
    public Fragment getItem(int position) {
        return findCarFragments.get(position);
    }

    @Override
    public int getCount() {
        return findCarFragments.size();
    }
}
