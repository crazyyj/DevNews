package com.newchar.supportlibrary.router;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * @author wenliqiang@100tal.com
 * date            2019-07-16
 * @since 当前版本描述，
 * @since 迭代版本描述
 */
public class NavRouter {

    public static void initialization(Application app) {
        if (Utils.isDebug()) {
            ARouter.openLog();
            ARouter.openDebug();
        }
        ARouter.init(app);
    }

    public static void injectActivity(Object activity) {
        ARouter.getInstance().inject(activity);
    }

}
