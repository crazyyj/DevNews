package com.newchar.browser;

import android.content.Context;
import android.webkit.WebView;

import java.util.Stack;

/**
 * @author wenliqiang wenliqiang@100tal.com
 * date            2019-06-18
 * @since 负责预加载WebView，
 * @since 迭代版本描述
 */
public class WebViewFactory {

    private static final int CACHED_WEB_VIEW_MAX_NUM = 2;

    /**
     * 全新未用的WebView栈
     */
    private Stack<WebView> mWebViewPreStack = new Stack<>();

    /**
     * App
     */
    private Context appContext;

    public static WebViewFactory getInstance(){
        return Holder.INSTANCE;
    }

    private static class Holder{
        private static final WebViewFactory INSTANCE = new WebViewFactory();
    }

    public WebView getWebView() {
        preCreate(appContext);
        return mWebViewPreStack.pop();
    }

    /**
     * 生产WebView
     */
    void preLoadWebView(Context context) {
        appContext = context;
        preCreate(appContext);
    }

    private WebView create(Context context) {
        return new WebView(context);
    }

    public void destroy() {
        mWebViewPreStack.clear();
    }

    private void preCreate(Context context) {
        while (mWebViewPreStack.size() < CACHED_WEB_VIEW_MAX_NUM) {
            mWebViewPreStack.push(create(context));
        }
    }

}
