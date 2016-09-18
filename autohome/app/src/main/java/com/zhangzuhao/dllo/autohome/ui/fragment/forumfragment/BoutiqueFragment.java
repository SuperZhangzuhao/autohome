package com.zhangzuhao.dllo.autohome.ui.fragment.forumfragment;

import android.content.ClipData;
import android.content.Context;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.zhangzuhao.dllo.autohome.R;
import com.zhangzuhao.dllo.autohome.ui.adapter.layoutadapter.RecyclerBoutiqueAadapter;
import com.zhangzuhao.dllo.autohome.ui.fragment.AbsBaseFragment;

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

    protected int setLayout() {
        return R.layout.fragment_boutique;
    }

    @Override
    protected void initViews() {
        recyclerView=  byView(R.id.boutique_recycler);
        menuImg = byView(R.id.boutique_menuimg);
        rbAdapter = new RecyclerBoutiqueAadapter(context);
        recyclerView.setAdapter(rbAdapter);
    }
            protected void initDatas () {
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
                datas.add("美人日");
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
        }

    /**
     * 点击打开抽屉  滑动不打开抽屉
     */
    private void initMenu() {
    }
}