package com.zhangzuhao.dllo.autohome.ui.activity;

import android.view.View;
import android.widget.TextView;

import com.zhangzuhao.dllo.autohome.R;

/**
 * Created by dllo on 16/10/9.
 */
public class ForumSearchActivity extends AbsBaseActivity {
    private TextView backTv;
    @Override
    protected int setLayout() {
        return R.layout.activity_forum_search;
    }

    @Override
    protected void initViews() {
        backTv = byView(R.id.forum_search_backtv);

        backTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    @Override
    protected void initDatas() {

    }
}
