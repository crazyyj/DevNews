package com.newchar.devnews.splash;

import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;

import com.newchar.devnews.R;
import com.newchar.devnews.base.BaseActivity;
import com.newchar.devnews.dao.LoginRecordDAO;
import com.newchar.devnews.http.entry.osc.OSCLoginCodeTokenResult;
import com.newchar.supportlibrary.db.entry.LoginRecord;
import com.newchar.supportlibrary.router.RouterExecute;

/**
 * @author wenliqiang@100tal.com
 * date            2019-07-16
 * @since 闪屏页面，负责首屏
 * @since 迭代版本描述
 */
public class SplashActivity extends BaseActivity {

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
    private final Handler mHandler = new Handler(callback);

    @Override
    protected void initWidgets() {
    }

    @Override
    protected void initData() {
        final LoginRecord loginRecord = LoginRecordDAO.getLastOSCLoginRecord();
        if (loginRecord == null) {
            mHandler.sendEmptyMessageDelayed(MSG_JUMP_LOGIN, 1000L);
            Log.e(TAG, " 从没登陆过  ");
        } else {
            final long l = loginRecord.getExpires_in() * 1000;
            final long loginTime = loginRecord.getLoginTime();
            final long l1 = System.currentTimeMillis();
            Log.e(TAG, " getExpires_in = " +l  + " loginTime = " + loginTime + " currentTimeMillis = " +  l1 );
            if (!TextUtils.isEmpty(loginRecord.getAccess_token()) && loginRecord.isExpire()) {
                //还没过期，去登陆，然后去首页
                OSCLoginCodeTokenResult.getInstance().setAccess_token(loginRecord.getAccess_token());
                OSCLoginCodeTokenResult.getInstance().setExpires_in(loginRecord.getExpires_in());
                mHandler.sendEmptyMessageDelayed(MSG_JUMP_MAIN, 1000L);
                Log.e(TAG, " 没过期");
            } else {
                //过期了，刷新token，进入首页
                mHandler.sendEmptyMessageDelayed(MSG_JUMP_LOGIN, 1000L);
                Log.e(TAG, " 过期了  ");
            }
        }
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

}