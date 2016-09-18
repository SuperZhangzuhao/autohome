package com.zhangzuhao.dllo.autohome.ui.adapter.layoutadapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zhangzuhao.dllo.autohome.R;
import com.zhangzuhao.dllo.autohome.utils.OnRvItemClick;

import java.util.List;

/**
 * Created by dllo on 16/9/12.
 *精品推荐RecyclerView的适配器
 */
public class RecyclerBoutiqueAadapter  extends RecyclerView.Adapter<RecyclerBoutiqueAadapter.MyViewHolder> {
    private List<String> datas;
    private OnRvItemClick onRvItemClick;
    private Context context;

    public void setOnRvItemClick(OnRvItemClick onRvItemClick) {
        this.onRvItemClick = onRvItemClick;
    }
    public void setDatas(List<String>datas){
        this.datas = datas;
        notifyDataSetChanged();
    }
    public RecyclerBoutiqueAadapter(Context context) {
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_rv_boutique , parent , false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }
    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        holder.boutiqueTv.setText(datas.get(position));
        //设置点击事件
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onRvItemClick != null){
                    int p = holder.getLayoutPosition();
                    String str = datas.get(position);
                    onRvItemClick.OnRvItemClickListener(p , str);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return datas != null && datas.size() > 0 ? datas.size(): 0;
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView  boutiqueTv;
        public MyViewHolder(View itemView) {
            super(itemView);
            boutiqueTv = (TextView) itemView.findViewById(R.id.boutique_rv_tv);
        }
    }
}
