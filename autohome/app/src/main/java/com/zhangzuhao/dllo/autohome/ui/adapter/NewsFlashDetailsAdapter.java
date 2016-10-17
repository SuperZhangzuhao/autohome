package com.zhangzuhao.dllo.autohome.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.zhangzuhao.dllo.autohome.R;
import com.zhangzuhao.dllo.autohome.model.bean.NewsFlashDetailsExBean;

import java.util.List;
import java.util.Map;

/**
 * Created by dllo on 16/10/10.
 * 快报详情页的适配器
 */
public class NewsFlashDetailsAdapter extends BaseExpandableListAdapter {
    private List<NewsFlashDetailsExBean.ResultBean.MessagelistBean> groupList;
    private Map<String , List<NewsFlashDetailsExBean.ResultBean.MessagelistBean.CommentlistBean>> childs;
    private Context context ;

    public void setGroupList(List<NewsFlashDetailsExBean.ResultBean.MessagelistBean> groupList) {
        this.groupList = groupList;
        notifyDataSetChanged();
    }

    public void setChilds(Map<String, List<NewsFlashDetailsExBean.ResultBean.MessagelistBean.CommentlistBean>> childs) {
        this.childs = childs;
        notifyDataSetChanged();
    }

    public NewsFlashDetailsAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getGroupCount() {
        return groupList != null ? groupList.size() : 0;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        List<NewsFlashDetailsExBean.ResultBean.MessagelistBean.CommentlistBean> d;
        d = childs.get(groupList.get(groupPosition));
        return d == null ? 0 :d.size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return groupList != null ? groupList.get(groupPosition) : null;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        List<NewsFlashDetailsExBean.ResultBean.MessagelistBean.CommentlistBean> d;
        d = childs.get(groupList.get(groupPosition));
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

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        GroupViewHolder groupHolder = null;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_father_newsflashdetails_exlistview , parent , false);
            groupHolder = new GroupViewHolder(convertView);
            convertView.setTag(groupHolder);
        }else {
            groupHolder = (GroupViewHolder) convertView.getTag();
        }
        NewsFlashDetailsExBean.ResultBean.MessagelistBean mBean = (NewsFlashDetailsExBean.ResultBean.MessagelistBean) getGroup(groupPosition);
        groupHolder.userName.setText(mBean.getAuthorname());
        groupHolder.time.setText(mBean.getPublishtime());
        groupHolder.content.setText(mBean.getContent());
        groupHolder.upcount.setText(mBean.getUpcount()+"");
        groupHolder.replaycount.setText(mBean.getReplycount()+"");
        Picasso.with(context).load(mBean.getHeadimg()).into(groupHolder.header);


        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ChildViewHolder holder = null;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_child_newsflashdetails_exlistview , parent , false);
            holder = new ChildViewHolder(convertView);
            convertView.setTag(holder);
        }else {
            holder = (ChildViewHolder) convertView.getTag();
        }
        NewsFlashDetailsExBean.ResultBean.MessagelistBean.CommentlistBean mBean = (NewsFlashDetailsExBean.ResultBean.MessagelistBean.CommentlistBean) childs.get(childPosition);
        holder.childUserName.setText(mBean.getUsername());
        holder.childContent.setText(mBean.getContent());
        Picasso.with(context).load(mBean.getHeadimg()).into(holder.childHeader);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    /**
     * GroupItem
     */
    class GroupViewHolder{
        private ImageView header , contentImg;
        private TextView userName , time , content , upcount , replaycount;
        public  GroupViewHolder (View groupView){
            header = (ImageView) groupView.findViewById(R.id.item_newsflash_details_father_userheadimg);
            contentImg = (ImageView) groupView.findViewById(R.id.item_newsflash_details_father_contentimg);
            userName = (TextView) groupView.findViewById(R.id.item_newsflash_details_father_usernametv);
            time = (TextView) groupView.findViewById(R.id.item_newsflash_details_father_timetv);
            content = (TextView) groupView.findViewById(R.id.item_newsflash_details_father_contanttv);
            upcount = (TextView) groupView.findViewById(R.id.item_newsflash_details_father_upcounttv);
            replaycount = (TextView) groupView.findViewById(R.id.item_newsflash_details_father_replaycount);
        }
    }
    /**
     * childItem
     */
    class ChildViewHolder{
        private ImageView childHeader ;
        private TextView childUserName , childContent;
        public ChildViewHolder (View childHolder){
            childHeader = (ImageView) childHolder.findViewById(R.id.item_newsflash_details_child_userheadimg);
            childUserName = (TextView) childHolder.findViewById(R.id.item_newsflash_details_child_usernametv);
            childContent = (TextView) childHolder.findViewById(R.id.item_newsflash_details_child_contenttv);
        }
    }
}
