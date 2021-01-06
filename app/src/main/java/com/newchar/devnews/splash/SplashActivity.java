package com.newchar.devnews.splash;

import android.content.Context;
import android.os.Handler;

import com.newchar.devnews.R;
import com.newchar.devnews.base.BaseActivity;
import com.newchar.devnews.util.HandlerFactory;
import com.newchar.oscrepository.entry.OSCUserInfoResult;
import com.newchar.supportlibrary.router.RouterExecute;

import static com.newchar.devnews.contract.SplashContract.IPresenter;
import static com.newchar.devnews.contract.SplashContract.IView;

/**
 * @author wenliqiang@100tal.com
 * date            2019-07-16
 * @since 闪屏页面，负责首屏
 * @since 迭代版本描述
 */
public class SplashActivity extends BaseActivity implements IView {

    private static final int MSG_JUMP_MAIN = 1;
    private static final int MSG_JUMP_LOGIN = 2;

    private final Handler.Callback callback = msg -> {
        switch (msg.what) {
            case MSG_JUMP_MAIN:
                RouterExecute.goMainActivity();
                finish();
                break;
            case MSG_JUMP_LOGIN:
                RouterExecute.goLoginActivity();
                finish();
                break;
            default:
                break;
        }
        return true;
    };
    private final Handler mHandler = HandlerFactory.getBackgroundHandler(callback);
    private IPresenter splashPresenter;

    @Override
    protected void initWidgets() {
    }

    @Override
    protected void initData() {
        splashPresenter = new SplashPresenter();
        splashPresenter.attachView(this);
        splashPresenter.getLoginState();
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void onStop() {
        mHandler.removeCallbacksAndMessages(null);//点了返回不触发跳转到首页
        super.onStop();
    }

    @Override
    protected void onRestart() {
        //TODO 查询本地登陆态， 未登陆跳转到登陆页面，已经登陆跳转到首页使用账户数据查询数据，（防止按Home 去设置清理数据， 在这里查询数据相对保险
        super.onRestart();
        mHandler.sendEmptyMessage(MSG_JUMP_MAIN);
    }

    @Override
    public void onDBNotHasLoginRecord() {
//        没有登陆信息，去登陆页面
        mHandler.sendEmptyMessageDelayed(MSG_JUMP_LOGIN, 1000L);
    }

    @Override
    public void onDBHasLoginRecord() {
        mHandler.sendEmptyMessageDelayed(MSG_JUMP_MAIN, 1000L);
    }

    @Override
    public void onDBLoginRecordIsExpire() {
        mHandler.sendEmptyMessageDelayed(MSG_JUMP_LOGIN, 1000L);
    }

    @Override
    public void onRefreshLoginSuccess(OSCUserInfoResult userInfo) {
        mHandler.sendEmptyMessage(MSG_JUMP_MAIN);
    }

    @Override
    public Context obtainContext() {
        return null;
    }

    @Override
    public void showPagePrompt(String prompt) {

    }
}