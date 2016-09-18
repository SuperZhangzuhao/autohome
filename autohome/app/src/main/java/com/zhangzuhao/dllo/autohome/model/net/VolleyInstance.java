package com.zhangzuhao.dllo.autohome.model.net;
import android.util.Log;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.zhangzuhao.dllo.autohome.ui.app.AutoHomeApp;
/**
 * Created by dllo on 16/9/14.
 * Volley使用的单例
 */
public class VolleyInstance {
    private RequestQueue referenceQueue;
    private static VolleyInstance mInstance;
    private VolleyInstance() {
        referenceQueue = Volley.newRequestQueue(AutoHomeApp.getContext());
    }
    public static VolleyInstance getmInstance() {
        if (mInstance == null) {
            synchronized (VolleyInstance.class) {
                if (mInstance == null) {
                    mInstance = new VolleyInstance();
                }
            }
        }
        return mInstance;
    }
    /**
     * 对外提供请求方法
     */
    public void startRequest(String url, final VolleyResult result) {
        StringRequest sr = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("net", "success:" + response);
                result.success(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("net", "error:" + error);
                result.failure();
            }
        });
        referenceQueue.add(sr);
    }
}
