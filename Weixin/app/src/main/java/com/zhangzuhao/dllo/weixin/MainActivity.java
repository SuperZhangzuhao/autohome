package com.zhangzuhao.dllo.weixin;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {

    private final String GAT = getClass().getSimpleName();
    private RelativalayoutBottom weixinButtom;
    private RelativalayoutBottom contactsButtom;
    private RelativalayoutBottom[] bottom = new RelativalayoutBottom[2];
    private ViewPager vp;
    private List<Fragment> fragments;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setCallBace();
    }



    //初始化控件
    private void initView() {
        vp = (ViewPager) findViewById(R.id.vp);
        weixinButtom = (RelativalayoutBottom) findViewById(R.id.weixin);
        contactsButtom = (RelativalayoutBottom) findViewById(R.id.contacts);

        weixinButtom.setAlpha(1);
        bottom[0] = weixinButtom;
        bottom[1] = contactsButtom;

        fragments = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            fragments.add(new FirstFragment());
        }
        ViewPagerAdapter vpa = new ViewPagerAdapter(getSupportFragmentManager(),fragments);
        vp.setAdapter(vpa);

    }
    private void setCallBace() {
        vp.addOnPageChangeListener(this);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        if (positionOffset > 0){
            bottom[position].setAlpha(1-positionOffset);
            bottom[position + 1].setAlpha(positionOffset);
        }

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state)

    }
}
