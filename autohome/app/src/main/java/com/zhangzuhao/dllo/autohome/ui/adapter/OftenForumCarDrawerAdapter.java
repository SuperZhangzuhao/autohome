package com.zhangzuhao.dllo.autohome.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.zhangzuhao.dllo.autohome.R;
import com.zhangzuhao.dllo.autohome.model.bean.OftenForumDrawerListViewBean;

import java.util.List;

/**
 * Created by dllo on 16/9/26.
 * 常用论坛的抽屉适配器
 */
public class OftenForumCarDrawerAdapter extends BaseAdapter {
    private Context context;
    private List<OftenForumDrawerListViewBean> datas;

    public OftenForumCarDrawerAdapter(Context context) {
        this.context = context;
    }

    public void setDatas(List<OftenForumDrawerListViewBean> datas) {
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
        OftenForumHolder holder = null;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_oftenforum_place_drawer , parent , false);
            holder = new OftenForumHolder(convertView);
            convertView.setTag(holder);
        }else {
            holder = (OftenForumHolder) convertView.getTag();
        }
        OftenForumDrawerListViewBean mBean = (OftenForumDrawerListViewBean) getItem(position);
        holder.str.setText(mBean.getStr());
        return convertView;
    }

    class OftenForumHolder{
        private TextView str ;
        public  OftenForumHolder(View view){
            str = (TextView) view.findViewById(R.id.item_oftenforum_drawer_tv);
        }
    }
}
