package com.newchar.devnews;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * @author wenliqiang
 * date 2019-06-11
 * @since 当前版本，（以及描述）
 * @since 迭代版本，（以及描述）
 */
public class WebViewActivity extends AppCompatActivity {

    public static final String WEB_URL = "url";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final String url = getIntent().getStringExtra(WEB_URL);

    }


}
