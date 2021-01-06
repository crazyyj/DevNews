package com.newchar.devnews.post.detail;

import com.newchar.devnews.base.IBaseContract.IBasePresenter;
import com.newchar.devnews.http.HttpRequest;
import com.newchar.devnews.http.JsonCompat;
import com.newchar.devnews.http.params.OSCParamsBuilder;
import com.newchar.oscrepository.entry.OSCPostDetail;

import java.io.IOException;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * @author wenliqiang
 * date 2020/6/22
 * @since 当前版本，（以及描述）
 * @since 迭代版本，（以及描述）
 */
public class Presenter implements IBasePresenter<View> {

    private View view;

    public Presenter(View view) {
        this.view = view;
    }

    public void requestOSCPostDetail(String postId) {
        final Map<String, Object> params = OSCParamsBuilder.buildOSCPostDetailParams(postId);
        HttpRequest.requestOSCPostDetail(params, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                getView().showPagePrompt(e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) {
                if (response.isSuccessful() && response.body() != null) {
                    try {
                        final String body = response.body().string();
                        final OSCPostDetail postDetail = JsonCompat.parse(OSCPostDetail.class, body);
                        getView().onPostDetailResponse(postDetail);
                    } catch (Exception e) {
                        e.printStackTrace();
                        getView().showPagePrompt(response.message());

                    }
                } else {
                    getView().showPagePrompt(response.message());
                }
            }
        });
    }

    @Override
    public View getView() {
        return view;
    }

    @Override
    public void attachView(View view) {
        this.view = view;
    }

}
