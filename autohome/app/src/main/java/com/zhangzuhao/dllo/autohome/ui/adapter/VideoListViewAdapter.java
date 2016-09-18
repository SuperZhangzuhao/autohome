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
import com.zhangzuhao.dllo.autohome.model.bean.VideoListViewBean;

import java.util.List;

/**
 * Created by dllo on 16/9/14.
 * 视频listview的实体类
 */
public class VideoListViewAdapter extends BaseAdapter {
    private Context context ;
    private List<VideoListViewBean.VideoListViewBeanChild1.VideoListViewBeanChild2>datas;
    public VideoListViewAdapter(Context context) {
        this.context = context;
    }
    public void setDatas(List<VideoListViewBean.VideoListViewBeanChild1.VideoListViewBeanChild2> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return datas != null && datas.size() > 0? datas.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return datas != null && datas.size() > 0? datas.size() : null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        VideoViewHolder holder = null;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_video_listview , parent , false);
            holder = new VideoViewHolder(convertView);
            convertView.setTag(holder);
        }else {
            holder = (VideoViewHolder) convertView.getTag();
        }
        VideoListViewBean.VideoListViewBeanChild1.VideoListViewBeanChild2  bean = datas.get(position);
        if (bean != null){
            holder.titleTv.setText(bean.getTitle());
            holder.countPalyTv.setText(bean.getPlaycount()+"");
            holder.timeTv.setText(bean.getTime());
            Picasso.with(context).load(bean.getSmallimg()).into(holder.smallImg);
        }
        return convertView;
    }
    class VideoViewHolder{
        TextView titleTv , timeTv , countPalyTv;
        ImageView smallImg ;
        public  VideoViewHolder (View view){
            titleTv = (TextView) view.findViewById(R.id.video_item_title);
            timeTv = (TextView) view.findViewById(R.id.video_item_time);
            countPalyTv = (TextView) view.findViewById(R.id.video_item_playcount);
            smallImg = (ImageView) view.findViewById(R.id.video_item_smallimg);
        }
    }
}
