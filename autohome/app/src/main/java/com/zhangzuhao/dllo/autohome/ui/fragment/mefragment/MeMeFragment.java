package com.zhangzuhao.dllo.autohome.ui.fragment.mefragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.zhangzuhao.dllo.autohome.R;
import com.zhangzuhao.dllo.autohome.ui.activity.CollectAtivity;
import com.zhangzuhao.dllo.autohome.ui.activity.EnterActivity;
import com.zhangzuhao.dllo.autohome.ui.fragment.AbsBaseFragment;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by dllo on 16/9/10.
 * 我的fragment
 */
public class MeMeFragment extends AbsBaseFragment implements View.OnClickListener {
    private TextView  collectTv , nameTv ;
    private ImageButton idEnterBtn , weiboEnterBtn , wechatEnterBtn;
    private SharedPreferences sp ;
    private CircleImageView  header;


    @Override
    protected int setLayout() {
        return R.layout.fragment_meme;
    }

    @Override
    protected void initViews() {
        collectTv = byView(R.id.me_mycollect);
        idEnterBtn = byView(R.id.me_identer);
        weiboEnterBtn = byView(R.id.me_weiboenter);
        wechatEnterBtn = byView(R.id.me_wechatenter);

        idEnterBtn.setOnClickListener(this);
        weiboEnterBtn.setOnClickListener(this);
        wechatEnterBtn.setOnClickListener(this);
    }
    @Override
    protected void initDatas() {
        collectTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("key" , "");
                goTo(context , CollectAtivity.class , bundle);
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.me_identer:
                Log.d("MeMeFragment", "账号登入");
                Bundle bundle = new Bundle();
                bundle.putString("key","");
                goTo(context , EnterActivity.class , bundle);
                break;
            case R.id.me_weiboenter:
                Log.d("MeMeFragment", "微博登入");
                break;
            case R.id.me_wechatenter:
                Log.d("MeMeFragment", "微信登入");
                break;
        }
    }
}
