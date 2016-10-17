package com.zhangzuhao.dllo.autohome.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.zhangzuhao.dllo.autohome.R;
import com.zhangzuhao.dllo.autohome.model.bean.DrawerBoutiqueLvBean;
import com.zhangzuhao.dllo.autohome.model.bean.DrawerDepreciateLvBean;

import java.util.List;

/**
 * Created by dllo on 16/9/29.
 * 精选推荐抽屉的适配器
 */
public class DrawerBoutiqueAdapter extends BaseAdapter {
    private Context context ;
    private List<DrawerBoutiqueLvBean> datas;
    public DrawerBoutiqueAdapter(Context context) {
        this.context = context;
    }
    public void setDatas(List<DrawerBoutiqueLvBean> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }
    @Override
    public int getCount() {
        return datas != null && datas.size()> 0? datas.size() : 0;
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
        BoutiqueHolder holder = null ;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_drawer_boutique_listview , parent , false);
            holder = new BoutiqueHolder(convertView);
            convertView.setTag(holder);
        }else {
            holder = (BoutiqueHolder) convertView.getTag();
        }
        DrawerBoutiqueLvBean mBean = (DrawerBoutiqueLvBean) getItem(position);
        holder.itemTv.setText(mBean.getStr());
        return convertView;
        }
    class  BoutiqueHolder{
        TextView itemTv;
        public BoutiqueHolder(View view){
            itemTv = (TextView) view.findViewById(R.id.drawer_boutique_item_tv);
        }
    }
}
