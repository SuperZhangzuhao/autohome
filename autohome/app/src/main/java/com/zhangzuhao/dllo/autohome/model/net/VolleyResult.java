package com.zhangzuhao.dllo.autohome.model.net;

/**
 * Created by dllo on 16/9/14.
 * 网络请求结果的接口
 */
public interface VolleyResult {
    void success(String resultStr);

    void failure();
}
