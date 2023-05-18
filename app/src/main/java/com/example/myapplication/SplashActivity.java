package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;


public class SplashActivity extends AppCompatActivity implements View.OnClickListener {
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide(); // actionBar 숨기기
        setContentView(R.layout.activity_splash);

        handler = new Handler(Looper.getMainLooper());
    }

    @Override
    protected void onStart() {
        super.onStart();

        // Splash Screen 화면이 시작되고, 딜레이를 준 후에 run() 안의 코드를 동작한다.
        // 1s = 1000ms
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                SplashActivity.this.beginMainActivity();
            }
        }, 2000);	// 2초 뒤에 run() 안의 동작을 함
    }

    @Override
    public void onClick(View view) {
        beginMainActivity();
    }

    private void beginMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}