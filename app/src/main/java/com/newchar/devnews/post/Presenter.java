package com.newchar.devnews.post;

import com.newchar.devnews.base.IBasePresenter;
import com.newchar.devnews.http.HttpRequest;
import com.newchar.devnews.http.entry.osc.OSCPostList;
import com.newchar.devnews.http.params.OSCParamsBuilder;

import java.io.IOException;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * @author wenliqiang
 * date 2019-09-10
 * @since 当前版本，（以及描述）
 * @since 迭代版本，（以及描述）
 */
public class Presenter implements IBasePresenter<IView> {

    private IView mView;
    /**
     * 当前博客页面 处于第几页数据
     */
    private int currPage = 0;

    Presenter(IView view) {
        mView = view;
    }

    public void requestOSCPostList() {
        final Map<String, Object> params = OSCParamsBuilder.buildOSCBlogListParams(1, "3");
        HttpRequest.requestOSCPostList(params, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                getView().showPagePrompt(e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) {
                if (response.isSuccessful() && response.body() != null) {
                    try {
                        final String body = response.body().string();
                        final OSCPostList postList = OSCPostList.valueOf(body);
                        getView().onCreateOSCPost(postList.getPostList());
                        getView().onUpdateNoticeNumber(postList.getNotice());
                        currPage++;
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

    public void requestMoreOSCPostList() {
        final Map<String, Object> params = OSCParamsBuilder.buildOSCBlogListParams(currPage + 1, "3");
        HttpRequest.requestOSCPostList(params, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                getView().showPagePrompt(e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) {
                if (response.isSuccessful() && response.body() != null) {
                    try {
                        final String body = response.body().string();
                        final OSCPostList postList = OSCPostList.valueOf(body);
                        getView().onCreateOSCPost(postList.getPostList());
                        getView().onUpdateNoticeNumber(postList.getNotice());
                        currPage++;
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
    public IView getView() {
        return mView;
    }

    @Override
    public void attachView(IView view) {

    }
}
