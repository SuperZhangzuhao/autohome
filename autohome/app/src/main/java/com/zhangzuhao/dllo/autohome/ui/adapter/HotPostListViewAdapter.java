package com.zhangzuhao.dllo.autohome.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.zhangzuhao.dllo.autohome.R;
import com.zhangzuhao.dllo.autohome.model.bean.HotPostListViewBean;

import java.util.List;

/**
 * Created by dllo on 16/9/23.
 */
public class HotPostListViewAdapter extends BaseAdapter {
    private List<HotPostListViewBean.ResultBean.ListBean> datas ;
    private Context context ;

    public HotPostListViewAdapter(Context context) {
        this.context = context;
    }

    public void setDatas(List<HotPostListViewBean.ResultBean.ListBean> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return datas != null && datas.size()>0 ? datas.size() : 0;
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
        HotPostHolder  holder = null ;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_hotpost_listview , parent , false);
            holder = new HotPostHolder(convertView);
            convertView.setTag(holder);
        }else {
            holder = (HotPostHolder) convertView.getTag();
        }
        HotPostListViewBean.ResultBean.ListBean mBean  = datas.get(position);
        holder.hotTitle.setText(mBean.getTitle());
        holder.hotTime.setText(mBean.getPostdate());
        holder.hotBbsName.setText(mBean.getBbsname());
        holder.hotReplay.setText(mBean.getReplycounts()+"");
        return convertView;
    }

   class HotPostHolder{
        TextView hotTitle , hotBbsName , hotTime , hotReplay;
       public  HotPostHolder (View view){
           hotTitle = (TextView) view.findViewById(R.id.item_hotpost_listview_title);
           hotBbsName = (TextView) view.findViewById(R.id.item_hotpost_listview_bbsname);
           hotTime = (TextView) view.findViewById(R.id.item_hotpost_listview_postdate);
           hotReplay = (TextView) view.findViewById(R.id.item_hotpost_listview_replaycount);
       }
    }
}
