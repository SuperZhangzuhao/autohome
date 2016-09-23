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
import com.zhangzuhao.dllo.autohome.model.bean.NewsFlashListViewBean;

import java.util.List;

/**
 * Created by dllo on 16/9/14.
 * 快报的listview的适配器
 */
public class NewsFlashListViewAapter extends BaseAdapter {
    private Context context;
    private List<NewsFlashListViewBean.ResultBean.ListBean> datas;

    public NewsFlashListViewAapter(Context context) {
        this.context = context;

    }

    public void setDatas(List<NewsFlashListViewBean.ResultBean.ListBean> datas) {
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
        NewsFlashViewHolder mHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_newsflash_listview, parent, false);
            mHolder = new NewsFlashViewHolder(convertView);
            convertView.setTag(mHolder);
        } else {
            mHolder = (NewsFlashViewHolder) convertView.getTag();
        }
        NewsFlashListViewBean.ResultBean.ListBean mBean = datas.get(position);
        if (mBean != null) {
            mHolder.titleTv.setText(mBean.getTitle());
            mHolder.reviewcountTv.setText(mBean.getReviewcount() + "");
            mHolder.createtimeTv.setText(mBean.getCreatetime());
            Picasso.with(context).load(mBean.getBgimage()).into(mHolder.bgimageImg);
        }
        return convertView;
    }

    class NewsFlashViewHolder {
        TextView titleTv, reviewcountTv, createtimeTv;
        ImageView bgimageImg;

        public NewsFlashViewHolder(View view) {
            titleTv = (TextView) view.findViewById(R.id.newsflash_listview_item_title);
            reviewcountTv = (TextView) view.findViewById(R.id.newsflash_listview_item_reviewcount);
            createtimeTv = (TextView) view.findViewById(R.id.newsflash_listview_item_createTv);
            bgimageImg = (ImageView) view.findViewById(R.id.newsflash_listview_item_bgimage);
        }
    }
}