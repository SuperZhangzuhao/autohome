package com.zhangzuhao.dllo.autohome.model.bean;

/**
 * Created by dllo on 16/9/22.
 * 视频抽屉的实体类
 */
public class VideoDrawerListViewBean  {
    private String itemStr;

    public VideoDrawerListViewBean() {
    }

    public VideoDrawerListViewBean(String itemStr) {
        this.itemStr = itemStr;
    }

    public String getItemStr() {
        return itemStr;
    }

    public void setItemStr(String itemStr) {
        this.itemStr = itemStr;
    }
}
