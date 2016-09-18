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
import com.zhangzuhao.dllo.autohome.model.bean.UseCarBean;

import java.util.List;

/**
 * Created by dllo on 16/9/16.
 * 用车的listView的适配器
 */
public class UseCarListViewAdapter extends BaseAdapter {
    private List<UseCarBean.ResultBean.NewslistBean> datas;
    private Context context;
    private static  final int TYPE_ONE =0 ;
    private static  final int TYPE_TWO = 1;
    private UseCarBean.ResultBean.NewslistBean newslistBean;
    public UseCarListViewAdapter(Context context) {
        this.context = context;
    }
    public void setDatas(List<UseCarBean.ResultBean.NewslistBean> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return datas != null && datas.size() > 0 ? datas.size() : 0 ;
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
    public int getItemViewType(int position) {
        int type = datas.get(position).getMediatype();
        if (type == 10){
            return TYPE_TWO;
        }else {
            return TYPE_ONE;
        }
    }
    @Override
    public int getViewTypeCount() {
        return 2;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        OneHolder oneHolder = null;
        TwoHolder twoHolder = null;
        int type = getItemViewType(position);
        if (convertView == null){
            switch (type){
                case TYPE_ONE:
                    convertView = LayoutInflater.from(context).inflate(R.layout.item_usecar_onepic , parent , false);
                    oneHolder = new OneHolder(convertView);
                    convertView.setTag(oneHolder);
                    break;
                case TYPE_TWO:
                    convertView = LayoutInflater.from(context).inflate(R.layout.item_usecar_threepic , parent , false);
                    twoHolder = new TwoHolder(convertView);
                    convertView.setTag(twoHolder);
                    break;
            }
        }else {
            switch (type){
                case TYPE_ONE:
                    oneHolder = (OneHolder) convertView.getTag();
                    break;
                case TYPE_TWO:
                    twoHolder = (TwoHolder) convertView.getTag();
                    break;
            }
        }
        UseCarBean.ResultBean.NewslistBean bean = datas.get(position);
        if (bean != null ) {
            switch (type){
                case TYPE_ONE:
                    oneHolder.title.setText(bean.getTitle());
                    oneHolder.count.setText(bean.getReplycount()+"");
                    oneHolder.time.setText(bean.getTime());
                    Picasso.with(context).load(bean.getSmallpic()).into(oneHolder.smallimg);
                    break;
                case TYPE_TWO:
                    twoHolder.title2.setText(bean.getTitle());
                    twoHolder.time2.setText(bean.getTime());
                    twoHolder.count2.setText(bean.getReplycount()+"");
                    Picasso.with(context).load(bean.getSmallpic()).into(twoHolder.leftImg);
                    Picasso.with(context).load(bean.getIndexdetail()).into(twoHolder.midlleImg);
                    Picasso.with(context).load(bean.getIndexdetail()).into(twoHolder.rigrtImg);
                    break;
            }
        }
        return convertView;
    }
    class OneHolder{
        TextView title , time  , count;
        ImageView smallimg;
        public OneHolder (View view){
            title = (TextView) view.findViewById(R.id.usecar_listview_onepic_title);
            time = (TextView)view.findViewById(R.id.usecar_listview_onepic_time);
            count = (TextView) view.findViewById(R.id.usecar_listview_onepic_count);
            smallimg = (ImageView) view.findViewById(R.id.usecar_listview_onepic_img);
        }
    }
    class TwoHolder{
        TextView title2  , time2 , count2 ;
        ImageView leftImg , midlleImg , rigrtImg;
        public TwoHolder(View view){
            title2 = (TextView) view.findViewById(R.id.usecar_listview_threeopic_title);
            time2 = (TextView) view.findViewById(R.id.usecar_listview_threeopic_time);
            count2 = (TextView) view.findViewById(R.id.usecar_listview_threeopic_count);
            leftImg = (ImageView) view.findViewById(R.id.usecar_listview_threeopic_leftimg);
            midlleImg = (ImageView) view.findViewById(R.id.usecar_listview_threeopic_middleimg);
            rigrtImg = (ImageView) view.findViewById(R.id.usecar_listview_threeopic_rightimg);
        }
    }
}
