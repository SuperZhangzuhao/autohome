package com.zhangzuhao.dllo.autohome.ui.fragment.recommendfragments;

import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;

import com.google.gson.Gson;
import com.zhangzuhao.dllo.autohome.R;
import com.zhangzuhao.dllo.autohome.model.bean.InnovateRotateBean;
import com.zhangzuhao.dllo.autohome.model.bean.InnovateSpinnerBean;
import com.zhangzuhao.dllo.autohome.model.bean.InnvoateListViewBean;
import com.zhangzuhao.dllo.autohome.model.net.VolleyInstance;
import com.zhangzuhao.dllo.autohome.model.net.VolleyResult;
import com.zhangzuhao.dllo.autohome.ui.adapter.InnvoateListViewAdapter;
import com.zhangzuhao.dllo.autohome.ui.adapter.InnvotateSpinnerAdapter;
import com.zhangzuhao.dllo.autohome.ui.adapter.vpadapter.InnovateRotateViewPagerAdapter;
import com.zhangzuhao.dllo.autohome.ui.fragment.AbsBaseFragment;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by dllo on 16/9/10.
 * 优创界面的fragment
 */
public class InnovateFragment extends AbsBaseFragment {
    /**
     * listView定义的数据
     */
    private String url = "http://news.app.autohome.com.cn/news_v6.1.0/newspf/npnewslist.ashx?a=2&pm=2&v=6.1.0&au=&type=3&lastid=&lastuid=0&size=30";
    private ListView listView ;
    private InnvoateListViewAdapter  mAdapter;
    private CircleImageView circler;
    /**
     * ViewPager相关的定义数据
     */
    private ViewPager mViewPager;
    private InnovateRotateViewPagerAdapter  innovateRotateViewPagerAdapter;
    private List<InnovateRotateBean> datas;
    private LinearLayout  mPointLl;
    private Handler  mHandler;
    private boolean  isRotate = false ;
    private Runnable  mRotateRunnable;
    /**
     * Spinner的相关定义数据
     */
    private List<InnovateSpinnerBean> spinnerDatas;
    private Spinner mSpinner;

    @Override
    protected int setLayout() {
        return R.layout.fragment_innovate;
    }

    @Override
    protected void initViews() {
        /**
         * listView相关数据的初始化以及绑定
         */
        listView = byView(R.id.innovate_listview);
        mAdapter = new InnvoateListViewAdapter(context);
        listView.setAdapter(mAdapter);
        View view = LayoutInflater.from(context).inflate(R.layout.item_listview_innovate_onepic ,null );
        circler = (CircleImageView) view.findViewById(R.id.item_innovate_listview_onepic_headimg);
        /**
         * Spinner相关初始化以及绑定
         */
        mSpinner = byView(R.id.innovate_spinner);
    }

    @Override
    protected void initDatas() {
        /**
         * listview获取网络数据
         */
        VolleyInstance.getmInstance().startRequest(url, new VolleyResult() {
            @Override
            public void success(String resultStr) {
                Gson gson = new Gson();
                InnvoateListViewBean mBean = gson.fromJson(resultStr , InnvoateListViewBean.class);
                List<InnvoateListViewBean.ResultBean.NewslistBean> datas = mBean.getResult().getNewslist();
                mAdapter.setDatas(datas);
            }
            @Override
            public void failure() {
            }
        });
        /**
         * 添加头布局
         */
        View headView = LayoutInflater.from(context).inflate(R.layout.item_innovate_rotate_listview , listView , false);
        mViewPager = (ViewPager) headView.findViewById(R.id.innovate_rotate_viewpager);
        mPointLl = (LinearLayout) headView.findViewById(R.id.innovate_rotate_layout);
        listView.addHeaderView(headView);
        /**
         * ViewPager构造数据
         */
        buildDatas();
        innovateRotateViewPagerAdapter = new InnovateRotateViewPagerAdapter(datas , context);
        mViewPager.setAdapter(innovateRotateViewPagerAdapter);
        mViewPager.setCurrentItem(datas.size()*100);
        /**
         * 开始轮播
         */
        mHandler = new Handler();
        startRotate();
        /**
         * 添加小圆点
         */
        addPoint();
        /**
         * 随着轮播图改变小圆点的颜色
         */
        changePoint();
        /**
         * 构造Spinner数据
         */
        createSpinner();
    }

    private void createSpinner() {
        spinnerDatas = new ArrayList<>();
        spinnerDatas.add(new InnovateSpinnerBean("优创"));
        spinnerDatas.add(new InnovateSpinnerBean("全部"));
        spinnerDatas.add(new InnovateSpinnerBean("我的关注"));
        Log.d("sss", "spinnerDatas:" + spinnerDatas);
        InnvotateSpinnerAdapter spAdapter = new InnvotateSpinnerAdapter(spinnerDatas , context);
        mSpinner.setAdapter(spAdapter);

    }

    private void startRotate() {
        mRotateRunnable = new Runnable() {
            @Override
            public void run() {
             int nowIndex = mViewPager.getCurrentItem();
                mViewPager.setCurrentItem(++nowIndex);
                if (isRotate){
                    mHandler.postDelayed(mRotateRunnable , 3000);
                }
            }
        };
        mHandler.postDelayed(mRotateRunnable , 3000);
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

    private void changePoint() {
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (isRotate){
                    for (int i = 0; i <datas.size() ; i++) {
                        ImageView pointIv = (ImageView) mPointLl.getChildAt(i);
                        pointIv.setImageResource(R.mipmap.point_white);
                    }
                    ImageView iv = (ImageView) mPointLl.getChildAt(position % datas.size());
                    iv.setImageResource(R.mipmap.point_grey);
                }
            }
            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void addPoint() {
        for (int i = 0; i <datas.size() ; i++) {
            ImageView pointIv = new ImageView(context);
            pointIv.setPadding(5 ,5,2,5);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(50 , 50);
            pointIv.setLayoutParams(params);
            /**
             * 设置第0页的小圆点为灰色
             */
        if (i == 0){
            pointIv.setImageResource(R.mipmap.point_grey);
        }else {
            pointIv.setImageResource(R.mipmap.point_white);
        }
            mPointLl.addView(pointIv);
        }
    }

    private void buildDatas() {
        datas = new ArrayList<>();
        datas.add(new InnovateRotateBean("http://qn.www2.autoimg.cn/youchuang/g14/M03/51/06/autohomecar__wKgH5FfiKr-AVvIEAATOtfoR_PI688.jpg?imageView2/0/w/640/h/320"));
        datas.add(new InnovateRotateBean("http://qn.www2.autoimg.cn/youchuang/g13/M0F/4D/92/autohomecar__wKgH1FfhCNaAQibVAAN0LoTp6qQ450.jpg?imageView2/0/w/640/h/320"));
        datas.add(new InnovateRotateBean("http://qn.www2.autoimg.cn/youchuang/g22/M04/31/38/autohomecar__wKgFW1fhDTeAZpzaAAMwsWU2OFM003.jpg?imageView2/0/w/640/h/320"));
        datas.add(new InnovateRotateBean("http://qn.www2.autoimg.cn/youchuang/g15/M01/4D/9C/autohomecar__wKgH5VfhAy6AIsDlAAPM8fWAiQ4876.jpg?imageView2/0/w/640/h/320"));
        datas.add(new InnovateRotateBean("http://qn.www2.autoimg.cn/youchuang/g6/M00/4E/28/autohomecar__wKgH3Fff_1uAR7QuAAetPa_xdUE667.jpg?imageView2/0/w/640/h/320"));
        Log.d("qqq", "datas:" + datas);
    }


}
