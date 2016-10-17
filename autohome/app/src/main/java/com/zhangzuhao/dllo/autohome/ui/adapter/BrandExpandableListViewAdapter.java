package com.zhangzuhao.dllo.autohome.ui.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.zhangzuhao.dllo.autohome.R;
import com.zhangzuhao.dllo.autohome.model.bean.BrandExpandableBean;

import java.util.List;
import java.util.Map;

/**
 * Created by dllo on 16/9/27.
 */
public class BrandExpandableListViewAdapter extends BaseExpandableListAdapter {
    private Context context ;
    int a;
    /**
     * 父布局的集合
     */
    private List<String> gruopDatas ;
    /**
     * 子布局的集合
     */
    private Map<String , List<BrandExpandableBean.ResultBean.BrandlistBean.ListBean>> childDatas;

    public BrandExpandableListViewAdapter(Context context) {
        this.context = context;
    }

    public void setChildDatas(Map<String, List<BrandExpandableBean.ResultBean.BrandlistBean.ListBean>> childDatas) {
        this.childDatas = childDatas;
        notifyDataSetChanged();
    }

    public void setGruopDatas(List<String> gruopDatas) {
        this.gruopDatas = gruopDatas;
        notifyDataSetChanged();
    }

    @Override
    public int getGroupCount() {
        return gruopDatas.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        List<BrandExpandableBean.ResultBean.BrandlistBean.ListBean> d;
        d = childDatas.get(gruopDatas.get(groupPosition));
        return d == null ? 0 : d.size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return gruopDatas != null ? gruopDatas.get(groupPosition) : null;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        List<BrandExpandableBean.ResultBean.BrandlistBean.ListBean> d;
        d = childDatas.get(gruopDatas.get(groupPosition));
        return d.get(childPosition);
}

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    /**
     *获取父布局的View
     */
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        Log.d("BrandExpandableListView", "groupPosition:" + groupPosition);
        GroupViewHolder groupViewHolder = null;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_father_brand_expandablelistview , parent , false);
            groupViewHolder = new GroupViewHolder(convertView);
            convertView.setTag(groupViewHolder);
        }else {
            groupViewHolder = (GroupViewHolder) convertView.getTag();
        }

        groupViewHolder.letterTv.setText(gruopDatas.get(groupPosition));
        return convertView;
    }

    /**
     *获取自布局的View
     */
    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ChildViewHolder childViewHolder = null;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_child_brand_expandablelistview , parent ,false);
            childViewHolder = new ChildViewHolder(convertView);
            convertView.setTag(childViewHolder);
        }else {
            childViewHolder = (ChildViewHolder) convertView.getTag();
        }
        BrandExpandableBean.ResultBean.BrandlistBean.ListBean childBean = (BrandExpandableBean.ResultBean.BrandlistBean.ListBean) getChild(groupPosition ,childPosition);
        childViewHolder.brandTv.setText(childBean.getName());
        Picasso.with(context).load(childBean.getImgurl()).into(childViewHolder.brandPic);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

//    public int indexOf(String s) {
//        for (int i = 0; i < gruopDatas.size(); i++) {
//            if ( gruopDatas.get(i).getLetter().equals(s) ) {
//                a = i;
//            }
//        }
//        return a;
//    }

    /**
     * 子类布局缓存
     */
    class ChildViewHolder{
        private TextView brandTv ;
        private ImageView brandPic;
        public  ChildViewHolder(View view){
            brandTv = (TextView) view.findViewById(R.id.item_brand_nametv);
            brandPic = (ImageView) view.findViewById(R.id.item_brand_img);
        }
    }
    /**
     * 父类布局缓存
     */
    class GroupViewHolder{
        private TextView letterTv;
        public GroupViewHolder (View view){
            letterTv = (TextView) view.findViewById(R.id.item_brand_lettertv);
        }
    }
}
