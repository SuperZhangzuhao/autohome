package com.zhangzuhao.dllo.autohome.ui.fragment.findcarfragment;

import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.google.gson.Gson;
import com.zhangzuhao.dllo.autohome.R;
import com.zhangzuhao.dllo.autohome.model.bean.ScreenListViewBean;
import com.zhangzuhao.dllo.autohome.model.net.VolleyInstance;
import com.zhangzuhao.dllo.autohome.model.net.VolleyResult;
import com.zhangzuhao.dllo.autohome.ui.adapter.ScreenListViewAdapter;
import com.zhangzuhao.dllo.autohome.ui.fragment.AbsBaseFragment;

import java.util.List;

/**
 * Created by dllo on 16/9/10.
 *筛选的fragment
 */
public class ScreenFragment extends AbsBaseFragment {
    /**
     *listview相关数据定义
     */
    private ListView mListView;
    private ScreenListViewAdapter  mAdapter;
    private String screenUrl = "http://cars.app.autohome.com.cn/cars_v5.8.0/cars/gethotseries-a2-pm2-v6.1.0-p1-s20.json";

    /**
     *popupwindow
     */
    private TextView showPopupTv;
    @Override
    protected int setLayout() {
        return R.layout.fragment_screen;
    }

    @Override
    protected void initViews() {
        mListView = byView(R.id.screen_listview);
        mAdapter = new ScreenListViewAdapter(context);
        mListView.setAdapter(mAdapter);
        /**
         * popupwindow
         */
        showPopupTv = byView(R.id.screen_tiaojian_tv);

        showPopupTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupWindow pop = new PopupWindow();
                pop.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
                pop.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
                View view = LayoutInflater.from(context).inflate(R.layout.popup_screen , null);
                pop.setContentView(view);
                pop.setFocusable(true);
                pop.setBackgroundDrawable(new BitmapDrawable());
                pop.setOutsideTouchable(true);
                pop.showAsDropDown(showPopupTv);
            }
        });
    }
    @Override
    protected void initDatas() {
        /**
         * 获取网络数据
         */
        VolleyInstance.getmInstance().startRequest(screenUrl, new VolleyResult() {
            @Override
            public void success(String resultStr) {
                Gson gson = new Gson();
                ScreenListViewBean mBean = gson.fromJson(resultStr , ScreenListViewBean.class);
                List<ScreenListViewBean.ResultBean.SeriesBean> datas = mBean.getResult().getSeries();
                mAdapter.setDatas(datas);
            }

            @Override
            public void failure() {

            }
        });

    }
}
