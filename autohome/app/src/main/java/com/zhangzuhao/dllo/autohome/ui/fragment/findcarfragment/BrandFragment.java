package com.zhangzuhao.dllo.autohome.ui.fragment.findcarfragment;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.zhangzuhao.dllo.autohome.R;
import com.zhangzuhao.dllo.autohome.model.bean.BrandExpandableBean;
import com.zhangzuhao.dllo.autohome.model.bean.BrandRecyclerViewBean;
import com.zhangzuhao.dllo.autohome.model.net.VolleyInstance;
import com.zhangzuhao.dllo.autohome.model.net.VolleyResult;
import com.zhangzuhao.dllo.autohome.ui.adapter.BrandExpandableListViewAdapter;
import com.zhangzuhao.dllo.autohome.ui.adapter.BrandRecyclerViewAdapter;
import com.zhangzuhao.dllo.autohome.ui.fragment.AbsBaseFragment;
import com.zhangzuhao.dllo.autohome.view.SideBar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dllo on 16/9/10.
 * 品牌的fragment
 */
public class BrandFragment extends AbsBaseFragment {
    /**
     * 定义ExpandableListView相关数据
     */
    private ExpandableListView expandableListView;
    private BrandExpandableListViewAdapter mAdapter;
//    private SideBar mSideBar;
    private String url = "http://223.99.255.20/cars.app.autohome.com.cn/cars_v5.7.0/cars/brands-pm2-ts635966571635589297.json";
    private String url2 = "http://223.99.255.20/cars.app.autohome.com.cn/dealer_v5.7.0/dealer/hotbrands-pm2.json";
    /**
     * RecyclerView相关数据定义
     */
    private RecyclerView recyclerView;
    private BrandRecyclerViewAdapter recyclerViewAdapter;
    /**
     * 抽屉的相关数据定义
     */
    private DrawerLayout mDrawerLayout;


    @Override
    protected int setLayout() {
        return R.layout.fragment_brand;
    }

    @Override
    protected void initViews() {
        expandableListView = byView(R.id.brand_expandablelistview);
        expandableListView.setGroupIndicator(null);
//        mSideBar = byView(R.id.brand_sidebar);
        mAdapter = new BrandExpandableListViewAdapter(context);
        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                return true;//屏蔽父布局的点击事件
            }
        });

        /**
         * RcyclerView定义并初始化
         */
        View view = LayoutInflater.from(context).inflate(R.layout.item_brand_exlistview_head_one, null);
        recyclerView = (RecyclerView) view.findViewById(R.id.brand_exlistview_headone_rl);
        recyclerViewAdapter = new BrandRecyclerViewAdapter(context);
        recyclerView.setAdapter(recyclerViewAdapter);
        GridLayoutManager glm = new GridLayoutManager(context, 5);
        recyclerView.setLayoutManager(glm);
        /**
         * 添加头布局
         */
        expandableListView.addHeaderView(view);
        View headtwo = LayoutInflater.from(context).inflate(R.layout.item_brand_exlistview_head_two, null);
        expandableListView.addHeaderView(headtwo);
        /**
         * 抽屉的初始化
         */
        mDrawerLayout = byView(R.id.findcar_drawerlayout);
    }

    @Override
    protected void initDatas() {
        /**
         * 获取网络数据
         */
        VolleyInstance.getmInstance().startRequest(url, new VolleyResult() {
            @Override
            public void success(String resultStr) {
                Gson gson = new Gson();
                List<String> groupDatas =  new ArrayList<>();
                Map<String ,List<BrandExpandableBean.ResultBean.BrandlistBean.ListBean>> childs = new HashMap<>();
                BrandExpandableBean mBean = gson.fromJson(resultStr, BrandExpandableBean.class);
                List<BrandExpandableBean.ResultBean.BrandlistBean> datas = mBean.getResult().getBrandlist();
                for (int i = 0; i <datas.size() ; i++) {
                    String letter = datas.get(i).getLetter();
                    groupDatas.add(letter);
                    childs.put(letter , datas.get(i).getList());
                }
                mAdapter.setGruopDatas(groupDatas);
                mAdapter.setChildDatas(childs);
                expandableListView.setAdapter(mAdapter);
                /**
                 * 加载数据是全部展开部
                 */
                for (int i = 0, count =datas.size() ; i< count ;i++) {
                    expandableListView.expandGroup(i);
                }
            }

            @Override
            public void failure() {
            }
        });
        /**
         * RcyclerView的解析数据
         */
        VolleyInstance.getmInstance().startRequest(url2, new VolleyResult() {
            @Override
            public void success(String resultStr) {
                Gson gson = new Gson();
                BrandRecyclerViewBean recyclerBean = gson.fromJson(resultStr , BrandRecyclerViewBean.class);
                List<BrandRecyclerViewBean.ResultBean.ListBean> recyclerDatas = recyclerBean.getResult().getList();
                recyclerViewAdapter.setDatas(recyclerDatas);
            }
            @Override
            public void failure() {
            }
        });

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Log.d("BrandFragment", "groupPosition:" + groupPosition);
                Log.d("BrandFragment", "childPosition:" + childPosition);
                mDrawerLayout.openDrawer(Gravity.RIGHT);
                mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNDEFINED);


                return false;
            }
        });
    }
}
