package com.zhangzuhao.dllo.autohome.ui.adapter.vpadapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by dllo on 16/9/10.
 */
public class MeVpAdapter extends FragmentPagerAdapter {
    private List<Fragment>meFragments ;

    public MeVpAdapter(FragmentManager fm , List<Fragment> meFragments) {
        super(fm);
        this.meFragments = meFragments;
    }

    @Override
    public Fragment getItem(int position) {
        return meFragments.get(position);
    }

    @Override
    public int getCount() {
        return meFragments.size();
    }
}
