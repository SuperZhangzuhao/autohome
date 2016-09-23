package com.zhangzuhao.dllo.autohome.ui.adapter.vpadapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.zhangzuhao.dllo.autohome.R;
import com.zhangzuhao.dllo.autohome.model.bean.InnovateRotateBean;

import java.util.List;

/**
 * Created by dllo on 16/9/21.
 * 优创的头布局的ViewPager适配器
 */
public class InnovateRotateViewPagerAdapter extends PagerAdapter {
    private List<InnovateRotateBean> datas;
    private Context context;
    private LayoutInflater inflater;
    private InnovateRotateBean bean;

    public InnovateRotateViewPagerAdapter(List<InnovateRotateBean> datas, Context context) {
        this.datas = datas;
        this.context = context;
        inflater=LayoutInflater.from(context);
    }

    public InnovateRotateViewPagerAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    public void setDatas(List<InnovateRotateBean> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return  datas ==null ? 0 : Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        int newPosition = position % datas.size();
        View convertView = inflater.inflate(R.layout.item_innovate_rotate ,container ,false);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.item_innovate_rotate_img);
        imageView.setImageResource(datas.get(newPosition).getImgId());
        bean = datas.get(newPosition);
        Glide.with(context).load(bean.getImgUrl()).into(imageView);
        container.addView(convertView);
        return convertView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

    }
}
