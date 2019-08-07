package com.newchar.devnews;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;

import com.newchar.supportlibrary.router.NavRouter;

/**
 * @author wenliqiang@100tal.com
 * date            2019-07-16
 * @since 当前版本描述，
 * @since 迭代版本描述
 */
public class App extends Application {

    private static final Handler mGlobalHandler = new Handler();

    @Override
    public void onCreate() {
        Looper.myQueue().addIdleHandler(mAppInitHandler);
        super.onCreate();
        NavRouter.initialization(App.this);

    }


    private final MessageQueue.IdleHandler mAppInitHandler = () -> {

        return false;
    };

}
