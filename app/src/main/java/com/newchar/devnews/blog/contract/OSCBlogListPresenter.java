package com.newchar.devnews.blog.contract;

import android.text.TextUtils;

import com.newchar.devnews.base.IBaseView;
import com.newchar.devnews.blog.contract.IOSCBlogListContract;
import com.newchar.devnews.http.HttpRequest;
import com.newchar.devnews.http.JsonCompat;
import com.newchar.devnews.http.entry.osc.OSCBlogList;
import com.newchar.devnews.http.params.OSCParamsBuilder;

import java.io.IOException;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * @author wenliqiang@100tal.com
 * date            2020/6/26
 * @since 当前版本描述，
 * @since 迭代版本描述
 */
public class OSCBlogListPresenter implements IOSCBlogListContract.Presenter {

    private IOSCBlogListContract.View mView;

    @Override
    public IOSCBlogListContract.View getView() {
        return mView;
    }

    @Override
    public void attachView(IBaseView view) {
        mView = (IOSCBlogListContract.View) view;
    }

    @Override
    public void requestOSCBlogList() {
        Map<String, Object> params = OSCParamsBuilder.buildOSCBlogListParams(1, "0");
        HttpRequest.requestOSCBlogList(params, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful() && response.body() != null) {
                    String body = response.body().string();
                    if (!TextUtils.isEmpty(body)) {
                        OSCBlogList oscBlogList = JsonCompat.parse(OSCBlogList.class, body);
                        getView().onBlogListResponse(oscBlogList.getBlogList());
                    } else {

                    }
                } else {

                }
            }
        });

    }



}
