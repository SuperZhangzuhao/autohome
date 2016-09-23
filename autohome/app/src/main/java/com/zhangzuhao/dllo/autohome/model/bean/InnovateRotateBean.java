package com.zhangzuhao.dllo.autohome.model.bean;

import java.io.Serializable;

/**
 * Created by dllo on 16/9/21.
 * 创新的实体类
 */
public class InnovateRotateBean implements Serializable {
    private int imgId;
    private String imgUrl;

    public InnovateRotateBean() {
    }

    public InnovateRotateBean(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public InnovateRotateBean(int imgId) {
        this.imgId = imgId;
    }

    public InnovateRotateBean(int imgId, String imgUrl) {
        this.imgId = imgId;
        this.imgUrl = imgUrl;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
