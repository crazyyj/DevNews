package com.newchar.devnews.main;

import android.util.Log;

import com.newchar.devnews.base.IBasePresenter;
import com.newchar.devnews.http.HttpRequest;
import com.newchar.devnews.http.JsonCompat;
import com.newchar.devnews.http.entry.OSCNewsList;
import com.newchar.devnews.http.entry.OSCTweet;
import com.newchar.devnews.util.constant.ConstantField;
import com.newchar.devnews.util.constant.OSCField;
import com.newchar.supportlibrary.constant.Login;
import com.newchar.supportlibrary.db.DBHelper;
import com.newchar.supportlibrary.db.entry.LoginRecord;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    private int newsPage = 0;

    private List<OSCNewsList.NewsItem> allNews = new ArrayList<>();

    Presenter(IView view) {
        mView = view;
    }

    public void requestOscNews() {
        Map<String, String> params = new HashMap<>();
        params.put(OSCField.Params.DATA_TYPE, OSCField.DataType.JSON);
        final LoginRecord lastLoginRecord = DBHelper.getInstance(getView().obtainContext()).getLastLoginRecord();
        if (lastLoginRecord == null) {
            return;
        }
        params.put(OSCField.Params.ACCESS_TOKEN, lastLoginRecord.getDesc());
        params.put("catalog", "1");
        params.put(OSCField.Params.PAGE_SIZE, String.valueOf(newsPage));
        params.put(OSCField.Params.PAGE_INDEX, ConstantField.PAGE_SIZE);
        HttpRequest.requestOSCNews(params, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    final OSCNewsList news = JsonCompat.parse(OSCNewsList.class, response.body().string());
                    newsPage += (news.newslist.size() % Integer.parseInt(ConstantField.PAGE_SIZE));

                    getView().onCreateOSCNews(news.newslist);
                    getView().onUpdateNoticeNumber(news.notice);
                    allNews.addAll(news.newslist);
                } else {
                    getView().showPagePrompt(response.message());
                }
            }
        });
    }

    public void requestOSTweetList() {
        Map<String, String> params = new HashMap<>();
        params.put(OSCField.Params.DATA_TYPE, OSCField.DataType.JSON);
        final LoginRecord lastLoginRecord = DBHelper.getInstance(getView().obtainContext()).getLastLoginRecord();
        if (lastLoginRecord == null) {
            return;
        }
        params.put(OSCField.Params.ACCESS_TOKEN, lastLoginRecord.getDesc());
        params.put(OSCField.Params.USER, "0");
        params.put(OSCField.Params.PAGE_SIZE, ConstantField.PAGE_SIZE);
        params.put(OSCField.Params.PAGE_INDEX, "1");
        params.put(OSCField.Params.DATA_TYPE, OSCField.DataType.JSON);
        HttpRequest.requestOSTweetList(params, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    final OSCTweet news = JsonCompat.parse(OSCTweet.class, response.body().string());
                    getView().onCreateOSCTweet(news.tweetlist);
                    getView().onUpdateNoticeNumber(news.notice);
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
}
