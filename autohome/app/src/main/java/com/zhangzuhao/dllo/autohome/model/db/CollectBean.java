package com.zhangzuhao.dllo.autohome.model.db;

import com.litesuits.orm.db.annotation.PrimaryKey;
import com.litesuits.orm.db.annotation.Table;
import com.litesuits.orm.db.enums.AssignType;

/**
 * Created by dllo on 16/10/10.
 * 收藏数据库的实体类
 */
@Table("collect")
public class CollectBean  {

    @PrimaryKey(AssignType.AUTO_INCREMENT)
    private int id ;
    private String title;
    private String imgUrl;
    private String time;
    private String replaycount;
    private String detailsUrl;

    public CollectBean() {
    }

    public CollectBean(int id, String title, String imgUrl, String time, String replaycount , String detailsUrl) {
        this.id = id;
        this.title = title;
        this.imgUrl = imgUrl;
        this.time = time;
        this.replaycount = replaycount;
        this.detailsUrl = detailsUrl;
    }

    public CollectBean(String title, String imgUrl, String time, String replaycount , String detailsUrl) {
        this.title = title;
        this.imgUrl = imgUrl;
        this.time = time;
        this.replaycount = replaycount;
        this.detailsUrl = detailsUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getReplaycount() {
        return replaycount;
    }

    public void setReplaycount(String replaycount) {
        this.replaycount = replaycount;
    }

    public String getDetailsUrl() {
        return detailsUrl;
    }

    public void setDetailsUrl(String detailsUrl) {
        this.detailsUrl = detailsUrl;
    }
}
