package com.zhangzuhao.dllo.autohome.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.zhangzuhao.dllo.autohome.R;
import com.zhangzuhao.dllo.autohome.model.bean.DrawerDepreciateLvBean;
import java.util.List;

/**
 * Created by dllo on 16/9/29.
 */
public class DrawerDepreciateAdapter extends BaseAdapter {
    private Context context ;
    private List<DrawerDepreciateLvBean> datas;
    public DrawerDepreciateAdapter(Context context) {
        this.context = context;
    }
    public void setDatas(List<DrawerDepreciateLvBean> datas) {
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
        DepreciateHolder holder = null ;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_depreciate_drawer_listview , parent , false);
            holder = new DepreciateHolder(convertView);
            convertView.setTag(holder);
        }else {
            holder = (DepreciateHolder) convertView.getTag();
        }
        DrawerDepreciateLvBean mBean = (DrawerDepreciateLvBean) getItem(position);
        holder.itemTv.setText(mBean.getStr());
        return convertView;
        }
    class DepreciateHolder{
        TextView itemTv;
        public DepreciateHolder(View view){
            itemTv = (TextView) view.findViewById(R.id.item_depreciate_listview_tv);
        }
    }
}
