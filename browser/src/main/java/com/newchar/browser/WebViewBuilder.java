package com.newchar.browser;

import android.annotation.SuppressLint;
import android.webkit.WebSettings;
import android.webkit.WebView;

/**
 * @author wenliqiang
 * date 2020/6/23
 * @since 当前版本，（以及描述）
 * @since 迭代版本，（以及描述）
 */
public class WebViewBuilder {

    private WebView mWebView;
    public WebViewBuilder(WebView host) {
        mWebView = host;
    }

    public static void defaultWebSettings(WebSettings webSettings) {
        webSettings.setSupportZoom(true);
        webSettings.setUseWideViewPort(true);
        javaScriptEnabled(webSettings, true);
        webSettings.setDomStorageEnabled(true);//设置适应Html5 //重点是这个设置
        webSettings.setBlockNetworkImage(false);
        webSettings.setDisplayZoomControls(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setRenderPriority(WebSettings.RenderPriority.HIGH);
    }


    /**
     * 设置是否能够解析Javascript
     */
    @SuppressLint("SetJavaScriptEnabled")
    public static void javaScriptEnabled(WebSettings webSettings, boolean enable) {
        if (webSettings.getJavaScriptEnabled() != enable) {
            webSettings.setJavaScriptEnabled(enable);
        }
    }


}
