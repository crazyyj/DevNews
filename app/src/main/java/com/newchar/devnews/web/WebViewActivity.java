package com.newchar.devnews.web;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.ViewParent;
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
        webSettings.setDisplayZoomControls(true);
        webSettings.setSupportZoom(true);

        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);
//        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
    }

    private WebView createWebView() {
        WebView webView = WebViewFactory.getInstance().getWebView(getApplicationContext());
        webView.setWebChromeClient(createWebChromeClient());
        webView.setWebViewClient(createWebViewClient());
        return webView;
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

    };

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
            mWebView.clearCache(true);        //清除缓存
            mWebView.clearHistory();                        //清除历史
//            mWebView.removeAllViews();                      //移除webview上子view
            mWebView.destroy();
            ViewParent parentView = mWebView.getParent();
            ((ViewGroup) parentView).removeAllViews();
            mWebView = null;
        }
    }

}
