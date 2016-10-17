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
        fragments.add(NewsFragment.newInstance("http://app.api.autohome.com.cn/autov5.0.0/news/newslist-pm1-c0-nt1-p1-s30-l0.json"));
        fragments.add(NewsFragment.newInstance("http://app.api.autohome.com.cn/autov4.8.8/news/newslist-pm1-c0-nt3-p1-s30-l0.json"));
        fragments.add(NewsFragment.newInstance("http://app.api.autohome.com.cn/autov4.8.8/news/newslist-pm1-c110100-nt2-p1-s30-l0.json"));
        fragments.add(new UseCarFragment());
        fragments.add(NewsFragment.newInstance("http://app.api.autohome.com.cn/autov4.8.8/news/newslist-pm1-c0-nt102-p1-s30-l0.json"));
        fragments.add(NewsFragment.newInstance("http://app.api.autohome.com.cn/autov4.8.8/news/newslist-pm1-c0-nt97-p1-s30-l0.json"));
        fragments.add(NewsFragment.newInstance("http://app.api.autohome.com.cn/autov4.8.8/news/newslist-pm1-c0-nt107-p1-s30-l0.json"));
        fragments.add(NewsFragment.newInstance("http://app.api.autohome.com.cn/autov4.8.8/news/newslist-pm1-c0-nt100-p1-s30-l0.json"));
        fragments.add(NewsFragment.newInstance("http://app.api.autohome.com.cn/autov4.8.8/news/videolist-pm1-vt8-s30-lastid0.json"));
        fragments.add(NewsFragment.newInstance("http://app.api.autohome.com.cn/autov4.8.8/news/shuokelist-pm1-s30-lastid0.json"));

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
        recommendTl.getTabAt(8).setText("技术");
        recommendTl.getTabAt(9).setText("文化");
        recommendTl.getTabAt(10).setText("改装");
        recommendTl.getTabAt(11).setText("游记");
        recommendTl.getTabAt(12).setText("原创视频");
        recommendTl.getTabAt(13).setText("说客");

    }
}
