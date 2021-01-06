package com.newchar.devnews;

import android.app.Application;
import android.content.Context;

import com.newchar.devnews.util.ContextHolder;
import com.newchar.devnews.util.drawable.ShapeBuilder;
import com.newchar.supportlibrary.router.NavRouter;

/**
 * @author wenliqiang@100tal.com
 * date            2019-07-16
 * @since 当前版本描述，
 * @since 迭代版本描述
 */
public class App extends Application {

//    private static final Handler mGlobalHandler = new Handler();


    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        ContextHolder.initialize(base);
    }

    @Override
    public void onCreate() {
//        Looper.myQueue().addIdleHandler(mAppInitHandler);
        ShapeBuilder.init(this);
        super.onCreate();
        NavRouter.initialization(App.this);
    }


//    private final MessageQueue.IdleHandler mAppInitHandler = () -> {
//        ShapeBuilder.init(this);
//        return false;
//    };

}
