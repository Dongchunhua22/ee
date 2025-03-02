package com.jiyun.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.jiyun.meishi.LoginActivity;
import com.jiyun.meishi.R;

public class GeRenFra extends Fragment {
    private TextView mLoginText;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.grren_fra, null);
        initView(view);
        return view;
    }


    private void initView(@NonNull final View itemView) {
        mLoginText = (TextView) itemView.findViewById(R.id.loginText);
        mLoginText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().startActivity(new Intent(getActivity(), LoginActivity.class));
            }
        });
    }
}
