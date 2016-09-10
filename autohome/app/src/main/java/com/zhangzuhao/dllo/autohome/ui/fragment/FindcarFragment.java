package com.zhangzuhao.dllo.autohome.ui.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.zhangzuhao.dllo.autohome.R;
import com.zhangzuhao.dllo.autohome.ui.adapter.vpadapter.FindcarVpAdapter;
import com.zhangzuhao.dllo.autohome.ui.fragment.findcarfragment.BrandFragment;
import com.zhangzuhao.dllo.autohome.ui.fragment.findcarfragment.DepreciateFragment;
import com.zhangzuhao.dllo.autohome.ui.fragment.findcarfragment.ScreenFragment;
import com.zhangzuhao.dllo.autohome.ui.fragment.findcarfragment.UsedcarFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/9/9.
 */
public class FindcarFragment extends AbsBaseFragment {
    private TabLayout findcarTl ;
    private ViewPager findcarVp ;
    private FindcarVpAdapter  findcarVpAdapter ;
    private List<Fragment> findCarFragments ;
    @Override
    protected int setLayout() {
        return R.layout.fragment_findcar;
    }

    @Override
    protected void initViews() {
   findcarVp = byView(R.id.findcar_vp);
   findcarTl = byView(R.id.findcar_tl);
    }

    @Override
    protected void initDatas() {
        findCarFragments = new ArrayList<>();
        findCarFragments.add(new BrandFragment());
        findCarFragments.add(new ScreenFragment());
        findCarFragments.add(new DepreciateFragment());
        findCarFragments.add(new UsedcarFragment());
        findcarVpAdapter = new FindcarVpAdapter(getChildFragmentManager() , findCarFragments);
        findcarVp.setAdapter(findcarVpAdapter);
        findcarTl.setupWithViewPager(findcarVp);
        findcarTl.setTabMode(TabLayout.MODE_SCROLLABLE);
        findcarTl.getTabAt(0).setText("品牌");
        findcarTl.getTabAt(1).setText("筛选");
        findcarTl.getTabAt(2).setText("降价");
        findcarTl.getTabAt(3).setText("找二手车");

    }
}
