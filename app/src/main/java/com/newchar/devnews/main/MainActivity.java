package com.newchar.devnews.main;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.newchar.devnews.R;
import com.newchar.devnews.base.BaseActivity;
import com.newchar.devnews.http.HttpRequest;
import com.newchar.devnews.http.entry.OSCNewsList;
import com.newchar.devnews.http.entry.OSCNoticeNumber;
import com.newchar.devnews.http.entry.OSCTweet;
import com.newchar.devnews.main.adapter.OSCTweetListAdapter;
import com.newchar.supportlibrary.router.ARouterPath;

import java.util.List;

import butterknife.BindView;

@Route(path = ARouterPath.ACTIVITY_MAIN)
public class MainActivity extends BaseActivity implements IView {

    private Presenter presenter;

    @BindView(R.id.rvMainTweetList)
    RecyclerView rvMainTweetList;
    private OSCTweetListAdapter oscTweetListAdapter;

    @Override
    protected void initWidgets() {
    }

    @Override
    protected void initData() {
        oscTweetListAdapter = new OSCTweetListAdapter(this);
        rvMainTweetList.setHasFixedSize(true);
        rvMainTweetList.setAdapter(oscTweetListAdapter);
        presenter = new Presenter(this);
        presenter.requestOSTweetList();

    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_main;
    }


    @Override
    public void onCreateOSCNews(List<OSCNewsList.NewsItem> newsItems) {

    }

    @Override
    public void onUpdateNoticeNumber(OSCNoticeNumber news) {

    }

    @Override
    public void onCreateOSCTweet(List<OSCTweet.OSCTweetItem> tweetList) {
        runOnUiThread(() -> oscTweetListAdapter.notifyDataSetChanged(tweetList));
    }

    @Override
    public void onPageLoading() {

    }

    @Override
    public void onPageError() {

    }

    @Override
    public Context obtainContext() {
        return this;
    }


    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }
}
