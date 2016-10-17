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
import com.zhangzuhao.dllo.autohome.model.bean.FindBean;
import com.zhangzuhao.dllo.autohome.utils.ScreenSizeUtils;

import java.util.List;

/**
 * Created by dllo on 16/9/28.
 */
public class FindListViewAdapter extends BaseAdapter {
    private Context context ;
    private List<FindBean.ResultBean.GoodslistBean.ListBean> datas;

    public FindListViewAdapter(Context context) {
        this.context = context;
    }

    public void setDatas(List<FindBean.ResultBean.GoodslistBean.ListBean> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return datas != null && datas .size() > 0 ? datas.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return datas != null && datas.size() > 0? datas.get(position) : null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
           FindListViewHolder holder = null;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_find_listview , parent , false);
            int heigh = ScreenSizeUtils.getScreenSize(context  , ScreenSizeUtils.ScreenState.HEIGHT);
            ViewGroup.LayoutParams params = convertView.getLayoutParams();
            params.height = heigh/6;
            convertView.setLayoutParams(params);

            holder = new FindListViewHolder(convertView);
            convertView.setTag(holder);
        }else {
            holder = (FindListViewHolder) convertView.getTag();
        }
        FindBean.ResultBean.GoodslistBean.ListBean mBean = datas.get(position);
        holder.titleTv.setText(mBean.getTitle());
        holder.secondTitleTv.setText(mBean.getAdinfo());
        holder.priceTv.setText(mBean.getPrice());
        holder.secondPriceTv.setText(mBean.getFctprice());
        Picasso.with(context).load(mBean.getLogo()).resize(ScreenSizeUtils.getScreenSize(context , ScreenSizeUtils.ScreenState.WIDTH)/10 ,
                ScreenSizeUtils.getScreenSize(context , ScreenSizeUtils.ScreenState.HEIGHT)/14).into(holder.carImg);
        return convertView;
    }
    class FindListViewHolder {
        TextView titleTv , secondTitleTv, priceTv , secondPriceTv;
        ImageView carImg;
        public FindListViewHolder (View view){
            titleTv = (TextView) view.findViewById(R.id.item_find_listview_titletv);
            secondTitleTv = (TextView) view.findViewById(R.id.item_find_listview_secondtitletv);
            priceTv = (TextView) view.findViewById(R.id.item_find_listview_pricetv);
            secondPriceTv = (TextView) view.findViewById(R.id.item_find_listview_secondprice);
            carImg = (ImageView) view.findViewById(R.id.item_find_listView_carimg);
        }
    }
}
