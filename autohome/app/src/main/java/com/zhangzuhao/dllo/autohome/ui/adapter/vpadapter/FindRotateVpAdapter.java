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
import com.zhangzuhao.dllo.autohome.model.bean.FindRotateBean;

import java.util.List;

/**
 * Created by dllo on 16/9/28.
 *发现轮播图的实体类
 */
public class FindRotateVpAdapter extends PagerAdapter {
    private List<FindRotateBean>datas;
    private Context context;
    private LayoutInflater inflater;
    private FindRotateBean findRotateBean ;

    public FindRotateVpAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    public void setDatas(List<FindRotateBean> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return datas == null ? 0 : Integer.MAX_VALUE ;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        int newPosition = position % datas.size();
        View convertView = inflater.inflate(R.layout.item_find_rotate, container, false);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.item_find_rotate_img);
        imageView.setImageResource(datas.get(newPosition).getImgId());
        findRotateBean = datas.get(newPosition);
        Glide.with(context).load(findRotateBean.getImgUrl()).into(imageView);
        container.addView(convertView);
        return convertView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

    }
}
