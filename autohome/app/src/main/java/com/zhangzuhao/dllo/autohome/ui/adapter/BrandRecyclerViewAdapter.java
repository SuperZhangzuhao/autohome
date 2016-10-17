package com.zhangzuhao.dllo.autohome.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.zhangzuhao.dllo.autohome.R;
import com.zhangzuhao.dllo.autohome.model.bean.BrandRecyclerViewBean;

import java.util.List;

/**
 * Created by dllo on 16/9/27.
 */
public class BrandRecyclerViewAdapter extends RecyclerView.Adapter<BrandRecyclerViewAdapter.BrandHolder> {
    private Context context ;
    private List<BrandRecyclerViewBean.ResultBean.ListBean> datas;

    public BrandRecyclerViewAdapter(Context context) {
        this.context = context;
    }

    public void setDatas(List<BrandRecyclerViewBean.ResultBean.ListBean> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    @Override
    public BrandHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_brand_recyclerview_headone , parent , false);
        BrandHolder holder = new BrandHolder(view);
        return holder ;
    }

    @Override
    public void onBindViewHolder(BrandHolder holder, int position) {
        BrandRecyclerViewBean.ResultBean.ListBean mBean = datas.get(position);
        holder.hotBrandTv.setText(mBean.getName());
        Picasso.with(context).load(mBean.getImg()).into(holder.hotBrandImg);
    }
    @Override
    public int getItemCount() {
        return datas != null && datas.size() > 0 ? datas.size() : 0;
    }
    class BrandHolder extends RecyclerView.ViewHolder{
         private ImageView hotBrandImg;
         private TextView hotBrandTv;
        public BrandHolder(View itemView) {
            super(itemView);
            hotBrandImg = (ImageView) itemView.findViewById(R.id.item_brand_recyclerview_img);
            hotBrandTv = (TextView) itemView.findViewById(R.id.item_brand_recyclerview_tv);


        }
    }
}
