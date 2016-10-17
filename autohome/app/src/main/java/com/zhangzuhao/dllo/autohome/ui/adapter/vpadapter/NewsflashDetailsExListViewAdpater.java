package com.zhangzuhao.dllo.autohome.ui.adapter.vpadapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;

import com.zhangzuhao.dllo.autohome.model.bean.NewsFlashDetailsExpandableBean;

import java.util.List;

/**
 * Created by dllo on 16/9/30.
 *
 */
public class NewsflashDetailsExListViewAdpater extends BaseExpandableListAdapter {
    private Context context ;
    int a  ;
    /**
     * 父类局的集合
     */
    private List<NewsFlashDetailsExpandableBean.ResultBean.NewsdataBean> groupDatas;
    /**
     * 子类的集合
     */
    private List<NewsFlashDetailsExpandableBean.ResultBean.MessagelistBean.AttachmentsBean> childDatas;

    public NewsflashDetailsExListViewAdpater(Context context) {
        this.context = context;
    }

    public void setChildDatas(List<NewsFlashDetailsExpandableBean.ResultBean.MessagelistBean.AttachmentsBean> childDatas) {
        this.childDatas = childDatas;
        notifyDataSetChanged();
    }

    public void setGroupDatas(List<NewsFlashDetailsExpandableBean.ResultBean.NewsdataBean> groupDatas) {
        this.groupDatas = groupDatas;
        notifyDataSetChanged();
    }

    @Override
    public int getGroupCount() {
        return groupDatas.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return childDatas.size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return groupDatas.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return childDatas.get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        return null;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        return null;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}
