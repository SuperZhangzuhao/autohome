package com.zhangzuhao.dllo.autohome.ui.adapter.vpadapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.zhangzuhao.dllo.autohome.R;
import com.zhangzuhao.dllo.autohome.utils.RotateBean;

import java.util.List;

/**
 * Created by dllo on 16/9/18.
 */
public class NewestRotateViewPagerAdapter extends PagerAdapter {

    private List<RotateBean>datas;
    private Context context;
    private LayoutInflater inflater ;
    private RotateBean rotateBean;

    public NewestRotateViewPagerAdapter(List<RotateBean> datas, Context context) {
        this.datas = datas;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    public NewestRotateViewPagerAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    public void setDatas(List<RotateBean> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    /**
     * 设置页数为最大值
     */
    @Override
    public int getCount() {
        return datas ==null ? 0 : Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        int newPosition = position % datas.size();
        View convertView = inflater.inflate(R.layout.item_newest_rotate ,container ,false);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.item_newest_rotate_img);
        imageView.setImageResource(datas.get(newPosition).getImgId());
        rotateBean = datas.get(newPosition);
        Glide.with(context).load(rotateBean.getImgUrl()).into(imageView);
        return convertView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
    }
}
