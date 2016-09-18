package com.zhangzuhao.dllo.autohome.ui.fragment.recommendfragments;

import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.zhangzuhao.dllo.autohome.R;
import com.zhangzuhao.dllo.autohome.model.bean.VideoListViewBean;
import com.zhangzuhao.dllo.autohome.model.net.VolleyInstance;
import com.zhangzuhao.dllo.autohome.model.net.VolleyResult;
import com.zhangzuhao.dllo.autohome.ui.adapter.VideoListViewAdapter;
import com.zhangzuhao.dllo.autohome.ui.app.AutoHomeApp;
import com.zhangzuhao.dllo.autohome.ui.fragment.AbsBaseFragment;

import java.lang.ref.ReferenceQueue;
import java.util.List;

/**
 * Created by dllo on 16/9/10.
 */
public class VideoFragment extends AbsBaseFragment {
    private TextView titleTv , timeTv , playCountTv;
    private ImageView smallImg;
    private ListView listView;
    private VideoListViewAdapter adapter ;
    private VideoListViewBean videoListViewBean;
    private List<VideoListViewBean>datas;
    private String videoUrl = "http://app.api.autohome.com.cn/autov5.0.0/news/videolist-pm2-vt0-s20-lastid0.json";

    @Override
    protected int setLayout() {
        return R.layout.fragment_video;
    }

    @Override
    protected void initViews() {
    titleTv = byView(R.id.video_item_title);
        timeTv = byView(R.id.video_item_time);
        playCountTv  = byView(R.id.video_item_playcount);
        smallImg = byView(R.id.video_item_smallimg);
        listView =  byView(R.id.video_listview);
        adapter = new VideoListViewAdapter(context);
        listView.setAdapter(adapter);
    }

    @Override
    protected void initDatas() {
        /**
         * 获取网络数据
         */
        VolleyInstance.getmInstance().startRequest(videoUrl, new VolleyResult() {
            @Override
            public void success(String resultStr) {
                Gson gson = new Gson();
                VideoListViewBean videoListViewBean = gson.fromJson(resultStr, VideoListViewBean.class);
                List<VideoListViewBean.VideoListViewBeanChild1.VideoListViewBeanChild2> datas = videoListViewBean.getResult().getList();
                datas.get(0).getTitle();
                datas.get(1).getTime();
                datas.get(2).getPlaycount();
                datas.get(3).getSmallimg();
                adapter.setDatas(datas);
            }
            @Override
            public void failure() {
            }
        });
    }
}
