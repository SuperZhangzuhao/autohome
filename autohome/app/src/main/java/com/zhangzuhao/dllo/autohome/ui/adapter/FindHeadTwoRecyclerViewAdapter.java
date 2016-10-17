package com.zhangzuhao.dllo.autohome.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hp.hpl.sparta.Text;
import com.squareup.picasso.Picasso;
import com.zhangzuhao.dllo.autohome.R;
import com.zhangzuhao.dllo.autohome.model.bean.FindBean;

import java.util.List;

/**
 * Created by dllo on 16/9/28.
 */
public class FindHeadTwoRecyclerViewAdapter extends RecyclerView.Adapter<FindHeadTwoRecyclerViewAdapter.TwoHeadHolder> {
    private Context context ;
    private List<FindBean.ResultBean.ModulelistBean.ListBean> datas;

    public FindHeadTwoRecyclerViewAdapter(Context context) {
        this.context = context;
    }

    public void setDatas(List<FindBean.ResultBean.ModulelistBean.ListBean> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    @Override
    public TwoHeadHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_find_two_head_recyclerview , parent , false);
        TwoHeadHolder headHolder = new TwoHeadHolder(view);
        return headHolder;
    }

    @Override
    public void onBindViewHolder(TwoHeadHolder holder, int position) {
        int type = datas.get(position).getType();
        Log.d("xxx", "type:" + type);
        if (type == 0){
         FindBean.ResultBean.ModulelistBean.ListBean mBean = datas.get(position);
            holder.titleTv.setText(mBean.getTitle());
            holder.secondTitleTv.setText(mBean.getAdinfo());
            holder.priceTv.setText(mBean.getPrice());
            holder.secondPriceTv.setText(mBean.getFctprice());
            Picasso.with(context).load(mBean.getLogo()).into(holder.carImg);
        }
    }

    @Override
    public int getItemCount() {
        return datas != null && datas.size()>0? datas.size() : 0;
    }

    class TwoHeadHolder extends RecyclerView.ViewHolder{
        private TextView titleTv , secondTitleTv , priceTv , secondPriceTv;
        private ImageView carImg;
        public TwoHeadHolder(View itemView) {
            super(itemView);
            titleTv = (TextView) itemView.findViewById(R.id.find_two_head_recycler_titletv);
            secondTitleTv = (TextView) itemView.findViewById(R.id.find_two_head_recycler_secondtitle);
            priceTv = (TextView) itemView.findViewById(R.id.find_two_head_recycler_price);
            secondPriceTv = (TextView) itemView.findViewById(R.id.find_two_head_recycler_secondprice);
            carImg = (ImageView) itemView.findViewById(R.id.find_two_head_recycler_img);

        }
    }
}
