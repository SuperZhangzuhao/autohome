package com.zhangzuhao.dllo.autohome.ui.fragment.forumfragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.google.gson.Gson;
import com.zhangzuhao.dllo.autohome.R;
import com.zhangzuhao.dllo.autohome.model.bean.BoutiqueListViewBean;
import com.zhangzuhao.dllo.autohome.model.net.VolleyInstance;
import com.zhangzuhao.dllo.autohome.model.net.VolleyResult;
import com.zhangzuhao.dllo.autohome.ui.adapter.BoutiqueListViewAdapter;
import com.zhangzuhao.dllo.autohome.ui.adapter.RecyclerBoutiqueAadapter;
import com.zhangzuhao.dllo.autohome.ui.fragment.AbsBaseFragment;
import com.zhangzuhao.dllo.autohome.utils.OnRvItemClick;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/9/10.
 * 精品推荐的fragment
 */
public class BoutiqueFragment extends AbsBaseFragment {
    private RecyclerView recyclerView;
    private List<String> datas;
    private RecyclerBoutiqueAadapter rbAdapter;
    private ImageView menuImg;
    private OnRvItemClick onRvItemClick;
    private ListView mListview;
    private BoutiqueListViewAdapter adapter;
    private String url;

    protected int setLayout() {
        return R.layout.fragment_boutique;
    }

    @Override
    protected void initViews() {
        recyclerView = byView(R.id.boutique_recycler);
        menuImg = byView(R.id.boutique_menuimg);
        rbAdapter = new RecyclerBoutiqueAadapter(context);
        recyclerView.setAdapter(rbAdapter);
        /**
         * listview
         */
        mListview = byView(R.id.boutique_listview);
        adapter = new BoutiqueListViewAdapter(context);
        mListview.setAdapter(adapter);
    }

    protected void initDatas() {

        /**
         * 设置RecyclerView布局
         */
        LinearLayoutManager llm = new LinearLayoutManager(context);
        llm.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(llm);
        /**
         * 构造数据
         */
        datas = new ArrayList<>();
        datas.add("全部");
        datas.add("媳妇儿当车模");
        datas.add("论坛红人馆");
        datas.add("论坛讲师");
        datas.add("精挑细选");
        datas.add("现身说法");
        datas.add("高端阵地");
        datas.add("电动车");
        datas.add("汇买车");
        datas.add("行车点评");
        datas.add("超级试驾员");
        datas.add("海外构成");
        datas.add("经典老车");
        datas.add("妹子选车");
        datas.add("优惠购车");
        datas.add("原创大片");
        datas.add("顶配风采");
        datas.add("改装有理");
        datas.add("养车有道");
        datas.add("首发阵营");
        datas.add("新车直播");
        datas.add("历史选题");
        datas.add("摩友天地");
        datas.add("蜜月之旅");
        datas.add("摄影课堂");
        datas.add("车友聚会");
        datas.add("单车部落");
        datas.add("杂谈俱乐部");
        datas.add("华北游记");
        datas.add("西南游记");
        datas.add("东北游记");
        datas.add("西北游记");
        datas.add("华中游记");
        datas.add("华南游记");
        datas.add("华东游记");
        datas.add("港澳台游记");
        datas.add("海外游记");
        datas.add("沧海遗珠");
        rbAdapter.setDatas(datas);
        /**
         * 菜单的点击事件
         */
        menuImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initMenu();
            }
        });
        rbAdapter.setOnRvItemClick(new OnRvItemClick() {
            @Override
            public void OnRvItemClickListener(int position, String str) {
                Log.d("xxxxxxx", "ddd");
                switch (position) {
                    case 0:
                        url = "http://app.api.autohome.com.cn/autov4.8.8/club/jingxuantopic-pm1-c0-p1-s30.json";
                        break;
                    case 1:
                        url = "http://app.api.autohome.com.cn/autov4.8.8/club/jingxuantopic-pm1-c104-p1-s30.json";
                        break;
                    case 2:
                        url = "http://app.api.autohome.com.cn/autov4.8.8/club/jingxuantopic-pm1-c194-p1-s30.json";
                        break;
                    case 3:
                        url = "http://app.api.autohome.com.cn/autov4.8.8/club/jingxuantopic-pm1-c110-p1-s30.json";
                        break;
                    case 4:
                        url = "http://app.api.autohome.com.cn/autov4.8.8/club/jingxuantopic-pm1-c172-p1-s30.json";
                        break;
                    case 5:
                        url = "http://app.api.autohome.com.cn/autov4.8.8/club/jingxuantopic-pm1-c230-p1-s30.json";
                        break;
                    case 6:
                        url = "http://app.api.autohome.com.cn/autov4.8.8/club/jingxuantopic-pm1-c233-p1-s30.json";
                        break;
                    case 7:
                        url = "http://app.api.autohome.com.cn/autov4.8.8/club/jingxuantopic-pm1-c121-p1-s30.json";
                        break;
                    case 8:
                        url = "http://app.api.autohome.com.cn/autov4.8.8/club/jingxuantopic-pm1-c106-p1-s30.json";
                        break;
                    case 9:
                        url = "http://app.api.autohome.com.cn/autov4.8.8/club/jingxuantopic-pm1-c118-p1-s30.json";
                        break;
                    case 10:
                        url = "http://app.api.autohome.com.cn/autov4.8.8/club/jingxuantopic-pm1-c210-p1-s30.json";
                        break;
                    case 11:
                        url = "http://app.api.autohome.com.cn/autov4.8.8/club/jingxuantopic-pm1-c199-p1-s30.json";
                        break;
                    case 12:
                        url = "http://app.api.autohome.com.cn/autov4.8.8/club/jingxuantopic-pm1-c198-p1-s30.json";
                        break;
                    case 13:
                        url = "http://app.api.autohome.com.cn/autov4.8.8/club/jingxuantopic-pm1-c168-p1-s30.json";
                        break;
                    case 14:
                        url = "http://app.api.autohome.com.cn/autov4.8.8/club/jingxuantopic-pm1-c113-p1-s30.json";
                        break;
                    case 15:
                        url = "http://app.api.autohome.com.cn/autov4.8.8/club/jingxuantopic-pm1-c109-p1-s30.json";
                        break;
                    case 16:
                        url = "http://app.api.autohome.com.cn/autov4.8.8/club/jingxuantopic-pm1-c191-p1-s30.json";
                        break;
                    case 17:
                        url = "http://app.api.autohome.com.cn/autov4.8.8/club/jingxuantopic-pm1-c196-p1-s30.json";
                        break;
                    case 18:
                        url = "http://app.api.autohome.com.cn/autov4.8.8/club/jingxuantopic-pm1-c107-p1-s30.json";
                        break;
                    case 19:
                        url = "http://app.api.autohome.com.cn/autov4.8.8/club/jingxuantopic-pm1-c105-p1-s30.json";
                        break;
                    case 20:
                        url = "http://app.api.autohome.com.cn/autov4.8.8/club/jingxuantopic-pm1-c122-p1-s30.json";
                        break;
                    case 21:
                        url = "";
                        break;
                    case 22:
                        url = "";
                        break;
                    case 23:
                        url = "";
                        break;
                    case 24:
                        url = "";
                        break;
                    case 25:
                        url = "";
                        break;
                    case 26:
                        url = "";
                        break;
                    case 27:
                        url = "";
                        break;
                    case 28:
                        url = "";
                        break;
                    case 29:
                        url = "";
                        break;
                    case 30:
                        url = "";
                        break;
                    case 31:
                        url = "";
                        break;
                    case 32:
                        url = "";
                        break;
                    case 33:
                        url = "";
                        break;
                    case 34:
                        url = "";
                        break;
                    case 35:
                        url = "";
                        break;
                    case 36:
                        url = "";
                        break;
                    case 37:
                        url = "";
                        break;
                    case 38:
                        url = "";
                        break;
                    case 39:
                        url = "";
                        break;
                    case 40:
                        url = "";
                        break;
                }
                /**
                 * 获取网络数据
                 */
                VolleyInstance.getmInstance().startRequest(url, new VolleyResult() {
                    @Override
                    public void success(String resultStr) {
                        Gson gson = new Gson();
                        BoutiqueListViewBean mBean = gson.fromJson(resultStr, BoutiqueListViewBean.class);
                        List<BoutiqueListViewBean.ResultBean.ListBean> datas = mBean.getResult().getList();
                        adapter.setDatas(datas);
                    }

                    @Override
                    public void failure() {
                    }
                });
            }
        });
    }

    /**
     * 点击打开抽屉  滑动不打开抽屉
     */
    private void initMenu() {
    }


}