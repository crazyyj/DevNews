package com.newchar.devnews.web;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.PixelFormat;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
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

import com.alibaba.android.arouter.facade.annotation.Route;
import com.newchar.devnews.R;
import com.newchar.devnews.util.constant.OSCField;
import com.newchar.supportlibrary.router.ARouterPath;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.List;

/**
 * @author wenliqiang
 * date 2019-06-11
 * @since 当前版本，（以及描述）
 * @since 迭代版本，（以及描述）
 */
@Route(path = ARouterPath.ACTIVITY_BROWSER)
public class WebViewActivity extends AppCompatActivity {

    private static final String URL = "url";
    public static final int REQUEST_CODE = 101;

    public static final int RESULT_CODE_FOR_OSC_LOGIN = 201;
    private WebView mWebView;

    /**
     * 当前页面的浏览的url
     */
    private String url;

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
     * 设置是否能够解析Javascript
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
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            Log.e("WEBVIew", "onPageStarted " + url);
            parseOSCLoginCode(url);
//            if (parseOSCLoginCode(url)) {
//                return;
//            }

        }



//        @Override
//        public void onLoadResource(WebView view, String url) {
//            if (!TextUtils.isEmpty(url) || url.endsWith(".png") || url.endsWith(".ico") || url.endsWith(".jpg")) {
//                view.getSettings().setBlockNetworkImage(false);
//            }
//            super.onLoadResource(view, url);
//        }



        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            Log.e("WEBVIew", "shouldOverrideUrlLoading " + request.toString());
            String overrideUrl;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                overrideUrl = request.getUrl().toString();
            } else {
                overrideUrl = request.toString();
            }
            if (parseOSCLoginCode(overrideUrl)) {
                return true;
            }

            if (isShouldOverrideUrl(overrideUrl)) {
                loadWebUrl(overrideUrl);
                return true;
            }
            return super.shouldOverrideUrlLoading(view, request);
        }

        private String isOSCLoginCallbackUrl(String url) {
            String code = null;

            if (!TextUtils.isEmpty(url)) {
                final Uri uri = Uri.parse(url);
                if (url.startsWith(OSCField.URL.BASE_OSC_URL) && TextUtils.isEmpty(code = uri.getQueryParameter(OSCField.Params.CODE))) {
                    return code;
                }
//                System.out.println("aaa  getFragment___ " + uri.getFragment());
//                System.out.println("aaa  getUserInfo___ " + uri.getUserInfo());
//                System.out.println("aaa  toString___ " + uri.toString());
//                System.out.println("aaa  getEncodedUserInfo___ "  + uri.getEncodedUserInfo());
//                System.out.println("aaa  getEncodedFragment___ " + uri.getEncodedFragment());
//                System.out.println("aaa  getSchemeSpecificPart___ " + uri.getSchemeSpecificPart());
//                System.out.println("aaa  getPort___ " + uri.getPort());
//                System.out.println("aaa  getHost___ " + uri.getHost());
//                System.out.println("aaa  getEncodedAuthority___ " + uri.getEncodedAuthority());
//                System.out.println("aaa  getAuthority___ " + uri.getAuthority());
//                System.out.println("aaa  getQuery___ " + uri.getQuery());
//                System.out.println("aaa  getLastPathSegment___" + uri.getLastPathSegment());
//                System.out.println("aaa  getPath___" + uri.getPath());
//                System.out.println("aaa  getPathSegments" + uri.getPathSegments().toString());
//                System.out.println("aaa  getScheme___" + uri.getScheme());
//                System.out.println("aaa  getEncodedSchemeSpecificPart___" + uri.getEncodedSchemeSpecificPart());
//                return false;
            }
            return code;
        }

        private boolean parseOSCLoginCode(String url) {
            final String code = isOSCLoginCallbackUrl(url);
            if (!TextUtils.isEmpty(code)) {
//                final String code = collectOAuthLoginCode(url);
                Intent intent = new Intent();
                intent.putExtra("oscLoginCode", code);
                setResult(WebViewActivity.RESULT_CODE_FOR_OSC_LOGIN, intent);
                finish();
                return true;
            }
            return false;
        }

        private String collectOAuthLoginCode(String url) {
            return Uri.parse(url).getQueryParameter("code");
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
            Log.e("newlq", "" + newProgress);
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

    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mWebView != null) {
            mWebView.onPause();
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        if (mWebView != null) {
            javaScriptEnabled(mWebView.getSettings(), true);
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
            ((ViewGroup) parentView).removeView(mWebView);
            mWebView.destroy();
            mWebView = null;
        }
    }

}
