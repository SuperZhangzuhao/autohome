package com.zhangzuhao.dllo.autohome.ui.fragment.recommendfragments;

import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.google.gson.Gson;
import com.zhangzuhao.dllo.autohome.R;
import com.zhangzuhao.dllo.autohome.model.bean.NewestListViewBean;
import com.zhangzuhao.dllo.autohome.model.bean.RotateBean;
import com.zhangzuhao.dllo.autohome.model.net.VolleyInstance;
import com.zhangzuhao.dllo.autohome.model.net.VolleyResult;
import com.zhangzuhao.dllo.autohome.ui.adapter.NewestListViewAdapter;
import com.zhangzuhao.dllo.autohome.ui.adapter.vpadapter.NewestRotateViewPagerAdapter;
import com.zhangzuhao.dllo.autohome.ui.fragment.AbsBaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/9/10.
 * 最新界面的Fragment
 */
public class NewestFragment extends AbsBaseFragment {
    /**
     * Listview
     */
    private String newestUrl = "http://app.api.autohome.com.cn/autov4.8.8/news/newslist-pm1-c0-nt0-p1-s30-l0.json";
    private ListView mListView;
    private NewestListViewAdapter newestListViewAdapter;
    /**
     * 轮播图
     */
    private ViewPager viewPager;
    private NewestRotateViewPagerAdapter newestRotateViewPagerAdapter;
    private List<RotateBean> datas;
    private LinearLayout pointLl;
    private Handler handler;
    private boolean isRotate = false;
    private Runnable rotateRunnable;

    @Override
    protected int setLayout() {
        return R.layout.fragment_newest;
    }

    @Override
    protected void initViews() {
        /**
         * 最新页面的ListView相关的初始化
         */
        mListView = byView(R.id.newest_listview);
        newestListViewAdapter = new NewestListViewAdapter(context);
        newestRotateViewPagerAdapter = new NewestRotateViewPagerAdapter(context);
        mListView.setAdapter(newestListViewAdapter);
    }

    @Override
    protected void initDatas() {
        /**
         * 获取网络数据
         */
        VolleyInstance.getmInstance().startRequest(newestUrl, new VolleyResult() {
            @Override
            public void success(String resultStr) {
                Gson gson = new Gson();
                NewestListViewBean bean = gson.fromJson(resultStr, NewestListViewBean.class);
                List<NewestListViewBean.ResultBean.NewslistBean> datas = bean.getResult().getNewslist();
                newestListViewAdapter.setDatas(datas);
            }

            @Override
            public void failure() {
            }
        });
        /**
         * 添加ListView的头布局
         */
        View headView = LayoutInflater.from(context).inflate(R.layout.item_newest_listview_rotate, mListView, false);
        viewPager = (ViewPager) headView.findViewById(R.id.item_newest_listview_rotate_vp);
        pointLl = (LinearLayout) headView.findViewById(R.id.item_newest_listview_rotate_point_container);
        mListView.addHeaderView(headView);
        Log.d("www", "为listview添加头布局");
        /**
         * ViewPager构造数据
         */
        buildDatas();
        Log.d("www", "为ViewPager创建数据");
        newestRotateViewPagerAdapter = new NewestRotateViewPagerAdapter(datas, context);
        viewPager.setAdapter(newestRotateViewPagerAdapter);
        viewPager.setCurrentItem(datas.size() * 100);
        /**
         * 开始轮播
         */
        handler = new Handler();
        startRotate();
        /**
         * 添加小圆点
         */
        addPoints();
        /**
         * 随着轮播图的播放改变小圆点的颜色
         */
        changePoints();
    }

    /**
     * 开始轮播
     */
    private void startRotate() {
        Log.d("www", "开始轮播");
        rotateRunnable = new Runnable() {
            @Override
            public void run() {
                int nowIndex = viewPager.getCurrentItem();
                viewPager.setCurrentItem(++nowIndex);
                if (isRotate) {
                    handler.postDelayed(rotateRunnable, 3000);
                }
            }
        };
        handler.postDelayed(rotateRunnable, 3000);
    }

    @Override
    public void onResume() {
        Log.d("NewestFragment", "onresume");
        super.onResume();
        isRotate = true;
    }

    @Override
    public void onPause() {
        Log.d("NewestFragment", "onpause");
        super.onPause();
        isRotate = false;
    }

    private void changePoints() {
        Log.d("www", "改变小圆点");
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (isRotate) {
                    for (int i = 0; i < datas.size(); i++) {
                        ImageView pointIv = (ImageView) pointLl.getChildAt(i);
                        pointIv.setImageResource(R.mipmap.point_white);
                    }
                    ImageView iv = (ImageView) pointLl.getChildAt(position % datas.size());
                    iv.setImageResource(R.mipmap.point_grey);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    /**
     * 添加轮播图上面的小圆点
     */
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
            pointLl.addView(pointIv);
        }
    }

    private void buildDatas() {
        Log.d("www", "添加轮播图片");
        datas = new ArrayList<>();
        datas.add(new RotateBean("http://www3.autoimg.cn/newsdfs/g16/M09/4C/16/640x320_0_autohomecar__wKgH11ff_siAT39EAAb11cjL4MY067.jpg"));
        datas.add(new RotateBean("http://www3.autoimg.cn/newsdfs/g6/M13/4C/41/640x320_0_autohomecar__wKjB0VffV46AVS3xAAr_7RZVkJo343.jpg"));
        datas.add(new RotateBean("http://www2.autoimg.cn/newsdfs/g18/M01/48/51/640x320_0_autohomecar__wKgH2VfdXsOAENBxAAHlhJ5YO-I087.jpg"));
        datas.add(new RotateBean("http://www2.autoimg.cn/newsdfs/g17/M13/45/3D/640x320_0_autohomecar__wKgH2FfeYnWAAOUJAALmvKVjQsI150.jpg"));
        datas.add(new RotateBean("http://www3.autoimg.cn/newsdfs/g17/M09/47/9E/640x320_0_autohomecar__wKgH51feKYCAQ02oAAhFNzn7tVU182.jpg"));
        datas.add(new RotateBean("http://www3.autoimg.cn/newsdfs/g17/M06/48/EB/640x320_0_autohomecar__wKgH51ffQBSASzHZAAfasiEN3g4753.jpg"));

    }

}
