package com.zhangzuhao.dllo.autohome.ui.fragment.forumfragment;

import android.widget.ListView;

import com.google.gson.Gson;
import com.zhangzuhao.dllo.autohome.R;
import com.zhangzuhao.dllo.autohome.model.bean.HotPostListViewBean;
import com.zhangzuhao.dllo.autohome.model.net.VolleyInstance;
import com.zhangzuhao.dllo.autohome.model.net.VolleyResult;
import com.zhangzuhao.dllo.autohome.ui.adapter.HotPostListViewAdapter;
import com.zhangzuhao.dllo.autohome.ui.fragment.AbsBaseFragment;

import java.util.List;

/**
 * Created by dllo on 16/9/10.
 * 热帖的fragment
 */
public class HotpostFragment extends AbsBaseFragment {
    /**
     *listview相关的定义数据
     */
    private ListView mListView;
    private HotPostListViewAdapter hotPostListViewAdapter;
    private String url  = "http://club.app.autohome.com.cn/club_v6.1.0/club/shotfoumlist-pm1-p1-s50.json";

    @Override
    protected int setLayout() {
        return R.layout.fragment_hotpost;
    }
    @Override
    protected void initViews() {
        mListView = byView(R.id.hotpost_listview);
        hotPostListViewAdapter = new HotPostListViewAdapter(context);
        mListView.setAdapter(hotPostListViewAdapter);
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
                HotPostListViewBean  hotBean = gson.fromJson(resultStr , HotPostListViewBean.class);
                List<HotPostListViewBean.ResultBean.ListBean> datas = hotBean.getResult().getList();
                hotPostListViewAdapter.setDatas(datas);
            }

            @Override
            public void failure() {

            }
        });
    }
}
