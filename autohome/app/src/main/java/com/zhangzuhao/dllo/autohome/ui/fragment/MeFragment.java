package com.zhangzuhao.dllo.autohome.ui.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.zhangzuhao.dllo.autohome.R;
import com.zhangzuhao.dllo.autohome.ui.adapter.vpadapter.MeVpAdapter;
import com.zhangzuhao.dllo.autohome.ui.fragment.mefragment.MeMeFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/9/9.
 */
public class MeFragment extends AbsBaseFragment {
    private TabLayout meTl;
    private ViewPager meVp;
    private List<Fragment> meFragments;
    private MeVpAdapter meVpAdapter;

    @Override
    protected int setLayout() {
        return R.layout.fragment_me;
    }

    @Override
    protected void initViews() {
    meTl = byView(R.id.me_tl);
    meVp = byView(R.id.me_vp);
    }

    @Override
    protected void initDatas() {
        meFragments = new ArrayList<>();
        meFragments.add(new MeMeFragment());
        meVpAdapter = new MeVpAdapter(getChildFragmentManager() , meFragments);
        meVp.setAdapter(meVpAdapter);
        meTl.setupWithViewPager(meVp);
        meTl.setTabMode(TabLayout.MODE_SCROLLABLE);
        meTl.getTabAt(0).setText("我");

    }
}
