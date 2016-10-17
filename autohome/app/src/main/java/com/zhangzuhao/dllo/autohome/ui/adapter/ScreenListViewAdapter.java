package com.zhangzuhao.dllo.autohome.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.zhangzuhao.dllo.autohome.R;
import com.zhangzuhao.dllo.autohome.model.bean.ScreenListViewBean;

import java.util.List;

/**
 * Created by dllo on 16/9/27.
 * 筛选的适配器
 */
public class ScreenListViewAdapter extends BaseAdapter {
    private Context context;
    private List<ScreenListViewBean.ResultBean.SeriesBean> datas;

    public ScreenListViewAdapter(Context context) {
        this.context = context;
    }

    public void setDatas(List<ScreenListViewBean.ResultBean.SeriesBean> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return datas != null && datas.size() > 0 ? datas.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return datas != null && datas.size() > 0 ? datas.get(position) : null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ScreenHolder holder = null ;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_screen_listview , parent , false);
            holder = new ScreenHolder(convertView);
            convertView.setTag(holder);
        }else {
            holder = (ScreenHolder) convertView.getTag();
        }
        ScreenListViewBean.ResultBean.SeriesBean mBean = datas.get(position);
        holder.nameTv.setText(mBean.getSeriesname());
        holder.priceTv.setText(mBean.getPricerange());
        Picasso.with(context).load(mBean.getThumburl()).into(holder.autoImg);
        return convertView;
    }
    class ScreenHolder{
        TextView nameTv , priceTv;
        ImageView autoImg;
        public ScreenHolder(View view){
            nameTv = (TextView) view.findViewById(R.id.item_screen_listview_nametv);
            priceTv = (TextView) view.findViewById(R.id.item_screen_listview_pricetv);
            autoImg = (ImageView) view.findViewById(R.id.item_screen_listview_autoimg);
        }
    }

}
