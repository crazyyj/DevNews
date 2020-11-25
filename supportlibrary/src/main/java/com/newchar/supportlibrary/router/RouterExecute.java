package com.newchar.supportlibrary.router;

import android.app.Activity;
import android.content.Intent;

import com.alibaba.android.arouter.launcher.ARouter;

import java.util.ArrayList;

/**
 * @author wenliqiang@100tal.com
 * date            2019-07-16
 * @since 全局路由跳转入口
 * @since 迭代版本描述
 */
public class RouterExecute {

    /**
     * 打开首页
     */
    public static void goMainActivity() {
        ARouter.getInstance().build(ARouterPath.ACTIVITY_MAIN)
                .withFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK)
                .navigation();
    }

    /**
     * 打开选择登陆页
     */
    public static void goLoginActivity() {
        ARouter.getInstance().build(ARouterPath.ACTIVITY_LOGIN)
                .navigation();
    }

    /**
     * 打开WebActivity
     */
    public static void goBrowserActivity(Activity activity,  String url) {
        ARouter.getInstance().build(ARouterPath.ACTIVITY_BROWSER)
                .withString("url", url)
                .navigation(activity, 101);
    }

    /**
     * 打开OSC博客详情页
     */
    public static void goBlogDetailActivity(int id) {
        ARouter.getInstance().build(ARouterPath.ACTIVITY_BLOG_DETAIL)
                .withInt("id", id)
                .navigation();
    }

    /**
     * 打开osc 帖子详情
     */
    public static void goPostDetailActivity(String postID) {
        ARouter.getInstance().build(ARouterPath.ACTIVITY_POST_DETAIL)
                .withString("postId", postID)
                .navigation();
    }



}
