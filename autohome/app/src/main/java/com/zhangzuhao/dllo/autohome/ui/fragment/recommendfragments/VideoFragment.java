package com.zhangzuhao.dllo.autohome.ui.fragment.recommendfragments;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.zhangzuhao.dllo.autohome.R;
import com.zhangzuhao.dllo.autohome.model.bean.VideoDrawerListViewBean;
import com.zhangzuhao.dllo.autohome.model.bean.VideoListViewBean;
import com.zhangzuhao.dllo.autohome.model.net.VolleyInstance;
import com.zhangzuhao.dllo.autohome.model.net.VolleyResult;
import com.zhangzuhao.dllo.autohome.ui.activity.NewestDetailsActivity;
import com.zhangzuhao.dllo.autohome.ui.activity.VideoDetailsActivity;
import com.zhangzuhao.dllo.autohome.ui.adapter.VideoDrawerListViewAdapter;
import com.zhangzuhao.dllo.autohome.ui.adapter.VideoListViewAdapter;
import com.zhangzuhao.dllo.autohome.ui.app.AutoHomeApp;
import com.zhangzuhao.dllo.autohome.ui.fragment.AbsBaseFragment;

import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/9/10.
 * 视频页面的Fragment
 */
public class VideoFragment extends AbsBaseFragment implements AdapterView.OnItemClickListener {
    private TextView titleTv, timeTv, playCountTv, allTv , closeDrawer;
    private ImageView smallImg;
    private ListView listView;
    private VideoListViewAdapter adapter;
    private VideoListViewBean videoListViewBean;
    private List<VideoListViewBean> datas;
    private String videoUrl = "http://app.api.autohome.com.cn/autov5.0.0/news/videolist-pm2-vt0-s20-lastid0.json";
    private ListView drawerListView;
    private DrawerLayout drawerlayout;
    private VideoDrawerListViewAdapter drawerAdapter;
    private List<VideoDrawerListViewBean> drawerlist;
    private List<VideoListViewBean.VideoListViewBeanChild1.VideoListViewBeanChild2> list;

    @Override
    protected int setLayout() {
        return R.layout.fragment_video;
    }

    @Override
    protected void initViews() {
        titleTv = byView(R.id.video_item_title);
        timeTv = byView(R.id.video_item_time);
        playCountTv = byView(R.id.video_item_playcount);
        smallImg = byView(R.id.video_item_smallimg);
        listView = byView(R.id.video_listview);
        adapter = new VideoListViewAdapter(context);
        listView.setAdapter(adapter);
        /**
         * 抽屉相关的初始化以及绑定数据
         */
        allTv = byView(R.id.video_quanbutv);
        closeDrawer = byView(R.id.drawer_depreciate_closetv);
        drawerlayout = byView(R.id.video_drawer);
        drawerListView = byView(R.id.drawer_video_listview);
        drawerAdapter = new VideoDrawerListViewAdapter(context);
        drawerListView.setAdapter(drawerAdapter);

        /**
         * 构造抽屉的数据
         */
        createDrawerDatas();
        /**
         * 点击"全部"打开抽屉
         */
        clickOpenDrawer();
        /**
         * listview的点击事件
         */
        listView.setOnItemClickListener(this);
        /**
         * 抽屉关闭文字的点击事件
         */
        closeDrawer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerlayout.closeDrawer(Gravity.RIGHT);
            }
        });
        /**
         * 抽屉的ListView的点击事件
         */
        drawerListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("VideoFragment", "抽屉点击事件");
            }
        });
    }

    private void createDrawerDatas() {
        drawerlist = new ArrayList<>();
        drawerlist.add(new VideoDrawerListViewBean("全部"));
        drawerlist.add(new VideoDrawerListViewBean("原创"));
        drawerlist.add(new VideoDrawerListViewBean("静态视频"));
        drawerlist.add(new VideoDrawerListViewBean("试车"));
        drawerlist.add(new VideoDrawerListViewBean("花边"));
        drawerlist.add(new VideoDrawerListViewBean("事件"));
        drawerlist.add(new VideoDrawerListViewBean("新车"));
        drawerlist.add(new VideoDrawerListViewBean("广告"));
        drawerlist.add(new VideoDrawerListViewBean("技术"));
        drawerlist.add(new VideoDrawerListViewBean("二手车"));
        drawerAdapter.setDatas(drawerlist);
    }

    private void clickOpenDrawer() {
        allTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("xxx", "点击事件");
                drawerlayout.openDrawer(Gravity.RIGHT);
                Log.d("xxx", "抽屉打开");
                drawerlayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNDEFINED);
            }
        });
    }

    @Override
    protected void initDatas() {
        /**
         * 获取网络数据
         */
        VolleyInstance.getmInstance().startRequest(videoUrl, new VolleyResult() {
            @Override
            public void success(String resultStr) {
                Gson gson = new Gson();
                VideoListViewBean videoListViewBean = gson.fromJson(resultStr, VideoListViewBean.class);
                list = videoListViewBean.getResult().getList();
                list.get(0).getTitle();
                list.get(1).getTime();
                list.get(2).getPlaycount();
                list.get(3).getSmallimg();
                adapter.setDatas(list);
            }

            @Override
            public void failure() {
            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Bundle bundle = new Bundle();
        bundle.putString("key" , "http://v.autohome.com.cn/v-"+list.get(position).getId()+".html");
        Log.d("VideoFragment", "bundle:" + bundle);
        goTo(context , VideoDetailsActivity.class  , bundle);
    }
}
