package com.zhangzuhao.dllo.autohome.ui.activity;

import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.zhangzuhao.dllo.autohome.R;

import java.util.HashMap;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.PlatformDb;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.tencent.qq.QQ;

/**
 * Created by dllo on 16/10/12.
 * 登入界面
 */
public class EnterActivity extends AbsBaseActivity implements View.OnClickListener {
    private TextView backTv , zhucheTv, forgotTv ;
    private Button enterBtn ;
    private ImageButton qqBtn;
    private SharedPreferences  sp;
    private SharedPreferences.Editor editor;
    private EditText user , code;
    @Override
    protected int setLayout() {
        return R.layout.enter_activity;
    }

    @Override
    protected void initViews() {
        backTv = byView(R.id.enter_backtv);
        zhucheTv = byView(R.id.enter_zhuce);
        forgotTv = byView(R.id.enter_forgottv);
        enterBtn = byView(R.id.enter_enterbtn);
        qqBtn = byView(R.id.me_qqenter);
        user = byView(R.id.enter_user);
        code = byView(R.id.enter_code);

        backTv.setOnClickListener(this);
        zhucheTv.setOnClickListener(this);
        forgotTv.setOnClickListener(this);
        enterBtn.setOnClickListener(this);
        qqBtn.setOnClickListener(this);

    }

    @Override
    protected void initDatas() {
        SharedPreferences enterSp = getSharedPreferences("enter" , MODE_PRIVATE);
        String mUserName = enterSp.getString("name", "" );
        Log.d("EnterActivity", mUserName);
        String mUserCode = enterSp.getString("code" , "");
        Log.d("EnterActivity", mUserCode);
        user.setText(mUserName);
        code.setText(mUserCode);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.enter_backtv:
                finish();
                break;
            case R.id.enter_zhuce:
                goTo(EnterActivity.this , ZhuceActivity.class);
                break;
            case R.id.enter_forgottv:
                break;
            case R.id.enter_enterbtn:
                finish();
                break;
            case R.id.me_qqenter:
                //获取第三方平台
                Platform platform = ShareSDK.getPlatform(this , QQ.NAME);
                //授权
                platform.authorize();

                platform.setPlatformActionListener(new PlatformActionListener() {
                    @Override
                    public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {
                        Toast.makeText(EnterActivity.this, "完成", Toast.LENGTH_SHORT).show();
                        //获取qq头像和名字
                        PlatformDb  db = platform.getDb();
                        String name = db.getUserName();
                        String icon = db.getUserIcon();
                        sp = getSharedPreferences("autohome" , MODE_PRIVATE);
                        editor = sp.edit();
                        editor.putString("name" , name);
                        editor.putString("icon" , icon);
                        editor.commit();

                    }
                    @Override
                    public void onError(Platform platform, int i, Throwable throwable) {
                        Toast.makeText(EnterActivity.this, "错误", Toast.LENGTH_SHORT).show();
                    }
                    @Override
                    public void onCancel(Platform platform, int i) {
                        Toast.makeText(EnterActivity.this, "取消", Toast.LENGTH_SHORT).show();
                    }
                });
        break;
        }
    }

}
