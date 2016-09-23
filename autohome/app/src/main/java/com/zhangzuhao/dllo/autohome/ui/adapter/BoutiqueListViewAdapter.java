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
import com.zhangzuhao.dllo.autohome.model.bean.BoutiqueListViewBean;

import java.util.List;

/**
 * Created by dllo on 16/9/22.
 */
public class BoutiqueListViewAdapter extends BaseAdapter {
    private List<BoutiqueListViewBean.ResultBean.ListBean> datas;
    private Context context;

    public BoutiqueListViewAdapter(Context context) {
        this.context = context;
    }

    public void setDatas(List<BoutiqueListViewBean.ResultBean.ListBean> datas) {
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
        AllHolder holder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_boutique_listview, parent, false);
            holder = new AllHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (AllHolder) convertView.getTag();
        }
        BoutiqueListViewBean.ResultBean.ListBean mBean = datas.get(position);
        holder.boutiqueTitle.setText(mBean.getTitle());
        holder.boutiqueBbsName.setText(mBean.getBbsname());
        holder.boutiqueReplay.setText(mBean.getReplycounts() + "");
        Picasso.with(context).load(mBean.getSmallpic()).into(holder.boutiqueImg);
        return convertView;
    }

    class AllHolder {
        TextView boutiqueTitle, boutiqueBbsName, boutiqueReplay;
        ImageView boutiqueImg;

        public AllHolder(View view) {
            boutiqueTitle = (TextView) view.findViewById(R.id.item_boutique_listview_title);
            boutiqueBbsName = (TextView) view.findViewById(R.id.item_boutique_listview_bbsname);
            boutiqueReplay = (TextView) view.findViewById(R.id.item_boutique_listview_replaycount);
            boutiqueImg = (ImageView) view.findViewById(R.id.item_boutique_listview_img);
        }
    }
}
