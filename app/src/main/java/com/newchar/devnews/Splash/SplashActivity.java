package com.newchar.devnews.Splash;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.newchar.devnews.R;
import com.newchar.supportlibrary.router.RouterExecuter;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author wenliqiang@100tal.com
 * date            2019-07-16
 * @since 闪屏页面，负责首屏
 * @since 迭代版本描述
 */
public class SplashActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.btnClickGoMain)
    public void onViewClicked() {
        RouterExecuter.goMainActivity();
    }

}