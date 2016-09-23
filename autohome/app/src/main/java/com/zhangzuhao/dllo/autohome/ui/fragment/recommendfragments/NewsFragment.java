package com.zhangzuhao.dllo.autohome.ui.fragment.recommendfragments;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.zhangzuhao.dllo.autohome.R;
import com.zhangzuhao.dllo.autohome.model.bean.NewsListViewBean;
import com.zhangzuhao.dllo.autohome.model.net.VolleyInstance;
import com.zhangzuhao.dllo.autohome.model.net.VolleyResult;
import com.zhangzuhao.dllo.autohome.ui.adapter.NewsListViewAdapter;
import com.zhangzuhao.dllo.autohome.ui.fragment.AbsBaseFragment;

import java.util.List;

/**
 * Created by dllo on 16/9/10.
 */
public class NewsFragment extends AbsBaseFragment {
    private TextView titleTv, timeTv, replyTv;
    private ImageView smallpic;
    private ListView listView;
    private NewsListViewAdapter newsListViewAdapter;
    private String newsUrl = "http://app.api.autohome.com.cn/autov5.0.0/news/newslist-pm1-c0-nt1-p1-s30-l0.json";

    @Override
    protected int setLayout() {
        return R.layout.fragment_news;
    }

    @Override
    protected void initViews() {
        titleTv = byView(R.id.news_item_title);
        timeTv = byView(R.id.news_item_time);
        replyTv = byView(R.id.news_item_replycount);
        smallpic = byView(R.id.news_item_smallpic);
        listView = byView(R.id.news_listview);
        newsListViewAdapter = new NewsListViewAdapter(context);
        listView.setAdapter(newsListViewAdapter);

    }

    @Override
    protected void initDatas() {
        Bundle bundle = getArguments();
        String str = bundle.getString("key");

        /**
         * 获取网络数据
         */
        VolleyInstance.getmInstance().startRequest(str, new VolleyResult() {
            @Override
            public void success(String resultStr) {
                Gson gson = new Gson();
                NewsListViewBean newsListViewBean = gson.fromJson(resultStr, NewsListViewBean.class);
                List<NewsListViewBean.ResultBean.NewslistBean> datas = newsListViewBean.getResult().getNewslist();
                newsListViewAdapter.setDatas(datas);
            }

            @Override
            public void failure() {
            }
        });
    }

    /**
     * fragment的单例类
     */
    public static NewsFragment newInstance(String url) {
        Bundle args = new Bundle();
        args.putString("key", url);
        NewsFragment fragment = new NewsFragment();
        fragment.setArguments(args);
        return fragment;
    }

}
