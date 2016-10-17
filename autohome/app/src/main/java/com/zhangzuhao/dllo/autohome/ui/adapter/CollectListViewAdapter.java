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
import com.zhangzuhao.dllo.autohome.model.bean.CollectListViewBean;
import com.zhangzuhao.dllo.autohome.model.db.CollectBean;

import java.util.List;

/**
 * Created by dllo on 16/10/11.
 */
public class CollectListViewAdapter extends BaseAdapter {
    private Context context ;
    private List<CollectBean> datas ;

    public CollectListViewAdapter(Context context) {
        this.context = context;
    }

    public void setDatas(List<CollectBean> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return datas !=null && datas.size()>0 ? datas.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return datas != null && datas.size() >0 ? datas.get(position) : null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CollectViewHolder holder = null;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_collect_listview , parent , false);
            holder = new CollectViewHolder(convertView);
            convertView.setTag(holder);
        }else {
            holder = (CollectViewHolder) convertView.getTag();
        }
        CollectBean mBean = (CollectBean) getItem(position);
        holder.title.setText(mBean.getTitle());
        holder.time.setText(mBean.getTime());
        holder.replayCount.setText(mBean.getReplaycount()+"");
        Picasso.with(context).load(mBean.getImgUrl()).into(holder.img);
        return convertView;
    }

    class CollectViewHolder {
        private TextView title  ,time , replayCount ;
        private ImageView img;
        public CollectViewHolder (View view){
            title = (TextView) view.findViewById(R.id.collect_title);
            time = (TextView) view.findViewById(R.id.collect_time);
            replayCount = (TextView) view.findViewById(R.id.collect_replaycount);
            img = (ImageView) view.findViewById(R.id.collect_img);
        }
    }
}
