package com.jiyun.meishi;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.jiyun.bean.SearchBean;
import com.jiyun.bean.SearchBeanDao;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SearchActivity extends AppCompatActivity {
    private ImageView mBackSearch;
    private EditText mEditSearch;
    private ImageView mClearSearch;
    private FlowLayout mFlowSearch;
    private RecyclerView mRecySearch;
    private TextView mTvSearch;
    private SearchBeanDao searchBeanDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
       initView();
        uptateData();
    }

    private void uptateData() {
        List<SearchBean> searchBeans = searchBeanDao.loadAll();
        mFlowSearch.removeAllViews();
        if (searchBeans!=null && searchBeans.size()>0){
            Collections.sort(searchBeans, new Comparator<SearchBean>() {
                @Override
                public int compare(SearchBean o1, SearchBean o2) {
                    return (int)(o2.getTime() - o1.getTime());
                }
            });
            for (int i = 0; i < searchBeans.size(); i++) {
                TextView inflate = (TextView) LayoutInflater.from(this).inflate(R.layout.item_label, null);
                inflate.setText(searchBeans.get(i).getKerword());
                mFlowSearch.addView(inflate);
            }
        }
    }

    private void initView() {
        mBackSearch = (ImageView) findViewById(R.id.search_back);
        mEditSearch = (EditText) findViewById(R.id.search_edit);
        mClearSearch = (ImageView) findViewById(R.id.search_clear);
        mFlowSearch = (FlowLayout) findViewById(R.id.search_flow);
        mRecySearch = (RecyclerView) findViewById(R.id.search_recy);
        searchBeanDao = BaseApp.getInstance().getDaoSession().getSearchBeanDao();

        mEditSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (TextUtils.isEmpty(s)) {
                    mFlowSearch.setVisibility(View.VISIBLE);
                    mRecySearch.setVisibility(View.GONE);
                } else {
                    mRecySearch.setVisibility(View.VISIBLE);
                    mFlowSearch.setVisibility(View.GONE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        mTvSearch = (TextView) findViewById(R.id.search_tv);
        mTvSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String keyword = mEditSearch.getText().toString();
                long time = System.currentTimeMillis();
                searchBeanDao.insertOrReplace(new SearchBean(keyword,time));
                uptateData();
            }
        });

        mClearSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchBeanDao.deleteAll();
                uptateData();
            }
        });
    }


}
