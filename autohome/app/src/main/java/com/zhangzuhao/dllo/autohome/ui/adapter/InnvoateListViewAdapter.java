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
import com.zhangzuhao.dllo.autohome.model.bean.InnvoateListViewBean;
import com.zhangzuhao.dllo.autohome.utils.ScreenSizeUtils;

import java.util.List;

/**
 * Created by dllo on 16/9/21.
 * 优创ListView的适配器
 */
public class InnvoateListViewAdapter extends BaseAdapter {
    private List<InnvoateListViewBean.ResultBean.NewslistBean>datas;
    private Context context ;
    /**
     *小图的行布局
     */
    private static final int TYPE_ONEPIC = 0;
    /**
     * 大图的行布局
     */
    private static final int TYPE_BIGPIC = 1;
    /**
     * 三个小图的行布局
     */
    private static final int TYPE_THREEPIC = 2 ;


    public InnvoateListViewAdapter(Context context) {
        this.context = context;
    }

    public void setDatas(List<InnvoateListViewBean.ResultBean.NewslistBean> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return datas != null &&datas.size()> 0 ? datas.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return datas != null && datas .size() > 0 ? datas.get(position) : null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getViewTypeCount() {
        return 3;
    }

    @Override
    public int getItemViewType(int position) {
        int type = datas.get(position).getMediatype();
        if (type == 1){
            return TYPE_ONEPIC;
        }else if (type == 2){
            return TYPE_THREEPIC;
        }else {
            return TYPE_BIGPIC;
        }
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        InOnepicHolder oneHolder = null;
        InThreePicHolder  threeHolder = null;
        BigPicHolder bigHolder = null;
        int type = getItemViewType(position);
        if (convertView == null){
            switch (type){
                case TYPE_ONEPIC:
                    convertView = LayoutInflater.from(context).inflate(R.layout.item_listview_innovate_onepic , parent ,false);
                    oneHolder = new InOnepicHolder(convertView);
                    convertView.setTag(oneHolder);
                    break;
                case TYPE_THREEPIC:
                    convertView = LayoutInflater.from(context).inflate(R.layout.item_listview_innvoate_threepic , parent ,false);
                    threeHolder = new InThreePicHolder(convertView);
                    convertView.setTag(threeHolder);
                    break;
                case TYPE_BIGPIC:
                    convertView = LayoutInflater.from(context).inflate(R.layout.item_listview_innvoate_bigpic , parent ,false);
                    bigHolder = new BigPicHolder(convertView);
                    convertView.setTag(bigHolder);
                    break;
            }
        }else {
            switch (type){
                case TYPE_ONEPIC:
                    oneHolder = (InOnepicHolder) convertView.getTag();
                    break;
                case TYPE_THREEPIC:
                    threeHolder = (InThreePicHolder) convertView.getTag();
                    break;
                case TYPE_BIGPIC:
                    bigHolder = (BigPicHolder) convertView.getTag();
            }
        }
        InnvoateListViewBean.ResultBean.NewslistBean mBean = datas.get(position);
        if (mBean != null){
            switch (type){
                case TYPE_ONEPIC:
                    oneHolder.oneNameTv.setText(mBean.getUsername());
                    oneHolder.oneTitleTv.setText(mBean.getTitle());
                    oneHolder.oneTimeTv.setText(mBean.getPublishtime());
                    oneHolder.onePraiseTv.setText(mBean.getPraisenum()+"");
                    oneHolder.oneReplayTv.setText(mBean.getReplycount()+"");
                    Picasso.with(context).load(mBean.getUserpic()).resize(ScreenSizeUtils.getScreenSize(context , ScreenSizeUtils.ScreenState.WIDTH)/14 ,
                            ScreenSizeUtils.getScreenSize(context , ScreenSizeUtils.ScreenState.HEIGHT)/14).into(oneHolder.oneHeadImg);
                    Picasso.with(context).load(mBean.getThumbnailpics().get(0)).into(oneHolder.oneThumbnailImg);

                    break;
                case TYPE_THREEPIC:
                    threeHolder.threeNameTv.setText(mBean.getUsername());
                    threeHolder.threeTitleTv.setText(mBean.getTitle());
                    threeHolder.threeTimeTv.setText(mBean.getPublishtime());
                    threeHolder.threePraiseTv.setText(mBean.getPraisenum()+"");
                    threeHolder.threeReplayTv.setText(mBean.getReplycount()+"");
                    Picasso.with(context).load(mBean.getUserpic()).into(threeHolder.threeHeadImg);
                    Picasso.with(context).load(mBean.getThumbnailpics().get(0)).into(threeHolder.threeLeftImg);
                    Picasso.with(context).load(mBean.getThumbnailpics().get(1)).into(threeHolder.threeMiddleImg);
                    Picasso.with(context).load(mBean.getThumbnailpics().get(2)).into(threeHolder.threeRightImg);
                    break;
                case TYPE_BIGPIC:
                    bigHolder.bigNameTv.setText(mBean.getUsername());
                    bigHolder.bigTitleTv.setText(mBean.getTitle());
                    bigHolder.bigPraiseTv.setText(mBean.getPraisenum()+"");
                    bigHolder.bigTimeTv.setText(mBean.getPublishtime());
                    bigHolder.bigReplayTv.setText(mBean.getReplycount()+"");
                    Picasso.with(context).load(mBean.getUserpic()).resize(ScreenSizeUtils.getScreenSize(context , ScreenSizeUtils.ScreenState.WIDTH)/14 ,
                            ScreenSizeUtils.getScreenSize(context , ScreenSizeUtils.ScreenState.HEIGHT)/14).into(bigHolder.bigHeadImg);
                    Picasso.with(context).load(mBean.getThumbnailpics().get(0)).resize(ScreenSizeUtils.getScreenSize(context , ScreenSizeUtils.ScreenState.WIDTH)/1 ,
                            ScreenSizeUtils.getScreenSize(context , ScreenSizeUtils.ScreenState.HEIGHT)/3).into(bigHolder.bigImg);
            }
        }


        return convertView;
    }

    /**
     * 一个小图的行布局
     */
    class InOnepicHolder{
        TextView oneNameTv , oneTitleTv , oneTimeTv , onePraiseTv , oneReplayTv;
        ImageView oneHeadImg , oneThumbnailImg;
        public InOnepicHolder (View view){
            oneNameTv = (TextView) view.findViewById(R.id.item_innovate_listview_onepic_name);
            oneTitleTv = (TextView) view.findViewById(R.id.item_innovate_listview_onepic_title);
            onePraiseTv = (TextView) view.findViewById(R.id.item_innovate_listview_onepic_zancount);
            oneTimeTv = (TextView) view.findViewById(R.id.item_innovate_listview_onepic_time);
            oneReplayTv = (TextView) view.findViewById(R.id.item_innovate_listview_onepic_talkcount);
            oneHeadImg = (ImageView) view.findViewById(R.id.item_innovate_listview_onepic_headimg);
            oneThumbnailImg = (ImageView) view.findViewById(R.id.item_innovate_listview_onepic_img);

        }
    }
    /**
     * 三个图片的行布局
     */
    class InThreePicHolder{
        TextView threeNameTv , threeTitleTv , threeTimeTv , threePraiseTv , threeReplayTv;
        ImageView threeLeftImg , threeMiddleImg , threeRightImg , threeHeadImg;
        public InThreePicHolder(View view){
            threeNameTv = (TextView) view.findViewById(R.id.item_innovate_listview_threepic_name);
            threeTitleTv = (TextView) view.findViewById(R.id.item_innovate_listview_threepic_title);
            threeTimeTv = (TextView) view.findViewById(R.id.item_innovate_listview_threepic_time);
            threePraiseTv = (TextView) view.findViewById(R.id.item_innovate_listview_threepic_zancount);
            threeReplayTv = (TextView) view.findViewById(R.id.item_innovate_listview_threepic_talkcount);
            threeLeftImg = (ImageView) view.findViewById(R.id.item_innovate_listview_threepic_leftimg);
            threeMiddleImg = (ImageView) view.findViewById(R.id.item_innovate_listview_threepic_middleimg);
            threeRightImg = (ImageView) view.findViewById(R.id.item_innovate_listview_threepic_rightimg);
            threeHeadImg = (ImageView) view.findViewById(R.id.item_innovate_listview_threepic_headimg);
        }
    }
    /**
     * 一个大图的行布局
     */
    class BigPicHolder{
        TextView bigNameTv , bigTitleTv , bigTimeTv , bigPraiseTv , bigReplayTv;
        ImageView bigImg ,bigHeadImg;
        public BigPicHolder(View view){
            bigNameTv = (TextView) view.findViewById(R.id.item_innovate_listview_bigpic_name);
            bigTitleTv = (TextView) view.findViewById(R.id.item_innovate_listview_bigpic_title);
            bigTimeTv = (TextView) view.findViewById(R.id.item_innovate_listview_bigpic_time);
            bigPraiseTv = (TextView) view.findViewById(R.id.item_innovate_listview_bigpic_zancount);
            bigReplayTv = (TextView) view.findViewById(R.id.item_innovate_listview_bigpic_zancount);
            bigImg = (ImageView) view.findViewById(R.id.item_innovate_listview_bigpic_bigmig);
            bigHeadImg = (ImageView) view.findViewById(R.id.item_innovate_listview_bigpic_headimg);
        }
    }
}
