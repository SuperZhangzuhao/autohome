package com.zhangzuhao.dllo.autohome.ui.fragment;

import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.google.gson.Gson;
import com.zhangzuhao.dllo.autohome.R;
import com.zhangzuhao.dllo.autohome.model.bean.FindBean;
import com.zhangzuhao.dllo.autohome.model.bean.FindHeadOneRecyclerViewBean;
import com.zhangzuhao.dllo.autohome.model.bean.FindRotateBean;
import com.zhangzuhao.dllo.autohome.model.net.VolleyInstance;
import com.zhangzuhao.dllo.autohome.model.net.VolleyResult;
import com.zhangzuhao.dllo.autohome.ui.adapter.FindHeadOneRecyclerViewAdapter;
import com.zhangzuhao.dllo.autohome.ui.adapter.FindHeadTwoRecyclerViewAdapter;
import com.zhangzuhao.dllo.autohome.ui.adapter.FindListViewAdapter;
import com.zhangzuhao.dllo.autohome.ui.adapter.vpadapter.FindRotateVpAdapter;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by dllo on 16/9/9.
 * 发现的fragment
 */
public class FindFragment extends AbsBaseFragment {
    /**
     *Listview的相关数据定义
     */
    private ListView mListView;
    private FindListViewAdapter mAdapter;
    private String url = "http://223.99.255.20/mobilenc.app.autohome.com.cn/discover_v5.8.0/mall/intelligentrecommend.ashx?a=2&pm=2&v=5.8.5&uid=0&deviceid=99000628573771&gps=38.889659,121.551063&cityid=210200&pid=210000&pageindex=1&pagesize=20&hid";
    private String oneRecyclerUrl= "http://223.99.255.20/mobilenc.app.autohome.com.cn/discover_v5.8.0/mobile/functionlist-a2-pm2-v5.8.5-pid210000-cid210200.json";
    /**
     * 轮播图
     */
    private ViewPager mViewPager;
    private FindRotateVpAdapter findRotateVpAdapter ;
    private List<FindRotateBean>datas;
    private LinearLayout layout ;
    private Handler handler;
    private boolean isRotate = false;
    private Runnable rotateRunnable;
    /**
     * 第一个头布局的Recyclerview
     */
    private RecyclerView recyclerview;
    private FindHeadOneRecyclerViewAdapter   oneHeadRviewAdapter;
    /**
     * 第二个头布局
     */
   private RecyclerView sRecyclerView;
    private FindHeadTwoRecyclerViewAdapter   twoHeadRviewAdapter;
    @Override
    protected int setLayout() {
        return R.layout.fragment_find;
    }

    @Override
    protected void initViews() {
        /**
         * listview相关数据绑定和初始化
         */
        mListView = byView(R.id.find_listview);
        mAdapter = new FindListViewAdapter(context);
        mListView.setAdapter(mAdapter);
        findRotateVpAdapter = new FindRotateVpAdapter(context);
        /**
         * 轮播图
         */
        View view  = LayoutInflater.from(context).inflate(R.layout.item_find_head_one , null);
        mViewPager = (ViewPager) view.findViewById(R.id.find_rotate_vp);
        layout = (LinearLayout) view.findViewById(R.id.find_rotate_ll);
        /**
         * 第一个头布局的Recyclerview
         */
        recyclerview = (RecyclerView) view.findViewById(R.id.item_find_head_one_rv);
        oneHeadRviewAdapter = new FindHeadOneRecyclerViewAdapter(context);
        recyclerview.setAdapter(oneHeadRviewAdapter);
        GridLayoutManager glm = new GridLayoutManager(context , 5);
        recyclerview.setLayoutManager(glm);
        mListView.addHeaderView(view);
        /**
         * 第二个头布局的RecyclerView
         */
        View sView = LayoutInflater.from(context).inflate(R.layout.item_find_head_two , null);
        sRecyclerView = (RecyclerView) sView.findViewById(R.id.item_find_head_two_rv);
        twoHeadRviewAdapter = new FindHeadTwoRecyclerViewAdapter(context);
        sRecyclerView.setAdapter(twoHeadRviewAdapter);
        GridLayoutManager sGlm = new GridLayoutManager( context , 2);
        sRecyclerView.setLayoutManager(sGlm);
        mListView.addHeaderView(sView);
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
                FindBean mBean = gson.fromJson(resultStr , FindBean.class);
                List<FindBean.ResultBean.GoodslistBean.ListBean> datas = mBean.getResult().getGoodslist().getList();
                mAdapter.setDatas(datas);
            }
            @Override
            public void failure() {
            }
        });
        VolleyInstance.getmInstance().startRequest(oneRecyclerUrl, new VolleyResult() {
            @Override
            public void success(String resultStr) {
                Gson gson = new Gson();
                FindHeadOneRecyclerViewBean  mBean = gson.fromJson(resultStr , FindHeadOneRecyclerViewBean.class);
                List<FindHeadOneRecyclerViewBean.ResultBean.FunctionlistBean> datas = mBean.getResult().getFunctionlist();
                oneHeadRviewAdapter.setDatas(datas);
            }
            @Override
            public void failure() {
            }
        });
        VolleyInstance.getmInstance().startRequest(url, new VolleyResult() {
            @Override
            public void success(String resultStr) {
                Gson gson = new Gson();
                FindBean twoRviewBean = gson.fromJson(resultStr , FindBean.class);
                List<FindBean.ResultBean.ModulelistBean.ListBean> mDatas  = twoRviewBean.getResult().getModulelist().get(1).getList();
                twoHeadRviewAdapter.setDatas(mDatas);
            }

            @Override
            public void failure() {

            }
        });

        /**
         * ViewPager构造数据
         */
        buildVpData();
        mViewPager.setCurrentItem(datas.size() * 100);
        /**
         *开始轮播
         */
        handler = new Handler();
        startRotate();
        /**
         * 添加小圆点
         */
        addPoints();
        /**
         * 随着轮播改变小圆点的颜色
         */
        changePoints();


    }
    private void startRotate() {
        Log.d("www", "开始轮播");
        rotateRunnable = new Runnable() {
            @Override
            public void run() {
                int nowIndex = mViewPager.getCurrentItem();
                mViewPager.setCurrentItem(++nowIndex);
                if (isRotate) {
                    handler.postDelayed(rotateRunnable, 3000);
                }
            }
        };
        handler.postDelayed(rotateRunnable, 3000);
    }
    @Override
    public void onResume() {
        super.onResume();
        isRotate = true;
    }

    @Override
    public void onPause() {
        super.onPause();
        isRotate = false;
    }
    private void changePoints() {
        Log.d("www", "改变小圆点");
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
            @Override
            public void onPageSelected(int position) {
                if (isRotate) {
                    for (int i = 0; i < datas.size(); i++) {
                        ImageView pointIv = (ImageView) layout.getChildAt(i);
                        pointIv.setImageResource(R.mipmap.point_white);
                    }
                    ImageView iv = (ImageView) layout.getChildAt(position % datas.size());
                    iv.setImageResource(R.mipmap.point_grey);
                }
            }
            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    private void addPoints() {
        Log.d("www", "绘制小圆点");
        for (int i = 0; i < datas.size(); i++) {
            ImageView pointIv = new ImageView(context);
            pointIv.setPadding(5, 5, 2, 5);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(50, 50);
            pointIv.setLayoutParams(params);
            /**
             * 设置第0页的小圆点为灰色
             */
            if (i == 0) {
                pointIv.setImageResource(R.mipmap.point_grey);
            } else {
                pointIv.setImageResource(R.mipmap.point_white);
            }
            layout.addView(pointIv);
        }
    }

    private void buildVpData() {
        datas = new ArrayList<>();
        datas.add(new FindRotateBean("http://app2.autoimg.cn/appdfs/g23/M01/3D/68/autohomecar__wKjBwFfrHo2AeyyrAAIZnNuryfs766.jpg"));
        datas.add(new FindRotateBean("http://app2.autoimg.cn/appdfs/g21/M14/34/C2/autohomecar__wKgFWlfk_z2Ae4JtAAEoYhNZKVA773.jpg"));
        datas.add(new FindRotateBean("http://app2.autoimg.cn/appdfs/g5/M0E/5A/5A/autohomecar__wKjB0lfqPhyAYWARAAFe31duapA200.jpg"));
        datas.add(new FindRotateBean("http://app2.autoimg.cn/appdfs/g11/M05/5A/80/autohomecar__wKjBzFfqH7uAe4iCAAJTMu2PiLQ490.jpg"));
        findRotateVpAdapter.setDatas(datas);
        mViewPager.setAdapter(findRotateVpAdapter);

    }
}
