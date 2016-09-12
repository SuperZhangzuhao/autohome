package com.zhangzuhao.dllo.autohome.ui.activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.zhangzuhao.dllo.autohome.R;
import com.zhangzuhao.dllo.autohome.model.bean.BoutiqueMenuLvBean;

import java.util.List;

/**
 * Created by dllo on 16/9/12.
 */
public class BoutiqueMenuLvAdapter extends BaseAdapter {
    private Context context ;
    private List<BoutiqueMenuLvBean> mboutiqueMenuLvBeen;

    public BoutiqueMenuLvAdapter(Context context) {
        this.context = context;
    }

    public void setMboutiqueMenuLvBeen(List<BoutiqueMenuLvBean> mboutiqueMenuLvBeen) {
        this.mboutiqueMenuLvBeen = mboutiqueMenuLvBeen;
    }

    @Override
    public int getCount() {
        return mboutiqueMenuLvBeen != null && mboutiqueMenuLvBeen.size() > 0 ? mboutiqueMenuLvBeen.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return mboutiqueMenuLvBeen != null && mboutiqueMenuLvBeen.size()> 0 ? mboutiqueMenuLvBeen.get(position): null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_lv_boutiuqe_menu , parent , false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        BoutiqueMenuLvBean mboutiqueMenuLvBean = (BoutiqueMenuLvBean) getItem(position);
        holder.mboutiqueMenuLvTv.setText(mboutiqueMenuLvBean.getmMenu());

        return convertView;
    }

    class ViewHolder {
        private TextView mboutiqueMenuLvTv;
        public ViewHolder (View view){
            mboutiqueMenuLvTv = (TextView) view.findViewById(R.id.item_lv_boutiuqe_menu_tv);
        }
    }

}
