package com.newchar.devnews.main;

import android.content.Context;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.newchar.devnews.R;
import com.newchar.devnews.base.BaseActivity;
import com.newchar.devnews.http.HttpRequest;
import com.newchar.devnews.http.entry.OSCNewsList;
import com.newchar.devnews.http.entry.OSCNoticeNumber;
import com.newchar.supportlibrary.router.ARouterPath;

import java.util.List;

@Route(path = ARouterPath.ACTIVITY_MAIN)
public class MainActivity extends BaseActivity implements IView {

    private Presenter presenter;

    @Override
    protected void initWidgets() {

    }

    @Override
    protected void initData() {
        presenter = new Presenter(this);
        presenter.requestOscNews();
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
    public void onPageLoading() {

    }

    @Override
    public void onPageError() {

    }

    @Override
    public Context obtainContext() {
        return this;
    }

}
