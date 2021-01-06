package com.newchar.devnews.post.detail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.FrameLayout;

import androidx.annotation.Nullable;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.newchar.browser.WebViewBuilder;
import com.newchar.browser.WebViewFactory;
import com.newchar.devnews.R;
import com.newchar.devnews.base.BaseActivity;
import com.newchar.oscrepository.entry.OSCPostDetail;
import com.newchar.supportlibrary.router.ARouterPath;

/**
 * @author wenliqiang
 * date 2020/6/22
 * @since 开源中国，帖子详情
 * @since 迭代版本，（以及描述）
 */
@Route(path = ARouterPath.ACTIVITY_POST_DETAIL)
public class OSCPostDetailActivity extends BaseActivity implements View {

    /**
     * 帖子id
     */
    private String postId;
    public static final String DATA_POST_ID = "postId";
    private WebView postContentWebView;
    private FrameLayout webViewContainer;

    @Override
    protected void initWidgets() {
        webViewContainer = findViewById(R.id.webViewContainer);
        this.postContentWebView = WebViewFactory.getInstance().getWebView();
        WebViewBuilder.defaultWebSettings(postContentWebView.getSettings());
    }

    @Override
    protected void handlerIntent(Intent newIntent, @Nullable Bundle savedInstanceState) {
        super.handlerIntent(newIntent, savedInstanceState);
        postId = newIntent.getStringExtra(DATA_POST_ID);
    }

    @Override
    protected void onResume() {
        super.onResume();
        WebViewBuilder.javaScriptEnabled(postContentWebView.getSettings(), true);
    }

    @Override
    protected void onPause() {
        super.onPause();
        WebViewBuilder.javaScriptEnabled(postContentWebView.getSettings(), false);
    }

    @Override
    protected void initData() {
        Presenter presenter = new Presenter(this);
        presenter.requestOSCPostDetail(postId);
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_osc_post_detail;
    }

    @Override
    public void onPostDetailResponse(OSCPostDetail postDetail) {
        runOnUiThread(() -> {
            postContentWebView.loadUrl(postDetail.getUrl());
            webViewContainer.addView(postContentWebView);
        });
    }

    @Override
    public Context obtainContext() {
        return null;
    }

    @Override
    public void showPagePrompt(String prompt) {

    }
}
