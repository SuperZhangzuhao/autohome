package com.zhangzuhao.dllo.autohome.ui.activity;

import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.zhangzuhao.dllo.autohome.R;

/**
 * Created by dllo on 16/10/12.
 * 注册页面
 */
public class ZhuceActivity extends AbsBaseActivity {
    private EditText userId , userCode ;
    private TextView backTv;
    private Button finishBtn;
    @Override
    protected int setLayout() {
        return R.layout.zuche_activity;
    }

    @Override
    protected void initViews() {
        backTv = byView(R.id.zhuce_backtv);
        userId = byView(R.id.zhuce_userid);
        userCode = byView(R.id.zhuce_usercode);
        finishBtn = byView(R.id.zhuce_nextbtn);

        backTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        finishBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = userId.getText().toString();
                String userMima = userCode.getText().toString();
                SharedPreferences sp = getSharedPreferences("enter" , MODE_PRIVATE);
                SharedPreferences.Editor edit = sp.edit();
                edit.putString("name" , userName);
                edit.putString("code" , userMima);
                edit.commit();
                goTo(ZhuceActivity.this , EnterActivity.class);
                finish();
            }
        });
    }

    @Override
    protected void initDatas() {

    }
}
