package com.zhangzuhao.dllo.autohome.ui.fragment;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.zhangzuhao.dllo.autohome.R;
import com.zhangzuhao.dllo.autohome.ui.adapter.vpadapter.RecommendVpAdapter;
import com.zhangzuhao.dllo.autohome.ui.fragment.recommendfragments.AssessmentFragment;
import com.zhangzuhao.dllo.autohome.ui.fragment.recommendfragments.InnovateFragment;
import com.zhangzuhao.dllo.autohome.ui.fragment.recommendfragments.NewestFragment;
import com.zhangzuhao.dllo.autohome.ui.fragment.recommendfragments.NewsFragment;
import com.zhangzuhao.dllo.autohome.ui.fragment.recommendfragments.NewsflashFragment;
import com.zhangzuhao.dllo.autohome.ui.fragment.recommendfragments.PriceFragment;
import com.zhangzuhao.dllo.autohome.ui.fragment.recommendfragments.UseCarFragment;
import com.zhangzuhao.dllo.autohome.ui.fragment.recommendfragments.VideoFragment;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by dllo on 16/9/9.
 * 推荐fragment
 */
public class RecommendFragment extends AbsBaseFragment {
    private ViewPager recommendVp;
    private TabLayout recommendTl;
    private List<Fragment> fragments;
    private RecommendVpAdapter recomVpAdapter ;
    @Override
    protected int setLayout() {
        return R.layout.fragment_recommend;
    }

    @Override
    protected void initViews() {
        recommendVp = byView(R.id.recommend_vp);
        recommendTl = byView(R.id.recommend_tl);
    }
    @Override
    protected void initDatas() {
        /**
         * 设置tablayout
         */
        fragments = new ArrayList<>();
        fragments.add(new NewestFragment());
        fragments.add(new InnovateFragment());
        fragments.add(new NewsflashFragment());
        fragments.add(new VideoFragment());
        fragments.add(new NewsFragment());
        fragments.add(new AssessmentFragment());
        fragments.add(new PriceFragment());
        fragments.add(new UseCarFragment());
        recomVpAdapter = new RecommendVpAdapter(getChildFragmentManager() ,fragments);
        recommendVp.setAdapter(recomVpAdapter);
        recommendTl.setupWithViewPager(recommendVp);
        recommendTl.setTabMode(TabLayout.MODE_SCROLLABLE);
//        View view = LayoutInflater.from(context).inflate(R.layout.item_fragment_recommend , null);
        recommendTl.getTabAt(0).setText("最新");
        recommendTl.getTabAt(1).setText("优创+");
        recommendTl.getTabAt(2).setText("快报");
        recommendTl.getTabAt(3).setText("视频");
        recommendTl.getTabAt(4).setText("新闻");
        recommendTl.getTabAt(5).setText("测评");
        recommendTl.getTabAt(6).setText("行情");
        recommendTl.getTabAt(7).setText("用车");
    }
}
