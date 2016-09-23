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
import com.zhangzuhao.dllo.autohome.model.bean.NewsListViewBean;

import java.util.List;

/**
 * Created by dllo on 16/9/14.
 * 新闻ListView的适配器
 */
public class NewsListViewAdapter extends BaseAdapter {
    private Context context;
    private List<NewsListViewBean.ResultBean.NewslistBean> datas;

    public NewsListViewAdapter(Context context) {
        this.context = context;
    }

    public void setDatas(List<NewsListViewBean.ResultBean.NewslistBean> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return datas != null && datas.size() > 0 ? datas.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return datas != null && datas.size() > 0 ? datas.size() : null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        NewsViewHolder holder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_news_listview, parent, false);
            holder = new NewsViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (NewsViewHolder) convertView.getTag();
        }
        NewsListViewBean.ResultBean.NewslistBean bean = datas.get(position);
        if (bean != null) {
            holder.titleTv.setText(bean.getTitle());
            holder.timeTv.setText(bean.getTime());
            holder.replyTv.setText(bean.getReplycount() + "");
            Picasso.with(context).load(bean.getSmallpic()).into(holder.smallImg);
        }
        return convertView;
    }

    class NewsViewHolder {
        private TextView titleTv, timeTv, replyTv;
        private ImageView smallImg;

        public NewsViewHolder(View view) {
            titleTv = (TextView) view.findViewById(R.id.news_item_title);
            timeTv = (TextView) view.findViewById(R.id.news_item_time);
            replyTv = (TextView) view.findViewById(R.id.news_item_replycount);
            smallImg = (ImageView) view.findViewById(R.id.news_item_smallpic);
        }
    }
}
