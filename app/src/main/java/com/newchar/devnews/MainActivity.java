package com.newchar.devnews;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.newchar.devnews.http.MURL;
import com.newchar.devnews.web.WebViewActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WebViewActivity.actionLaunch(this, MURL.getOSCLoginAUthUrl());

    }


}
