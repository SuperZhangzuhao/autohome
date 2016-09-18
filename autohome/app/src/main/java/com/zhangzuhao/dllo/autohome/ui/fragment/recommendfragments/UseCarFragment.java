package com.zhangzuhao.dllo.autohome.ui.fragment.recommendfragments;

import android.widget.ListView;

import com.google.gson.Gson;
import com.zhangzuhao.dllo.autohome.R;
import com.zhangzuhao.dllo.autohome.model.bean.UseCarBean;
import com.zhangzuhao.dllo.autohome.model.net.VolleyInstance;
import com.zhangzuhao.dllo.autohome.model.net.VolleyResult;
import com.zhangzuhao.dllo.autohome.ui.adapter.UseCarListViewAdapter;
import com.zhangzuhao.dllo.autohome.ui.fragment.AbsBaseFragment;

import java.util.List;

/**
 * Created by dllo on 16/9/16.
 * 用车的Fragment
 */
public class UseCarFragment extends AbsBaseFragment {
    private String Url = "http://app.api.autohome.com.cn/autov5.0.0/news/newslist-pm2-c0-nt82-p1-s20-l0.json";
    private ListView listview;
    private UseCarListViewAdapter adapter ;
    @Override
    protected int setLayout() {
        return R.layout.fragment_usecar;
    }

    @Override
    protected void initViews() {
        listview = byView(R.id.usecar_listview);
        adapter = new UseCarListViewAdapter(context);
        listview.setAdapter(adapter);

    }

    @Override
    protected void initDatas() {
        /**
         * 获取网络数据
         */
        VolleyInstance.getmInstance().startRequest(Url, new VolleyResult() {
            @Override
            public void success(String resultStr) {
                    Gson gson = new Gson();
                    UseCarBean bean = gson.fromJson(resultStr , UseCarBean.class);
                    List<UseCarBean.ResultBean.NewslistBean> datas = bean.getResult().getNewslist();
                    adapter.setDatas(datas);

                }

            @Override
            public void failure() {

            }
        });

    }
}
