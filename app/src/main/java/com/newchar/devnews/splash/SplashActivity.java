package com.newchar.devnews.splash;

import android.content.Context;
import android.os.Handler;

import com.newchar.devnews.R;
import com.newchar.devnews.base.BaseActivity;
import com.newchar.supportlibrary.router.RouterExecute;

/**
 * @author wenliqiang@100tal.com
 * date            2019-07-16
 * @since 闪屏页面，负责首屏
 * @since 迭代版本描述
 */
public class SplashActivity extends BaseActivity {

    private static final int MSG_JUMP_MAIN = 1;

    private final Handler.Callback callback = msg -> {
        switch (msg.what) {
            case MSG_JUMP_MAIN:
                RouterExecute.goLoginActivity();
                finish();
                break;
            default:
                break;
        }
        return true;
    };
    private final Handler mHandler = new Handler(callback);

    @Override
    protected void initWidgets() {
        mHandler.sendEmptyMessageDelayed(MSG_JUMP_MAIN, 3000L);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_splash;
    }

    @Override
    public void onBackPressed() {
        mHandler.removeCallbacksAndMessages(null);//点了返回不出发跳转到首页
        super.onBackPressed();
    }

    @Override
    public void onPageLoading() {

    }

    @Override
    public void onPageError() {

    }

    @Override
    public Context obtainContext() {
        return this;
    }
}