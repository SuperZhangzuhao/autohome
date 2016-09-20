package com.zhangzuhao.dllo.autohome.ui.adapter;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.zhangzuhao.dllo.autohome.R;
import com.zhangzuhao.dllo.autohome.model.bean.NewestListViewBean;
import com.zhangzuhao.dllo.autohome.model.bean.NewsListViewBean;

import java.util.List;

/**
 * Created by dllo on 16/9/19.
 * 最新界面的ListView的适配器
 */
public class NewestListViewAdapter extends BaseAdapter {
    private List<NewestListViewBean.ResultBean.NewslistBean>datas;
    private Context context;

    /**
     *轮播图的行布局
     */
    private static final int TYPE_ROTATE = 0;
    /**
     * 只有一个图片的行布局
     */
    private static final int TYPE_ONEIMG = 1;
    /**
     * 有三个图片的行布局
     */
    private static final int TYPE_THREEIMG = 2;
//    private NewestListViewBean.ResultBean.NewslistBean mBean ;

    public NewestListViewAdapter(Context context) {
        this.context = context;
    }

    public void setDatas(List<NewestListViewBean.ResultBean.NewslistBean> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return datas != null && datas.size()> 0 ? datas.size() : 0;
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
        int a = position;
        int b = datas.get(position).getMediatype();
        Log.d("xxx", "b:" + b);
        if (a == 0){
            return TYPE_ROTATE;
        }
        else if (b == 6){
            return TYPE_THREEIMG;
        }else {
            return TYPE_ONEIMG;
        }

    }

    @Override
    public int getViewTypeCount() {
        return 3;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        RotateHolder holder = null ;
        OnePicHolder oneHolder = null;
        ThreePicHolder threeHolder = null;
        int type = getItemViewType(position);
        if (convertView == null){
            switch (type){
                case TYPE_ROTATE:
                    convertView = LayoutInflater.from(context).inflate(R.layout.item_newest_rotate , parent ,false);
                    holder = new RotateHolder(convertView);
                    convertView.setTag(holder);
                    break;
                case TYPE_ONEIMG:
                    convertView = LayoutInflater.from(context).inflate(R.layout.item_newest_listview_first , parent , false);
                    oneHolder = new OnePicHolder(convertView);
                    convertView.setTag(oneHolder);
                    break;
                case TYPE_THREEIMG :
                    convertView = LayoutInflater.from(context).inflate(R.layout.item_newest_listview_second , parent ,false);
                    threeHolder = new ThreePicHolder(convertView);
                    convertView.setTag(threeHolder);
                    break;
            }
        }else {
            switch (type){
                case TYPE_ROTATE:
                    holder = (RotateHolder) convertView.getTag();
                    break;
                case TYPE_ONEIMG:
                    oneHolder = (OnePicHolder) convertView.getTag();
                    break;
                case TYPE_THREEIMG:
                    threeHolder = (ThreePicHolder) convertView.getTag();
            }
        }

        NewestListViewBean.ResultBean.NewslistBean mbean = datas.get(position);
        Log.d("xxxxxx", "mbean:" + mbean);
        if (mbean != null){
            switch (type){
                case TYPE_ROTATE:
                    break;
                case TYPE_ONEIMG:
                    oneHolder.titleTv.setText(mbean.getTitle());
                    oneHolder.timeTv.setText(mbean.getTime());
                    oneHolder.countTv.setText(mbean.getReplycount()+"");
                    Picasso.with(context).load(mbean.getSmallpic()).into(oneHolder.smallImg);
                    break;
                case TYPE_THREEIMG:
                    threeHolder.tTitleTv.setText(mbean.getTitle());
                    threeHolder.tTimeTv.setText(mbean.getTime());
                    threeHolder.tCountTv.setText(mbean.getReplycount()+"");
                    Picasso.with(context).load("http://car2.autoimg.cn/cardfs/product/g9/M12/45/E3/t_autohomecar__wKjBzlfeZPmAHIYYAAS-81iPdh0340.jpg").into(threeHolder.leftImg);
                    Picasso.with(context).load("http://car3.autoimg.cn/cardfs/product/g13/M00/4C/E7/t_autohomecar__wKgH41feZPmAdvg6AASWSe8fgyI357.jpg").into(threeHolder.midlleImg);
                    Picasso.with(context).load("http://car2.autoimg.cn/cardfs/product/g9/M11/50/4D/t_autohomecar__wKgH31feZPiASCDuAASVAsDiw0M087.jpg").into(threeHolder.rightImg);
            }
        }
        return convertView;
    }
    /**
     * 轮播图行布局
     */
    class RotateHolder {
        private ViewPager viewPager;

        public RotateHolder(View view) {
            viewPager = (ViewPager) view.findViewById(R.id.item_newest_listview_rotate_vp);
        }
    }
        /**
         * 一个图片的行布局
         */
        class OnePicHolder{
            private TextView titleTv , timeTv , countTv;
            private ImageView smallImg;
            public OnePicHolder(View view){
                titleTv = (TextView) view.findViewById(R.id.item_newest_listview_first_title);
                timeTv = (TextView) view.findViewById(R.id.item_newest_listview_first_time);
                countTv = (TextView) view.findViewById(R.id.item_newest_listview_first_count);
                smallImg = (ImageView) view.findViewById(R.id.item_newest_listview_first_img);
            }
        }
    /**
     * 三个图片的行布局
     */
    class ThreePicHolder{
        private TextView tTitleTv , tTimeTv , tCountTv;
        private ImageView leftImg , midlleImg , rightImg;
        public ThreePicHolder(View view){
            tTitleTv = (TextView) view.findViewById(R.id.item_newest_listview_second_title);
            tTimeTv = (TextView) view.findViewById(R.id.item_newest_listview_second_time);
            tCountTv = (TextView) view.findViewById(R.id.item_newest_listview_second_count);
            leftImg = (ImageView) view.findViewById(R.id.item_newest_listview_second_imgleft);
            midlleImg = (ImageView) view.findViewById(R.id.item_newest_listview_second_imgmidlle);
            rightImg = (ImageView) view.findViewById(R.id.item_newest_listview_second_imgright);
        }
    }
}
