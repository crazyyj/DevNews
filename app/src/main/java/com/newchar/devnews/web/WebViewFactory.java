package com.newchar.devnews.web;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.os.Looper;
import android.os.MessageQueue;
import android.webkit.WebView;

import java.lang.ref.WeakReference;
import java.util.Stack;

/**
 * @author wenliqiang wenliqiang@100tal.com
 * date            2019-06-18
 * @since 负责预加载WebView，
 * @since 迭代版本描述
 */
public class WebViewFactory {

    private static final int CACHED_WEBVIEW_MAX_NUM = 3;

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

    public WebView getWebView(Context context) {
        if (mWebViewPreStack == null || mWebViewPreStack.isEmpty()) {
            return create(context);
        }
        return mWebViewPreStack.pop();
    }

    /**
     * 生产WebView
     */
    public void preLoadWebView(Context context) {
        appContext = context.getApplicationContext();
        Looper.myQueue().addIdleHandler(idleHandler);
    }

    private WebView create(Context context) {
        return new WebView(context);
    }

    private final MessageQueue.IdleHandler idleHandler = new MessageQueue.IdleHandler() {
        @Override
        public boolean queueIdle() {
            mWebViewPreStack.push(create(appContext));
            return mWebViewPreStack.size() > CACHED_WEBVIEW_MAX_NUM;
        }
    };

}
