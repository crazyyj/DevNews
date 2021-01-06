package com.newchar.supportlibrary.router;

/**
 * @author wenliqiang@100tal.com
 * date            2019-07-16
 * @since ARouter 类注解，path 定义类
 * @since 迭代版本描述
 */
public interface ARouterPath {

    String ACTIVITY_SPLASH = "/common/splash";

    /**
     * 打开首页
     */
    String ACTIVITY_MAIN = "/common/main";

    /**
     * 打开登陆页
     */
    String ACTIVITY_LOGIN = "/common/login";

    /**
     * 帖子详情
     */
    String ACTIVITY_POST_DETAIL = "/common/postDetail";

    /**
     * WebView
     */
    String ACTIVITY_BROWSER = "/common/webView";

    /**
     * osc 博客详情
     */
    String ACTIVITY_BLOG_DETAIL = "/common/blogDetail";

}
