package com.zhangzuhao.dllo.autohome.view;

/**
 * Created by dllo on 16/10/9.
 */
public interface OnRefreshListener {
    /**
     * 下拉刷新
     */
    void onDownPullRefresh();
    /**
     * 下拉加载
     */
    void onLoadingMore();
}
