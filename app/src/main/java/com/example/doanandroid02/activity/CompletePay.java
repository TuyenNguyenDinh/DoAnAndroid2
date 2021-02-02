package com.example.doanandroid02.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.doanandroid02.R;

import java.util.Timer;
import java.util.TimerTask;

public class CompletePay extends AppCompatActivity {
    ProgressBar progressBar;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complete_pay);
        textView = findViewById(R.id.textThanks);
        progressBar = findViewById(R.id.pbRedirect);
        progressBar.setIndeterminate(true);

        setHideActionbar();

        progressBar.setVisibility(View.VISIBLE);

        textView.setText("Quý khách đã đặt hàng thành công! Sản phẩm của Quý khách sẽ được chuyển đến Địa có trong phần Thông tin Khách hàng của chúng Tôi sau thời gian 2 đến 3 ngày, tính từ thời điểm này." +
                " Nhân viên giao hàng sẽ liên hệ với Quý khách qua Số Điện thoại trước khi giao hàng 24 tiếng"
                + "Hệ thống sẽ quay về trang chủ sau 5s. " + "Cám ơn Quý khách đã sử dụng Sản phẩm của Công ty chúng Tôi!");
        int timeout = 5000;
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                finish();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        }, timeout);
    }


    private void setHideActionbar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
    }
}