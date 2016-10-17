package com.zhangzuhao.dllo.autohome.ui.fragment.forumfragment;

import android.graphics.Color;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.zhangzuhao.dllo.autohome.R;
import com.zhangzuhao.dllo.autohome.model.bean.LetterIndexBean;
import com.zhangzuhao.dllo.autohome.model.bean.OftenForumDrawerListViewBean;
import com.zhangzuhao.dllo.autohome.ui.adapter.OftenForumCarDrawerAdapter;
import com.zhangzuhao.dllo.autohome.ui.fragment.AbsBaseFragment;
import com.zhangzuhao.dllo.autohome.utils.StringHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;

/**
 * Created by dllo on 16/9/10.
 * 常用论坛的fragment
 */
public class OftenforumFragment extends AbsBaseFragment  {
    /**
     *LinearLayout的相关数据绑定
     */
    private LinearLayout carLinear , placeLinear , zutiLinear;
    /**
     * 索引抽屉的相关数据定义
     */
    private HashMap<String , Integer>selector; //存放含有索引字母的位置
    private LinearLayout layoutIndex;
    private ListView drawerListView;
    private TextView tv_show;
    private OftenForumCarDrawerAdapter  oftenForumCarDrawerAdapter ;

    /**
     * 抽屉的相关定义数据
     */
    private DrawerLayout mDrawerLayout;
    private List<OftenForumDrawerListViewBean> mBean ;
    private OftenForumCarDrawerAdapter mAdapter;
    private TextView show;


    @Override
    protected int setLayout() {
        return R.layout.fragment_oftenforum;
    }

    @Override
    protected void initViews() {
        carLinear = byView(R.id.oftenforum_carll);
        placeLinear = byView(R.id.oftenforum_placell);
        zutiLinear = byView(R.id.oftenforum_zutill);
        /**
         * LinearLayout的点击事件
         */
        carLinear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        placeLinear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBean = new ArrayList<OftenForumDrawerListViewBean>();
                mBean.add(new OftenForumDrawerListViewBean("安徽论坛"));
                mBean.add(new OftenForumDrawerListViewBean("澳门论坛"));
                mBean.add(new OftenForumDrawerListViewBean("北京论坛"));
                mBean.add(new OftenForumDrawerListViewBean("重庆论坛"));
                mBean.add(new OftenForumDrawerListViewBean("福建论坛"));
                mBean.add(new OftenForumDrawerListViewBean("甘肃论坛"));
                mBean.add(new OftenForumDrawerListViewBean("广东论坛"));
                mBean.add(new OftenForumDrawerListViewBean("广西论坛"));
                mBean.add(new OftenForumDrawerListViewBean("贵州论坛"));
                mBean.add(new OftenForumDrawerListViewBean("海南论坛"));
                mBean.add(new OftenForumDrawerListViewBean("河北论坛"));
                mBean.add(new OftenForumDrawerListViewBean("黑龙江论坛"));
                mBean.add(new OftenForumDrawerListViewBean("河南论坛"));
                mBean.add(new OftenForumDrawerListViewBean("湖北论坛"));
                mBean.add(new OftenForumDrawerListViewBean("湖南论坛"));
                mBean.add(new OftenForumDrawerListViewBean("海外论坛"));
                mBean.add(new OftenForumDrawerListViewBean("江苏论坛"));
                mBean.add(new OftenForumDrawerListViewBean("江南论坛"));
                mBean.add(new OftenForumDrawerListViewBean("吉林论坛"));
                mBean.add(new OftenForumDrawerListViewBean("辽宁论坛"));
                mBean.add(new OftenForumDrawerListViewBean("内蒙古论坛"));
                mBean.add(new OftenForumDrawerListViewBean("宁夏论坛"));
                mBean.add(new OftenForumDrawerListViewBean("青海论坛"));
                mBean.add(new OftenForumDrawerListViewBean("山西论坛"));
                mBean.add(new OftenForumDrawerListViewBean("山东论坛"));
                mBean.add(new OftenForumDrawerListViewBean("上海论坛"));
                mBean.add(new OftenForumDrawerListViewBean("四川论坛"));
                mBean.add(new OftenForumDrawerListViewBean("陕西论坛"));
                mBean.add(new OftenForumDrawerListViewBean("天津论坛"));
                mBean.add(new OftenForumDrawerListViewBean("台湾论坛"));
                mBean.add(new OftenForumDrawerListViewBean("西藏论坛"));
                mBean.add(new OftenForumDrawerListViewBean("新疆论坛"));
                mBean.add(new OftenForumDrawerListViewBean("香港论坛"));
                mBean.add(new OftenForumDrawerListViewBean("云南论坛"));
                mBean.add(new OftenForumDrawerListViewBean("浙江论坛"));
                mAdapter.setDatas(mBean);
                mDrawerLayout.openDrawer(Gravity.RIGHT);
                mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNDEFINED);

            }
        });
        zutiLinear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBean = new ArrayList<OftenForumDrawerListViewBean>();
                mBean.add(new OftenForumDrawerListViewBean("精彩作业论坛"));
                mBean.add(new OftenForumDrawerListViewBean("维修保养论坛"));
                mBean.add(new OftenForumDrawerListViewBean("修饰改装论坛"));
                mBean.add(new OftenForumDrawerListViewBean("自驾游论坛"));
                mBean.add(new OftenForumDrawerListViewBean("摄影论坛"));
                mBean.add(new OftenForumDrawerListViewBean("车展快报论坛"));
                mBean.add(new OftenForumDrawerListViewBean("社区公告论坛"));
                mBean.add(new OftenForumDrawerListViewBean("养车之家论坛"));
                mBean.add(new OftenForumDrawerListViewBean("经销商论坛"));
                mBean.add(new OftenForumDrawerListViewBean("自行车论坛"));
                mBean.add(new OftenForumDrawerListViewBean("GPS论坛"));
                mBean.add(new OftenForumDrawerListViewBean("App应用体验论坛"));
                mBean.add(new OftenForumDrawerListViewBean("摩托车论坛"));
                mBean.add(new OftenForumDrawerListViewBean("卡丁车论坛"));
                mBean.add(new OftenForumDrawerListViewBean("精彩连载论坛"));
                mBean.add(new OftenForumDrawerListViewBean("活动报道论坛"));
                mBean.add(new OftenForumDrawerListViewBean("二手车论坛"));
                mBean.add(new OftenForumDrawerListViewBean("FIST Auto论坛"));
                mBean.add(new OftenForumDrawerListViewBean("亿佰欧论坛"));
                mBean.add(new OftenForumDrawerListViewBean("金驰之星论坛"));
                mBean.add(new OftenForumDrawerListViewBean("autobots论坛"));
                mBean.add(new OftenForumDrawerListViewBean("运通德系改装论坛"));
                mBean.add(new OftenForumDrawerListViewBean("车168论坛"));
                mBean.add(new OftenForumDrawerListViewBean("儿童安全座椅论坛"));
                mBean.add(new OftenForumDrawerListViewBean("鬼马改装论坛"));
                mBean.add(new OftenForumDrawerListViewBean("VTC上海会论坛"));
                mBean.add(new OftenForumDrawerListViewBean("TCPracing论坛"));
                mBean.add(new OftenForumDrawerListViewBean("名欧改装论坛"));
                mAdapter.setDatas(mBean);
                mDrawerLayout.openDrawer(Gravity.RIGHT);
                mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNDEFINED);
            }
        });

        /**
         * 抽屉相关的数据初始化
         */
        mDrawerLayout = byView(R.id.oftenforum_drawer);
        drawerListView = byView(R.id.drawer_oftenforum_listview);
        show = byView(R.id.oftenforum_titlethreetv);
        mAdapter = new OftenForumCarDrawerAdapter(context);
        drawerListView.setAdapter(mAdapter);

    }
    @Override
    protected void initDatas() {

    }

}
