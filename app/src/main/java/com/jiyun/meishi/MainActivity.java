package com.jiyun.meishi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initTimer();
    }

    private void initTimer() {
        timer = new Timer();
       TimerTask timerTask= new TimerTask() {
            @Override
            public void run() {
                MainActivity.this.startActivity(new Intent(MainActivity.this,HomeActivity.class));
                cancel();

            }
        };

        timer.schedule(timerTask,3000,3000);




    }
}
