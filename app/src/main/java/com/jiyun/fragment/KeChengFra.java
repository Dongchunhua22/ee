package com.jiyun.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.jiyun.meishi.R;
import com.jiyun.meishi.SearchActivity;

public class KeChengFra extends Fragment implements View.OnClickListener {


    private ImageView mSearchCourse;
    private TextView mSortCourse;
    private ImageView mImgCourse;
    private ConstraintLayout mSelItem;
    private TextView mSchoolSmall;
    private ImageView mImg;
    private TextView mKonwledge;
    private TextView mModel;
    private TextView mShai;
    private TabLayout mTabXuanke;
    private ViewPager mPageXuanke;
    private ConstraintLayout mMSelItem;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.kecheng_fra, null);
        initView(view);
        return view;
    }

    private void initView(@NonNull final View itemView) {

        mSearchCourse = (ImageView) itemView.findViewById(R.id.course_search);
        mSearchCourse.setOnClickListener(this);
        mSortCourse = (TextView) itemView.findViewById(R.id.course_sort);
        mSortCourse.setOnClickListener(this);
        mImgCourse = (ImageView) itemView.findViewById(R.id.course_img);
        mImgCourse.setOnClickListener(this);
        mSelItem = (ConstraintLayout) itemView.findViewById(R.id.item_sel);
        mMSelItem = (ConstraintLayout) itemView.findViewById(R.id.mSelItem);
    }


    private void initPop() {
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.pop_laout, null);
        final PopupWindow popupWindow = new PopupWindow(inflate, ViewGroup.LayoutParams.MATCH_PARENT, 400);
        popupWindow.setBackgroundDrawable(null);
        backgroundAlpha(0.5f);
        popupWindow.setOutsideTouchable(true);
        popupWindow.showAsDropDown(mMSelItem, 0, 0);
        //点击非菜单部分退出
        inflate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });

        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                backgroundAlpha(1.0f);
            }
        });
    }

    public void backgroundAlpha(float bgAlpha) {
        WindowManager.LayoutParams lp = getActivity().getWindow().getAttributes();
        lp.alpha = bgAlpha; //0.0-1.0
        getActivity().getWindow().setAttributes(lp);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.course_search:
                startActivity(new Intent(getActivity(), SearchActivity.class));
                // TODO 20/06/23
                break;
            case R.id.course_sort:
                // TODO 20/06/23
                break;
            case R.id.course_img:
                // TODO 20/06/23
                break;
            default:
                break;
        }
    }
}
