package com.newchar.devnews;

import android.os.Bundle;
import android.view.ViewParent;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * @author wenliqiang
 * date 2019-06-11
 * @since 当前版本，（以及描述）
 * @since 迭代版本，（以及描述）
 */
public class WebViewActivity extends AppCompatActivity {

    private WebView mWebView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        inflateWebView();
    }

    private WebView createWebView() {
        WebView webView = new WebView(getApplicationContext());
        webView.setWebViewClient(createWebViewClient());
        return webView;
    }

    private WebViewClient createWebViewClient() {
        return new NewCharWebViewClient();
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
    protected void onPause() {
        super.onPause();
        if (mWebView != null) {
            mWebView.onPause();
        }
    }

    @Override
    protected void onDestroy() {
        destroyWebView();
        super.onDestroy();
    }

    private void destroyWebView() {
        if (mWebView != null) {
            ViewParent parentView = mWebView.getParent();
            if (parentView instanceof FrameLayout) {
                ((FrameLayout) parentView).removeAllViews();
            }
            mWebView.destroy();
            mWebView = null;
        }
    }


}
