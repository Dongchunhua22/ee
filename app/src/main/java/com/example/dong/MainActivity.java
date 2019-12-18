package com.example.dong;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTv;
    private Toolbar mToo;
    private RelativeLayout mRela;
    private TabLayout mTab;
    private ShouFragment shouFragment;
    private XaizaiFragment xaizaiFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initFragment();
        initTab();

    }
    //给TabLayout设置数据，监听切换fragment
    private void initTab() {
        mTab.addTab(mTab.newTab().setText("首页"));
        mTab.addTab(mTab.newTab().setText("下载"));
        mTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()){
                    case 0:
                        getSupportFragmentManager().beginTransaction().show(shouFragment).hide(xaizaiFragment).commit();
                        break;
                    case 1:
                        getSupportFragmentManager().beginTransaction().show(xaizaiFragment).hide(shouFragment).commit();
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
    //开启fragment的事务
    private void initFragment() {
        shouFragment = new ShouFragment();
        xaizaiFragment = new XaizaiFragment();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction tran = fm.beginTransaction();
        tran.add(R.id.rela, shouFragment);
        tran.add(R.id.rela, xaizaiFragment);
        tran.show(shouFragment).hide(xaizaiFragment);
        tran.commit();
    }

    private void initView() {
        mTv = (TextView) findViewById(R.id.tv);
        mToo = (Toolbar) findViewById(R.id.too);
        mRela = (RelativeLayout) findViewById(R.id.rela);
        mTab = (TabLayout) findViewById(R.id.tab);
    }
}
