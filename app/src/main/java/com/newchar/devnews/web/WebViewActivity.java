package com.newchar.devnews.web;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.newchar.devnews.R;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * @author wenliqiang
 * date 2019-06-11
 * @since 当前版本，（以及描述）
 * @since 迭代版本，（以及描述）
 */
public class WebViewActivity extends AppCompatActivity {

    public static final String URL = "url";

    private WebView mWebView;

    /**
     * 当前页面的浏览的url
     */
    private String url;

    public static void actionLaunch(Context context, String url) {
        Intent intent = new Intent(context.getApplicationContext(), WebViewActivity.class);
        intent.putExtra(URL, url);
        ActivityCompat.startActivity(context, intent, null);
    }

    private void handleReceiveData(Intent intent) {
        if (intent != null) {
            url = intent.getStringExtra(URL);
        }
    }


    private void loadWebUrl(String url) {
        try {
            mWebView.loadUrl(URLDecoder.decode(url, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        handleReceiveData(getIntent());
        inflateWebView();
        initWebSetting(mWebView.getSettings());
        loadWebUrl(url);
    }

    @SuppressLint("SetJavaScriptEnabled")
    private void initWebSetting(WebSettings webSettings) {
        webSettings.setJavaScriptEnabled(true);//设置能够解析Javascript
        webSettings.setDomStorageEnabled(true);//设置适应Html5 //重点是这个设置
        webSettings.setBlockNetworkImage(false);
        webSettings.setDisplayZoomControls(false);

        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);
//        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);

    }

    private WebView createWebView() {
        WebView webView = new WebView(getApplicationContext());
        webView.setWebChromeClient(createWebChromeClient());
        webView.setWebViewClient(createWebViewClient());
        return webView;
    }

    private WebViewClient createWebViewClient() {
        return new NewCharWebViewClient();
    }

    private WebChromeClient createWebChromeClient() {
        return new NewCharWebChromeClient();
    }

    private void inflateWebView() {
        FrameLayout flWebViewContainer = findViewById(R.id.flWebViewContainer);
        if (flWebViewContainer.getChildCount() > 0) {
            mWebView = (WebView) flWebViewContainer.getChildAt(0);
        } else {
            mWebView = createWebView();
            flWebViewContainer.addView(mWebView);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mWebView != null) {
            mWebView.onResume();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mWebView != null) {
            mWebView.onPause();
        }
    }

    @Override
    public void onBackPressed() {
        if (mWebView != null && mWebView.canGoBack()) {
            mWebView.goBack();
            return;
        }
        super.onBackPressed();
    }

    @Override
    protected void onDestroy() {
        destroyWebView();
        super.onDestroy();
    }

    private void destroyWebView() {
        if (mWebView != null) {
            mWebView.stopLoading();                          //停止加载
            mWebView.clearCache(true);        //清除缓存
            mWebView.clearHistory();                        //清除历史
            mWebView.removeAllViews();                      //移除webview上子view
            mWebView.destroy();
            ViewParent parentView = mWebView.getParent();
            ((ViewGroup) parentView).removeAllViews();
            mWebView = null;
        }
    }

}
