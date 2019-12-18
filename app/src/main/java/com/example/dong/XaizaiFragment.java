package com.example.dong;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class XaizaiFragment extends Fragment implements View.OnClickListener {
    private View view;
    private ProgressBar mPro;
    private TextView mShow;
    private Button mBtn;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.xiaxai_fragment, null);
        initView(view);
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }


        return view;
    }

    private void initView(View view) {
        mPro = (ProgressBar) view.findViewById(R.id.pro);
        mShow = (TextView) view.findViewById(R.id.show);
        mBtn = (Button) view.findViewById(R.id.btn);
        mBtn.setOnClickListener(this);
    }
    //接收
    @Subscribe
    public void  jie(Event event){
        int dangqian = event.dangqian;
        int max = event.max;
        mPro.setMax(max);
        mPro.setProgress(dangqian);
        float v=dangqian*1f/max*100;
        mShow.setText("进度"+(int)v+"%");

            Toast.makeText(getActivity(),"下载完成",Toast.LENGTH_SHORT).show();


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.btn:
                Intent intent = new Intent(getActivity(), Myservice.class);
                getActivity().startService(intent);
                break;
        }
    }
}
