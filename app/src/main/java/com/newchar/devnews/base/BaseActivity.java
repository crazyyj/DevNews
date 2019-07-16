package com.newchar.devnews.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author wenliqiang@100tal.com
 * date            2019-07-16
 * @since 当前版本描述，
 * @since 迭代版本描述
 */
public class BaseActivity extends AppCompatActivity {

    private Unbinder mButterKnife;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mButterKnife = ButterKnife.bind(this);
    }


    @Override
    protected void onDestroy() {
        if (mButterKnife != null) {
            mButterKnife.unbind();
        }
        super.onDestroy();
    }

}
