package com.zhangzuhao.dllo.autohome.ui.fragment.recommendfragments;

import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.zhangzuhao.dllo.autohome.R;
import com.zhangzuhao.dllo.autohome.model.bean.DrawerNewsFlashBean;
import com.zhangzuhao.dllo.autohome.model.bean.NewsFlashListViewBean;
import com.zhangzuhao.dllo.autohome.model.net.VolleyInstance;
import com.zhangzuhao.dllo.autohome.model.net.VolleyResult;
import com.zhangzuhao.dllo.autohome.ui.adapter.DrawerNewsFlashAdapter;
import com.zhangzuhao.dllo.autohome.ui.adapter.NewsFlashListViewAapter;
import com.zhangzuhao.dllo.autohome.ui.fragment.AbsBaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/9/10.
 * 推荐页面快报的Fragment
 */
public class NewsflashFragment extends AbsBaseFragment {
    private TextView titleTv, reviewcountTv, createtimeTv, allTv;
    private ImageView bgimageImg;
    private ListView mListView;
    private NewsFlashListViewAapter mNewsFlashListViewAapter;
    private String newsflashUrl = "http://app.api.autohome.com.cn/autov5.0.0/news/fastnewslist-pm2-b0-l0-s20-lastid0.json";
    private DrawerLayout mDrawerlayout;
    private ListView drawerListView;
    private List<DrawerNewsFlashBean> datas;
    private DrawerNewsFlashAdapter drawerAdapter;

    @Override
    protected int setLayout() {
        return R.layout.fragment_newsflash;
    }

    @Override
    protected void initViews() {
        titleTv = byView(R.id.newsflash_listview_item_title);
        reviewcountTv = byView(R.id.newsflash_listview_item_reviewcount);
        createtimeTv = byView(R.id.newsflash_listview_item_createTv);
        bgimageImg = byView(R.id.newsflash_listview_item_bgimage);
        mListView = byView(R.id.newsflash_listview);
        mNewsFlashListViewAapter = new NewsFlashListViewAapter(context);
        mListView.setAdapter(mNewsFlashListViewAapter);
        /**
         * 抽屉的相关初始化数据
         */
        allTv = byView(R.id.newsflash_top_leveltv);
        mDrawerlayout = byView(R.id.drawer_newsflsh_drawer);
        drawerListView = byView(R.id.drawer_newsflash_listview);
        drawerAdapter = new DrawerNewsFlashAdapter(context);
        drawerListView.setAdapter(drawerAdapter);
        /**
         * 点击"全部级别"弹抽屉
         */
        allTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("xxx", "点击事件");
                mDrawerlayout.openDrawer(Gravity.RIGHT);
                Log.d("xxx", "抽屉打开");
                mDrawerlayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNDEFINED);
            }
        });
    }

    @Override
    protected void initDatas() {
        /**
         * 获取网络数据
         */
        VolleyInstance.getmInstance().startRequest(newsflashUrl, new VolleyResult() {
            @Override
            public void success(String resultStr) {
                Log.d("net", resultStr);
                Gson gson = new Gson();
                NewsFlashListViewBean newsFlashListViewBean = gson.fromJson(resultStr, NewsFlashListViewBean.class);
                List<NewsFlashListViewBean.ResultBean.ListBean> datas = newsFlashListViewBean.getResult().getList();
                mNewsFlashListViewAapter.setDatas(datas);
            }

            @Override
            public void failure() {
            }
        });
        /**
         * 给侧拉菜单的ListView设置数据
         */
        drawerDatas();
        /**
         * 设置抽屉的属性
         */
        attributeDrawer();
    }

    private void attributeDrawer() {
        mDrawerlayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
    }

    private void drawerDatas() {
        datas = new ArrayList<>();
        datas.add(new DrawerNewsFlashBean("不限"));
        datas.add(new DrawerNewsFlashBean("微型车"));
        datas.add(new DrawerNewsFlashBean("小型"));
        datas.add(new DrawerNewsFlashBean("紧凑车型"));
        datas.add(new DrawerNewsFlashBean("中型车"));
        datas.add(new DrawerNewsFlashBean("中大型车"));
        datas.add(new DrawerNewsFlashBean("大型车"));
        datas.add(new DrawerNewsFlashBean("跑车"));
        datas.add(new DrawerNewsFlashBean("MPV"));
        datas.add(new DrawerNewsFlashBean("低端皮卡"));
        datas.add(new DrawerNewsFlashBean("高端皮卡"));
        datas.add(new DrawerNewsFlashBean("小型SUV"));
        datas.add(new DrawerNewsFlashBean("紧凑型SUV"));
        datas.add(new DrawerNewsFlashBean("中型SUV"));
        datas.add(new DrawerNewsFlashBean("中大型SUV"));
        datas.add(new DrawerNewsFlashBean("大型SUV"));
        drawerAdapter.setDatas(datas);
    }
}
