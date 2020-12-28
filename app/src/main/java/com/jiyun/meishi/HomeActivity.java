package com.jiyun.meishi;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.jiyun.adapter.FraPagerAdapter;
import com.jiyun.fragment.GeRenFra;
import com.jiyun.fragment.KeChengFra;
import com.jiyun.fragment.ShouFra;
import com.jiyun.fragment.YueKeFra;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    private ArrayList<Integer> images;
    private  ArrayList<String>strings;
    private ArrayList<Fragment> fragments;
    private ViewPager mVapger;
    private TabLayout mTab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initView();
       // initTab();
        initFragment();

      /*  mTab.addTab(mTab.newTab().setText("tab1"));
        mTab.addTab(mTab.newTab().setText("tab2"));
        mTab.addTab(mTab.newTab().setText("tab3"));
        mTab.addTab(mTab.newTab().setText("tab4"));*/

     /*   View tab1 = getCustomView(R.drawable.one_selector, "首页");
        View tab2 = getCustomView(R.drawable.two_selector, "课程");
        View tab3 = getCustomView(R.drawable.three_selector, "约课记录");
        View tab4 = getCustomView(R.drawable.three_selector, "个人");
*/



     /*   mTab.getTabAt(0).setCustomView(tab1);
        mTab.getTabAt(1).setCustomView(tab2);
        mTab.getTabAt(2).setCustomView(tab3);
        mTab.getTabAt(3).setCustomView(tab4);*/


    }
   /* public View getCustomView(int imgres,String text){
        View root = LayoutInflater.from(this).inflate(R.layout.tabs, null);
        ImageView img = root.findViewById(R.id.image);
        TextView title = root.findViewById(R.id.text);
        img.setImageResource(imgres);
        title.setText(text);
        return  root;



    }
*/

    private void initView() {
        mVapger = (ViewPager) findViewById(R.id.vapger);
        mTab = (TabLayout) findViewById(R.id.tab);
    }

    private void initFragment() {
        fragments = new ArrayList<>();
        fragments.add(new ShouFra());
        fragments.add(new KeChengFra());
        fragments.add(new YueKeFra());
        fragments.add(new GeRenFra());
        FraPagerAdapter fraPagerAdapter = new FraPagerAdapter(getSupportFragmentManager(), fragments);
        mVapger.setAdapter(fraPagerAdapter);
        mTab.setupWithViewPager(mVapger);

        mTab.getTabAt(0).setText("首页").setIcon(R.drawable.one_selector);
        mTab.getTabAt(1).setText("课程").setIcon(R.drawable.one_selector);
        mTab.getTabAt(2).setText("约课记录").setIcon(R.drawable.one_selector);
        mTab.getTabAt(3).setText("个人").setIcon(R.drawable.one_selector);


    }

    private void initTab() {
        strings = new ArrayList<>();
        strings.add("首页");
        strings.add("课程");
        strings.add("约课记录");
        strings.add("个人");
    }
}
