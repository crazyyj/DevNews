package com.newchar.devnews.main;

import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.newchar.devnews.R;
import com.newchar.devnews.base.BaseActivity;
import com.newchar.devnews.http.entry.osc.OSCNewsList;
import com.newchar.devnews.http.entry.osc.OSCNoticeNumber;
import com.newchar.devnews.http.entry.osc.OSCPostList;
import com.newchar.devnews.http.entry.osc.OSCTweet;
import com.newchar.devnews.main.adapter.OSCPostListAdapter;
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
    private OSCPostListAdapter oscPostListAdapter;

    @Override
    protected void initWidgets() {
//        oscTweetListAdapter = new OSCTweetListAdapter(this);
        oscPostListAdapter = new OSCPostListAdapter(this);
        rvMainTweetList.setHasFixedSize(true);
        rvMainTweetList.setAdapter(oscPostListAdapter);
    }

    @Override
    protected void initData() {
        presenter = new Presenter(this);
        presenter.requestOSCPostList();

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
    public void onCreateOSCPost(List<OSCPostList.Item> postList) {
        runOnUiThread(() -> oscPostListAdapter.notifyDataSetChanged(postList));
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
