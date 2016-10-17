package com.zhangzuhao.dllo.autohome.ui.activity;

import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhangzuhao.dllo.autohome.R;

/**
 * Created by dllo on 16/10/12.
 */
public class WelcomeActiviry extends AbsBaseActivity {
    private ImageView showImg;
    private TextView jumpTv;

    @Override
    protected int setLayout() {
        return R.layout.activity_welcome;


    }

    @Override
    protected void initViews() {
        showImg = byView(R.id.welcome_img);
        jumpTv = byView(R.id.weclome_jumptv);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
              goTo(WelcomeActiviry.this  , MainActivity.class);
                finish();
            }
        } , 3000);

    }

    @Override
    protected void initDatas() {
//     /   jumpTv.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                finish();
//            }
//        });



    }
}
