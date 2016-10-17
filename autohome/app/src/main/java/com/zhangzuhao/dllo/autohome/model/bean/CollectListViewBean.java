package com.zhangzuhao.dllo.autohome.model.bean;

/**
 * Created by dllo on 16/10/11.
 */
public class CollectListViewBean {

    private String title;
    private String time ;
    private String imgUrl ;
    private String replayCount;
    private String img ;

    public CollectListViewBean() {
    }

    public CollectListViewBean(String title, String time, String imgUrl, String replayCount ,String img) {
        this.title = title;
        this.time = time;
        this.imgUrl = imgUrl;
        this.replayCount = replayCount;
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getReplayCount() {
        return replayCount;
    }

    public void setReplayCount(String replayCount) {
        this.replayCount = replayCount;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
