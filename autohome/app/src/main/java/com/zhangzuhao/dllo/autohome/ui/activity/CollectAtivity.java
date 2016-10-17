package com.zhangzuhao.dllo.autohome.ui.activity;

import android.util.Log;
import android.widget.ListView;

import com.zhangzuhao.dllo.autohome.R;
import com.zhangzuhao.dllo.autohome.model.db.CollectBean;
import com.zhangzuhao.dllo.autohome.model.db.LiteOrmInstance;
import com.zhangzuhao.dllo.autohome.ui.adapter.CollectListViewAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/10/11.
 */
public class CollectAtivity extends AbsBaseActivity {
    private ListView mListView;
    private CollectListViewAdapter  mAdapter;
    private List<CollectBean> list;

    @Override
    protected int setLayout() {
        return R.layout.activity_collect;
    }

    @Override
    protected void initViews() {
        mListView = byView(R.id.collect_listview);

    }

    @Override
    protected void initDatas() {
        /**
         * 数据库查询
         */
        list = new ArrayList<>();
        list =  LiteOrmInstance.getInstance().queryAll();
        mAdapter = new CollectListViewAdapter(this);
        mAdapter.setDatas(list);
        mListView.setAdapter(mAdapter);


    }
}
