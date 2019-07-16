package com.newchar.supportlibrary.router;

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
                .navigation();
    }



}
