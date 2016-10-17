package com.zhangzuhao.dllo.autohome.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.zhangzuhao.dllo.autohome.R;
import com.zhangzuhao.dllo.autohome.model.bean.FindHeadOneRecyclerViewBean;
import com.zhangzuhao.dllo.autohome.utils.ScreenSizeUtils;

import java.util.List;

/**
 * Created by dllo on 16/9/28.
 */
public class FindHeadOneRecyclerViewAdapter extends RecyclerView.Adapter<FindHeadOneRecyclerViewAdapter.FindRcHolder> {
    private Context context;
    private List<FindHeadOneRecyclerViewBean.ResultBean.FunctionlistBean> datas;

    public FindHeadOneRecyclerViewAdapter(Context context) {
        this.context = context;
    }

    public void setDatas(List<FindHeadOneRecyclerViewBean.ResultBean.FunctionlistBean> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    @Override
        public FindRcHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_find_head_one_recycler , parent , false);
        FindRcHolder holder = new FindRcHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(FindRcHolder holder, int position) {
        FindHeadOneRecyclerViewBean.ResultBean.FunctionlistBean mBean= datas.get(position);
        holder.titleTv.setText(mBean.getTitle());
        Picasso.with(context).load(mBean.getIconurl()).resize(ScreenSizeUtils.getScreenSize(context , ScreenSizeUtils.ScreenState.WIDTH)/8 ,
                ScreenSizeUtils.getScreenSize(context , ScreenSizeUtils.ScreenState.HEIGHT)/14).into(holder.iconurlImg);
    }

    @Override
    public int getItemCount() {
        return datas != null && datas.size() > 0 ? datas.size(): 0;
    }

    class FindRcHolder extends RecyclerView.ViewHolder{
        TextView titleTv ;
        ImageView iconurlImg ;
        public FindRcHolder(View itemView) {
            super(itemView);
            titleTv = (TextView) itemView.findViewById(R.id.item_find_head_one_recycler_tv);
            iconurlImg = (ImageView) itemView.findViewById(R.id.item_find_head_one_recycler_img);
        }
    }
}
