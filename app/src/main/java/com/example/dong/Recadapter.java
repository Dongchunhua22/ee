package com.example.dong;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class Recadapter extends RecyclerView.Adapter<Recadapter.ViewHoder> {
    private Context context;
    private List<Bean.DataBean.DatasBean>data;

    public Recadapter(Context context, List<Bean.DataBean.DatasBean> data) {
        this.context = context;
        this.data = data;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public List<Bean.DataBean.DatasBean> getData() {
        return data;
    }

    public void setData(List<Bean.DataBean.DatasBean> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public Recadapter.ViewHoder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.item1, null);
        ViewHoder viewHoder = new ViewHoder(view);
        return viewHoder;
    }

    @Override
    public void onBindViewHolder(@NonNull Recadapter.ViewHoder viewHoder, int i) {
        Glide.with(context).load(data.get(i).getEnvelopePic()).into(viewHoder.img);
        viewHoder.title.setText(data.get(i).getTitle());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHoder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView title;
        public ViewHoder(@NonNull View itemView) {
            super(itemView);
             img = itemView.findViewById(R.id.img);
             title = itemView.findViewById(R.id.title);
        }
    }
}
