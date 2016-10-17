package com.zhangzuhao.dllo.autohome.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ExpandableListView;

import com.google.gson.Gson;
import com.zhangzuhao.dllo.autohome.R;
import com.zhangzuhao.dllo.autohome.model.bean.NewsFlashDetailsExBean;
import com.zhangzuhao.dllo.autohome.model.net.VolleyInstance;
import com.zhangzuhao.dllo.autohome.model.net.VolleyResult;
import com.zhangzuhao.dllo.autohome.ui.adapter.NewsFlashDetailsAdapter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dllo on 16/9/30.
 * 快报的二级详情界面
 */
public class NewsFlashDetailsActivity extends AbsBaseActivity {
    private ExpandableListView expandableListView ;
    private NewsFlashDetailsAdapter mAdapter;
    private String mUrl;

    @Override
    protected int setLayout() {
        return R.layout.activity_newsflashdetails;
    }

    @Override
    protected void initViews() {
     expandableListView = byView(R.id.newsflash_details_exlistview);
     mAdapter = new NewsFlashDetailsAdapter(this);
     expandableListView.setAdapter(mAdapter);


    }

    @Override
    protected void initDatas() {
        /**
         * 接收传来的接口
         */
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        mUrl = bundle.getString("key");
        /**
         * 数据解析
         */
        VolleyInstance.getmInstance().startRequest(mUrl, new VolleyResult() {
            @Override
            public void success(String resultStr) {
                Gson gson = new Gson();
                Map<String , List<NewsFlashDetailsExBean.ResultBean.MessagelistBean.CommentlistBean>>childs = new HashMap<>();
                NewsFlashDetailsExBean mBean = gson.fromJson(resultStr  , NewsFlashDetailsExBean.class);
                List<NewsFlashDetailsExBean.ResultBean.MessagelistBean> gruopDatas = mBean.getResult().getMessagelist();
                mAdapter.setGroupList(gruopDatas);
                for (int i = 0; i <gruopDatas.size(); i++) {
                    String time = gruopDatas.get(i).getPublishtime();
                    childs.put(time , gruopDatas.get(i).getCommentlist());
                }
                mAdapter.setChilds(childs);
            }

            @Override
            public void failure() {

            }
        });

    }
}
