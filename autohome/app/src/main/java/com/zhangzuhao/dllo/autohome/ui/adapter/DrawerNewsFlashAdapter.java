package com.zhangzuhao.dllo.autohome.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.zhangzuhao.dllo.autohome.R;
import com.zhangzuhao.dllo.autohome.model.bean.DrawerNewsFlashBean;

import java.util.List;

/**
 * Created by dllo on 16/9/17.
 * 快报侧拉菜单的适配器
 */
public class DrawerNewsFlashAdapter extends BaseAdapter {
    private Context context;
    private List<DrawerNewsFlashBean> datas;

    public DrawerNewsFlashAdapter(Context context) {
        this.context = context;
    }

    public void setDatas(List<DrawerNewsFlashBean> datas) {
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
        DrawerHolder holder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_drawer_newsflash_listview, parent, false);
            holder = new DrawerHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (DrawerHolder) convertView.getTag();
        }
        DrawerNewsFlashBean bean = (DrawerNewsFlashBean) getItem(position);
        holder.textView.setText(bean.getStr());
        return convertView;
    }

    class DrawerHolder {
        private TextView textView;

        public DrawerHolder(View view) {
            textView = (TextView) view.findViewById(R.id.drawer_newsflash_item_tv);
        }
    }
}
