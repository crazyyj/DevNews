package com.newchar.devnews.splash;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.widget.Toast;

import com.newchar.devnews.R;
import com.newchar.devnews.base.BaseActivity;
import com.newchar.devnews.dao.LoginRecordDAO;
import com.newchar.supportlibrary.db.BaseSQLiteHelper;
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
        //TODO 上次的登陆态
        final LoginRecord loginRecord = LoginRecordDAO.getLoginRecord();
        if (SystemClock.uptimeMillis() < loginRecord.getExpires_in() + loginRecord.getLoginTime()) {
            //还没过期，去登陆，然后去首页
            mHandler.sendEmptyMessageDelayed(MSG_JUMP_MAIN, 1000L);
            Log.e(TAG, " 没过期了");
        } else {
            //过期了，给出提示，打开登陆页面
            mHandler.sendEmptyMessageDelayed(MSG_JUMP_LOGIN, 1000L);
            Log.e(TAG, " 过期了。cursor.getCount() ");
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