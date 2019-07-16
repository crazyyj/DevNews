package com.newchar.devnews;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.newchar.supportlibrary.router.ARouterPath;

@Route(path = ARouterPath.ACTIVITY_MAIN)
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        WebViewActivity.actionLaunch(this, MURL.getOSCLoginAUthUrl());

    }


}
