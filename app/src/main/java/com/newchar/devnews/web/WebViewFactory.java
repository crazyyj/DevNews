package com.newchar.devnews.web;

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

    /**
     * 全新未用的WebView栈
     */
    private Stack<WebView> mWebViewPreStack = new Stack<>();

    /**
     * 生产WebView
     */
    public void preLoadWebView() {

    }

    public WebView create(Context context) {
        return new WebView(context);
    }

}
