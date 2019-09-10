package com.newchar.supportlibrary.router;

import android.content.Intent;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * @author wenliqiang@100tal.com
 * date            2019-07-16
 * @since 全局路由跳转入口
 * @since 迭代版本描述
 */
public class RouterExecute {

    public static void goMainActivity() {
        ARouter.getInstance().build(ARouterPath.ACTIVITY_MAIN)
                .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK)
                .navigation();
    }

    public static void goLoginActivity() {
        ARouter.getInstance().build(ARouterPath.ACTIVITY_LOGIN)
                .navigation();
    }



}
