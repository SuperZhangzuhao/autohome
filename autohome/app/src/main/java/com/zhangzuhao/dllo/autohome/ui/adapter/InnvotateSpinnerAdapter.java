package com.zhangzuhao.dllo.autohome.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zhangzuhao.dllo.autohome.R;
import com.zhangzuhao.dllo.autohome.model.bean.InnovateSpinnerBean;

import java.util.List;

/**
 * Created by dllo on 16/9/22.
 * 优创的Spinner的适配器
 */
public class InnvotateSpinnerAdapter extends BaseAdapter {
    private List<InnovateSpinnerBean> datas;
    private Context context;

    public InnvotateSpinnerAdapter(Context context) {
        this.context = context;
    }

    public void setDatas(List<InnovateSpinnerBean> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    public InnvotateSpinnerAdapter(List<InnovateSpinnerBean> datas, Context context) {
        this.datas = datas;
        this.context = context;
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
        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(R.layout.item_spinner_innovate, null);
        if (convertView != null) {
            TextView textView = (TextView) convertView.findViewById(R.id.item_innovate_spinner_tv);
            textView.setText(datas.get(position).getStr());
        }

        return convertView;
    }
}
