package com.example.dong;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import org.greenrobot.eventbus.EventBus;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Myservice extends Service {

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
//在服务里下载
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        final OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://alissl.ucdl.pp.uc.cn/fs08/2017/05/02/7/106_64d3e3f76babc7bce131650c1c21350d.apk")
                .get()
                .build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                InputStream in = response.body().byteStream();
                long max = response.body().contentLength();
                FileOutputStream out = new FileOutputStream("/sdcard/1/小花.apk");
                int jindu=0;
                int len=0;
                byte[]bytes=new byte[1024];
                Event event = new Event((int) max, jindu);
                while ((len=in.read(bytes))!=-1){
                    out.write(bytes,0,len);
                    jindu+=len;
                    event.setDangqian(jindu);
                    EventBus.getDefault().post(event);//eventbus传数据
                }

            }
        });
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
