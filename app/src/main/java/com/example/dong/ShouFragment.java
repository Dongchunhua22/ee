package com.example.dong;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class ShouFragment extends Fragment implements NetView{
    private View view;
    private RecyclerView mRecy;
    private Persener persener;
    private List<Bean.DataBean.DatasBean> data;
    private Recadapter recadapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.shou_fragment, null);
        persener = new Persener(this);
        initView(view);
        initData();
        initRec();
        return view;
    }
        //设置recyview
    private void initRec() {
        mRecy.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecy.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayout.VERTICAL));
        data = new ArrayList<>();
        recadapter = new Recadapter(getActivity(), data);
        mRecy.setAdapter(recadapter);

    }

    private void initData() {
        persener.getData();
    }

    private void initView(View view) {
        mRecy = (RecyclerView) view.findViewById(R.id.recy);
    }

    @Override
    public void setData(List<Bean.DataBean.DatasBean> datas) {
        //打印数据
        Log.d("2222", "setData: "+datas.toString());
        data.addAll(datas);
        recadapter.notifyDataSetChanged();


    }
}
