package com.newchar.devnews.blog;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.newchar.devnews.R;
import com.newchar.devnews.base.BaseActivity;
import com.newchar.devnews.http.HttpRequest;
import com.newchar.devnews.http.JsonCompat;
import com.newchar.devnews.http.params.OSCParamsBuilder;
import com.newchar.oscrepository.entry.OSCBlogDetail;
import com.newchar.oscrepository.entry.OSCHttpError;
import com.newchar.supportlibrary.router.ARouterPath;

import java.io.IOException;
import java.util.Map;

import butterknife.BindView;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * @author wenliqiang@100tal.com
 * date            2020/6/26
 * @since 当前版本描述，
 * @since 迭代版本描述
 */
@Route(path = ARouterPath.ACTIVITY_BLOG_DETAIL)
public class OSCBlogDetailActivity extends BaseActivity {

    @BindView(R.id.webView)
    WebView webView;

    private int id;

    @Override
    protected void initWidgets() {

    }

    private void requestOSCBlogDetail() {
        Map<String, Object> params = OSCParamsBuilder.buildOSCBlogDetailParams(id);
        HttpRequest.requestOSCBlogDetail(params, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final ResponseBody body = response.body();
                if (response.isSuccessful() && body != null) {
                    String bodyJson = null;
                    try {
                        bodyJson = body.string();
                        Log.e(" TAG ", bodyJson);
                        OSCBlogDetail blogDetail = JsonCompat.parse(OSCBlogDetail.class, bodyJson);
                        new Handler(Looper.getMainLooper()).post(() -> {
                            webView.loadUrl(blogDetail.getUrl());
                        });
                    } catch (IOException e) {
                        e.printStackTrace();
                        if (!TextUtils.isEmpty(bodyJson)) {
                            String finalBodyJson = bodyJson;
                            new Handler(Looper.getMainLooper()).post(() -> {
                                OSCHttpError blogDetail = JsonCompat.parse(OSCHttpError.class, finalBodyJson);
                                Toast.makeText(OSCBlogDetailActivity.this, blogDetail.getError_description(), Toast.LENGTH_SHORT).show();
                            });
                        }
                    }
                }
            }
        });
    }

    @Override
    protected void initData() {
        requestOSCBlogDetail();
    }

    @Override
    protected void handlerIntent(Intent newIntent, @Nullable Bundle savedInstanceState) {
        super.handlerIntent(newIntent, savedInstanceState);
        id = newIntent.getIntExtra("id", 0);
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_osc_blog_detail;
    }


}
