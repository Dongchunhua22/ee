package com.example.dong;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {
    //https://www.wanandroid.com/project/list/1/json?cid=294
    String str="https://www.wanandroid.com/project/";
    @GET("list/1/json?cid=294")
    Observable<Bean>getData();
}
