package com.zhangzuhao.dllo.autohome.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.zhangzuhao.dllo.autohome.R;
import com.zhangzuhao.dllo.autohome.model.bean.VideoDrawerListViewBean;

import java.util.List;

/**
 * Created by dllo on 16/9/22.
 * 视频页面的抽屉的ListView的适配器
 */
public class VideoDrawerListViewAdapter extends BaseAdapter {
    private List<VideoDrawerListViewBean> datas;
    private Context context;

    public VideoDrawerListViewAdapter(Context context) {
        this.context = context;
    }

    public VideoDrawerListViewAdapter(List<VideoDrawerListViewBean> datas, Context context) {
        this.datas = datas;
        this.context = context;
    }

    public void setDatas(List<VideoDrawerListViewBean> datas) {
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
        VideoDrawerHolder holder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_video_drawer_listview, parent, false);
            holder = new VideoDrawerHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (VideoDrawerHolder) convertView.getTag();
        }
        VideoDrawerListViewBean mBean = (VideoDrawerListViewBean) getItem(position);
        holder.textView.setText(mBean.getItemStr());

        return convertView;
    }

    class VideoDrawerHolder {
        TextView textView;

        public VideoDrawerHolder(View view) {
            textView = (TextView) view.findViewById(R.id.item_drawer_listview_tv);
        }
    }
}
