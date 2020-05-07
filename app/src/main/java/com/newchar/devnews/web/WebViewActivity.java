package com.newchar.devnews.web;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.webkit.SslErrorHandler;
import android.webkit.URLUtil;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.newchar.devnews.R;
import com.newchar.devnews.http.MURL;

import java.io.IOException;
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
    public static final int REQUEST_CODE = 101;

    public static final int RESULT_CODE_FOR_OSC_LOGIN = 201;
    private WebView mWebView;

    /**
     * 当前页面的浏览的url
     */
    private String url;

    public static void actionLaunch(Activity context, String url) {
        Intent intent = new Intent(context.getApplicationContext(), WebViewActivity.class);
        intent.putExtra(URL, url);
        ActivityCompat.startActivityForResult(context, intent, REQUEST_CODE, null);
    }

    private void handleReceiveData(Intent intent) {
        if (intent != null) {
            url = intent.getStringExtra(URL);
        }
    }


    private void loadWebUrl(String url) {
        try {
            mWebView.loadUrl(URLDecoder.decode(url, "UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        getWindow().setFormat(PixelFormat.TRANSLUCENT);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE
                | WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED);
        initView();
        handleReceiveData(getIntent());
        inflateWebView();
        initWebSetting(mWebView.getSettings());
        loadWebUrl(url);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        handleReceiveData(intent);
        loadWebUrl(url);

        setIntent(intent);
    }

    private void initView() {
        findViewById(R.id.ivIncludeGlobalBack).setOnClickListener(v -> finish());
    }

    @SuppressLint("SetJavaScriptEnabled")
    private void initWebSetting(WebSettings webSettings) {
        webSettings.setSupportZoom(true);
        webSettings.setUseWideViewPort(true);
        javaScriptEnabled(webSettings, true);
        webSettings.setDomStorageEnabled(true);//设置适应Html5 //重点是这个设置
        webSettings.setBlockNetworkImage(false);
        webSettings.setDisplayZoomControls(true);
        webSettings.setLoadWithOverviewMode(true);

        webSettings.setRenderPriority(WebSettings.RenderPriority.HIGH);
    }


    private WebView createWebView() {
        WebView webView = WebViewFactory.getInstance().getWebView();
        webView.setWebChromeClient(createWebChromeClient());
        webView.setWebViewClient(createWebViewClient());
        return webView;
    }

    /**
     * 设置能够解析Javascript
     */
    @SuppressLint("SetJavaScriptEnabled")
    private void javaScriptEnabled(WebSettings webSettings, boolean enable) {
        if (webSettings.getJavaScriptEnabled() != enable) {
            webSettings.setJavaScriptEnabled(enable);
        }
    }

    private WebViewClient createWebViewClient() {
        return mWebViewClient;
    }

    private WebChromeClient createWebChromeClient() {
        return mWebChromeClient;
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

    private final WebViewClient mWebViewClient = new WebViewClient() {
//        @Override
//        public void onPageStarted(WebView view, String url, Bitmap favicon) {
//            super.onPageStarted(view, url, favicon);
//            view.getSettings().setBlockNetworkImage(true);
//        }
//
//        @Override
//        public void onLoadResource(WebView view, String url) {
//            if (!TextUtils.isEmpty(url) || url.endsWith(".png") || url.endsWith(".ico") || url.endsWith(".jpg")) {
//                view.getSettings().setBlockNetworkImage(false);
//            }
//            super.onLoadResource(view, url);
//        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            String overrideUrl;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                overrideUrl = request.getUrl().toString();
            } else {
                overrideUrl = request.toString();
            }
            if (isOSCLoginCallbackUrl(overrideUrl)) {
                final String code = collectOAuthLoginCode(overrideUrl);
                Intent intent = new Intent();
                intent.putExtra("oscLoginCode", code);
                setResult(WebViewActivity.RESULT_CODE_FOR_OSC_LOGIN, intent);
                finish();
                return true;
            }
            if (isShouldOverrideUrl(overrideUrl)) {
                loadWebUrl(overrideUrl);
                return true;
            }
            return super.shouldOverrideUrlLoading(view, request);
        }

        private boolean isOSCLoginCallbackUrl(String url) {
            return URLUtil.isAboutUrl(url);
        }

        private String collectOAuthLoginCode(String url) {
            return MURL.obtainGetUrlParams(url).get("code");
        }

        /**
         * 是否允许覆盖当前页面链接，请求
         * @param overrideUrl   覆盖的链接
         * @return true 允许，false 不允许
         */
        private boolean isShouldOverrideUrl(String overrideUrl) {
            return !TextUtils.isEmpty(overrideUrl) && !overrideUrl.startsWith("about:blank");
        }

        @Override
        public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
//        super.onReceivedSslError(view, handler, error);
            handler.proceed();
        }

    };

    private final WebChromeClient mWebChromeClient = new WebChromeClient() {
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            super.onProgressChanged(view, newProgress);
        }
    };

    @Override
    protected void onResume() {
        super.onResume();
        if (mWebView != null) {
            mWebView.onResume();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (mWebView != null) {
            javaScriptEnabled(mWebView.getSettings(), true);
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
    protected void onStop() {
        super.onStop();
        if (mWebView != null) {
            //屏蔽js动画后台运行耗电
            javaScriptEnabled(mWebView.getSettings(), false);
        }
    }

    private boolean webViewBackPressed() {
        boolean isCan = mWebView != null && mWebView.canGoBack();
        if (isCan) {
            mWebView.goBack();
        }
        return isCan;
    }

    @Override
    public void onBackPressed() {
        if (!webViewBackPressed()) {
            super.onBackPressed();
        }
    }

    @Override
    protected void onDestroy() {
        destroyWebView();
        super.onDestroy();
    }

    private void destroyWebView() {
        if (mWebView != null) {
            mWebView.stopLoading();                          //停止加载
            mWebView.clearCache(true);                      //清除缓存
            mWebView.clearHistory();                        //清除历史
//            mWebView.removeAllViews();                      //移除webview上子view
            ViewParent parentView = mWebView.getParent();
            ((ViewGroup) parentView).removeAllViews();
            mWebView.destroy();
            mWebView = null;
        }
    }

}
