package com.zhangzuhao.dllo.autohome.ui.fragment.findcarfragment;

import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.zhangzuhao.dllo.autohome.R;
import com.zhangzuhao.dllo.autohome.model.bean.DrawerDepreciateLvBean;
import com.zhangzuhao.dllo.autohome.ui.adapter.DrawerDepreciateAdapter;
import com.zhangzuhao.dllo.autohome.ui.fragment.AbsBaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/9/10.
 *降价的fragment
 */
public class DepreciateFragment extends AbsBaseFragment implements View.OnClickListener {
    private TextView brandTv , priceTv  , levelTv , orderTv , closeTv;
    private DrawerLayout mDrawerLayout;
    private ListView drawerListView;
    private DrawerDepreciateAdapter  mAdapter;
    private List<DrawerDepreciateLvBean> datas ;
    private DrawerDepreciateLvBean mBean;

    @Override
    protected int setLayout() {
        return R.layout.fragment_depreciate;
    }

    @Override
    protected void initViews() {
        brandTv = byView(R.id.depreciate_brandtv);
        priceTv = byView(R.id.depreciate_pricetv);
        levelTv = byView(R.id.depreciate_levletv);
        orderTv = byView(R.id.depreciate_paixutv);
        closeTv = byView(R.id.drawer_depreciate_closetv);
        /**
         * 抽屉
         */
        mDrawerLayout = byView(R.id.depreciate_dl);
        drawerListView = byView(R.id.drawer_depreciate_listview);
        mAdapter = new DrawerDepreciateAdapter(context);
        drawerListView.setAdapter(mAdapter);

        brandTv.setOnClickListener(this);
        priceTv.setOnClickListener(this);
        levelTv.setOnClickListener(this);
        orderTv.setOnClickListener(this);
        closeTv.setOnClickListener(this);
    }
    @Override
    protected void initDatas() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.depreciate_brandtv:
                break;
            case R.id.depreciate_pricetv:
                /**
                 * 给价格的抽屉构造数据
                 */
                initPriceData();
                mDrawerLayout.openDrawer(Gravity.RIGHT);
                mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNDEFINED);
                break;
            case R.id.depreciate_levletv:
                /**
                 * 给级别的抽屉构造数据
                 */
                initLevelDatas();
                mDrawerLayout.openDrawer(Gravity.RIGHT);
                mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNDEFINED);
                break;
            case R.id.depreciate_paixutv:
                /**
                 * 排序抽屉的构造数据
                 */
                initOrderDatas();
                mDrawerLayout.openDrawer(Gravity.RIGHT);
                mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNDEFINED);
                break;
            case R.id.drawer_depreciate_closetv:
                mDrawerLayout.closeDrawer(Gravity.RIGHT);
                break;
        }
    }

    private void initOrderDatas() {
        datas = new ArrayList<>();
        datas.add(new DrawerDepreciateLvBean("大幅度"));
        datas.add(new DrawerDepreciateLvBean("销量多"));
        datas.add(new DrawerDepreciateLvBean("价格低"));
        datas.add(new DrawerDepreciateLvBean("距离近"));
        mAdapter.setDatas(datas);
    }

    private void initLevelDatas() {
        datas = new ArrayList<>();
        datas.add(new DrawerDepreciateLvBean("不限"));
        datas.add(new DrawerDepreciateLvBean("微型车"));
        datas.add(new DrawerDepreciateLvBean("小型车"));
        datas.add(new DrawerDepreciateLvBean("紧凑型车"));
        datas.add(new DrawerDepreciateLvBean("中型车"));
        datas.add(new DrawerDepreciateLvBean("中大型车"));
        datas.add(new DrawerDepreciateLvBean("豪华车"));
        datas.add(new DrawerDepreciateLvBean("跑车"));
        datas.add(new DrawerDepreciateLvBean("MPV"));
        datas.add(new DrawerDepreciateLvBean("全部SUV"));
        datas.add(new DrawerDepreciateLvBean("小型SUV"));
        datas.add(new DrawerDepreciateLvBean("紧凑型SUV"));
        datas.add(new DrawerDepreciateLvBean("中型SUV"));
        datas.add(new DrawerDepreciateLvBean("中大型SUV"));
        datas.add(new DrawerDepreciateLvBean("全尺寸SUV"));
        datas.add(new DrawerDepreciateLvBean("微面"));
        datas.add(new DrawerDepreciateLvBean("微卡"));
        datas.add(new DrawerDepreciateLvBean("轻客"));
        mAdapter.setDatas(datas);
    }

    private void initPriceData() {
        datas = new ArrayList<>();
        datas.add(new DrawerDepreciateLvBean("不限"));
        datas.add(new DrawerDepreciateLvBean("5万以下"));
        datas.add(new DrawerDepreciateLvBean("5-8万"));
        datas.add(new DrawerDepreciateLvBean("8-10万"));
        datas.add(new DrawerDepreciateLvBean("10-15万"));
        datas.add(new DrawerDepreciateLvBean("15-20万"));
        datas.add(new DrawerDepreciateLvBean("20-25万"));
        datas.add(new DrawerDepreciateLvBean("25-35万"));
        datas.add(new DrawerDepreciateLvBean("35-50万"));
        datas.add(new DrawerDepreciateLvBean("50-70万"));
        datas.add(new DrawerDepreciateLvBean("70-100万"));
        datas.add(new DrawerDepreciateLvBean("100万以上"));
        mAdapter.setDatas(datas);
    }
}
