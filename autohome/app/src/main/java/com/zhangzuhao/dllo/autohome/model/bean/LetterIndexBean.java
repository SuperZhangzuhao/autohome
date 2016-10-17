package com.zhangzuhao.dllo.autohome.model.bean;

/**
 * Created by dllo on 16/9/26.
 * 按照字母索引的实体类
 */
public class LetterIndexBean {
    private String name ;
    private String pinYinName;

    public LetterIndexBean(String name) {
        super();
        this.name = name;
    }

    public LetterIndexBean(String name, String pinYinName) {
        super();
        this.name = name;
        this.pinYinName = pinYinName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPinYinName() {
        return pinYinName;
    }

    public void setPinYinName(String pinYinName) {
        this.pinYinName = pinYinName;
    }
}
