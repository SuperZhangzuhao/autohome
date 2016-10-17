package com.zhangzuhao.dllo.autohome.ui.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import com.zhangzuhao.dllo.autohome.R;
import com.zhangzuhao.dllo.autohome.ui.activity.ForumSearchActivity;
import com.zhangzuhao.dllo.autohome.ui.adapter.vpadapter.ForumVpAdapter;
import com.zhangzuhao.dllo.autohome.ui.fragment.forumfragment.BoutiqueFragment;
import com.zhangzuhao.dllo.autohome.ui.fragment.forumfragment.HotpostFragment;
import com.zhangzuhao.dllo.autohome.ui.fragment.forumfragment.OftenforumFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/9/9.
 * 论坛的fragment
 */
public class ForumFragment extends AbsBaseFragment {
    private TabLayout forumTl;
    private ViewPager forumVp;
    private ForumVpAdapter forumVpAdapter;
    private List<Fragment>fragments;
    private ImageView searchImg;
    @Override
    protected int setLayout() {
        return R.layout.fragment_forum;
    }

    @Override
    protected void initViews() {
        forumTl = byView(R.id.forum_tl);
        forumVp = byView(R.id.forum_vp);
        searchImg = byView(R.id.forum_img);

        searchImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("key" ,"s");
                goTo(context , ForumSearchActivity.class  , bundle);
            }
        });
    }
    @Override
    protected void initDatas() {
        fragments = new ArrayList<>();
        fragments.add(new BoutiqueFragment());
        fragments.add(new HotpostFragment());
        fragments.add(new OftenforumFragment());
        forumVpAdapter = new ForumVpAdapter(getChildFragmentManager() , fragments);
        forumVp.setAdapter(forumVpAdapter);
        forumTl.setupWithViewPager(forumVp);
        forumTl.setTabMode(TabLayout.MODE_SCROLLABLE);
        forumTl.getTabAt(0).setText("精选推荐");
        forumTl.getTabAt(1).setText("热帖");
        forumTl.getTabAt(2).setText("常用论坛");

    }
}
